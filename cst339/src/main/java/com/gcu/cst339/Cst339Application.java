package com.gcu.cst339;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.gcu" })
@EnableJpaRepositories({ "com.gcu.data.repository" })
@EntityScan({ "com.gcu.model" })
public class Cst339Application {

	public static void main(String[] args) {
		SpringApplication.run(Cst339Application.class, args);
	}

}
