package com.yy.study;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test2 {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("张三","23");
        map.put("李四","23");
        map.put("王五","男");
        map.put("赵六","女");

        System.out.println("第一种方式");
        for(Object o:map.keySet()){
            System.out.print(o+"\t");
        }
        for(Object o:map.values()){
            System.out.print(o+"\t");
        }
        System.out.println();

        System.out.println("第二种方式");
        for (Object key:map.keySet()){
            String value=map.get(key);
            System.out.print(key+"----"+value+"\t");
        }
        System.out.println();

        System.out.println("第三种方式");
        for (Map.Entry<String,String> entry:map.entrySet()){
            System.out.print(entry.getKey()+"----"+entry.getValue()+"\t");
        }
        System.out.println();

        System.out.println("第四种方式");
        Iterator<Map.Entry<String,String>> iterator=map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String> entry=iterator.next();
            System.out.print(entry.getKey()+"----"+entry.getValue()+"\t");
        }


    }
}
