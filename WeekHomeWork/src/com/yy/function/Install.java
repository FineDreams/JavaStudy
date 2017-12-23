package com.yy.function;

import com.yy.entity.Person;
import com.yy.util.ModifyUtil;

import java.sql.SQLException;
import java.util.Scanner;

public class Install {
    public static void userInstall(Person person) throws SQLException {
        Scanner scanner=new Scanner(System.in);

        System.out.println("①查看账户信息②修改昵称\t③修改密码\t④修改用户名\t⑤注销\t⑥返回");
        String input=scanner.nextLine();
        switch (input){
            case "1":

                ModifyUtil.query(person.getUsername());
            case "2":
                System.out.println("请输入新的昵称:");
                String newname=scanner.nextLine();
                ModifyUtil.update("nickname",person.getName(),newname);
                person.setName(newname);
                System.out.println("昵称修改成功!");
                System.out.println("当前登录用户:"+person.getName());
                break;
            case "3":
                System.out.println("请输入新密码:");
                String newpass=scanner.nextLine();
                ModifyUtil.update("password",person.getPassword(),newpass);
                System.out.println("密码修改成功!请重新登录");
                return;
            case "4":
                break;
            case "5":
                break;
            case "6":

                return;
        }
    }
}
