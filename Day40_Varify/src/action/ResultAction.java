package action;

import com.opensymphony.xwork2.ActionSupport;

public class ResultAction  extends ActionSupport{

    public String plaintext(){

        return SUCCESS;
    }

    public String toGlobalGR(){
        System.out.println("请求转发到:Global");

        return SUCCESS;

    }

}
