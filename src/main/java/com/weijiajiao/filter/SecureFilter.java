package com.weijiajiao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public  class SecureFilter implements Filter{
	private static final Long SECOND = 1000L;
	private static final Long MINUTE = SECOND * 60;
	

	@Override
	public void destroy() {
		System.out.println("destroy SecureFilter");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//把ServletRequest和ServletResponse转换成真正的类型
        HttpServletRequest req = (HttpServletRequest)request;
        HttpSession session = req.getSession();

        String requestURI = req.getRequestURI();
        boolean ingnoredURLs = requestURI.equals("/auth/login_page") || requestURI.endsWith("/wechat_login")|| requestURI.endsWith("favicon.ico") ||
        		requestURI.contains("/css/")||requestURI.contains("/images/")
        		||requestURI.contains("/js/");
        if(  ingnoredURLs ){
        	//允许访问的链接，允许访问
            chain.doFilter(request, response);
            return;
        }
        
        //判断用户是否登录，进行页面的处理
        Long currentTime = System.currentTimeMillis();
        Long freezonTime_m = (currentTime - session.getLastAccessedTime())/ MINUTE ;
        Long createTimeTillNow =( currentTime - session.getCreationTime()) / MINUTE;
        if(session.isNew() || freezonTime_m > 1  || createTimeTillNow > 30){
            //未登录用户，或者session 超过时间重定向到登录页面
        	session.invalidate();
            ((HttpServletResponse)response).sendRedirect("/auth/login_page");
            return;
        }else{
        	chain.doFilter(request, response);
        }
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("init SecureFilter");
	}
	
}
