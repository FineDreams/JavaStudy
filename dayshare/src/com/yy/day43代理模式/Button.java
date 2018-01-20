package com.yy.day43代理模式;

public class Button implements IFunction{

    public Button(String btnName) {
        this.btnName = btnName;
    }

    private String btnName;

    public String getBtnName() {
        return btnName;
    }

    @Override
    public void click() {
        System.out.println(btnName + "被点击了");
    }

    @Override
    public void getButtonName() {

    }
}
