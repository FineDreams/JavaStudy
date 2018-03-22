package com.ty.admin.domain;

public class Admin {
    private Integer adminId;

    private String adminName;

    private String adminCode;

    private String adminTelephone;

    private String adminPassword;

    private String adminPower;

    public Admin(Integer adminId, String adminName, String adminCode, String adminTelephone, String adminPassword, String adminPower) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminCode = adminCode;
        this.adminTelephone = adminTelephone;
        this.adminPassword = adminPassword;
        this.adminPower = adminPower;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminCode='" + adminCode + '\'' +
                ", adminTelephoe='" + adminTelephone + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminPower='" + adminPower + '\'' +
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

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode == null ? null : adminCode.trim();
    }

    public String getAdminTelephone() {
        return adminTelephone;
    }

    public void setAdminTelephone(String adminTelephone) {
        this.adminTelephone = adminTelephone == null ? null : adminTelephone.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminPower() {
        return adminPower;
    }

    public void setAdminPower(String adminPower) {
        this.adminPower = adminPower == null ? null : adminPower.trim();
    }
}