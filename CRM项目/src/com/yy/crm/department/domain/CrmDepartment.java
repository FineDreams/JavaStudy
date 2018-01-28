package com.yy.crm.department.domain;

import com.yy.crm.post.domain.CrmPost;

import java.util.HashSet;
import java.util.Set;

public class CrmDepartment {
    private String depId;
    private String depName;
    private Set<CrmPost> crmPosts=new HashSet<>();

    public Set<CrmPost> getCrmPosts() {
        return crmPosts;
    }

    public CrmDepartment() {
    }

    public CrmDepartment(String depId, String depName, Set<CrmPost> crmPosts) {
        this.depId = depId;
        this.depName = depName;
        this.crmPosts = crmPosts;
    }

    @Override
    public String toString() {
        return "CrmDepartment{" +
                "depId='" + depId + '\'' +
                ", depName='" + depName + '\'' +
                ", crmPosts=" + crmPosts +
                '}';
    }

    public void setCrmPosts(Set<CrmPost> crmPosts) {
        this.crmPosts = crmPosts;
    }

    public String getDepId() {
        return depId;
    }

    public void setDepId(String depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrmDepartment that = (CrmDepartment) o;

        if (depId != null ? !depId.equals(that.depId) : that.depId != null) return false;
        if (depName != null ? !depName.equals(that.depName) : that.depName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = depId != null ? depId.hashCode() : 0;
        result = 31 * result + (depName != null ? depName.hashCode() : 0);
        return result;
    }
}
