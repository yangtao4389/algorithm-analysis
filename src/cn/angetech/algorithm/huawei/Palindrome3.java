package cn.angetech.algorithm.huawei;

import java.util.Stack;

// 最简单解法
public class Palindrome3 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        Stack<Integer> stack = new Stack();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome3 palindrome3 = new Palindrome3();
        Palindrome3.ListNode node = palindrome3.new ListNode(1);
        node.next = palindrome3.new ListNode(2);
        node.next.next = palindrome3.new ListNode(2);
        node.next.next.next = palindrome3.new ListNode(1);
        System.out.println(palindrome3.isPalindrome(node));
    }
}
