package com.yy;

import com.yy.config.SpringConfig;
import com.yy.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        HelloService helloService = (HelloService) context.getBean("helloService");
        helloService.sayHello();
    }
}
