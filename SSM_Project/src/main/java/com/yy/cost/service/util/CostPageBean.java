package com.yy.cost.service.util;

import com.yy.util.PageBean;

public class CostPageBean extends PageBean {
    /**
     * 构造PageBean对象仅需要三个参数,其他参数皆可以计算得出
     *
     * @param nowPageIndex 当前页
     * @param dataCount    所有数据
     */
    public CostPageBean(int nowPageIndex, int dataCount) {
        super(nowPageIndex, dataCount);
    }
    private String sort;
    private String group;

    public CostPageBean(int nowPageIndex, int dataCount, String sort, String group) {
        super(nowPageIndex, dataCount);
        this.sort = sort;
        this.group = group;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "CostPageBean{" +
                "sort='" + sort + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
