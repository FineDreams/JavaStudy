package com.yy.account.service.util;

import com.yy.util.PageBean;

import java.util.ArrayList;
import java.util.List;

public class AccountPageBean extends PageBean {
    /**
     * 构造PageBean对象仅需要三个参数,其他参数皆可以计算得出
     *
     * @param nowPageIndex 当前页
     * @param dataCount    所有数据
     */
    public AccountPageBean(int nowPageIndex, int dataCount) {
        super(nowPageIndex, dataCount);
    }
    private String realName;
    private String idcardNo;
    private String loginName;
    private String status;

    public AccountPageBean() {
    }

    public AccountPageBean(int nowPageIndex, int dataCount, String realName, String idcardNo, String loginName, String status) {
        super(nowPageIndex, dataCount);
        this.realName = realName;
        this.idcardNo = idcardNo;
        this.loginName = loginName;
        this.status = status;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AccountPageBean{" +
                "realName='" + realName + '\'' +
                ", idcardNo='" + idcardNo + '\'' +
                ", loginName='" + loginName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
