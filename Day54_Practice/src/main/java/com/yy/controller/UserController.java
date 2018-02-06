package com.yy.controller;

import com.yy.domain.Department;
import com.yy.domain.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
//@RequestMapping("/user")
public class UserController {
    private Department department=new Department();
//    private String SUCCESS="success";


    @RequestMapping(value = "/display")
    @ResponseBody
    public Department display(String depart){
        System.out.println("你好");
        System.out.println(depart);
        int departId= Integer.parseInt(depart);
        System.out.println(departId);
        List<Post> posts =new ArrayList<Post>();
        if (departId==0){
            department.setDepartId("0");
            department.setName("外部");
            posts.add(new Post("1","经理"));
            posts.add(new Post("2","副经理"));
            posts.add(new Post("3","秘书"));
            posts.add(new Post("4","文员"));
        }
        if (departId==1){
            department.setDepartId("1");
            department.setName("内部");
            posts.add(new Post("1","总裁"));
            posts.add(new Post("2","董事长"));
            posts.add(new Post("3","股东"));
            posts.add(new Post("4","HR"));
        }
        department.setPostList(posts);
        System.out.println(department.toString());
        return department;

    }

    @RequestMapping("/upload")
    public String uploadFile(MultipartFile item) throws IOException{
//        原始名称
        String originalFilename = item.getOriginalFilename();
        if (originalFilename != null && originalFilename.length() > 0){
//            存储图片的物理路径
            String pic_path="C:\\Users\\lanou3g\\Desktop\\Temp";
//            新的图片名称
            String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
//            新图片
            File newFile = new File(pic_path, newFileName);
            System.out.println(newFile.getAbsolutePath());
//            保存文件
            item.transferTo(newFile);
        }
        return "display";
    }
}
