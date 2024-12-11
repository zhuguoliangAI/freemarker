package com.example.freemarker.freemarker_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class FreemarkerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreemarkerDemoApplication.class, args);
		System.out.println("server in running");
	}

}
