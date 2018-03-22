package com.yy.springbootweb_wyj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ComponentScan("com.yy")
@SpringBootApplication
public class SpringbootwebWyjApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebWyjApplication.class, args);
	}
}
