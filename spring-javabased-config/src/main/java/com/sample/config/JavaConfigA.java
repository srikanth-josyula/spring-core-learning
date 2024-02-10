package com.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

import com.sample.services.DependencyInjectionService;
import com.sample.utils.DependencyUtilA;
import com.sample.utils.DependencyUtilB;
import com.sample.utils.DependencyUtilPrototype;
import com.sample.utils.DependencyUtilSingleton;

@Configuration
@Import({ JavaConfigB.class, JavaConfigC.class })
public class JavaConfigA {

	@Profile("test1")
	@Bean(name = "dependencyUtilA")
	public DependencyUtilA dependencyUtilA_test2() {
		System.out.println("Profile for Test 2 is Called");
		return new DependencyUtilA();
	}
	
	//Topic = Bean names can be given names
	//Topic = Bean Profiles can we done on bean or class
	@Profile("test")
	@Bean(name = "dependencyUtilA")
	public DependencyUtilA dependencyUtilA() {
		System.out.println("Profile for Test 1 is Called");
		return new DependencyUtilA();
	}
	
	

	//Topic = Bean Multiple aliases
	@Bean(name = { "dependencyUtilB", "utilB", "autowirebyNameB" })
	public DependencyUtilB dependencyUtilB() {
		return new DependencyUtilB();
	}

	//Topic = Bean Scopes
	@Bean(name = "dependencyUtilPrototype")
	@Scope("prototype")
	public DependencyUtilPrototype dependencyUtilPrototype() {
		return new DependencyUtilPrototype();
	}

	//Topic = Bean Scopes
	@Bean(name = "dependencyUtilSingleton")
	@Scope("singleton")
	public DependencyUtilSingleton dependencyUtilSingleton() {
		return new DependencyUtilSingleton();
	}

	//Topic = Bean LifeCycle
	//Destroy method is not called for beans of scope prototype. This is because the context doesn't keep track of the prototype scope objects
	@Bean(name = "diService" ,initMethod = "init", destroyMethod = "destroy")
	public DependencyInjectionService diService() {
		return new DependencyInjectionService();
	}
}