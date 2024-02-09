package com.sample.configmetadata.annotationbased.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.sample.javabased.services.DependencyInjectionService;

@Component
public class AnnotationConfig {

	@Bean(name = "diService")
	public DependencyInjectionService diService() {
		return new DependencyInjectionService();
	}
}