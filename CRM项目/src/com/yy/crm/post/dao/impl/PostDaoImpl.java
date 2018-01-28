package com.yy.crm.post.dao.impl;

import com.yy.crm.post.dao.PostDao;
import com.yy.crm.post.domain.CrmPost;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class PostDaoImpl extends HibernateDaoSupport implements PostDao {
    @Override
    public List<CrmPost> ajaxGetInfo(String depId) {
        List<CrmPost> crmPosts= (List<CrmPost>) this.getHibernateTemplate().find("from CrmDepartment c where c.depId=?", depId);
        return crmPosts;
    }
}
