package domain;

import java.util.List;

public class PageBean {
    private List<User> users;
    private int pageCode;//当前页码
    private int totalData;//数据总条数
    private int totalPages;//总页码
    private int pageSize=10;//一个页面显示多少条数据

    private String params;//多条件组合查询的条件

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalPages() {
        int number=totalData/pageSize;
        if (totalData%pageSize>0){
            number++;
        }
        return number;
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public void setUsers(List<User> users) {

        this.users = users;
    }

    public List<User> getUsers() {

        return users;
    }

    public PageBean() {

    }

    public PageBean(List<User> users, int pageCode, int totalData, int pageSize, String params) {

        this.users = users;
        this.pageCode = pageCode;
        this.totalData = totalData;
        this.pageSize = pageSize;
        this.params = params;
    }
}
