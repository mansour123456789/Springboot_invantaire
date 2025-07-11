package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.example.model")
@ComponentScan({"com.example"})
@EnableJpaRepositories("com.example.repository")
public class PfaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PfaApplication.class, args);
	}

}
