package com.yy.workTest1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

public class StartGame {
    public static void playGame(String nickName) throws InterruptedException, IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("欢迎"+nickName);
        System.out.println("\n请选择等级:\t①困难\t②适中\t③简单");
        String input=scanner.nextLine();
        String str1="fs,/.?<>!+-=09897&SDFHUWENAF*&*$#$jffaskjfdsf1234567890";
        String str2="FSDKJWEIRWOITUERYHFjsdfahdfkjhdajkf2353534545";
        String str3="abcdefghisdfiksdfsfjask123456";
        System.out.println("游戏准备!");
            for (int i = 0; i <3 ; i++) {
                Thread.sleep(1000);
                System.out.println("倒计时"+(3-i)+"后开始");
            }
        System.out.println("游戏开始");
//            String input=scanner.nextLine();
            switch (input){
                case "1":
                    game(30,str1,nickName);
                    break;
                case "2":
                    game(20,str2,nickName);
                    break;
                case "3":
                    game(10,str3,nickName);
                    break;
            }
        }

    public static void game(int len,String string,String nickName) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        long score=0;
        for (int i = 0; i < len; i++) {
            int a = random.nextInt(len);
            String str = string.substring(a, a + 1);
            sb.append(str);
        }
        String result = new String(sb);
        System.out.println(result);

        long start = System.currentTimeMillis();
        while (true) {
            String input = scanner.nextLine();
            if (!(result.equals(input))) {
                System.out.println("输入不匹配，请重新输入:");
                continue;
            }
            long end = System.currentTimeMillis();
            score = end - start;
            System.out.println("游戏结束!\n" + "成绩用时:" + score);

            System.out.println("是否上传你的成绩?\t①是\t②否");
            int isof = scanner.nextInt();
            switch (isof) {
                case 1:
                    upLoad(score, nickName);
                    return;
                case 2:
                    return;
            }
        }
    }
    public static void upLoad(long score,String user) throws IOException {
        URL url=new URL("http://192.168.20.221:8080/day16/insert?username="+user+"&score="+score);
        url.openConnection();
        System.out.println("成绩上传成功!");
    }
}
