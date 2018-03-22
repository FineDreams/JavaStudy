package com.yy.config;

import com.yy.converter.MyMessageConverter;
import com.yy.interceptor.ShowInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("com.yy")
public class MyMvcConfig extends WebMvcConfigurerAdapter{

    /**
     * @returnInternalResourceViewResolver 是SpringMVC视图渲染的核心机制
     *
     */
   @Bean
   public InternalResourceViewResolver viewResolver(){
       InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
       //jsp页面前缀
       viewResolver.setPrefix("/WEB-INF/classes/views/");
       //后缀
       viewResolver.setSuffix(".jsp");
       viewResolver.setViewClass(JstlView.class);
       return viewResolver;
   }
   @Bean
   public ShowInterceptor showInterceptor(){
       return new ShowInterceptor();
   }

//   文件上传
    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
        //设置文件上传最大值
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }

//    在配置类中添加自定义的转换器
    @Bean
    public MyMessageConverter messageConverter(){
        return new MyMessageConverter();
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(messageConverter());
    }
//    在配置类中添加演示页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //addResourceHandler指的是对外暴露的访问路径
        //addResourceLocations指的是文件放置的目录
       registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(showInterceptor());
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }
}
