package com.yy.admin.domain;

public class Admin {
    private Integer adminId;

    private String adminCode;

    private String adminPassword;

    private String adminName;

    private String telephone;

    private String power;

    public Admin(Integer adminId, String adminCode, String adminPassword, String adminName, String telephone, String power) {
        this.adminId = adminId;
        this.adminCode = adminCode;
        this.adminPassword = adminPassword;
        this.adminName = adminName;
        this.telephone = telephone;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminCode='" + adminCode + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminName='" + adminName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", power='" + power + '\'' +
                '}';
    }

    public Admin() {
        super();
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode == null ? null : adminCode.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power == null ? null : power.trim();
    }
}