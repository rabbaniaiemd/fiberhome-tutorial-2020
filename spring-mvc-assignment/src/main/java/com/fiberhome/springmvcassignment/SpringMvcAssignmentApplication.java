package com.fiberhome.springmvcassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.fiberhome.springmvcassignment")
public class SpringMvcAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcAssignmentApplication.class, args);
	}

}
