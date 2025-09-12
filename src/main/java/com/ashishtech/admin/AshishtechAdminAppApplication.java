package com.ashishtech.admin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AshishtechAdminAppApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AshishtechAdminAppApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AshishtechAdminAppApplication.class, args);
	}
}
