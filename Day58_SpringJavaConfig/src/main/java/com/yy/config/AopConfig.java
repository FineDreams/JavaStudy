package com.yy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//注解扫描，指定扫描那个包
@ComponentScan("com.yy")
@EnableAspectJAutoProxy//开启对AspectJ的支持
public class AopConfig {
}
