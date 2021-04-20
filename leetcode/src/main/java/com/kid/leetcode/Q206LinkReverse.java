package com.kid.leetcode;


import com.kid.leetcode.util.LinkUtil;
import com.kid.leetcode.util.ListNode;

import java.util.HashMap;

public class Q206LinkReverse {

    /**
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     * */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public static void main(String[] args) {
        Q206LinkReverse q206LinkReverse = new Q206LinkReverse();
        int[] a  = {1,2,3,4,5};
        final ListNode listNode = LinkUtil.getListNode(a);
        final ListNode listNode1 = q206LinkReverse.reverseList(listNode);
        LinkUtil.printListNode(listNode1);
    }
}
