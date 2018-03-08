package com.yy.cost.controller;

import com.yy.cost.domain.Cost;
import com.yy.cost.service.CostService;
import com.yy.cost.service.util.CostPageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/cost")
public class CostController {
    @Resource
    private CostService costService;

    @RequestMapping("/feeList")
    public String feeList(Model model,int nowPageIndex,String sort,String group){
        if (sort==null){
            sort="sort_asc";
        }
        if (group==null){
            group="id";
        }
        CostPageBean pageBean =costService.queryAllCost(nowPageIndex,sort,group);
//        System.out.println(pageBean.toString());
        model.addAttribute("pageBean",pageBean);
        return "fee/fee_list";
    }

    @RequestMapping("/costDetail")
    public String costDetail(Model model,int id){
        Cost cost=costService.queryDetailById(id);
        model.addAttribute("cost",cost);
        return "fee/fee_detail";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "fee/fee_add";
    }
    @RequestMapping("/feelAdd")
    public String feelAdd(Model model,Cost cost){
        costService.addCost(cost);
        System.out.println(cost.toString());
        return "redirect:/cost/feeList?nowPageIndex=1";
    }
    @RequestMapping("/modifyDetail")
    public String modifyDetail(Model model,int id){
        Cost cost=costService.queryDetailById(id);
        model.addAttribute("cost",cost);
        return "fee/fee_modi";
    }
    @RequestMapping("/feeModify")
    public String feeModify(Cost cost){
        costService.ModifyDetail(cost);
//        System.out.println(cost.toString());
        return "fee/fee_list";
    }

    @RequestMapping("/delete")
    public String deleteCost(int id){
        costService.deleteCostById(id);
        return "redirect:/cost/feeList?nowPageIndex=1";
    }
    @RequestMapping("/modifyStatus")
    public String modifyStatus(int id){
        costService.ModifyStatus(id);
        return "redirect:/cost/feeList?nowPageIndex=1";
    }

}
