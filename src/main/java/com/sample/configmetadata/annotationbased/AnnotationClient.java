package com.sample.configmetadata.annotationbased;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.configmetadata.annotationbased.services.DependencyInjectionService;

public class AnnotationClient {

	public static void main(String[] args) {

		AbstractApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("configmetadata/annotation/context.xml");
			DependencyInjectionService diServices = (DependencyInjectionService) context.getBean("diService");
			diServices.getResponse();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.close();
		}
	}
}
