package com.yy.crm.post.domain;

import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.staff.domain.CrmStaff;

import java.util.HashSet;
import java.util.Set;

public class CrmPost {
    private String postId;
    private String postName;
//    private String depId;

    private CrmDepartment crmDepartment;
    private Set<CrmStaff> crmStaffs=new HashSet<>();

    public CrmDepartment getCrmDepartment() {
        return crmDepartment;
    }

    public void setCrmDepartment(CrmDepartment crmDepartment) {
        this.crmDepartment = crmDepartment;
    }

    public CrmPost(String postId, String postName,  CrmDepartment crmDepartment, Set<CrmStaff> crmStaffs) {
        this.postId = postId;
        this.postName = postName;
//        this.depId = depId;
        this.crmDepartment = crmDepartment;
        this.crmStaffs = crmStaffs;
    }



    @Override
    public String toString() {
        return "CrmPost{" +
                "postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
//                ", depId='" + depId + '\'' +
//                ", crmStaffs=" + crmStaffs +
                '}';
    }

//    public void setDepId(String depId) {
//        this.depId = depId;
//    }
//
//    public String getDepId() {
//        return depId;
//    }

    public Set<CrmStaff> getCrmStaffs() {
        return crmStaffs;
    }


    public CrmPost() {

    }

    public void setCrmStaffs(Set<CrmStaff> crmStaffs) {
        this.crmStaffs = crmStaffs;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrmPost crmPost = (CrmPost) o;

        if (postId != null ? !postId.equals(crmPost.postId) : crmPost.postId != null) return false;
        if (postName != null ? !postName.equals(crmPost.postName) : crmPost.postName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postId != null ? postId.hashCode() : 0;
        result = 31 * result + (postName != null ? postName.hashCode() : 0);
        return result;
    }
}
