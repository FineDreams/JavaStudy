import com.opensymphony.xwork2.ActionSupport;
import domain.User;

import java.util.List;

public class ListAction extends ActionSupport {
    private List<User> list;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public String list(){
        System.out.println(list.get(0).getName());
        System.out.println(list.get(0).getPassword());
        System.out.println(list.get(0).getGender());
        System.out.println(list.get(0).getAge());
        return "list";
    }
}
