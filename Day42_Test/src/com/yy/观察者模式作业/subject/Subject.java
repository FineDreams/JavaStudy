package com.yy.观察者模式作业.subject;

import com.yy.观察者模式作业.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> list=new ArrayList<>();
   public void add(Observer observer){

       list.add(observer);
   }
   public void delete(Observer observer){
       list.remove(observer);
   }
   public void notify(String info){
       for (Observer observer : list) {
           observer.update(info);
       }
   }

}
