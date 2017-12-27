package com.yy.study.decorator;

import com.yy.study.componet.饮品;

public class 兑水Decorator extends Decorator{

    public 兑水Decorator(饮品 yp){
        super(yp);
    }

    @Override
    public int price() {
        return yp.price()-5;
    }

    @Override
    public String getName() {
        return "兑水了的"+yp.getName();
    }
}
