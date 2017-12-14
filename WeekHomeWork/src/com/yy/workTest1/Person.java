package com.yy.workTest1;

public class Person {
    private String nickname;
    private String username;
    private String password;

    public Person() {
    }

    public Person(String nickname, String username, String password) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
    }

    public String getName() {

        return nickname;
    }

    public void setName(String nickname) {
        this.nickname = nickname;
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
}
