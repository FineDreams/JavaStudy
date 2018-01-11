package com.yy.bookstore.user.web.servlet;

import com.lanou.servlet.BaseServlet;
import com.yy.bookstore.cart.domain.Cart;
import com.yy.bookstore.user.domain.User;
import com.yy.bookstore.user.service.UserService;
import com.yy.bookstore.user.service.exception.*;
import org.apache.commons.beanutils.BeanUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "UserServlet",urlPatterns = "/user")
public class UserServlet extends BaseServlet {
   private UserService userService=new UserService();
    public String login(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User login= userService.login(username, password);
            request.getSession().setAttribute("user",login);
            Cart cart=new Cart();
            request.getSession().setAttribute("cart",cart);
            return "r:/jsps/main.jsp";
        } catch (UserException e) {
            request.setAttribute("errorMsg",e.getMessage());
            return "f:/jsps/user/login.jsp";
        }
    }
    public String regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //f:表示请求转发
        //r:表示重定向
        Map<String, String[]> parameterMap = request.getParameterMap();


        User fromU=new User();
        try {
            BeanUtils.populate(fromU,parameterMap);
            String uuid= UUID.randomUUID().toString().replaceAll("-","");
            fromU.setUid(uuid);
            fromU.setCode(uuid);
            User regist = userService.regist(fromU);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UserException e) {
            request.setAttribute("errorMsg",e.getMessage());
            return "f:/jsps/msg.jsp";
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            userService.sendMail(fromU.getCode());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return "r:/jsps/user/login.jsp";
    }
    public String active(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/xml;charset=utf-8");
        String code =(String) request.getParameter("code");
        try {
            userService.active(code);
            response.getWriter().write("SUCCESS");

        } catch (UserException e) {
            request.setAttribute("errorMsg",e.getMessage());
            return "f:/jsps/msg.jsp";
        }  catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "f:/jsps/msg.jsp";
    }

    public String quit(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        if(session==null){
            return "r:/jsps/user/login.jsp";
        }
        User user = (User)session.getAttribute("user");

        Cookie cookie = new Cookie("username",user.getUsername());
        cookie.setMaxAge(60*60*24*10);
        response.addCookie(cookie);
        session.removeAttribute("user");
        return "f:/jsps/user/login.jsp";
    }
}
