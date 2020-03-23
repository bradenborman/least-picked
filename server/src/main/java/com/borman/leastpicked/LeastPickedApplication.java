package com.borman.leastpicked;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LeastPickedApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(LeastPickedApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LeastPickedApplication.class);
	}

}