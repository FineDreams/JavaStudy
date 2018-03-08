package com.yy.service.dao;

import com.yy.service.domain.Service;
import com.yy.service.service.ServiceService;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ServiceMapper {
    int deleteByPrimaryKey(Integer serviceId);

    int insert(Service record);

    int insertSelective(Service record);

    Service selectByPrimaryKey(Integer serviceId);

    int updateByPrimaryKeySelective(Service record);

    int updateByPrimaryKey(Service record);

    int queryDataCount(Map<String, Object> map);

    List<Service> queryAllByGroup(Map<String, Object> map);

    List<Service> queryByAccountId(int accountId);

}