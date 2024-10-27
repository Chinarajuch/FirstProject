package com.vtalent.employeeInfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Config {
	
	@Bean
	Docket createSwagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("app-doc")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.vtalent.employeeInfo"))
				.paths(PathSelectors.any())
				.build();
	}

}
