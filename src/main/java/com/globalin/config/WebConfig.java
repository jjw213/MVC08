package com.globalin.config;

import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//web.xml
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	// root-config
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		// 스프링 설정파일 클래스 목록을 리턴
		return new Class[] { RootConfig.class };
	}

	// servlet-context
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		// 서블릿 설정파일 클래스 목록 리턴
		return new Class[] { ServletConfig.class };
	}

	// 서블릿이 요청을 처리할 주소 주시
	// @WebServlet("/") 했던 것
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

	// web.xml에 throwExceptionIfNoHandlerFound 했던거 여기선 이렇게
	@Override
	protected void customizeRegistration(Dynamic registration) {
		// TODO Auto-generated method stub
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}
}
