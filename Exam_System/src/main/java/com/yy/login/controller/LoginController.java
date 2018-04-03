package com.yy.login.controller;

import com.yy.admin.domain.Admin;
import com.yy.admin.service.AdminService;
import com.yy.student.domain.Student;
import com.yy.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final static String ANUMBER_ERROR="0";
    private final static String PSSWORD_ERROR="1";
    private final static String STUDENT_SUCCESS="2";
    private final static String ADMIN_SUCCESS="3";

    @Resource
    private StudentService studentService;
    @Resource
    private AdminService adminService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }


    @ResponseBody
    @RequestMapping("/ajaxLogin")
    public Map<String,Object> userLogin(String stuNumber, String password, HttpSession session){
        Map<String,Object> result=new HashMap<>();

        String power=null;
        Student student = studentService.selectStudentByNumber(stuNumber);
        Admin admin = adminService.selectByCode(stuNumber);
        if (student!=null){
            power=student.getPower();
        }
        if (admin!=null){
            power=admin.getPower();
        }
        if (power==null){
            result.put("flag",ANUMBER_ERROR);
            return result;
        }else if (power.equals("student")){
            assert student != null;
            if (!student.getPassword().equals(password)){
                result.put("flag",PSSWORD_ERROR);
                return result;
            }else {
                session.setAttribute("student",student);
                result.put("flag",STUDENT_SUCCESS);
                return result;
            }
        }else if (power.equals("admin")){
            if (!(admin != null && admin.getAdminPassword().equals(password))){
                result.put("flag",PSSWORD_ERROR);
                return result;
            }else {
                session.setAttribute("admin",admin);
                result.put("flag",ADMIN_SUCCESS);
                return result;
            }
        }
        return null;
    }

}
