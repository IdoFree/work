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

        //由于web.xml中设置Filter过滤全部请求，可以排除不需要过滤的url
        String requestURI = req.getRequestURI();
        if(requestURI.equals("/wechat_login") || requestURI.endsWith("favicon.ico") ||
        		requestURI.contains("/css/")||requestURI.contains("/images/") 
        		||requestURI.contains("/js/") ){
            chain.doFilter(request, response);
            return;
        }
        
        //判断用户是否登录，进行页面的处理
        if(null == session.getAttribute("user")){
            //未登录用户，重定向到登录页面
            ((HttpServletResponse)response).sendRedirect("/wechat_login");
            return;
        } else {
            //已登录用户，允许访问
            chain.doFilter(request, response);
        }
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("init SecureFilter");
	}
	
}
