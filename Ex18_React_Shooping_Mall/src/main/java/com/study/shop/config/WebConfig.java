package com.study.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")		//모든 요청 경로 허용
				.allowedOrigins("http://localhost:3000")  // REACT 주소
				.allowedMethods("*")  // GET, POST, PUT, DELETE 다 허용
				.allowedHeaders("*")
				.allowCredentials(true);		// 인증정보 포함 허용
	}
}