package com.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.github.javafaker.Faker;

@SpringBootApplication
@EnableWebMvc
public class SwaggerUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerUiApplication.class, args);
	}

	@Bean
	Faker faker() {
		return new Faker();
	}
	@Bean
	 RestTemplate template() {
		 return new RestTemplate();
	 }

}
