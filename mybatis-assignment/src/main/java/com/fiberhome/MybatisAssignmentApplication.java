package com.fiberhome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.fiberhome"})
@MapperScan(basePackages = {"com.fiberhome.dao"})
public class MybatisAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisAssignmentApplication.class, args);
	}

}
