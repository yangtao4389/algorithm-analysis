package cn.angetech.algorithm.dynamic_programming.pack;
/*
* 动态规划里面的 经典案列 背包问题
* https://blog.csdn.net/lanyu_01/article/details/79815801
*
* */

import java.util.ArrayList;

/*
问题描述：
一个背包的总容量为V,现在有N类物品,第i类物品的重量为weight[i],价值为value[i]
那么往该背包里装东西,怎样装才能使得最终包内物品的总价值最大。这里装物品主要由三种装法：
1、0-1背包：每类物品最多只能装一次
2、多重背包：每类物品都有个数限制，第i类物品最多可以装num[i]次
3、完全背包：每类物品可以无限次装进包内

* 0-1背包问题
* V：背包容量
* N：物品种类
* weight: 物品重量
* value： 物品价值
*
*  物品种类/背包容量：
*  *  1  2  3  4  ..j..  V
*  1
*  2
*  .
*  i
*  .
*  N
*
*  dp[i=N][j=V]  的值
*  先记录 每一条 dp[i][j] 的 价值 最大值
*   weight[i] > j  则第i件物品 不能装入容量为j的背包  此时  dp[i][j] = dp[i-1][j]
*   <=j  如果装入，则有 dp[i][j] = dp[i-1][j-weight[i]]+value[i]
*   然后进行与前值进行对比
*
*
*
* */
public class ZeroOnePack {
    public static void main(String[] args) {
        zeroOnePack(4,4,new int[]{4,3,1,1,1},new int[]{3000,2000,1500,2000,1000});
    }

    /*
    *
     * V：背包容量
     * N：物品种类
     * weight: 物品重量
     * value： 物品价值
     * */
    public static void zeroOnePack(int V,int N,int[] weight,int[] value) {
       // 背包容量为纵坐标  物品种类为横坐标 每次遍历背包容量 然后再切换到下一行，又遍历背包容量
        // 直接处理成 背包容量变为1,2,3，j，V   下标1对应1  则 初始值比原值大于1
        int[][] dp = new int[N+1][V+1];
        for (int i=1;i<N+1;i++){
            for (int j =1;j<V+1;j++){
                // 如果容量小，则不装，价值等于前一个价值
                // j 为当前容量
                // weight[i-1] 为当前物品的容量
                // dp[i][j] =   价值
                if(weight[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    //  大于或者等于 则尝试装
                    // 装了之后的价值
                    //  当前物品的价值value[i-1]
                    // 剩余容量的价值  dp[i-1][j-weight[i-1] ]  + value[i-1]
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i-1] ]  + value[i-1] );
                }
            }
        }

        /*
        * 打印一下 最终得出的数据
        * */
        for (int i=1;i<N+1;i++){
            for (int j =1;j<V+1;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        // 最大价值求出来了 dp[N][V]
        int maxValue = dp[N][V];
        System.out.println("能装的最大价值："+maxValue);


        // 那装的是哪些物品呢？
        // 逆推找出背包里面的所有商品的编号
        String numStr = "";
        int j = V;
        for (int i=N;i>0;i--){
            if (dp[i][j]>dp[i-1][j]){ // 这里添加了商品 找到该商品的重量  然后让j 减去 重量 再去对比当前那行
                numStr = i +  " " +numStr;
                j = j-weight[i-1];
            }
            if (j == 0){
                break;
            }
        }
        System.out.println(numStr);
















    }

}
