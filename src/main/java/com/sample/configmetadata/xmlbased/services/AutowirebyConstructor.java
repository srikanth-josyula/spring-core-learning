package com.sample.configmetadata.xmlbased.services;

import com.sample.configmetadata.xmlbased.utils.DependencyUtilA;
import com.sample.configmetadata.xmlbased.utils.DependencyUtilB;

public class AutowirebyConstructor {

	DependencyUtilA dependencyUtilA = null;
	DependencyUtilB dependencyUtilB = null;

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