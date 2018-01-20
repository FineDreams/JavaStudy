package com.yy.观察者模式作业;

import com.yy.观察者模式作业.observer.Reader;
import com.yy.观察者模式作业.subject.Book;

public class main {
    public static void main(String[] args) {

        Book book=new Book("豫故");

        Reader reader=new Reader("小吴");
        Reader reader2=new Reader("小王");
        Reader reader3=new Reader("小龙");
        Reader reader4=new Reader("小新");

        book.add(reader);
        book.add(reader2);
        book.add(reader3);

        book.notify("更新啦");

    }
}
