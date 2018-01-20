package domain;

public class User {
    private String username;
    private String password;
    private String sureword;
    private String phone;
    private String email;
    private String code;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sureword='" + sureword + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

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

    public String getSureword() {
        return sureword;
    }

    public void setSureword(String sureword) {
        this.sureword = sureword;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User() {

    }

    public User(String username, String password, String sureword, String phone, String email, String code) {

        this.username = username;
        this.password = password;
        this.sureword = sureword;
        this.phone = phone;
        this.email = email;
        this.code = code;
    }
}
