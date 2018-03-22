package com.yy.student.domain;

import java.util.Date;

public class Student {
    private String stuNumber;

    private String stuName;

    private String password;

    private String realname;

    private String phone;

    private String email;

    private Date enrolldate;

    private String clazz;

    private String power;

    private String gender;

    public Student(String stuNumber, String stuName, String password, String realname, String phone, String email, Date enrolldate, String clazz, String power, String gender) {
        this.stuNumber = stuNumber;
        this.stuName = stuName;
        this.password = password;
        this.realname = realname;
        this.phone = phone;
        this.email = email;
        this.enrolldate = enrolldate;
        this.clazz = clazz;
        this.power = power;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNumber='" + stuNumber + '\'' +
                ", stuName='" + stuName + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", enrolldate=" + enrolldate +
                ", clazz='" + clazz + '\'' +
                ", power='" + power + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Student() {
        super();
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber == null ? null : stuNumber.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(Date enrolldate) {
        this.enrolldate = enrolldate;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz == null ? null : clazz.trim();
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power == null ? null : power.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }
}