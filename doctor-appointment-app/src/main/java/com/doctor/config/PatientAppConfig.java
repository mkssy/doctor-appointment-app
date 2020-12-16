package com.doctor.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.doctor"})
public class PatientAppConfig {
	
	
	@Bean
	InternalResourceViewResolver getViewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	

	@Bean
	public JdbcTemplate getJdbcTemplateObject() {
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		return jdbcTemplate;
	}
	

	@Bean
	public DataSource getDataSource() {

		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		datasource.setUrl("jdbc:sqlserver://LAPTOP-VAM1F6B7\\SQLEXPRESS:1433;database=doctorAppointmentForm");
		datasource.setUsername("sa");
		datasource.setPassword("admin123");
		return datasource;
	}
	
	@Bean
	public JavaMailSenderImpl configureJavaMailSenderObject() {
		
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost("smtp.gmail.com");
		javaMailSenderImpl.setUsername("mayursyadav2020@gmail.com");
		javaMailSenderImpl.setPassword("mayurex@00");
		javaMailSenderImpl.setPort(587);
		
		Properties mailProperties = new Properties();
		mailProperties.put("mail.smtp.starttls.enable", true);
		mailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		javaMailSenderImpl.setJavaMailProperties(mailProperties);
		
		return javaMailSenderImpl;
	}

}
