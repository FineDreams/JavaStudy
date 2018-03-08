package com.yy.service.controller;

import com.yy.account.domain.Account;
import com.yy.cost.domain.Cost;
import com.yy.service.domain.Service;
import com.yy.service.service.ServiceService;
import com.yy.service.service.util.ServicePageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Resource
    private ServiceService serviceService;

    @RequestMapping("/serviceList")
    public String serviceList(Model model, ServicePageBean servicePageBean){
        ServicePageBean pageBean=serviceService.queryBygroup(servicePageBean);
        model.addAttribute("ServicePageBean",pageBean);
        return "service/service_list";
    }

    @RequestMapping("/serviceDetail")
    public String serviceDetail(Model model,int serviceId){
        Service service=serviceService.queryDetailById(serviceId);
        model.addAttribute("service",service);
        return "service/service_detail";
    }

    @RequestMapping("toAddService")
    public String toAddService(Model model){
        List<Cost> costList=serviceService.queryAllCostName();
        model.addAttribute("costList",costList);
        return "service/service_add";
    }

    @RequestMapping("/findByIdcardNo")
    @ResponseBody
    public Account findByIdcardNo(String idcardNo){
        Account account = serviceService.queryByIdcardNo(idcardNo);
        return  account;
    }

    @RequestMapping("/toServiceModify")
    public String toServiceModify(Model model,int serviceId){
        Service service=serviceService.queryDetailById(serviceId);
        List<Cost> costList=serviceService.queryAllCostName();
        model.addAttribute("service",service);
        model.addAttribute("costList",costList);
        return "service/service_modi";
    }

    @RequestMapping("/modifyService")
    public String modifyService(Service service){
        serviceService.modifyService(service);
        return "redirect:serviceList";
    }

    @RequestMapping("/addService")
    public String addService(Service service){
        System.out.println("测试service====="+service.toString());
        serviceService.addService(service);
        return "redirect:serviceList";
    }

    @RequestMapping("/deleteService")
    public String deleteService(int serviceId){
        serviceService.deleteServiceById(serviceId);
        return "redirect:serviceList";
    }

    @RequestMapping("/changServiceStatus")
    public String changServiceStatus(int serviceId){
        serviceService.changServiceStatus(serviceId);
        return "redirect:serviceList";
    }
}
