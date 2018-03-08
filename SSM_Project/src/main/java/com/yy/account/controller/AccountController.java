package com.yy.account.controller;

import com.yy.account.domain.Account;
import com.yy.account.service.AccountService;
import com.yy.account.service.util.AccountPageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Resource
    private AccountService accountService;

    @RequestMapping("/toAccount")
    public String toAccount(){
        return "account/account_list";
    }

    @RequestMapping("/accountList")
    public String groupSearch(Model model,AccountPageBean pageBean){
        AccountPageBean accountPageBean=accountService.queryByGroup(pageBean);
        model.addAttribute("accountPageBean",accountPageBean);
        return "account/account_list";
    }

    @RequestMapping("/toModify")
    public String toModify(Model model,int accountId){
        Account account=accountService.queryAccountById(accountId);
        model.addAttribute("account",account);
        return "account/account_modi";
    }

    @RequestMapping("/modifyAccount")
    public String ModifyAccount(Account account){
        accountService.modifyAccount(account);
        return "redirect:accountList";
    }

    @RequestMapping("toAddAccount")
    public String toAddAccount(){
        return "account/account_add";
    }

    @RequestMapping("/addAccount")
    public String addAccount(Account account){
        accountService.addAccount(account);
        return "redirect:accountList";
    }

    @RequestMapping("/deleteAccount")
    public String deleteAccount(int accountId){
        accountService.deleteAccountById(accountId);
        return "redirect:accountList";
    }

    @RequestMapping("/accountDetail")
    public String accountDetail(Model model,int accountId){
        Account account = accountService.queryAccountById(accountId);
        model.addAttribute("account",account);
        return "account/account_detail";
    }

    @RequestMapping("/changeStatus")
    public String changeStatus(int accountId){
        accountService.changStatus(accountId);
        return "redirect:accountList";
    }

}
