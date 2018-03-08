package com.yy.cost.service.impl;

import com.yy.cost.dao.CostMapper;
import com.yy.cost.domain.Cost;
import com.yy.cost.service.CostService;
import com.yy.cost.service.util.CostPageBean;
import com.yy.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CostServiceImpl implements CostService {

    @Resource
    private CostMapper costMapper;

    @Override
    public CostPageBean queryAllCost(int page, String sort, String group) {
        int pageCount = costMapper.queryDataCount();
        CostPageBean pageBean=  new CostPageBean(page,pageCount,sort,group);
        Map<String,Object> map=new HashMap<>();
        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());
        if (sort!=null){
            map.put("sort",sort);
        }
        if (group!=null){
            map.put("group",group);
        }
        List<Cost> costList = costMapper.queryAllCost(map);
        pageBean.setList(costList);
        return pageBean;
    }

    @Override
    public void addCost(Cost cost) {
        cost.setStatus("0");
        costMapper.insert(cost);
    }

    @Override
    public Cost queryDetailById(int id) {
        Cost cost= costMapper.selectByPrimaryKey(id);
        return cost;
    }

    @Override
    public void ModifyDetail(Cost cost) {
        costMapper.updateByPrimaryKeySelective(cost);
    }

    @Override
    public void deleteCostById(int id) {
        costMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void ModifyStatus(int id) {
        Cost cost = costMapper.selectByPrimaryKey(id);
        String status = cost.getStatus();
        Date startime = cost.getStartime();
        if (startime==null){
            cost.setStartime(new Date());
        }
        if (status.equals("0")){
            cost.setStatus("1");
        }
        if (status.equals("1")){
            cost.setStatus("0");
        }
        costMapper.updateByPrimaryKeySelective(cost);
    }
}
