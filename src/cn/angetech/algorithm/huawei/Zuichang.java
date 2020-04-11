package cn.angetech.algorithm.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Zuichang {
    public static void main(String[] args) {
        /*
         * 两个字符串 最长公共子串
         * */
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a, b;
            a = in.next();
            b = in.next();

            int result = 0;
            int aLen = a.length();
            int bLen = b.length();

            // 对b进行循环去比较
            for (int i = 0; i < bLen; i++) {
                int i1 = a.indexOf(b.charAt(i)); // 先解决一个问题  如果出现多次在该字符串中 就会出问题
//                System.out.println(i1);
                if (i1 >= 0) { // 存在 则去对比  有多处存在
                    int len = 0;
                    int tmpa = i1;
                    int tmpb = i;
                    while (tmpa < aLen && tmpb < bLen &&a.charAt(tmpa) == b.charAt(tmpb)) {
                        len++;
                        tmpa++;
                        tmpb++;
                    }
                    result = Math.max(result, len);
                }
            }
            System.out.println(result);


        }


    }
}
