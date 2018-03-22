package com.yy.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
        context.register(MyMvcConfig.class);
        //将spring的配置与servletContext关联
        context.setServletContext(servletContext);
        context.refresh();
        //将spring的DispatcherServlet与AnnotationConfigWebApplicationContext
        ServletRegistration.Dynamic servlet=servletContext.addServlet("dispatcher",new DispatcherServlet(context));

        //匹配所有路径
        servlet.addMapping("/");
        //设置最先加载
        servlet.setLoadOnStartup(1);

    }
}
