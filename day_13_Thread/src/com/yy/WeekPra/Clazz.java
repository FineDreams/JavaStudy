package com.yy.WeekPra;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
public class Clazz {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
       Class<?> c= Class.forName("com.yy.WeekPra.AA");
        AA A=(AA) c.newInstance();
        A.setName("张三");
        System.out.println(A.getName());
        Method show=c.getMethod("show");
        show.invoke(c);
    }
}
