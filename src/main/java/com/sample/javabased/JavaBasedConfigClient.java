package com.sample.javabased;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sample.javabased.config.JavaConfigA;
import com.sample.javabased.services.DependencyInjectionService;
import com.sample.javabased.utils.DependencyUtilB;


public class JavaBasedConfigClient {
	public static void main(String[] args) {

		// AbstractApplicationContext provides close methods, ApplicationContext doesn't have it
		AnnotationConfigApplicationContext context = null;
		try {
			
			// this (using var-arg constructor)
			//context = new AnnotationConfigApplicationContext(JavaConfigA.class,JavaConfigB.class);
						
			// Topic=@Import, we can group module or category, to make things more maintainable and modular
			// This is the same as line 18, where we tried to import the Configs into one
			
			
			context = new AnnotationConfigApplicationContext();
			// This can be also set using system 
			//System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
			context.getEnvironment().setActiveProfiles("test");
			context.register(JavaConfigA.class);
			context.refresh();

			// Possible Error CGLIB is required to process @Configuration classes
			// add CGLIB to the classpath
			DependencyInjectionService diService = (DependencyInjectionService) context.getBean("diService");
			
			DependencyUtilB secondaryConfigBean = (DependencyUtilB) context.getBean("secondaryConfigBean");
			System.out.println(secondaryConfigBean.somePrint());
			System.out.println("====================");
			System.out.println();
			
			
			diService.getResponse();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.close();
			// used to close if the JVM shuts down
			context.registerShutdownHook();
		}
	}
}
