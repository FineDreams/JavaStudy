package com.yy.crm.course.domain;

import com.yy.crm.staff.domain.CrmStaff;

import java.util.List;

public class PageBean {
    private List<CrmStaff> crmStaffs;
    private int pageCode;
    private int totalData;
    private int totalPages;
    private int pageSize=5;


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

    public List<CrmStaff> getCrmStaffs() {
        return crmStaffs;
    }

    public void setCrmStaffs(List<CrmStaff> crmStaffs) {
        this.crmStaffs = crmStaffs;
    }

    public PageBean(List<CrmStaff> crmStaffs, int pageCode, int totalData, int totalPages, int pageSize) {
        this.crmStaffs = crmStaffs;
        this.pageCode = pageCode;
        this.totalData = totalData;
        this.totalPages = totalPages;
        this.pageSize = pageSize;
    }

    public PageBean() {
    }
}
