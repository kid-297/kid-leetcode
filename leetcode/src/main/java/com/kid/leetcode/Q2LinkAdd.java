package com.kid.leetcode;

import com.kid.leetcode.util.LinkUtil;
import com.kid.leetcode.util.ListNode;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/7/29 10:56
 */
public class Q2LinkAdd {
    /**
    * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    *
    * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    *
    * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    *
    * 示例：
    *
    * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    * 输出：7 -> 0 -> 8
    * 原因：342 + 465 = 807
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1,q=l2,temp = head;

        int carry = 0;
        //1.从链表开始，俩两相加
        while (p != null || q != null){
            int x = p != null ? p.val : 0;
            int y = q != null ? q.val : 0;
            int sum = x + y + carry;
            //2.如果相加需要进位，则考虑进位相加到下一次
            carry = sum/10;
            temp.next =  new ListNode(sum % 10);
            temp = temp.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0){
            temp.next = new ListNode(carry);
        }
        //4.输出链表
        return head.next;
    }

    public static void main(String[] args) {
        Q2LinkAdd q2LinkAdd = new Q2LinkAdd();
        int[] l1 = {2,4,3};
        int[] l2 = {5,6,4};
        ListNode head1 = new ListNode(l1[0]);
        ListNode head2 = new ListNode(l2[0]);
        for (int i = 1; i < l1.length; i++) {
            LinkUtil.add(l1[i],head1);
        }
        for (int i = 1; i < l2.length; i++) {
            LinkUtil.add(l2[i],head2);
        }
        ListNode listNode = q2LinkAdd.addTwoNumbers(head1, head2);
        System.out.println(listNode.toString());
    }




}


