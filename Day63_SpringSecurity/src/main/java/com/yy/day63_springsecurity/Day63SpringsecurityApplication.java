package com.yy.day63_springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.yy")
public class Day63SpringsecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day63SpringsecurityApplication.class, args);
	}
}
