package com.yy.day43代理模式;

public class ProxyButton implements IFunction {

    //代理对象中必须要有被代理对象的引用
    private IFunction function;
    //角色名称
    private String roleName;

    @Override
    public void click() {
        if ("管理员".equals(roleName)){
            function.click();
        }else {
            System.out.println("你没有权限点击"+function);
        }
    }

    @Override
    public void getButtonName() {

    }


}
