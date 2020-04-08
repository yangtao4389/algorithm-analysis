package cn.angetech.algorithm.huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
* 链接：https://www.nowcoder.com/questionTerminal/ce46d7af661345f2b1dad0edd491100c
来源：牛客网

题目标题：

报数游戏

题目描述：

有n（n<=100）围成一圈，顺序排号（从1排到n）。从第一个人开始报数（从1一直往上报数)，凡报到m及m的倍数或者尾数为m的人退出圈子，问最后留下的是原来第几号的那位？

输入描述：

输入为两个正整数，第一个<=100，第二个<=9；

输出描述：

输出为一个正整数；

样式输入：

10 3

样式输出：

5
*
* */
public class BaoShu {
    public static void main(String[] args) {
//        System.out.println(98/10);
//        System.out.println(10%10);  // 0
//        int a = 98;
//        Integer m = 3;
        // 尾数是否为3
//        m.toString().endsWith(m)

        System.out.println(1%3);
        int baoshu2 = new BaoShu().baoshu2(10, 3);
        System.out.println(baoshu2);

    }

    /*
    *
    * 利用数组的可变性来实现
    * */
    public int baoshu2(int n,Integer m){
//        if(n>100 || n<0){
//            return 0;
//        }
//        if (m>9 || m<0){
//            return 0;
//        }

        if(n==1 || m==1){
            return n;
        }
        // 构造一个数组存储所有n   1,2,3.. n
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1;i<=n;i++){
            list.add(i);
        }

        // 构造一个全局计数 从1 开始 一直数 知道 list的长度为1
        Integer count = 1;
        while (list.size() >1){
            int tmpSize;
            tmpSize = list.get(0);
            list.remove(0);
            if(count%m == 0 || count.toString().endsWith(m.toString())){ // 当前报的数 为 m的倍数 或者 以m结尾
            }else {
                list.add(tmpSize);
            }
            count ++;
        }
        return list.get(0);
    }




    /*
    * n 为总共多少人
    * m 为 m的倍数 以及尾数为m
    * */
    public int baoshu(int n,int m){
        if(n>100 || n<0){
            return 0;
        }
        if (m>9 || m<0){
            return 0;
        }

        // 构造一个数组，当数组里面只有1个数字时，退出
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i=1;i<=n;i++){
            list.add(i);
        }
        System.out.println(list);  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        while (digui(list,m).size()<=0);

        return 0;
    }

    /*
    * n 传当前的数组长度
    *
    * */
    private static List<Integer> digui(List<Integer> list, int m){
        HashSet<Integer> todoDeleteSet = new HashSet<>();
        ArrayList<Integer> list2 = new ArrayList<>();


        int n = list.size();
        if (n == 1){
            return list;
        }

        // 找m的倍数与m  n=10 m=3
        int totalCircle = n/m; // 总共循环的次数为3 及3与3的倍数
        for (int i=1;i<=totalCircle;i++){
            todoDeleteSet.add(m*i);
        }
        // 找到m结尾的数 1-9的m  假设为1 则21 有 1,11 21 3个 假设为9  只有9  19 两个
        int totalCircle2 = n%10;
        int isdelete1 = n%10 >=m ? 1:0;  // 看是否尾数大于m
        for (int i=0;i<=totalCircle2+isdelete1;i++){
            todoDeleteSet.add(i*10+m);
        }
        System.out.println(todoDeleteSet);

        for (int i=0;i<n;i++){
            if(todoDeleteSet.contains(i+1)){
                continue;
            }
            list2.add(list.get(i));
        }
        System.out.println(list2);
        return list2;
    }

}
