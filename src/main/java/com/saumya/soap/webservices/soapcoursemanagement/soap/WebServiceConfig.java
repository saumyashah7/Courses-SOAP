package com.saumya.soap.webservices.soapcoursemanagement.soap;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

//Enable Spring Web Services
@EnableWs
//Spring Configuration
@Configuration

public class WebServiceConfig {
	//MessageDispatcherServlet
		//AplicationContext
	//url => /ws/*
	
	@Bean
	ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet,"/ws/*");
	}
	
	@Bean(name="courses")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coursesSchema) {
		DefaultWsdl11Definition def=new DefaultWsdl11Definition();
		def.setPortTypeName("CoursePort");
		def.setTargetNamespace("http://saumya.com/courses");
		def.setLocationUri("/ws");
		def.setSchema(coursesSchema);
		
		return def;
	}
	
	@Bean
	XsdSchema corsesSchema() {
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
	}

}
