package com.yy.account.service.impl;

import com.yy.account.dao.AccountMapper;
import com.yy.account.domain.Account;
import com.yy.account.service.AccountService;
import com.yy.account.service.util.AccountPageBean;
import com.yy.service.dao.ServiceMapper;
import com.yy.service.domain.Service;
//import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Resource
    private ServiceMapper serviceMapper;

    @Override
    public AccountPageBean queryByGroup(AccountPageBean pageBean) {
        Map<String,Object> map=new HashMap<>();
        if (pageBean.getRealName()!=null){
            map.put("realName",pageBean.getRealName());
        }
        if (pageBean.getIdcardNo()!=null){
            map.put("idcardNo",pageBean.getIdcardNo());
        }
        if (pageBean.getLoginName()!=null){
            map.put("loginName",pageBean.getLoginName());
        }
        if (pageBean.getStatus()!=null){
            map.put("status",pageBean.getStatus());
        }
        int dataCount=accountMapper.queryDataCount(map);
        AccountPageBean accountPageBean=new AccountPageBean(pageBean.getNowPageIndex(),dataCount);

        map.put("start",accountPageBean.getStart());
        map.put("pageSize",accountPageBean.getPageSize());

        List<Account> accountList=accountMapper.selectByGroup(map);
        accountPageBean.setList(accountList);
        accountPageBean.setRealName(pageBean.getRealName());
        accountPageBean.setIdcardNo(pageBean.getIdcardNo());
        accountPageBean.setLoginName(pageBean.getLoginName());
        accountPageBean.setStatus(pageBean.getStatus());
        return accountPageBean;
    }

    @Override
    public Account queryAccountById(int id) {
        Account account = accountMapper.selectByPrimaryKey(id);
        return account;
    }

    @Override
    public void addAccount(Account account) {
        account.setStatus("1");
        accountMapper.insertSelective(account);
    }

    @Override
    public void modifyAccount(Account account) {
        accountMapper.updateByPrimaryKeySelective(account);
    }

    @Override
    public void deleteAccountById(int accountId) {
        Account account = accountMapper.selectByPrimaryKey(accountId);
        account.setStatus("3");
        Date date = new Date();
        account.setCloseDate(date);
        accountMapper.updateByPrimaryKeySelective(account);
        List<Service> serviceList=serviceMapper.queryByAccountId(accountId);
        for (Service service : serviceList) {
            service.setStatus("3");
            service.setCloseDate(date);
            serviceMapper.updateByPrimaryKeySelective(service);
        }

    }

    @Override
    public void changStatus(int accountId) {
        Account account = accountMapper.selectByPrimaryKey(accountId);
        String status = account.getStatus();
        if (status.equals("1")){
            account.setStatus("2");
            account.setPauseDate(new Date());
            List<Service> serviceList = serviceMapper.queryByAccountId(accountId);
            for (Service service : serviceList) {
                service.setStatus("2");
                service.setPauseDate(new Date());
                serviceMapper.updateByPrimaryKeySelective(service);
            }
        }
        if (status.equals("2")){
            account.setStatus("1");
        }
        accountMapper.updateByPrimaryKey(account);
    }
}
