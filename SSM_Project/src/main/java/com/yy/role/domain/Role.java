package com.yy.role.domain;

import java.util.List;

public class Role {
    private Integer roleId;

    private String name;

    private String group_info;

    private List<Module> modules;

    public String getGroup_info() {
        return group_info;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", name='" + name + '\'' +
                ", group_info='" + group_info + '\'' +
                ", modules=" + modules +
                '}';
    }

    public Role(Integer roleId, String name, String group_info) {
        this.roleId = roleId;
        this.name = name;
        this.group_info = group_info;

    }

    public Role(Integer roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public void setGroup_info(String group_info) {
        this.group_info = group_info;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public Role() {
        super();
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}