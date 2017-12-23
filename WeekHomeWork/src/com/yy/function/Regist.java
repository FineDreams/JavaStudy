package com.yy.function;

import com.yy.exception.IrregularException;
import com.yy.exception.UserNameExistsException;
import com.yy.entity.Person;
import com.yy.exception.UserNameNoneException;
import com.yy.exception.passWordErroException;
import com.yy.util.jdbcUtil;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Regist {
    //注册方法
    public static void getPer() throws  UserNameExistsException, IrregularException, SQLException {
        Scanner scanner = new Scanner(System.in);
        Boolean isTrue = null;
        Person person=null;
        while (true){
            System.out.println("请取个昵称吧:");
            String nickname = scanner.nextLine();
            if(!(nickname.matches("[A-Z]+[A-Za-z]*"))){
                System.out.println("昵称只能是英文字母，并且首字母必须大写!");
                continue;
            }
            System.out.println("请输入用户名:");
            String username = scanner.nextLine();

            Connection connection= jdbcUtil.getConnection();
            PreparedStatement pstate=connection.prepareStatement("SELECT * FROM users WHERE uname=?");
            pstate.setString(1,username);
            ResultSet resultSet = pstate.executeQuery();
            if (resultSet.next()){
                throw new UserNameExistsException();
            }
            System.out.println("请输入密码:");
            String password = scanner.nextLine();
            if (!(password.matches("[A-Za-z]+[0-9]+|[0-9]+[a-zA-Z]+"))){
                System.out.println("密码中必须包含字母和数字!");
            }else {
                    userRegist(nickname,username,password);
                System.out.println("注册成功!");
                return;
            }
        }
    }

    //登录方法
    public static void Login(Person person) throws IOException, InterruptedException, SQLException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (person != null) {
                System.out.print("欢迎光临!\n用户:" + person.getName());
                System.out.println("请输入要操作的功能!\n①查询天气\n②查询手机归属地\n③手速游戏\n" +
                                    "④查询手速游戏前十名用户\n⑤账户管理\n⑥返回");
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        SearchDemo.searchWeather();
                        break;
                    case 2:
                        SearchDemo.searchPhone();
                        break;
                    case 3:
                        StartGame.playGame(person.getName());
                        break;
                    case 4:
                        SearchDemo.searchTen();
                        break;
                    case 5:
                        Install.userInstall(person);
                        break;
                    case 6:
                        return;
                }
            }
        }
    }




    public static void userRegist(String nickName,String userName,String passWord) throws SQLException {
        Connection connection = jdbcUtil.getConnection();
        PreparedStatement pstate = connection.prepareStatement("INSERT INTO users VALUES (?,?,?)");
        pstate.setString(1,nickName);
        pstate.setString(2,userName);
        pstate.setString(3,passWord);
        pstate.execute();

        pstate.close();
        connection.close();
    }

    public static Person userJdbcLogin(String userName,String passWord) throws SQLException, UserNameNoneException, passWordErroException {
        Person person=null;
        String uName;
        String nickName;
        String password;
        Connection connection=jdbcUtil.getConnection();
        PreparedStatement pstate=connection.prepareStatement("SELECT * FROM users WHERE uname=?");
        pstate.setString(1,userName);
        ResultSet resultSet = pstate.executeQuery();

        while (resultSet.next()){
            nickName=resultSet.getString(1);
            uName = resultSet.getString(2);
            System.out.println(uName);
            password = resultSet.getString(3);

            if(password.equals(passWord)){
                System.out.println("登录成功!");
                person=new Person(nickName,uName,password);
                return person;
            }else {
                throw new passWordErroException();
            }
        }
        throw new UserNameNoneException();
    }

}
