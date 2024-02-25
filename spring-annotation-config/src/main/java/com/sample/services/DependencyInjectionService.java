package com.sample.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import com.sample.utils.DependencyUtilA;
import com.sample.utils.DependencyUtilB;

public class DependencyInjectionService {

	@Value("150")
	int intField;

	@Value("String 1")
	String stringField1;

	// This can be read using .properties file
	@Value("List Value 1,List Value 2")
	List<String> listField;

	// Autowired annotation on variable/setters is equivalent to autowire="byType"
	@Autowired(required = true)
	DependencyUtilA dependencyUtilA;

	// Auto wiring done byName
	@Autowired
	@Qualifier("autowirebyNameB")
	DependencyUtilB autowirebyName;

	public DependencyInjectionService() {
	}

	public void init() {
		System.out.println("-----------init() method : Initialized. ------------");
	}

	public void getResponse() {
		System.out.println("Printing DI int Field ::" + intField);
		System.out.println("Printing DI String Field 1 ::" + stringField1);
		System.out.println("Printing DI List Field  ::" + listField);
		System.out.println();
		System.out.println("Printing DI Dependency Bean A ::" + dependencyUtilA.somePrint());
		System.out.println("Printing DI Dependency Bean B using AutoWiring byName ::" + autowirebyName.somePrint());

	}

	public void destroy() {
		System.out.println("-----------destroy() method : Closed. ------------");
	}

}
