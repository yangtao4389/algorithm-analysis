package cn.angetech.algorithm.dynamic_programming;
/*
*
* 斐波拉契
* */
public class Fib {

    // 直接用递归的低效算法
    public static int lowFib(int n){
        if (n<=1){
            return 1;
        }else {
            return lowFib(n-1) + lowFib(n-2);
        }

    }

    // 高效算法，只记录最近算出的两个斐波拉契数
    public static int highFib(int n){
        if (n<=1){
            return 1;
        }
        int last = 1;
        int nextToLast = 1;
        int answer = 1;
        for (int i=2;i<=n;i++){
            answer = last + nextToLast;
            nextToLast = last;
            last = answer;
        }
        return answer;
    }
}
