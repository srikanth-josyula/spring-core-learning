package com.sample.javabased.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.javabased.utils.DependencyUtilB;

//This class is replacement of XML
@Configuration
public class JavaConfigC {

	@Value("This is a Secondary Bean Conif Class Response")
	private String stringField1;

	
	//Think this as a bean in XML, we have id and to ingest values we can use
	@Bean(name = "secondaryConfigBean")
	public DependencyUtilB dependecyBeanB() {
		System.out.println("====================");
		System.out.println(stringField1);
		return new DependencyUtilB();
	}

}