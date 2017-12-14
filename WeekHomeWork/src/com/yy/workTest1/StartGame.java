package com.yy.workTest1;

import java.util.Random;
import java.util.Scanner;

public class StartGame {
    public static void playGame() throws InterruptedException {
        Scanner scanner=new Scanner(System.in);

        System.out.println("请选择等级:\t①困难\t②适中\t③简单");
        String input=scanner.nextLine();
        String str1="fs,/.09897&SDFHUWENAF*&*$#$jffaskjfdsf34543656";
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
                    game(30,str1);
                    break;
                case "2":
                    game(20,str2);
                    break;
                case "3":
                    game(10,str3);
                    break;
            }
        }

    public static void game(int len,String string) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
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
                System.out.println("输入不匹配，请重新开始");
                continue;
            }
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("游戏结束!\n" + "用时:" + time);
        }
    }
}
