package com.yy.bean;

public class Teacher {
    private long tid;
    private String name;
    private String subject;
    private int age;

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", age=" + age +
                '}';
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Teacher(long tid, String name, String subject, int age) {

        this.tid = tid;
        this.name = name;
        this.subject = subject;
        this.age = age;
    }

    public Teacher() {

    }
}
