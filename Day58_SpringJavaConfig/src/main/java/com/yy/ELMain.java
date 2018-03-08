package com.yy;

import com.yy.config.ELConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ELMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ELConfig.class);
        ELConfig bean = context.getBean(ELConfig.class);
        bean.outputResource();
        context.close();
    }
}
