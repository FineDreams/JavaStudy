package com.yy.crm.post.service;

import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.post.domain.CrmPost;
import com.yy.crm.staff.domain.CrmStaff;

import java.util.List;

public interface PostService {
    List<CrmPost> ajaxGet(CrmDepartment department);

    List<CrmStaff> searchGroup(String depName, String postName, String staffName);

    List<CrmPost> queryAllDep();

    CrmPost queryByPostId(String postId);

    void addOrEdit(CrmPost crmPost);
}
