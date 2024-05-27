package com.spring.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author pelayord76
 */
@SpringBootApplication
@EnableScheduling
public class PdawApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdawApplication.class, args);
	}

}
