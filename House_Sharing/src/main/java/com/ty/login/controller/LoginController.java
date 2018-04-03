package com.ty.login.controller;

import com.ty.admin.domain.Admin;
import com.ty.admin.service.AdminService;
import com.ty.login.util.ImageUtil;
import com.ty.user.domain.User;
import com.ty.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private AdminService adminService;
    @Resource
    private UserService userService;

    private final static int SUCCESS=0;
    private final static int ADMIN_CODE_ERROR=1;
    private final static int PASSWORD_ERROR=2;
    private final static int IMAGE_CODE_ERROR=3;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "main/login";
    }

    @RequestMapping("/toIndex")
    public String toIndex(){
        return "main/index";
    }

    @ResponseBody
    @RequestMapping("/ajaxLogin")
    public Map<String,Object> login(String name,String password,String code,HttpSession session){
        Map<String,Object> result=new HashMap<>();
        String imageCode= (String) session.getAttribute("imageCode");
        if (code==null||!code.equalsIgnoreCase(imageCode)){
            result.put("flag",IMAGE_CODE_ERROR);
            return result;
        }
        String power=null;
        Admin admin = adminService.queryAdminByName(name);
        User user = userService.queryUserByName(name);
        if (admin!=null){
            power=admin.getAdminPower();
        }
        if (user!=null){
            power=user.getPower();
        }
        if (power==null){
            result.put("flag",ADMIN_CODE_ERROR);
            return result;
        }else if (power.equals("1")){
            if (!user.getPassword().equals(password)){
                result.put("flag",PASSWORD_ERROR);
                return result;
            }else {
                session.setAttribute("power",power);
                session.setAttribute("user",user);
                result.put("flag",SUCCESS);
                return result;
            }
        }else if (power.equals("2")){
            if (!admin.getAdminPassword().equals(password)){
                result.put("flag",PASSWORD_ERROR);
                return result;
            }else {
                session.setAttribute("power",power);
                session.setAttribute("admin",admin);
                result.put("flag",SUCCESS);
                return result;
            }
        }
        return null;
    }

    @RequestMapping("/quit")
    public String quit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("admin");
        session.removeAttribute("user");
        session.removeAttribute("power");
        return "redirect:toLogin";
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
