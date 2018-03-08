package com.yy.config;

import com.yy.service.BeanService;
import com.yy.service.JSR250Service;
import org.springframework.context.annotation.Bean;

public class InitDesConfig {
    @Bean(initMethod = "init",destroyMethod = "destroy")
    public BeanService beanService(){
        return new BeanService();
    }

    @Bean
    public JSR250Service jsr250Service(){
        return new JSR250Service();
    }
}
