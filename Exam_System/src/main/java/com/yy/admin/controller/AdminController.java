package com.yy.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/toIndex")
    public String toManagerIndex(){
        return "manager/manager";
    }
    @RequestMapping("/toTestPaper")
    public String toTestPaper(){
        return "manager/paper/Paper";
    }
    @RequestMapping("/toQuestions")
    public String toTiKu(){
        return "manager/question/Tiku";
    }
    @RequestMapping("/toAddTopic")
    public String toAddTopic(){
        return "manager/question/AddQuestion";
    }
    @RequestMapping("toAddPaper")
    public String toAddPaper(){
        return "manager/paper/addPaper";
    }

    @RequestMapping("toModifyAccount")
    public String toModifyAccount(){
        return "manager/AccountMaintain";
    }


}
