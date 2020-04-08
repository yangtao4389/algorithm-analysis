package cn.angetech.algorithm.huawei;

import java.util.ArrayList;
import java.util.Arrays;

/*
* 这里有 n 个航班，它们分别从 1 到 n 进行编号。

我们这儿有一份航班预订表，表中第 i 条预订记录 bookings[i] = [i, j, k] 意味着我们在从 i 到 j 的每个航班上预订了 k 个座位。

请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。


示例：

输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
输出：[10,55,45,25,25]

提示：
1 <= bookings.length <= 20000
1 <= bookings[i][0] <= bookings[i][1] <= n <= 20000
1 <= bookings[i][2] <= 10000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/corporate-flight-bookings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class Hangban {
    /*
    *
    * 这个解决方法：执行用时 :1813 ms, 在所有 Java 提交中击败了19.27%的用户
                    内存消耗 :55.9 MB, 在所有 Java 提交中击败了100.00%的用户
    * */

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ints = new int[n];
        System.out.println(Arrays.toString(ints));  //[0, 0, 0, 0, 0]
        for (int[] booking: // [1,2,10]
             bookings) {
            for (int i=booking[0]-1;i<booking[1];i++){
                ints[i] += booking[2];
            }
        }
        return ints;
    }

    /*
    * 执行用时3毫秒的案例
    *
    * */
    public int[] corpFlightBookings1(int[][] bookings, int n) {
        int[] ints = new int[n];
        for (int[] booking:bookings){ // [1,2,10]
            ints[booking[0]-1]+=booking[2]; // 第一个先增

            // 最后一个递减？？  这个思路 简直了。
            if(booking[1]<n){
                ints[booking[1]] -= booking[2];  // [10,,,,-10]
            }
        }

        for (int i=1;i<n;i++){
            ints[i] += ints[i-1];
        }
        return ints;


    }



    public static void main(String[] args) {
        int[][] ints = {{1,2,10},{2,3,20},{2,5,25}};

        int[] ints1 = new Hangban().corpFlightBookings(ints, 5);
        System.out.println(Arrays.toString(ints1));
    }
}
