package com.yy.login.interceptor;

import com.yy.role.domain.Module;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CheckModuleInterceptor implements HandlerInterceptor {
    @SuppressWarnings("unchecked")
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        List<Module> modules= (List<Module>) httpServletRequest.getSession().getAttribute("allModules");
        int currentModule= (Integer) httpServletRequest.getSession().getAttribute("currentModule");
        for (Module module:modules) {
            if (module.getModuleId()==currentModule){
                return true;
            }
        }
        httpServletResponse.sendRedirect(
                httpServletRequest.getContextPath()+"/login/noPower"
        );
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
