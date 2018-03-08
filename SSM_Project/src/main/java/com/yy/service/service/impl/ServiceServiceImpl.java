package com.yy.service.service.impl;

import com.yy.account.dao.AccountMapper;
import com.yy.account.domain.Account;
import com.yy.cost.dao.CostMapper;
import com.yy.cost.domain.Cost;
import com.yy.service.dao.ServiceMapper;
import com.yy.service.domain.Service;
import com.yy.service.service.ServiceService;
import com.yy.service.service.util.ServicePageBean;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service("serviceService")
public class ServiceServiceImpl implements ServiceService {
    @Resource
    private ServiceMapper serviceMapper;

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private CostMapper costMapper;

    @Override
    public ServicePageBean queryBygroup(ServicePageBean servicePageBean) {
        Map<String,Object> map=new HashMap<>();
        if(servicePageBean.getIdcardNo()!=null){
            map.put("idcardNo",servicePageBean.getIdcardNo());
        }
        if (servicePageBean.getOsUsername()!=null){
            map.put("osUsername",servicePageBean.getOsUsername());
        }
        if (servicePageBean.getUnixHost()!=null){
            map.put("unixHost",servicePageBean.getUnixHost());
        }
        if (servicePageBean.getStatus()!=null){
            map.put("status",servicePageBean.getStatus());
        }

        int dataCount=serviceMapper.queryDataCount(map);
        ServicePageBean pageBean=new ServicePageBean(servicePageBean.getNowPageIndex(),dataCount);

        map.put("start",pageBean.getStart());
        map.put("pageSize",pageBean.getPageSize());


        pageBean.setIdcardNo(servicePageBean.getIdcardNo());
        pageBean.setOsUsername(servicePageBean.getOsUsername());
        pageBean.setUnixHost(servicePageBean.getUnixHost());
        pageBean.setStatus(servicePageBean.getStatus());
        List<Service> serviceList=serviceMapper.queryAllByGroup(map);
        pageBean.setList(serviceList);
        return pageBean;
    }

    @Override
    public Service queryDetailById(int serviceId) {
        Service service=serviceMapper.selectByPrimaryKey(serviceId);
        return service;
    }

    @Override
    public void modifyService(Service service) {
        Integer id = service.getCostId();
        Service selectByPrimaryKey = serviceMapper.selectByPrimaryKey(service.getServiceId());
        Cost cost = selectByPrimaryKey.getCost();
        Cost costById = costMapper.selectByPrimaryKey(id);
        cost.setName(costById.getName());
        costMapper.updateByPrimaryKeySelective(cost);
    }

    @Override
    public Account queryByIdcardNo(String idcardNo) {
        Account account=accountMapper.queryByIdcardNo(idcardNo);
        return account;
    }

    @Override
    public List<Cost> queryAllCostName() {
        List<Cost> costList=costMapper.queryAllCostName();
        return costList;
    }

    @Override
    public void addService(Service service) {
        service.setStatus("1");
        service.setCreateDate(new Date());
        serviceMapper.insertSelective(service);
    }

    @Override
    public void deleteServiceById(int serviceId) {
        Service service = serviceMapper.selectByPrimaryKey(serviceId);
        service.setStatus("3");
        serviceMapper.updateByPrimaryKeySelective(service);
    }

    @Override
    public void changServiceStatus(int serviceId) {
        Service service = serviceMapper.selectByPrimaryKey(serviceId);
        String serviceStatus = service.getStatus();
        Integer accountId = service.getAccountId();
        Account account = accountMapper.selectByPrimaryKey(accountId);
        String accountStatus = account.getStatus();
        if (accountStatus.equals("1")){
            if (serviceStatus.equals("1")){
                service.setStatus("2");
                service.setPauseDate(new Date());
            }
            if (serviceStatus.equals("2")){
                service.setStatus("1");
                service.setCreateDate(new Date());
            }
            serviceMapper.updateByPrimaryKeySelective(service);
        }
    }
}
