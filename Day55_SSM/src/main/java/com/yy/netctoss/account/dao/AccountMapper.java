package com.yy.netctoss.account.dao;

import com.yy.netctoss.account.domain.Account;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer accountId);

    Account searchAccountByName(String name);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}