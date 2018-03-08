package com.yy.account.service;

import com.yy.account.domain.Account;
import com.yy.account.service.util.AccountPageBean;

public interface AccountService {

    AccountPageBean queryByGroup(AccountPageBean pageBean);

    Account queryAccountById(int id);

    void addAccount(Account account);

    void modifyAccount(Account account);

    void deleteAccountById(int accountId);

    void changStatus(int accountId);

}
