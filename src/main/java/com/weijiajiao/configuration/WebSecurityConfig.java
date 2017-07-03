package com.weijiajiao.configuration;
import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.weijiajiao.filter.SecureFilter;

//package com.weijiajiao.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import com.weijiajiao.service.AccountService;
//
//@EnableWebSecurity
//@Configuration
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private AccountService accountService;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.userDetailsService(accountService).passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/area/**", "/article/**","/teacher/search","/teacher/{teacherId}").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic().and()
//                .csrf().disable();
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**", "/**/favicon.ico");
//    }
//
//}

@Configuration
public class WebSecurityConfig {

	/*@Bean
	public FilterRegistrationBean filterRegistration() {

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(secureFilter());
		registration.addUrlPatterns("*//*");
		//the parameters can be used in the filter init method
//		registration.addInitParameter("paramName", "paramValue");
		registration.setName("secureFilter");
		registration.setOrder(1);
		return registration;
	}

	public Filter secureFilter() {
		return new SecureFilter();
	}*/
	
	
	
}

