package com.sample.javabased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sample.javabased.config.JavaConfigA;
import com.sample.javabased.config.JavaConfigB;
import com.sample.javabased.services.DependencyInjectionService;

public class JavaBasedConfigClient {
	public static void main(String[] args) {

		// In case you have multiple configuration classes, you can specify them like
		// this (using var-arg constructor)
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfigA.class, JavaConfigB.class);

		// Possible Error CGLIB is required to process @Configuration classes
		// add CGLIB to the classpath 
		DependencyInjectionService diService = (DependencyInjectionService) context.getBean("diService");
		diService.getResponse();
	}
}
