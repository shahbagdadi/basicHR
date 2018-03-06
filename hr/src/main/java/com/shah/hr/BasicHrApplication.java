package com.shah.hr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BasicHrApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicHrApplication.class, args);
	}
}
