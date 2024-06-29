package com.ihis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ihis"})
public class IhisDbManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IhisDbManagerApplication.class, args);
	}

}
