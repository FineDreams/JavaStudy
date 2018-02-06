package com.yy.crm.post.dao;

import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.post.domain.CrmPost;
import com.yy.crm.staff.domain.CrmStaff;

import java.util.List;

public interface PostDao {
    List<CrmPost> ajaxGetInfo(CrmDepartment department);
    List<CrmStaff> searchGroup(String sb);

    List<CrmPost> queryAllDep();

    CrmPost queryByPostId(String postId);

    void addOrEdit(CrmPost crmPost);
}
