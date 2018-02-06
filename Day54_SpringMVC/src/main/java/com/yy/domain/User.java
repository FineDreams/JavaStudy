package com.yy.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Map;

//@XmlRootElement
public class User {

    private int id;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", ids=" + ids +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", list=" + list +
                ", map=" + map +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private List<Integer> ids;
    private String username;
    private String password;
    private List<String> list;
    private Map<String,Object> map;


    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public User() {
    }

    public User(List<Integer> ids, String username, String password) {
        this.ids = ids;
        this.username = username;
        this.password = password;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
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
