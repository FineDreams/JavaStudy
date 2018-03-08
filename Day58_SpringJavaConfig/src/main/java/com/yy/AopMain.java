package com.yy;

import com.yy.config.AopConfig;
import com.yy.service.AopDemoService;
import com.yy.service.MethodAopService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
        context.register(AopConfig.class);

        //一定要刷新的
        context.refresh();
        AopDemoService aopDemoService = context.getBean(AopDemoService.class);
        MethodAopService methodAopService = context.getBean(MethodAopService.class);
        aopDemoService.showAop();
        methodAopService.showAop();
        context.close();
    }
}
