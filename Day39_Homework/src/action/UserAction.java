package action;

import com.opensymphony.xwork2.ActionSupport;
import domain.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import service.UserService;
import service.exception.*;

import javax.servlet.http.HttpServletRequest;

public class UserAction extends ActionSupport implements ServletRequestAware{
    private HttpServletRequest request;
   private UserService userService=new UserService();
   private User user=new User();
   private String username;
   private String password;
   private String code;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String register(){
        System.out.println(user);
        UserService userService=new UserService();
        User userFromDb = userService.searchByName(this.user.getUsername());
        if (userFromDb!=null){
            addFieldError("usernameMsg","用户名已存在!");
            return "input";
        }
        if (user.getUsername().equals("")){
            addFieldError("usernameMsg","用户名不能为空!");
            return "input";
        }
        if (user.getPassword()==null||user.getPassword().equals("")){
            addFieldError("passwordMsg","密码不能为空!");
            return "input";
        }
        if (!user.getPassword().equals(user.getSureword())){
            addFieldError("surewordMsg","两次输入的密码不相同!");
            return "input";
        }
        if (user.getSureword()==null||user.getSureword().equals("")){
            addFieldError("surewordMsg","确认密码不能为空!");
            return "input";
        }
        if (StringUtils.isBlank(
                user.getPhone()
        )){
            addFieldError("phoneMsg","电话号码不能为空!");
            return "input";
        }
        if (StringUtils.isBlank(
                user.getEmail()
        )){
            addFieldError("emailMsg","邮箱不能为空");
            return "input";
        }
//        String code = (String) ServletActionContext.getRequest().getSession().getAttribute("output");

        if (user.getCode()==null||user.equals("")){
            addFieldError("codeMsg","请输入验证码!");
            return "input";
        }
        if (!(CodeImgResult.code).equalsIgnoreCase(user.getCode())){
            addFieldError("codeMsg","验证码错误!");
            return "input";
        }

        userService.register(user);
        return "register";
    }
    public String login(){
        User user = userService.searchByName(username);
        if (user==null){
            addFieldError("loginFailed","用户名错误");
            return "input";
        }
        if (!user.getPassword().equals(password)){
            addFieldError("passwordError","密码错误");
            return "input";
        }
        if (code.equals("")||code==null){
            addFieldError("codeFailed","请输入验证码!");
            return "input";
        }
        System.out.println(CodeImgResult.code+"--");
        System.out.println(code+"--");
        if(!(CodeImgResult.code).equalsIgnoreCase(code)){
            addFieldError("codeFailed","验证码错误!");
            return "input";
        }

        ServletActionContext.getRequest().getSession().setAttribute("username",username);
        return "login";
    }


    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }
}
