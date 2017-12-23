package com.yy.main;

import com.yy.exception.IrregularException;
import com.yy.exception.UserNameExistsException;
import com.yy.exception.UserNameNoneException;
import com.yy.exception.passWordErroException;
import com.yy.function.Regist;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.sql.SQLException;
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
                    } catch (IrregularException e) {
                        System.out.println(e.getMessage());
                    } catch (UserNameExistsException e) {
                        System.out.println(e.getMessage());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    System.out.println("请输入用户名:");
                    String username=scanner.nextLine();
                    System.out.println("请输入密码:");
                    String password=scanner.nextLine();
                    try {
                        Regist.Login(Regist.userJdbcLogin(username,password));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }catch (UserNameNoneException e) {
                        System.out.println(e.getMessage());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (passWordErroException e) {
                        System.out.println(e.getMessage());
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
