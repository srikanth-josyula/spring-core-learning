package com.sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.services.DependencyInjectionService;
import com.sample.utils.DependencyUtilB;

//This class is replacement of XML
@Configuration
public class JavaConfigB {

	@Value("This is a Secondary Bean Conif Class Response")
	private String stringField1;

	
	//Think this as a bean in XML, we have id and to ingest values we can use
	@Bean(name = "secondaryConfigBean")
	public DependencyUtilB dependecyBeanB() {
		System.out.println("====================");
		System.out.println(stringField1);
		return new DependencyUtilB();
	}

	
	@Bean(name = "diService")
	public DependencyInjectionService diService() {
		System.out.println("This is called when profile - test2 is called");
		return null;
	}
}