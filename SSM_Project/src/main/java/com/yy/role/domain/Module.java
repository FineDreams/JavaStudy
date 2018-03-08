package com.yy.role.domain;

public class Module {
    private Integer moduleId;

    private String name;

    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Module(Integer moduleId, String name, Role role) {
        this.moduleId = moduleId;
        this.name = name;
        this.role = role;
    }

    public Module(Integer moduleId, String name) {
        this.moduleId = moduleId;
        this.name = name;
    }

    public Module() {
        super();
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleId=" + moduleId +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}