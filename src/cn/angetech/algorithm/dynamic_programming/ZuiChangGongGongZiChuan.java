package cn.angetech.algorithm.dynamic_programming;



/*
* 利用动态规划
* 求解最长公共子串
*
* 动态规划 需要将
*
* */
public  class ZuiChangGongGongZiChuan {
    public static void main(String[] args) {
        new ZuiChangGongGongZiChuan().zuiChangGongGongZiChuan("abcdabed","gabe");
    }
    public void zuiChangGongGongZiChuan(String s1,String s2) {
        /*
        * s1为横坐标
        * s2 为纵坐标
        *  * a,b,c,d,b,c,e,f
        *  b 0  1 0 0 1 0 0 0   先对比
        *  c 0  0 2 0 0 2 0 0   再对比
        *  e 0  0 0 0 0 0 3 0
        *  f 0  0 0 0 0 0 0 4
        * */

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int column = chars1.length;

        int[][] dp = new int[chars2.length+1][chars1.length+1];
        MaxValue maxValueObj = new MaxValue(0,0);

        for (int i=1;i<chars2.length+1;i++){ // b
            for (int j = 1;j<chars1.length+1;j++){  // 与s1 对比
                if (chars2[i-1] == chars1[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;  // 跟对角线的值相比 // 这里会出问题 当i j 都为0时 所以将 数组构造的更大一点
                    if (maxValueObj.len < dp[i][j]){
                        maxValueObj.len =  dp[i][j];
                        maxValueObj.j = j;
                    }
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i=1;i<chars2.length+1;i++) { // b
            for (int j = 1; j < chars1.length + 1; j++) {  // 与s1 对比
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }


        System.out.println("最大长度:"+maxValueObj.len);
        System.out.println("匹配最大字符串："+s1.substring(maxValueObj.j-maxValueObj.len,maxValueObj.j));

    }
    public static class MaxValue {
        private int len;
        private int j;  // 从哪里结束的

        MaxValue(int len, int j) {
            this.len = len;
            this.j = j;
        }
    }

}
