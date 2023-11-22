package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@ServletComponentScan
@SpringBootApplication
@MapperScan("com.example.mapper")
public class Demo202311Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo202311Application.class, args);
	}

}
