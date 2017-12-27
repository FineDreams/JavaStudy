package homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class 反序列化示例 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fr=new FileInputStream("src");
        ObjectInputStream ois=new ObjectInputStream(fr);
        Object o=ois.readObject();
        System.out.println(o);
        ois.close();
    }
}
