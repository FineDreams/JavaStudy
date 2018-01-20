package action;

import bean.Student;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

public class OgnlAction extends ActionSupport {

    private Student student;

    public String stu(){
        System.out.println(student);
        ServletActionContext.getRequest().setAttribute("student",student);
        return SUCCESS;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
