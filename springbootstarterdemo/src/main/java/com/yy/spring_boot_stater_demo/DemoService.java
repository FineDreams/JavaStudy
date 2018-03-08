package com.yy.spring_boot_stater_demo;

public class DemoService {

    private String msg;

    public String say(){
        return "hello:"+msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
