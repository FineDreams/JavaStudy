package com.yy.config;

import com.yy.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsServiceImpl(){
        return new UserDetailServiceImpl();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //添加我们自定义的user detail service 认证
        auth.userDetailsService(userDetailsServiceImpl());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()//所有请求都需要认证(登录后才能访问)
                .and()
                .formLogin()
                .loginPage("/login")//定制登录行为，登录页面可以任意访问
                .failureUrl("/login?error")
                .permitAll()//失败页面可以任意访问
                .and()
                .logout().permitAll();//定制注销行为，注销请求可以任意访问
        //permitAll:赋予任意全新
        //failureUrl：指定失败页面
    }
}
