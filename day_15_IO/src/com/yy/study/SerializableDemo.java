package com.yy.study;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializableDemo {
   @Test
    public void output() throws IOException {
        pet p=new pet("雪纳瑞","male");

       FileOutputStream fos=new FileOutputStream("src/com/yy/study/pet.out");

       ObjectOutputStream oos=new ObjectOutputStream(fos);

       oos.writeObject(p);

       oos.flush();
       oos.close();

    }
}
