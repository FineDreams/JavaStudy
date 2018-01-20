import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport{

    public String hello(){
        System.out.println("哈哈哈");
        return "success";
    }
}
