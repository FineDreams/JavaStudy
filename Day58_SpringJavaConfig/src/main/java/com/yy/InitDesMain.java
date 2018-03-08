package com.yy;

import com.yy.config.InitDesConfig;
import com.yy.service.BeanService;
import com.yy.service.JSR250Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InitDesMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(InitDesConfig.class);
        JSR250Service bean = context.getBean(JSR250Service.class);
        BeanService beanService = context.getBean(BeanService.class);
    }
}
