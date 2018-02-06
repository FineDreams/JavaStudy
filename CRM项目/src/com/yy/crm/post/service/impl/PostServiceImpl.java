package com.yy.crm.post.service.impl;

import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.post.dao.PostDao;
import com.yy.crm.post.domain.CrmPost;
import com.yy.crm.post.service.PostService;
import com.yy.crm.staff.domain.CrmStaff;

import java.util.List;

public class PostServiceImpl implements PostService {
    private PostDao postDao;

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<CrmPost> ajaxGet(CrmDepartment department) {
        List<CrmPost> crmPosts = postDao.ajaxGetInfo(department);
        return crmPosts;
    }

    @Override
    public List<CrmStaff> searchGroup(String depName, String postName, String staffName) {
        StringBuilder sb=new StringBuilder("from CrmStaff cs where 1=1 ");
        if (depName!=null&&postName==null&&staffName==null){
            sb.append(" and cs.crmPost.crmDepartment='"+depName+"'");
        }
        if (depName==null&&postName==null&&staffName!=null){
            sb.append(" and cs.staffName like '%"+staffName+"%'");
        }
        if (depName==null&&postName==null&&staffName==null){
            sb.append("");
        }
        List<CrmStaff> crmStaffs = postDao.searchGroup(sb.toString());
        return crmStaffs;
    }

    @Override
    public List<CrmPost> queryAllDep() {
       List<CrmPost> crmPostList=postDao.queryAllDep();
        return crmPostList;
    }

    @Override
    public CrmPost queryByPostId(String postId) {
        CrmPost crmPost=postDao.queryByPostId(postId);
        return crmPost;
    }

    @Override
    public void addOrEdit(CrmPost crmPost) {
        postDao.addOrEdit(crmPost);
    }
}
