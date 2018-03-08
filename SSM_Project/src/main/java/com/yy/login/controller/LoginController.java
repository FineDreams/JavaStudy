package com.yy.login.controller;

import com.yy.admin.domain.Admin;
import com.yy.admin.service.AdminService;
import com.yy.login.util.ImageUtil;
import com.yy.role.domain.Module;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController{
    private final static int SUCCESS=0;
    private final static int ADMIN_CODE_ERROR=1;
    private final static int PASSWORD_ERROR=2;
    private final static int IMAGE_CODE_ERROR=3;

    @Resource
    private AdminService adminService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "main/login";
    }

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "main/index";
    }
    @RequestMapping("/noPower")
    public String noPower(){
        return "main/nopower";
    }
    @RequestMapping("/ajaxLogin")
    @ResponseBody
    public Map<String,Object> login(String adminCode, String password, String code, HttpSession session){
        Map<String,Object> result=new HashMap<>();
        String imageCode= (String) session.getAttribute("imageCode");
        if (code==null||!code.equalsIgnoreCase(imageCode)){
            result.put("flag",IMAGE_CODE_ERROR);
            return result;
        }
        Admin admin=adminService.findByCode(adminCode);
        if (admin==null){
            result.put("flag",ADMIN_CODE_ERROR);
            return result;
        }else if (!admin.getPassword().equals(password)){
            result.put("flag",PASSWORD_ERROR);
            return result;
        }else {
            session.setAttribute("admin",admin);
            List<Module> modules=adminService.findModulesByAdmin(admin.getAdminId());
            session.setAttribute("allModules",modules);
            result.put("flag",SUCCESS);
            return result;
        }
    }
    @RequestMapping("/createImage")
    public void createImage(HttpServletResponse response,HttpSession session) throws Exception{
        Map<String, BufferedImage> imageMap = ImageUtil.createImage();
        String code = imageMap.keySet().iterator().next();
        session.setAttribute("imageCode",code);
        BufferedImage image = imageMap.get(code);
        response.setContentType("image/jpeg");
        OutputStream ops=response.getOutputStream();
        ImageIO.write(image,"jpeg",ops);
        ops.close();
    }

}
