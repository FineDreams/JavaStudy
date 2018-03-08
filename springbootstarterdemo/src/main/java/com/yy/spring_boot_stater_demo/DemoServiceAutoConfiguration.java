package com.yy.spring_boot_stater_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(DemoProperties.class)
@ConditionalOnClass(DemoService.class)
@ConditionalOnProperty(prefix = "demo",value = "enabled",matchIfMissing = true)
public class DemoServiceAutoConfiguration {

    @Autowired
    private DemoProperties demoProperties;

    @Bean
    public DemoService demoService(){
        DemoService demoService=new DemoService();
        demoService.setMsg(demoProperties.getMsg());
        return demoService;
    }

}
