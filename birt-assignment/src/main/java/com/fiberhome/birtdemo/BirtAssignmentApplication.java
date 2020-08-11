package com.fiberhome.birtdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.fiberhome")
public class BirtAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirtAssignmentApplication.class, args);
	}

}
