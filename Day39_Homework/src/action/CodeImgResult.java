package action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.zhuang.util.VerifyCode;
import org.apache.struts2.ServletActionContext;

public class CodeImgResult implements Result {
    public static String code;
    @Override
    public void execute(ActionInvocation actionInvocation) throws Exception {

        String output = VerifyCode.getInstance().output(
                ServletActionContext.getResponse().getOutputStream()
        );
        code=output;
        System.out.println(output);
//        ServletActionContext.getRequest().getSession().setAttribute("output",output);
    }
}
