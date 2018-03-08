package com.yy.springbootbase;

import com.yy.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//核心注解：是一个组合注解，功能：配置，自动配置，扫描
//自动配置：根据类路径中的jar包为当前项目自动配置
//如果添加了spring-boot-starter-web依赖：（自动配置Tomcat和springMVC）
//springBoot会自动扫描@springBootApplication所在类的同级包以及下级包里的bean
//下面是关闭：DataSource的自动配置
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@ImportResource({"classpath:some-context.xml","classpath:another-context.xml"})
@RestController
@SpringBootApplication
@ComponentScan("com.yy")
public class SpringbootbaseApplication {

	@Value("${project.author}")
	private String projectAuthor;

	@Value("${project.name}")
	private String projectName;

	@Autowired
	private AuthorSettings authorSettings;

	@RequestMapping("/indexTwo")
	public String indexTwo(){
		return "author name is "+authorSettings.getName()+"  author gender is "+authorSettings.getGender();
	}
	@RequestMapping("/indexOne")
	public String indexOne(){
		return "projectAuthor:----"+projectAuthor+"      projectName:----"+projectName;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringbootbaseApplication.class, args);
	}
}
