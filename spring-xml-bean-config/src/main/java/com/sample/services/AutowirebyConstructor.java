package com.sample.services;

import com.sample.utils.DependencyUtilA;
import com.sample.utils.DependencyUtilB;

public class AutowirebyConstructor {

	// byType mode in constructor argument.
	DependencyUtilA dependencyUtilA = null;
	DependencyUtilB dependencyUtilB = null;

	// Auto-wire a bean by property data type in constructor argument. In this case,
	// since the data type of bean is same as the constructor argument data type in
	public AutowirebyConstructor(DependencyUtilA dependencyUtilA, DependencyUtilB dependencyUtilB) {
		super();
		this.dependencyUtilA = dependencyUtilA;
		this.dependencyUtilB = dependencyUtilB;
	}

	public void getResponse() {
		System.out.println("Printing Constructor DI String Field 2 " + dependencyUtilA.somePrint());
		System.out.println("Printing Constructor DI String Field 2 " + dependencyUtilB.somePrint());
	}

}