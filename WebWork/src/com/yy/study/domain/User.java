package com.yy.study.domain;

public class User {
    private String nickname;
    private String uname;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public User() {
    }

    public String getNickname() {

        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String nickname, String uname, String password) {

        this.nickname = nickname;
        this.uname = uname;
        this.password = password;
    }
}
