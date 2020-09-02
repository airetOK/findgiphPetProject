package com.airetok.findgiph;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FindgiphApplication {

	public static void main(String[] args) {
		SpringApplication.run(FindgiphApplication.class, args);
	}

}
