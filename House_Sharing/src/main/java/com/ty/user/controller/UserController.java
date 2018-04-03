package com.ty.user.controller;

import com.ty.user.domain.Rental;
import com.ty.user.domain.User;
import com.ty.user.service.UserService;
import com.ty.user.service.util.RentalPageBean;
import com.ty.util.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.security.util.Password;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
//进入个人信息界面
    @RequestMapping("/toInfo")
    public String toInfo(){
        return "user/user_info";
    }


    //查出所有的租房信息
    @RequestMapping("/queryRentals")
    public String queryRentals(Model model, RentalPageBean pageBean){
        RentalPageBean rentalPageBean=userService.queryAllRental(pageBean);
        model.addAttribute("pageBean",rentalPageBean);
        return "rental/rental_list";
    }
//进入发布租房信息界面
    @RequestMapping("/toHouseRental")
    public String toHouseRental(){
        return "rental/rental_add";
    }
    //发布租房信息
    @RequestMapping("/addRental")
    public String addRental(Rental rental){
        userService.addRental(rental);
        return "redirect:queryRentals";
    }

    //进入出租房详情页
    @RequestMapping("/toRentalDetail")
    public String toRentalDetail(Model model,int rid){
        Rental rental=userService.queryRentalByRid(rid);
        model.addAttribute("rental",rental);
        return "rental/rental_detail";
    }
//进入修改页面
    @RequestMapping("/toRentalModify")
    public String toRentalModify(Model model,int rid){
        Rental rental = userService.queryRentalByRid(rid);
        model.addAttribute("rental",rental);
        return "rental/rental_modi";
    }
    //租房信息修改
    @RequestMapping("/rentalModify")
    public String rentalModify(Rental rental){
        System.out.println("测试传到后台的rental:"+rental);
        userService.rentalModify(rental);
        return "redirect:queryRentals";
    }
    //查询登录用户的租房信息
    @RequestMapping("/myRental")
    public String myRental(Model model,int uid,int nowPageIndex){
        PageBean pageBean=userService.queryRentalByUid(uid,nowPageIndex);
        model.addAttribute("pageBean",pageBean);
        return "rental/rental_my";
    }

    //进行租房，改变状态
    @RequestMapping("/changeState")
    public String changeState(int rid){
        userService.changeState(rid);
        return "redirect:queryRentals";
    }
    //修改个人信息
    @RequestMapping("/modifyUser")
    public String modifyUser(User user){
        System.out.println(user.toString());
        userService.modifyUserInfo(user);
        return "main/index";
    }
    //进入修改密码界面
    @RequestMapping("/toModifyPassword")
    public String toModifyPassword(){
        return "user/user_modi_pwd";
    }
    //修改密码
    @ResponseBody
    @RequestMapping("/modifyPassword")
    public Map<String,Object> modifyPassword(int uid, String password, String newPassword){
        Map<String,Object> result=new HashMap<>();

        User user=userService.selectUserById(uid);
        if (!user.getPassword().equals(password)){
            result.put("flag","1");
            return result;
        }else {
            result.put("flag","2");
            user.setPassword(newPassword);
            userService.modifyUserPassword(user);
            return result;
        }
    }
}
