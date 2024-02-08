package com.sample.javabased.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.sample.javabased.services.DependencyInjectionService;
import com.sample.javabased.utils.DependencyUtilA;
import com.sample.javabased.utils.DependencyUtilB;
import com.sample.javabased.utils.DependencyUtilPrototype;
import com.sample.javabased.utils.DependencyUtilSingleton;

@Configuration
public class JavaConfigA {

	// Bean names can be given names
	@Bean(name = "dependencyUtilA")
	public DependencyUtilA dependencyUtilA() {
		return new DependencyUtilA();
	}

	// Spring also allows a bean to have multiple aliases
	@Bean(name = { "dependencyUtilB", "utilB", "autowirebyNameB" })
	public DependencyUtilB dependencyUtilB() {
		return new DependencyUtilB();
	}

	@Bean(name = "dependencyUtilPrototype")
	@Scope("prototype")
	public DependencyUtilPrototype dependencyUtilPrototype() {
		return new DependencyUtilPrototype();
	}

	@Bean(name = "dependencyUtilSingleton")
	@Scope("singleton")
	public DependencyUtilSingleton dependencyUtilSingleton() {
		return new DependencyUtilSingleton();
	}

	@Bean(name = "diService")
	public DependencyInjectionService diService() {
		return new DependencyInjectionService();
	}
}