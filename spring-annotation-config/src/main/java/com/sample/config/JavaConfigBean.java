package com.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sample.services.DependencyInjectionService;
import com.sample.utils.DependencyUtilA;
import com.sample.utils.DependencyUtilB;

@Configuration
public class JavaConfigBean {

	@Bean(name = "dependencyUtilA")
	public DependencyUtilA dependencyUtilA_test2() {
		System.out.println("Profile for Test 2 is Called");
		return new DependencyUtilA();
	}

	@Bean(name = { "dependencyUtilB", "utilB", "autowirebyNameB" })
	public DependencyUtilB dependencyUtilB() {
		return new DependencyUtilB();
	}

	@Bean(name = "diService", initMethod = "init", destroyMethod = "destroy")
	public DependencyInjectionService diService() {
		return new DependencyInjectionService();
	}
}