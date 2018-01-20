package action;

import bean.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
//                                          这里给了泛型Student
                                            //模型驱动就知道了，是要给Student赋值各种属性
public class ModelAction extends ActionSupport implements ModelDriven<Student>{
    //模型驱动不会帮助我们创建Student对象
    //需要我们手动创建
    private Student student=new Student();

    public String model(){
        System.out.println(student);
        return SUCCESS;
    }
    @Override
    public Student getModel() {
        //需要在这里讲对象返回
        return student;
    }
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


}
