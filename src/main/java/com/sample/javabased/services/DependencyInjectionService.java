package com.sample.javabased.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import com.sample.javabased.utils.DependencyUtilA;
import com.sample.javabased.utils.DependencyUtilB;
import com.sample.javabased.utils.DependencyUtilPrototype;
import com.sample.javabased.utils.DependencyUtilSingleton;

public class DependencyInjectionService {

	@Value("150")
	int intField;

	@Value("String 1")
	String stringField1;

	// This can be read using .properties file
	@Value("List Value 1,List Value 2")
	List<String> listField;

	//Autowired annotation on variable/setters is equivalent to autowire="byType"
	@Autowired
	DependencyUtilA dependencyUtilA;

	//Auto wiring done byName
	@Autowired
	@Qualifier("autowirebyNameB")
	DependencyUtilB autowirebyName;

	@Autowired
	DependencyUtilPrototype dependencyUtilPrototype;
	
	//Autowiring on setters
	DependencyUtilSingleton dependencyUtilSingleton;
	@Autowired
	public void setDependencyUtilSingleton(DependencyUtilSingleton dependencyUtilSingleton) {
		this.dependencyUtilSingleton = dependencyUtilSingleton;
	}
	
	//Reading the beans again
	@Autowired
	DependencyUtilPrototype dependencyUtilPrototype1;
	
	@Autowired
	DependencyUtilSingleton dependencyUtilSingleton1;

	public DependencyInjectionService() {
	}

	public void getResponse() {
		System.out.println("Printing Constructor DI int Field ::" + intField);
		System.out.println("Printing Constructor DI String Field 1 ::" + stringField1);
		System.out.println("Printing Constructor DI List Field  ::" + listField);

		System.out.println("Printing Constructor DI Dependency Bean A ::" + dependencyUtilA.somePrint());
		System.out.println(
				"Printing Constructor DI Dependency Bean B using AutoWiring byName ::" + autowirebyName.somePrint());

		System.out.println("Printing Constructor DI Prototype Scope Bean Memory ::" + dependencyUtilPrototype.hashCode());
		System.out.println("Printing Constructor DI Singleton Scope Bean Memory ::" + dependencyUtilSingleton.hashCode());
		System.out.println();
		System.out.println("Printing Constructor DI Prototype Scope Bean Memory ::" + dependencyUtilPrototype1.hashCode());
		System.out.println("Printing Constructor DI Singleton Scope Bean Memory ::" + dependencyUtilSingleton1.hashCode());
	}
}
