package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import domain.User;
import org.apache.struts2.ServletActionContext;
import service.UserService;

public class UserAction extends ActionSupport {
    private User user;
    private UserService userService=new UserService();

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
        User userFromDb = userService.searchByUserName(this.user.getUsername());
//        CodeImgResult codeImgResult=new CodeImgResult();
        if (userFromDb!=null){
            addFieldError("user.username","用户已存在!");
            return "input";
        }
        if (!(CodeImgResult.code).equalsIgnoreCase(this.user.getCode())){
            addFieldError("user.code","验证码错误!");
            return "input";
        }
        userService.insertUser(user);

        return "register";
    }

    public String login(){
        User userFromDb = userService.searchByUserName(username);
        CodeImgResult codeImgResult=new CodeImgResult();
        if (userFromDb==null){
            addFieldError("UNameError","用户名错误!");
            return "input";
        }
        if (!(userFromDb.getPassword()).equals(password)){
            addFieldError("passwordError","密码错误!");
            return "input";
        }
        if (!(CodeImgResult.code).equalsIgnoreCase(code)){
            addFieldError("codeFailed","验证码错误!");
            return "input";
        }
        ServletActionContext.getRequest().getSession().setAttribute("username",userFromDb.getUsername());
        return "login";
    }



//    @Override
//    public User getModel() {
//        return user;
//    }
}
