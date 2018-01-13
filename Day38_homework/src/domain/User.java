package domain;

public class User {
    private String uname;
    private String gender;
    private int score;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                ", uname='" + uname + '\'' +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                ", age=" + age +
                '}';
    }


    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {

    }

    public User(String uname, String gender, int score, int age) {

        this.uname = uname;
        this.gender = gender;
        this.score = score;
        this.age = age;
    }
}
