package com.yy.crm.staff.domain;

public class CrmStaff {

    private int staffId;
    private String username;
    private String password;

    public CrmStaff(int staffId, String username, String password) {
        this.staffId = staffId;
        this.username = username;
        this.password = password;
    }

    public CrmStaff() {

    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrmStaff crmStaff = (CrmStaff) o;

        if (staffId != crmStaff.staffId) return false;
        if (username != null ? !username.equals(crmStaff.username) : crmStaff.username != null) return false;
        if (password != null ? !password.equals(crmStaff.password) : crmStaff.password != null) return false;

        return true;
    }

    @Override
    public String toString() {
        return "CrmStaff{" +
                "staffId=" + staffId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        int result = staffId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
