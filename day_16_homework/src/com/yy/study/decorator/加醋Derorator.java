package com.yy.study.decorator;

import com.yy.study.componet.饮品;

public class 加醋Derorator extends Decorator{

    public 加醋Derorator(饮品 yp){
        super(yp);
    }


    @Override
    public int price() {
        return yp.price()+2;
    }

    @Override
    public String getName() {
        return "加醋的"+yp.getName();
    }
}
