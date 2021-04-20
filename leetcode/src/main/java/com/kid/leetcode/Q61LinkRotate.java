package com.kid.leetcode;

import com.kid.leetcode.util.LinkUtil;
import com.kid.leetcode.util.ListNode;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/7/30 09:50
 */
public class Q61LinkRotate {

    /**
     *
     给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

     示例 1:

     输入: 1->2->3->4->5->NULL, k = 2
     输出: 4->5->1->2->3->NULL
     解释:
     向右旋转 1 步: 5->1->2->3->4->NULL
     向右旋转 2 步: 4->5->1->2->3->NULL
     示例 2:

     输入: 0->1->2->NULL, k = 4
     输出: 2->0->1->NULL
     解释:
     向右旋转 1 步: 2->0->1->NULL
     向右旋转 2 步: 1->2->0->NULL
     向右旋转 3 步: 0->1->2->NULL
     向右旋转 4 步: 2->0->1->NULL

     拼接成环形，然后从中间断开
     算法实现很直接：

     找到旧的尾部并将其与链表头相连 old_tail.next = head，整个链表闭合成环，同时计算出链表的长度 n。
     找到新的尾部，第 (n - k % n - 1) 个节点 ，新的链表头是第 (n - k % n) 个节点。
     断开环 new_tail.next = None，并返回新的链表头 new_head。
     实现

     */

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return null;
        }
        if (head.next == null){
            return head;
        }
        //接环
        ListNode l1 = head;
        int count = 1;
        while (l1.next != null){
            count++;
            l1 = l1.next;
        }
        l1.next = head;
        ListNode l2 = head;
        //断掉
        for (int i = 0; i < count - k%count -1; i++) {
            l2 = l2.next;
        }
        ListNode l3 = l2.next;
        l2.next = null;
        return l3;
    }

  /*  public ListNode rotateRight1(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for(n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }*/

    public static void main(String[] args) {
        Q61LinkRotate q61LinkRotate = new Q61LinkRotate();

        int[] l = {1,2,3,4,5};

        ListNode listNode = q61LinkRotate.rotateRight(LinkUtil.getListNode(l), 2);
        LinkUtil.printListNode(listNode);
    }
}
