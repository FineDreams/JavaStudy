package com.yy.service.service;

import com.yy.account.domain.Account;
import com.yy.cost.domain.Cost;
import com.yy.service.domain.Service;
import com.yy.service.service.util.ServicePageBean;

import java.util.List;

public interface ServiceService {
    ServicePageBean queryBygroup(ServicePageBean servicePageBean);

    Service queryDetailById(int serviceId);

    void modifyService(Service service);

    Account queryByIdcardNo(String idcardNo);

    List<Cost> queryAllCostName();

    void addService(Service service);

    void deleteServiceById(int serviceId);

    void changServiceStatus(int serviceId);

}
