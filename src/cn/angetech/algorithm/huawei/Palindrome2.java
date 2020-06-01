package cn.angetech.algorithm.huawei;

import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
1、请判断一个链表是否为回文链表。
示例 1:
输入: 1->2
输出: false
示例 2:
输入: 1->2->2->1
输出: true
*
* */
public class Palindrome2 {
    public static boolean isPalindrome(LinkedList linkedList){
        LinkedList sourseList = linkedList;
        Collections.reverse(linkedList);
        System.out.println(sourseList);
        System.out.println(linkedList);
        for (int i = 0; i < linkedList.size(); i++) {
            if (sourseList.indexOf(i) != linkedList.indexOf(i)){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println("请输入：");
        Scanner scanner = new Scanner(System.in);
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (scanner.hasNext()){
            linkedList.add(scanner.nextInt());
            System.out.println(linkedList);
            System.out.println(isPalindrome(linkedList));
        }


    }

}
