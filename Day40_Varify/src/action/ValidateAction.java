package action;

import bean.Student;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.validation.SkipValidation;

public class ValidateAction extends ActionSupport {
    private Student student;


    @Override
    public void validate() {
        if(StringUtils.isBlank(
                student.getName()
        )){
            addFieldError("errorMsg","不好意思用户名不能为空");
        }
    }
    public String val(){
        return SUCCESS;
    }

    //跳过val2，让validate方法，不验证val2方法
    @SkipValidation
    public String val2(){
        System.out.println("val2");
        return SUCCESS;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }




}
