package com.yy.crm.post.dao.impl;

import com.yy.crm.department.domain.CrmDepartment;
import com.yy.crm.post.dao.PostDao;
import com.yy.crm.post.domain.CrmPost;
import com.yy.crm.staff.domain.CrmStaff;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
    @Override
    public List<CrmPost> ajaxGetInfo(CrmDepartment department) {
        List<CrmPost> crmPosts= (List<CrmPost>) this.getHibernateTemplate().find("from CrmPost where crmDepartment=?", department);
        return crmPosts;
    }

    @Override
    public List<CrmStaff> searchGroup(String sb) {
        List<CrmStaff> crmStaffList = (List<CrmStaff>) this.getHibernateTemplate().find(sb);
        return crmStaffList;
    }

    @Override
    public List<CrmPost> queryAllDep() {
        List<CrmPost> crmPosts= (List<CrmPost>) this.getHibernateTemplate().find("from CrmPost ");
        return crmPosts;
    }

    @Override
    public CrmPost queryByPostId(String postId) {
        CrmPost crmPost = this.getHibernateTemplate().get(CrmPost.class, postId);
        return crmPost;
    }

    @Override
    public void addOrEdit(CrmPost crmPost) {
        String postId = crmPost.getPostId();
        if (!postId.equals("")){
            CrmPost post = getHibernateTemplate().get(CrmPost.class, postId);
            post.setPostName(crmPost.getPostName());
        }else {
            CrmDepartment crmDepartment = getHibernateTemplate().get(CrmDepartment.class, crmPost.getCrmDepartment().getDepId());
            crmPost.setCrmDepartment(crmDepartment);
            getHibernateTemplate().save(crmPost);
        }
    }


}
