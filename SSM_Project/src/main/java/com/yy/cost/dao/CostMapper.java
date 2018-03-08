package com.yy.cost.dao;

import com.yy.cost.domain.Cost;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface CostMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cost record);

    int insertSelective(Cost record);

    Cost selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cost record);

    List<Cost> queryAllCost(Map<String,Object> map);
    int queryDataCount();

    List<Cost> queryAllCostName();

}