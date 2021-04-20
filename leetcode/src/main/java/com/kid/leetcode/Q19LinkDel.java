package com.kid.leetcode;

import com.kid.leetcode.util.LinkUtil;
import com.kid.leetcode.util.ListNode;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/7/29 13:39
 */
public class Q19LinkDel {

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     *
     * 你能尝试使用一趟扫描实现吗？
     * 此处n指倒数,m指正数
     *             n + m = total + 1;
     *             上述算法可以优化为只使用一次遍历。我们可以使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1步，
     *             而第二个指针将从列表的开头出发。现在，这两个指针被 n 个结点分开。我们通过同时移动两个指针向前来保持这个恒定的间隔，
     *             直到第一个指针到达最后一个结点。此时第二个指针将指向从最后一个结点数起的第 n 个结点。
     *             我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp1 = head;
        ListNode temp2 = head;

        int first = 0;

        while (temp1 != null){
            first ++;
            temp1 = temp1.next;
            if(first > n+1){
                temp2 = temp2.next;
            }
        }

        if(first <= n){
            return head.next;
        }

        temp2.next = temp2.next.next;
        return head;
    }


    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


    public static void main(String[] args) {
        Q19LinkDel q19DelLink = new Q19LinkDel();
        ListNode head1 = new ListNode(0);
        int[] l1 = {1,2};
        for (int i = 0; i < l1.length; i++) {
            LinkUtil.add(l1[i],head1);
        }
        ListNode listNode = q19DelLink.removeNthFromEnd(head1.next, 2);
        while (listNode != null){
            System.out.print(listNode.val+",");
            listNode = listNode.next;
        }
    }
}
