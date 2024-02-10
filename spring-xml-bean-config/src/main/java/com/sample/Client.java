package com.sample;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.services.AutowirebyConstructor;
import com.sample.services.ConstructorDIService;
import com.sample.services.SetterDIService;


public class Client {

	public static void main(String[] args) {
		
		//AbstractApplicationContext provides close methods, ApplicationContext doesn't have it
		AbstractApplicationContext context = null;
		try{
			context= new ClassPathXmlApplicationContext("context.xml");
			System.out.println("ApplicationContext Initialized !!");

			System.out.println("##---- Using the Constructor DI Concepts ----##");
			ConstructorDIService constructorDI = (ConstructorDIService) context.getBean("constructorDI");
			constructorDI.getResponse();
			
			System.out.println("##----  Using the Setter DI Concepts ----##");
			SetterDIService setterDI = (SetterDIService) context.getBean("setterDI");
			setterDI.getResponse();
			
			
			System.out.println("##----  Using the Constructor autowiring Concepts ----##");
			AutowirebyConstructor autowirebyConstructor = (AutowirebyConstructor) context.getBean("autowirebyConstructor");
			autowirebyConstructor.getResponse();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			context.close();
			//used to close if the JVM shuts down
			context.registerShutdownHook();
		}
	}
}
