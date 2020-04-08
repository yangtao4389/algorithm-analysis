package cn.angetech.algorithm.huawei;

import java.util.Scanner;

public class ZiFuChuanChangDu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        String s1 = split[split.length - 1];
        System.out.println(s1.length());
    }
}
