package cn.angetech.algorithm.dynamic_programming;
/*
* 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

若这两个字符串没有公共子序列，则返回 0。

 

示例 1:

输入：text1 = "abcde", text2 = "ace"
输出：3
解释：最长公共子序列是 "ace"，它的长度为 3。
示例 2:

输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc"，它的长度为 3。
示例 3:

输入：text1 = "abc", text2 = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0。
 

提示:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
输入的字符串只含有小写英文字符。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*
*
* */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        longestCommonSubsequence("bsbininm","jmjkbkjkv");  // 只能输出1  我却输出了2
    }

    public static void longestCommonSubsequence(String s1,String s2) {

        // 利用动态规划来试试
        /*
        * s1/s2
        * * a b c d e
        * a 1 1 1 1 1 对比第一行 看它的左边上边 左上数据 取最大值 如果相等 再加1
        * c 1 1 2 2 2 跟上面那行结构一样
        * e 1 1 2 2 3
        *
        * 这种只能求出 最大值  但具体位置 好像 不太好求。。
        *
        *
        * */

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        int[][] dp = new int[chars2.length + 1][chars1.length + 1];
        for (int i=1;i<chars2.length+1;i++){
            for (int j =1;j<chars1.length+1;j++){
                if (chars1[j-1] == chars2[i-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        for (int i=1;i<chars2.length+1;i++) { // b
            for (int j = 1; j < chars1.length + 1; j++) {  // 与s1 对比
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("最大长度:"+ dp[chars2.length][chars1.length]);



    }

}
