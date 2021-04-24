package com.session.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.session.controllers" })
public class SessionRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionRedisApplication.class, args);
	}

}
