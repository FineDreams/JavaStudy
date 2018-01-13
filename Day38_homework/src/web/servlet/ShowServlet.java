package web.servlet;

import domain.PageBean;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import service.ShowService;
import util.C3POUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShowServlet",urlPatterns = "/show")
public class ShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pc = request.getParameter("pc");
        PageBean pageBean=new PageBean();
        if (pc==null){
          pc="1";
        }
        int p = Integer.parseInt(pc);
        int begin=(p-1)*pageBean.getPageSize();
        int end=p*pageBean.getPageSize();
        pageBean.setPageCode(p);

        String uname = request.getParameter("uname");
        String gender = request.getParameter("gender");
        String score = request.getParameter("score");
        String age = request.getParameter("age");

        String[] pageInfo={"uname","gender","score","age"};
        String[] pageValue={uname,gender,score,age};

        String params="";
        for (int i = 0; i < pageValue.length; i++) {
            if (pageValue[i]!=null&&pageValue[i]!=""){
                params=params+"&"+pageInfo[i]+"="+pageValue[i];
            }
        }
        pageBean.setParams(params);

        ShowService showService=new ShowService();
        List<User> users = showService.searchByGroup(begin,uname,gender,score,age);
        pageBean.setUsers(users);
        int count = showService.searchCount(uname, gender, score, age);
        pageBean.setTotalData(count);

        request.setAttribute("pageBean",pageBean);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
