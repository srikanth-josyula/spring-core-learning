package com.sample.javabased.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
	@Autowired(required=true)
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
	
	
	@PostConstruct
    private void postConstruct() {
		System.out.println("-----------postConstruct method : Initialized. ------------");
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
		System.out.println(
				"Printing DI Dependency Bean B using AutoWiring byName ::" + autowirebyName.somePrint());
		System.out.println();
		System.out.println("--------- Bean Scopes Memory Test 1 -------");
		System.out.println("Printing DI Prototype Scope Bean Memory ::" + dependencyUtilPrototype.hashCode());
		System.out.println("Printing DI Singleton Scope Bean Memory ::" + dependencyUtilSingleton.hashCode());
		System.out.println();
		System.out.println("--------- Bean Scopes Memory Test 2 -------");
		System.out.println("Printing DI Prototype Scope Bean Memory ::" + dependencyUtilPrototype1.hashCode());
		System.out.println("Printing DI Singleton Scope Bean Memory ::" + dependencyUtilSingleton1.hashCode());
	}
	
	public void destroy() {
		System.out.println("-----------destroy() method : Closed. ------------");
	}
	
	@PreDestroy
    public void preDestroy() {
		System.out.println("-----------preDestroy method : Closed. ------------");
    }
}
