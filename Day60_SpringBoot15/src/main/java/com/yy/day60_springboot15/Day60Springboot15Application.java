package com.yy.day60_springboot15;

import com.yy.spring_boot_stater_demo.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan("com.yy")
public class Day60Springboot15Application {

	@Autowired
	DemoService demoService;

	@RequestMapping("/")
	public String index(){
		return demoService.say();
	}

	public static void main(String[] args) {
		SpringApplication.run(Day60Springboot15Application.class, args);
	}
}
