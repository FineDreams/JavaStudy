package com.yy.crm.staff.web.filter;

import com.yy.crm.staff.domain.CrmStaff;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    private HttpServletRequest request;
    private HttpServletResponse response;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       request=(HttpServletRequest)servletRequest;
       response=(HttpServletResponse)servletResponse;
        CrmStaff crmStaff = (CrmStaff) request.getSession().getAttribute("crmStaff");
        if (crmStaff==null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
