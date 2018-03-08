package com.yy.account.dao;

import com.yy.account.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AccountMapper {
    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer accountId);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);


    int queryDataCount(Map<String, Object> map);

    List<Account> selectByGroup(Map<String, Object> map);

    Account queryByIdcardNo(String idcardNo);
}