package com.yy.study;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap();
        map.put("1101","张三");
        map.put("1101","李四");
        map.put("1103","王五");
        map.put("1104","赵六");
        map.put("1105","赵六");




        //first(map);
//        Iterator iterator=map.entrySet().iterator();
        //second(map);

        //third(map);

        //four(map);
    }

    private static void four(Map<String, String> map) {
        System.out.println("第四种遍历方式:");
        for (String key:map.keySet()
             ) {
            String value=map.get(key);
            System.out.print(key+"----"+value+"\t");
        }
    }

    private static void third(Map<String, String> map) {
        System.out.println("第三种遍历方式:");
        Iterator<Map.Entry<String,String>> iterator=map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            String key=next.getKey();
            String value=next.getValue();
            System.out.print(key+"----"+value+"\t");
        }
        System.out.println();
    }

    private static void second(Map<String, String> map) {
        System.out.println("第二种遍历方式:");
        for (Map.Entry<String,String> entry:map.entrySet()
             ) {
            String key=entry.getKey();
            String value=entry.getValue();
            System.out.print(key+"----"+value+"\t");
        }
        System.out.println();
    }

    private static void first(Map<String, String> map) {
        System.out.println("第一种遍历方式:");
        for (Object obj:map.keySet()){
            System.out.print(obj+"\t");
        }
        for (Object o:map.values()){
            System.out.print(o+"\t");
        }
        System.out.println();
    }
}
