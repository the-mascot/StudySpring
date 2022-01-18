package com.oracle.sBootMybatis03.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.oracle.sBootMybatis03.service.SampleInterceptor;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	
	// interCeptor
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new SampleInterceptor()).addPathPatterns("/interCeptor");
		
	}
	
}
