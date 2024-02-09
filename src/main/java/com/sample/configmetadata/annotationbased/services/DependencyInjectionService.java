package com.sample.configmetadata.annotationbased.services;

import com.sample.javabased.utils.DependencyUtilA;
import com.sample.javabased.utils.DependencyUtilB;

public class DependencyInjectionService {

	DependencyUtilA dependencyUtilA;
	DependencyUtilB dependencyUtilB;

	public DependencyInjectionService(DependencyUtilA dependencyUtilA, DependencyUtilB dependencyUtilB) {
		this.dependencyUtilA = dependencyUtilA;
		this.dependencyUtilB = dependencyUtilB;
	}

	public void getResponse() {
		System.out.println("Printing DI Dependency Bean A ::" + dependencyUtilA.somePrint());
		System.out.println("Printing DI Dependency Bean B ::" + dependencyUtilB.somePrint());
		System.out.println();
	}
}
