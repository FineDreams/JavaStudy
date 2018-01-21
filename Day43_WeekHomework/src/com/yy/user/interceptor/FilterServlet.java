package com.yy.user.interceptor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(filterName = "FilterServlet",urlPatterns = {"/addEmployee.jsp","/index.jsp","/modify.jsp"})
public class FilterServlet implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        String username = (String) request.getSession().getAttribute("username");
        if (username!=null) {
            chain.doFilter(req, resp);
            return;
        }
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
