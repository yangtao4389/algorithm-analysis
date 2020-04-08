package cn.angetech.algorithm.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 链接：https://www.nowcoder.com/questionTerminal/8b870ea5dda44975a08f4b82fd6bdb16
来源：牛客网

给定一个由小写字母组成的字符串s，请将其分割成尽量多的子串，并保证每个字母最多只在其中一个子串中出现。请返回由一个或多个整数表示的分割后各子串的长度。


输入描述:
来自标准输入的一行由小写字母组成的字符串。


输出描述:
字符串最优分割后各子串的长度，多个数字之间由空格分隔。
示例1
输入
ababbacadefgdehijhklij
输出
8 6 8
说明
该样例下最优的分割为"ababbaca" + "defgde" + "hijhklij"，在该分割下字母abc仅出现在"ababbaca"中、字母defg仅出现在"defgde"中、字母hijkl仅出现在"hijhklij"中
要求将其“分割为尽量多的子串”意味着像"ababbacadefgde" + "hijhklij"这样的分割也是合法的，但在本题中并不是最优解
*
*
* */
public class ZiFuChuanFenGe {
    public static void main(String[] args) throws IOException {
//        String s = "ababbacadefgdehijhklij";
//        System.out.println(s.length());

        getMaxStr();
    }

    public static void getMaxStr() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        StringBuilder result = new StringBuilder();  // 结果数据输出  格式：  数字 空格 数字

        /*
         * 对给定的字符串 判断 当找到最大长度的时候 substring 字符串 直到字符串为0
         *
         * 最大长度，
         * 假设下标为0 的字符串 的最后一个index  为5
         * 则 在1-5中间的各个字符去找 s的 最大index 然后替换
         *  取完  写入 result
         *
         *  将原有字符串进行切割 再次循环
         * */
        while (s.length() >0){
            // 临时的index 记录第一个字节
            int tmpIndex = s.lastIndexOf(s.charAt(0));
            for (int i=1;i<tmpIndex;i++){
                tmpIndex  = Math.max(tmpIndex, s.lastIndexOf(s.charAt(i)));
            }
            result.append((tmpIndex+1) +" ");
            s = s.substring(tmpIndex+1);

        }
        // 去掉末尾的空格
        System.out.println(result.toString().trim());

    }





    public void fenge() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        StringBuilder sb = new StringBuilder();
        while (s.length() > 0) {
            int index = s.lastIndexOf(s.charAt(0));//首先找到第一个字符的最后索引的位置，在再这个范围内找出子串的最大长度
            for (int i = 1; i < index; i++) {
                index = Math.max(s.lastIndexOf(s.charAt(i)), index);
            }
            sb.append(index + 1).append(" ");
            s = s.substring(index + 1);
        }
        System.out.println(sb.substring(0, sb.length() - 1).toString());
    }


}
