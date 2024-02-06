package com.sample.configmetadata.xmlbased.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sample.configmetadata.xmlbased.utils.DependencyUtilA;
import com.sample.configmetadata.xmlbased.utils.DependencyUtilB;
import com.sample.configmetadata.xmlbased.utils.DependencyUtilPrototype;
import com.sample.configmetadata.xmlbased.utils.DependencyUtilSingleton;

public class ConstructorDIService {

	int intField;
	String stringField1;
	String stringField2;
	List<String> listField;
	Map<String, String> mapField;

	DependencyUtilA dependencyUtilA = null;

	// Injecting using auto-wiring if give by Type only the TYPE is considered the
	// name here is different from the bean name
	// Bean name is not autowirebytype, but still it works
	DependencyUtilB autowirebytype = null;

	public void setReportPathUtils(DependencyUtilB autowirebytype) {
		this.autowirebytype = autowirebytype;
	}
	
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
		System.out.println("This is the init methood");
	}

	public void getResponse() {
		System.out.println("Printing Constructor DI int Field " + intField);
		System.out.println("Printing Constructor DI String Field 1 " + stringField1);
		System.out.println("Printing Constructor DI String Field 2 " + stringField2);

		System.out.println("Printing Constructor DI List Field  " + listField);
		System.out.println("Printing Constructor DI Map Field  ");
		for (Entry<String, String> map : mapField.entrySet()) {
			System.out.println(map.getKey() + "=" + map.getValue());
		}

		System.out.println("Printing Constructor DI Dependency Bean A " + dependencyUtilA.somePrint());
		System.out.println("Printing Constructor DI Dependency Bean B " + autowirebytype.somePrint());
		
		
		System.out.println("Printing Constructor DI Prototype Scope Bean Memory " + dependencyUtilPrototype.hashCode());
		System.out.println("Printing Constructor DI Singleton Scope Bean Memory " + dependencyUtilSingleton.hashCode());
	}
	
	public void destroy() {
		System.out.println("This is the destroy methood");
	}

}