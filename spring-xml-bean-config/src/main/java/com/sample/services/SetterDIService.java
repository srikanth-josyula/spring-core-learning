package com.sample.services;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sample.utils.DependencyUtilA;
import com.sample.utils.DependencyUtilB;
import com.sample.utils.DependencyUtilPrototype;
import com.sample.utils.DependencyUtilSingleton;


public class SetterDIService {

	int intField;
	String stringField1;
	String stringField2;
	List<String> listField;
	Map<String, String> mapField;

	DependencyUtilA dependencyUtilA = null;

	//Auto wiring by property name. If the name of a bean is same as the name of other bean property, auto wire it.
	//Here the dependencyUtilB should be same as dependencyUtilB as of in context.xml
	//We need to have setters as we are not explicitly sending in context.xml
	DependencyUtilB dependencyUtilB = null;

	public void setReportPathUtils(DependencyUtilB dependencyUtilB) {
		this.dependencyUtilB = dependencyUtilB;
	}

	//Beans for Scopes
	DependencyUtilPrototype dependencyUtilPrototype = null;
	DependencyUtilSingleton dependencyUtilSingleton = null;

	
	public void getResponse() {
		System.out.println("Printing Setter DI int Field " + intField);
		System.out.println("Printing Setter DI String Field 1 " + stringField1);
		System.out.println("Printing Setter DI String Field 2 " + stringField2);
		System.out.println();
		System.out.println("Printing Setter DI List Field  " + listField);
		System.out.println("Printing Setter DI Map Field  ");
		for (Entry<String, String> map : mapField.entrySet()) {
			System.out.println("    "+map.getKey() + "=" + map.getValue());
		}
		System.out.println();
		System.out.println("--------- Bean Scopes Memory Test 1 -------");
		System.out.println("Printing Setter DI Dependency Bean A " + dependencyUtilA.somePrint());
		System.out.println("Printing Setter DI Dependency Bean B " + dependencyUtilB.somePrint());
		
		System.out.println();
		System.out.println("--------- Bean Scopes Memory Test 2 -------");
		System.out.println("Printing Setter DI Prototype Scope Bean Memory " + dependencyUtilPrototype.hashCode());
		System.out.println("Printing Setter DI Singleton Scope Bean Memory " + dependencyUtilSingleton.hashCode());
	}

	//Setters for the fields
	public void setIntField(int intField) {
		this.intField = intField;
	}

	public void setStringField1(String stringField1) {
		this.stringField1 = stringField1;
	}

	public void setStringField2(String stringField2) {
		this.stringField2 = stringField2;
	}

	public void setListField(List<String> listField) {
		this.listField = listField;
	}

	public void setMapField(Map<String, String> mapField) {
		this.mapField = mapField;
	}

	public void setDependencyUtilA(DependencyUtilA dependencyUtilA) {
		this.dependencyUtilA = dependencyUtilA;
	}

	public void setDependencyUtilB(DependencyUtilB dependencyUtilB) {
		this.dependencyUtilB = dependencyUtilB;
	}

	public void setDependencyUtilPrototype(DependencyUtilPrototype dependencyUtilPrototype) {
		this.dependencyUtilPrototype = dependencyUtilPrototype;
	}

	public void setDependencyUtilSingleton(DependencyUtilSingleton dependencyUtilSingleton) {
		this.dependencyUtilSingleton = dependencyUtilSingleton;
	}

}