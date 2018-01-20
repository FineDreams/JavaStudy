package com.yy.action;

import com.yy.bean.BaseDao;
import com.yy.bean.BaseDaoImpl;
import com.yy.bean.Demo;

public class DemoAction {
    private BaseDao<Demo> baseDao=new BaseDaoImpl();
    public String demo(){
        //假装我是一个Struts2的action
        //毕竟POJO类也可以作为action使用

        baseDao.add(new Demo());
        return "success";
    }
}
