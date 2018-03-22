package com.yy.mapper;

import com.yy.domain.Article;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer goodsId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer goodsId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> queryAllArticle();

    Article queryArticlById(int goodsId);

}