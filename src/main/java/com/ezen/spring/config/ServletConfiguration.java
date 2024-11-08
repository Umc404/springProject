package com.ezen.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

// 나중에 componentScan 에 exception 404 not found 추가 : com.ezen.spring.excetion
@EnableScheduling
@EnableWebMvc
@ComponentScan(basePackages = {"com.ezen.spring.controller","com.ezen.spring.service","com.ezen.spring.handler"})
public class ServletConfiguration implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// resource 경로설정
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
		// 파일 업로드경로. 나중에.
//		registry.addResourceHandler("/upload/**")
//				.addResourceLocations("file:///D:\\umc\\_myProject\\_fileUpload\\");
		// 집에서 하려면 이 경로에 폴더 만듭시다.
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// view 경로 설정
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		
		// '화면에 뷰를 구성할 때 jstl 에 대한 사용을 하는 jsp를 구성하겠다.'
		viewResolver.setViewClass(JstlView.class);
		
		registry.viewResolver(viewResolver);
	}
	
	@Bean(name = "multipartResolver")
	public MultipartResolver getMultipartResolver() {
		StandardServletMultipartResolver multipartResolver = 
				new StandardServletMultipartResolver();
		return multipartResolver;
	}
}
