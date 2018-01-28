package com.yy.crm.post.dao;

import com.yy.crm.post.domain.CrmPost;

import java.util.List;

public interface PostDao {
    List<CrmPost> ajaxGetInfo(String depId);
}
