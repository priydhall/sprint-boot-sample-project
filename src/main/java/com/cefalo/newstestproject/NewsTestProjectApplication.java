package com.cefalo.newstestproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class NewsTestProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsTestProjectApplication.class, args);
	}
}
