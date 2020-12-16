package com.doctor.config;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class PatientAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		Class[] configClasses = {PatientAppConfig.class};
		
		return configClasses;
	}

	@Override
	protected String[] getServletMappings() {
		
		String urlPattern[] = {"/"};
		return urlPattern;
	}

}
