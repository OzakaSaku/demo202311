package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.mapper") //设置mapper接⼝的扫描包
@SpringBootApplication
public class Demo202311Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo202311Application.class, args);
	}

}
