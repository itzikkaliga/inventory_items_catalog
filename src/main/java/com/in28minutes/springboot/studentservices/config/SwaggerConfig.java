package com.in28minutes.springboot.studentservices.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;


@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.in28minutes.springboot.studentservices"))
				.paths(PathSelectors.regex("/rest.*"))
				.build()
				.apiInfo(myApiInfo());
	}

	private ApiInfo myApiInfo() {
		ApiInfo myInfo = new ApiInfo(
				"Swagger API Catalog",
				"A Swagger API catalog for inventory items",
				"1.0",
				"Terms Of Licensce",
				new Contact("Itzik Kaliga", "","itzikkaliga01@gmail.com"),
				"","");
		return myInfo;
	}

}


