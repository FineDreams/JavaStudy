import java.util.List;

public class Person {
    private List<User> userList;

    @Override
    public String toString() {
        return "Person{" +
                "userList=" + userList +
                '}';
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Person() {

    }

    public Person(List<User> userList) {

        this.userList = userList;
    }
}
