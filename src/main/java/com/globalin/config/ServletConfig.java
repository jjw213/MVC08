package com.globalin.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = { "com.globalin.controller", "com.globalin.exception" })
public class ServletConfig implements WebMvcConfigurer {
	// WebMvcConfigurer 인터페이스는 스프링이 MVC와 관련된 설정을 메소드로 오버라이딩 할 때 사용
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");

	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		// jstl을 사용하는 jsp로 view를 설정한다.
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);

	}

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver cmr = new CommonsMultipartResolver();
		cmr.setMaxUploadSize(1024 * 1024 * 10);
		cmr.setMaxUploadSizePerFile(1024 * 1024 * 2);
		cmr.setMaxInMemorySize(1024 * 1024);
		cmr.setUploadTempDir(new FileSystemResource("C:\\Nexon"));
		cmr.setDefaultEncoding("UTF-8");
		return cmr;
	}
}
