package com.yy.study.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "HomeFilter",urlPatterns = "/index.jsp")
public class HomeFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=utf-8");
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        String uname = (String)request.getSession().getAttribute("uname");
        if (uname!=null){
            chain.doFilter(req, resp);
            return;
        }
        response.sendRedirect(request.getContextPath()+"/login.jsp");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
