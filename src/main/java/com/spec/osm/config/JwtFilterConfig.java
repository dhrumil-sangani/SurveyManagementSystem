//package com.spec.osm.config;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.spec.osm.JwtAuthenticationFilter;
//
//@Configuration
//public class JwtFilterConfig {
//	@Bean
//	public FilterRegistrationBean<JwtAuthenticationFilter> jwtFilter() {
//	    FilterRegistrationBean<JwtAuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
//	    registrationBean.setFilter(new JwtAuthenticationFilter());
//	    registrationBean.addUrlPatterns("/api/*"); // Specify the URL patterns to protect with JWT authentication
//	    return registrationBean;
//	}
//}
