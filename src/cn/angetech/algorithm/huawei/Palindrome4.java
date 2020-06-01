package cn.angetech.algorithm.huawei;

import java.util.List;

public class Palindrome4 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    // 利用快慢指针 快的走两步 慢的走一步 找到中间值
    // 反转后半段链表 进行逐一对比
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 奇数 slow找到的是中间值 偶数 slow找到的是n/2+1
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // 反转slow过后的链表
        ListNode reverseFast = reverseList(slow);
        while (head != null){
            if (head.val != reverseFast.val){
                return false;
            }
            head = head.next;
            reverseFast = reverseFast.next;
        }
        return true;


    }
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        Palindrome4 palindrome4 = new Palindrome4();
        ListNode node = palindrome4.new ListNode(1);
        node.next = palindrome4.new ListNode(2);
        node.next.next = palindrome4.new ListNode(3);
        node.next.next.next = palindrome4.new ListNode(4);
        node.next.next.next.next = palindrome4.new ListNode(5);
        node.next.next.next.next.next = palindrome4.new ListNode(6);
        node.next.next.next.next.next.next = palindrome4.new ListNode(7);
        System.out.println(palindrome4.isPalindrome(node));

    }



}
