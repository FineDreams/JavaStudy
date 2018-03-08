package com.yy.config;

import com.yy.service.TargetService;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//在junit环境下提供Spring TestContext Framework的功能
@ContextConfiguration(classes = {TestConfig.class})
//加载配置ApplicationContext,classes参数用来加载配置类
@ActiveProfiles("prod")//声明当前正在活动的profile(可以理解为环境)
public class TestConfigTest {
    @Autowired//注入
    private TargetService targetService;
    @org.junit.Test
    public void prodBeanShouldInject(){
        String expected="for production profile";
        String actual=targetService.getContent();
        System.out.println(actual);
        //判断二者是否相等
        Assert.assertEquals(expected,actual);
    }
}