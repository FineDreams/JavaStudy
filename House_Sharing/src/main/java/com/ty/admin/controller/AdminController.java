package com.ty.admin.controller;

import com.ty.admin.service.AdminService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class AdminController {

    @Resource
    private AdminService adminService;

}
