package com.yy.student.controller;

import com.yy.student.domain.Student;
import com.yy.student.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final static String NUMBER_EXIT="exit";
    private final static String SUCCESS="ok";
    private final static String ERROR="error";


    @Resource
    private StudentService studentService;

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "student/student";
    }
    @RequestMapping("/toTest")
    public String toTest(){
        return "student/testPage";
    }
    @RequestMapping("/toManager")
    public String toManager(){
        return "manager/manager";
    }

    @ResponseBody
    @RequestMapping("/register")
    public Map<String,Object> register(Student student){
        Map<String,Object> result=new HashMap<>();
        Student studentByNumber=studentService.selectStudentByNumber(student.getStuNumber());
        if (studentByNumber!=null){
            result.put("flag",NUMBER_EXIT);
            return result;
        }else {
            studentService.insertStudent(student);
            result.put("flag",SUCCESS);
            return result;
        }
    }


}
