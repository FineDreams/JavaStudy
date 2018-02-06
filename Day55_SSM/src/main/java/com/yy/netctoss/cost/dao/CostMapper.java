package com.yy.netctoss.cost.dao;

import com.yy.netctoss.cost.domain.Cost;

public interface CostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer id);

    Cost searchCostByName(String name);

    int updateByPrimaryKeySelective(Cost record);

    int updateByPrimaryKey(Cost record);
}