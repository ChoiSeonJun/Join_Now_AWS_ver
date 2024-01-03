package com.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootTemplateApplication.class, args);
		System.out.println("BootTemplateApplication 실행");
	}

}
