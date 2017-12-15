package com.yy.main;

import com.yy.exception.IrregularException;
import com.yy.exception.UserNameExistsException;
import com.yy.function.Regist;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("①注册\t②登录\t③退出");
            String input=scanner.nextLine();
            switch (input){
                case "1":
                    try {
                        Regist.getPer();
                    } catch (DocumentException e) {
                        e.printStackTrace();
                    } catch (IrregularException e) {
                        System.out.println(e.getMessage());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (UserNameExistsException e) {
                        System.out.println(e.getMessage());
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
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "3":
                    System.out.println("拜拜，下次见哦!");
                    return;
                default:
                    break;

            }

        }
    }

}
