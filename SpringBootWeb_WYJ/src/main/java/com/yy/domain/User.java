package com.yy.domain;

public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String realName;

    private Integer sex;

    private String phone;

    private String idCard;

    private String address;

    private Integer userType;

    private Integer deleteFlag;

    private String email;

    private String emailpw;

    private Integer prepare1;

    private String prepare2;

    private String prepare3;

    public User(Integer userId, String userName, String password, String realName, Integer sex, String phone, String idCard, String address, Integer userType, Integer deleteFlag, String email, String emailpw, Integer prepare1, String prepare2, String prepare3) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.sex = sex;
        this.phone = phone;
        this.idCard = idCard;
        this.address = address;
        this.userType = userType;
        this.deleteFlag = deleteFlag;
        this.email = email;
        this.emailpw = emailpw;
        this.prepare1 = prepare1;
        this.prepare2 = prepare2;
        this.prepare3 = prepare3;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEmailpw() {
        return emailpw;
    }

    public void setEmailpw(String emailpw) {
        this.emailpw = emailpw == null ? null : emailpw.trim();
    }

    public Integer getPrepare1() {
        return prepare1;
    }

    public void setPrepare1(Integer prepare1) {
        this.prepare1 = prepare1;
    }

    public String getPrepare2() {
        return prepare2;
    }

    public void setPrepare2(String prepare2) {
        this.prepare2 = prepare2 == null ? null : prepare2.trim();
    }

    public String getPrepare3() {
        return prepare3;
    }

    public void setPrepare3(String prepare3) {
        this.prepare3 = prepare3 == null ? null : prepare3.trim();
    }
}