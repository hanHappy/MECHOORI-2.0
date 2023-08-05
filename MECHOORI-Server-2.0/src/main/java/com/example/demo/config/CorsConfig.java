package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// URL Mapping과 관련된 내용들에 영향을 주므로 조심히 사용할 것
@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer{

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods("*")      
				.allowedHeaders("*");     
	}
	
}
