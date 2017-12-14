package com.yy.workTest1;

import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Scanner;

public class TestMain1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("①注册\t②登录");
            String input=scanner.nextLine();
            switch (input){
                case "1":
                    try {
                        Regist.getPer();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    } catch (UserNameExistsException e) {
                        System.out.println(e.getMessage());
                    } catch (IrregularException e) {
                        System.out.println(e.getMessage());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    System.out.println("请输入用户名:");
                    String username=scanner.nextLine();
                    System.out.println("请输入密码:");
                    String password=scanner.nextLine();
                    try {
                        Regist.userLogin(username,password);
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;

            }

        }
    }

}
