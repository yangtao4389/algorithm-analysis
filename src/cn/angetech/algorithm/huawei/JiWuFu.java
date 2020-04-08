package cn.angetech.algorithm.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
题目：以0和1组成的长度为5的字符串代表每个人所得到的福卡，每一位代表一种福卡，1表示已经获得该福卡，单类型福卡不超过1张，随机抽取一个小于10人团队，求该团队最多可以集齐多少套五福？

输入描述:
输入若干个"11010"、”00110"的由0、1组成的长度等于5位字符串,代表的指定团队中每个人福卡获得情况
注意1：1人也可以是一个团队
注意2：1人可以有0到5张福卡，但福卡不能重复

输出描述:
输出该团队能凑齐多少套五福

示例1
输入
11001
输出
0
————————————————
版权声明：本文为CSDN博主「jiandonghan」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/m0_37771869/article/details/81254412
* */
public class JiWuFu {
    public static void main(String[] args) throws IOException {
//        System.out.println(5%5);
        jiwufu();
    }

    public static void jiwufu() throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String s = bf.readLine();
        int count[] = new int[5];

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.next();
            for (int i=0;i<s.length();i++){
                // 以5为单位 统计  当字符串
                char c = s.charAt(i);
                if (s.charAt(i) == '1'){
                    count[i%5] ++;
                }

            }
        }
        System.out.println(Arrays.toString(count));

        int result = count[0];
        for (int i:count){
            result = Math.min(i,result);
        }
        System.out.println(result);


    }
}
