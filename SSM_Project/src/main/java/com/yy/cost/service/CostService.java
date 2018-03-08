package com.yy.cost.service;

import com.yy.cost.domain.Cost;
import com.yy.cost.service.util.CostPageBean;
import com.yy.util.PageBean;

import java.util.List;

public interface CostService {
//    PageBean queryAllCost(int page);

    void addCost(Cost cost);

    Cost queryDetailById(int id);

    void ModifyDetail(Cost cost);

    void deleteCostById(int id);

    void ModifyStatus(int id);

    CostPageBean queryAllCost(int nowPageIndex, String sort, String group);
}
