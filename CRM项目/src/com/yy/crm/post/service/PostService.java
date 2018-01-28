package com.yy.crm.post.service;

import com.yy.crm.post.domain.CrmPost;

import java.util.List;

public interface PostService {
    List<CrmPost> ajaxGet(String depId);
}
