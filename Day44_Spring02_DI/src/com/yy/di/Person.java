package com.yy.di;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Person {
    private String name;
    private Car car;
    private List list;
    private Set set;
    private Map map;
    private Properties properties;
    private Object[] objects;


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", car=" + car +"\n"+
                ", list=" + list +
                ", set=" + set +"\n"+
                ", map=" + map +
                ", properties=" + properties +
                ", objects=" + Arrays.toString(objects) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public Person() {
    }

    public Person(String name, Car car, List list,Set set,Map map, Properties properties, Object[] objects) {
        this.name = name;
        this.car = car;
        this.list = list;
        this.set = set;
        this.map = map;
        this.properties = properties;
        this.objects = objects;
    }

    public void init() throws IOException {
        InputStream stream = Person.class.getClassLoader().getResourceAsStream("study.properties");
//        InputStream stream = ClassLoader.getSystemResourceAsStream("study.properties");
        properties=new Properties();
        properties.load(stream);
    }
}
