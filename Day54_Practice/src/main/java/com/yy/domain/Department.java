package com.yy.domain;

import java.util.List;

public class Department {
    private String departId;
    private String name;
    private List<Post> postList;

    public Department() {
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departId='" + departId + '\'' +
                ", name='" + name + '\'' +
                ", postList=" + postList +
                '}';
    }
}
