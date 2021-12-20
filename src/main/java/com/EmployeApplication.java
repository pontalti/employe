package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableWebMvc
@EnableMongoRepositories(basePackages = "com")
@ComponentScan("com")
@EnableOpenApi
public class EmployeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeApplication.class, args);
	}

}
