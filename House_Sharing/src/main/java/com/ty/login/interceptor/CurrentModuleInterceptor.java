package com.ty.login.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurrentModuleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURI();
        int currentModule=0;//默认0是netctorss首页
        if (url.contains("queryRentals")){
            currentModule=1;
        }else if (url.contains("toInfo")){
            currentModule=2;
        }else if (url.contains("toHouseRental")){
            currentModule=3;
        }else if (url.contains("myRental")){
            currentModule=4;
        }else if (url.contains("toModifyPassword")){
            currentModule=5;
        }
        httpServletRequest.getSession().setAttribute("currentModule",currentModule);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
