package com.yy.crm.post.service.impl;

import com.yy.crm.post.dao.PostDao;
import com.yy.crm.post.domain.CrmPost;
import com.yy.crm.post.service.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {
    private PostDao postDao;

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public List<CrmPost> ajaxGet(String depId) {
        List<CrmPost> crmPosts = postDao.ajaxGetInfo(depId);
        return crmPosts;
    }
}
