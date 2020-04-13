package cn.angetech.algorithm.dynamic_programming.pack;
/*
问题描述：
一个背包的总容量为V,现在有N类物品,第i类物品的重量为weight[i],价值为value[i]
那么往该背包里装东西,怎样装才能使得最终包内物品的总价值最大。这里装物品主要由三种装法：
1、0-1背包：每类物品最多只能装一次
2、多重背包：每类物品都有个数限制，第i类物品最多可以装num[i]次
3、完全背包：每类物品可以无限次装进包内
*/


public class ManyPack {
    /*
     * V：背包容量
     * N：物品种类
     * weight: 物品重量
     * value： 物品价值
     * num: 物品数量
    *
    * */
    public static void main(String[] args) {
        mangPack(4,4,new int[]{4,3,1,1,1},new int[]{3000,2000,1500,2000,1000},new int[]{1,1,1,1,1});
    }

    public static void mangPack(int V,int N,int[] weight,int[] value,int[] num) {
        // 根据0-1背包问题 来解决
        // 这次每行做对比的时候 就可以把当前物品在添加的时候 做个判断
        int[][] dp = new int[N+1][V+1];
        for (int i=1;i<N+1;i++){
            for (int j = 1;j<V+1;j++){
                //  //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
                if (weight[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    // 这里跟0-1背包不同
                    // 考虑物品的件数限制
                    int maxV = Math.min(num[i-1],j/weight[i-1]);
                    for (int k =0;k<maxV+1;k++){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-k*weight[i-1]]+k*value[i-1]);
                    }
                }
            }
        }

        // 最大价值求出来了 dp[N][V]
        int maxValue = dp[N][V];
        System.out.println("能装的最大价值："+maxValue);

        // 装的又是哪些商品 各有多少件呢？



    }
}
