package cn.angetech.algorithm.huawei;

import java.util.Stack;

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
public class Palindrome {
    /*
    * 1、构造Node类
    * 2、构造LinkedList类
    * 3、判断LinkedList实例是否为回文链表
    *
    * */

    public static class Node{
        public int data;
        public Node next = null;
        Node(int data){
            this.data = data;
        }
    }

    public static class LinkedList{
        Node head = null;
        Node tail = null;
        public void insert(Node node){
            if (head == null){
                head = node;
                tail = node;
            }else {
                // 末尾追加  头怎么链接？像是会自动链接的
                tail.next = node;
                tail = node;
            }
        }
    }


    public  static boolean isPalindrome(LinkedList linkedList){
        /*
        * 1、反转对比值
        *
        * */
        Stack<Integer> stack = new Stack<>();
        Node head = linkedList.head;
        if (head == null){
            return false;
        }
        if (head.next == null){
            return true;
        }

        while (head != null){
            stack.push(head.data);
            head = head.next;
        }
        System.out.println(stack);
        head = linkedList.head;
        while (head != null){
            int tmp = stack.pop();
            if (head.data != tmp){
                return false;
            }
            head = head.next;
        }
        return true;


    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(new Node(1));
        linkedList.insert(new Node(3));
        linkedList.insert(new Node(1));
        System.out.println(linkedList);

        System.out.println(isPalindrome(linkedList));

    }

}
