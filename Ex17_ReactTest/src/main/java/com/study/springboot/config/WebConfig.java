package com.study.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry reg) {
		reg.addMapping("/**") // 모든 요청경로 허용
			.allowedOrigins("http://localhost:3000") // react 주소
			.allowedMethods("*") // get, post, put, delete 모두 허용한다
			.allowedHeaders("*")
			.allowCredentials(true); // 인증정보 포함 허용
	}
}
