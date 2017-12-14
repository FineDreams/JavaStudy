package com.yy.workTest1;

import java.util.Random;
import java.util.Scanner;

public class StartGame {
    public static void playGame() throws InterruptedException {
        Scanner scanner=new Scanner(System.in);
        while (true) {
//            System.out.println("请选择等级:\t①困难\t②适中\t③简单");
//            String input=scanner.nextLine();
            System.out.println("游戏准备!");
            for (int i = 0; i <3 ; i++) {
                Thread.sleep(1000);
                System.out.println("倒计时"+(3-i)+"后开始");
            }
            System.out.println("游戏开始");


        }
    }
//    public static void hard(){
//        Random random=new Random();
//        StringBuilder sb=new StringBuilder();
//        sb.append()
//    }
}
