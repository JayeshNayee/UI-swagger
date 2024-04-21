package com.swagger.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class swaggerConfig {
	@Bean
	public	Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfoDetails())
				.select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}

	
	
	private ApiInfo getInfoDetails() {
	return new ApiInfo("Jayesh", "jd nayee", "V1.0", "Trems and Condition",new Contact("xyx", "xyz.in", "xyz@gmail.com"), "Licence text", "url of licence", Collections.emptyList());
	}
}
