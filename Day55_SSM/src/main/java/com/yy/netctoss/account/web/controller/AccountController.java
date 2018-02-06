package com.yy.netctoss.account.web.controller;

import com.yy.netctoss.account.dao.AccountMapper;
import com.yy.netctoss.account.domain.Account;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {
    private AccountMapper accountMapper;
    @RequestMapping(value = "/findAccount")
    public String login(Account account, Model model){
        AccountMapper accountMapper = (AccountMapper) new ClassPathXmlApplicationContext("spring-servlet.xml").getBean("accountMapper");
        Account accountByName = accountMapper.searchAccountByName(account.getLoginName());
        System.out.println(accountByName.toString());
        model.addAttribute("account",accountByName);
        return "index";
    }

}
