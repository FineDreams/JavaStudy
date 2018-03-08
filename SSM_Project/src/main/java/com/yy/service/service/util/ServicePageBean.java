package com.yy.service.service.util;


import com.yy.util.PageBean;

public class ServicePageBean extends PageBean {


    public ServicePageBean() {
    }

    public ServicePageBean(int nowPageIndex, int dataCount) {
        super(nowPageIndex, dataCount);
    }

    private String osUsername;
    private String unixHost;
    private String idcardNo;
    private String status;

    public ServicePageBean(String osUsername, String unixHost, String idcardNo, String status) {
        this.osUsername = osUsername;
        this.unixHost = unixHost;
        this.idcardNo = idcardNo;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ServicePageBean{" +
                "osUsername='" + osUsername + '\'' +
                ", unixHost='" + unixHost + '\'' +
                ", idcardNo='" + idcardNo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public ServicePageBean(int nowPageIndex, int dataCount, String osUsername, String unixHost, String idcardNo, String status) {
        super(nowPageIndex, dataCount);
        this.osUsername = osUsername;
        this.unixHost = unixHost;
        this.idcardNo = idcardNo;
        this.status = status;
    }

    public String getOsUsername() {
        return osUsername;
    }

    public void setOsUsername(String osUsername) {
        this.osUsername = osUsername;
    }

    public String getUnixHost() {
        return unixHost;
    }

    public void setUnixHost(String unixHost) {
        this.unixHost = unixHost;
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
