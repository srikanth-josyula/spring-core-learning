package com.sample.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sample.utils.DependencyUtilA;
import com.sample.utils.DependencyUtilB;
import com.sample.utils.DependencyUtilPrototype;
import com.sample.utils.DependencyUtilSingleton;


public class ConstructorDIService {

	// Injection on fields
	int intField;
	String stringField1;
	String stringField2;
	List<String> listField;
	Map<String, String> mapField;

	
	// Injection of beans
	DependencyUtilA dependencyUtilA = null;

	//Auto wiring by property data type. If data type of a bean is compatible with the data type of other bean property, auto wire it.
	//Here the autowirebytype is not the same as dependencyUtilB as of in context.xml
	//We need to have setters as we are not explicitly sending in context.xml
	DependencyUtilB autowirebytype = null;

	public void setReportPathUtils(DependencyUtilB autowirebytype) {
		this.autowirebytype = autowirebytype;
	}
	
	//Beans for Scopes
	DependencyUtilPrototype dependencyUtilPrototype = null;
	DependencyUtilSingleton dependencyUtilSingleton = null;

	// IF we are injecting normal object, we dont need default constructor

	public ConstructorDIService(int intField, String stringField1, String stringField2, List<String> listField,
			Map<String, String> mapField, DependencyUtilA dependencyUtilA,DependencyUtilPrototype dependencyUtilPrototype,DependencyUtilSingleton dependencyUtilSingleton) {
		this.intField = intField;
		this.stringField1 = stringField1;
		this.stringField2 = stringField2;
		this.listField = listField;
		this.mapField = mapField;
		this.dependencyUtilA = dependencyUtilA;
		this.dependencyUtilPrototype = dependencyUtilPrototype;
		this.dependencyUtilSingleton = dependencyUtilSingleton;
	}
	
	public void init() {
		System.out.println("-----------init() method : Initialized. ------------");
	}

	public void getResponse() {
		System.out.println("Printing Constructor DI int Field " + intField);
		System.out.println("Printing Constructor DI String Field 1 " + stringField1);
		System.out.println("Printing Constructor DI String Field 2 " + stringField2);
		System.out.println();
		System.out.println("Printing Constructor DI List Field  " + listField);
		System.out.println("Printing Constructor DI Map Field  ");
		for (Entry<String, String> map : mapField.entrySet()) {
			System.out.println("    "+map.getKey() + "=" + map.getValue());
		}
		System.out.println();
		System.out.println("--------- Bean Scopes Memory Test 1 -------");
		System.out.println("Printing Constructor DI Dependency Bean A " + dependencyUtilA.somePrint());
		System.out.println("Printing Constructor DI Dependency Bean B " + autowirebytype.somePrint());
		
		System.out.println();
		System.out.println("--------- Bean Scopes Memory Test 2 -------");
		System.out.println("Printing Constructor DI Prototype Scope Bean Memory " + dependencyUtilPrototype.hashCode());
		System.out.println("Printing Constructor DI Singleton Scope Bean Memory " + dependencyUtilSingleton.hashCode());
	}
	
	public void destroy() {
		System.out.println("-----------destroy() method : Closed. ------------");
	}

}