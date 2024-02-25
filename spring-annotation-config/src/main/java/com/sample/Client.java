package com.sample;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.services.DependencyInjectionService;
import com.sample.services.SetterDIService;

public class Client {

	public static void main(String[] args) {

		AbstractApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("context.xml");
			System.out.println("ApplicationContext Initialized !!");

			System.out.println("\n##---- Using the Setter DI Concepts from XMl----##");
			SetterDIService setterDI = (SetterDIService) context.getBean("setterDI");
			setterDI.getResponse();

			System.out.println("\n##---- Using the DependencyInjectionService from JavaConfigBean----##");
			//we can retrieve the beans defined in Java-based configuration using the same context.getBean() method.
			DependencyInjectionService diService = context.getBean("diService", DependencyInjectionService.class);
			diService.getResponse();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (context != null) {
				context.close();
			}
		}
	}
}
