package com.kid.leetcode;

import com.kid.leetcode.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q23MergeKLists {

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     *
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     *
     * 输入：lists = [[]]
     * 输出：[]
     *  
     *
     * 提示：
     *
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     *
     */

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null){
                continue;
            }
            queue.add(lists[i]);
        }
        ListNode node = new ListNode(0);
        ListNode temp = node;
        while (!queue.isEmpty()){
            temp.next = queue.poll();
            temp = temp.next;
            if (temp.next != null){
                queue.add(temp.next);
            }
        }
        return node.next;
    }
}

/**
 *  public ListNode mergeKLists(ListNode[] lists) {
 *         if (lists == null || lists.length == 0) return null;
 *         PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
 *             @Override
 *             public int compare(ListNode o1, ListNode o2) {
 *                 if (o1.val < o2.val) return -1;
 *                 else if (o1.val == o2.val) return 0;
 *                 else return 1;
 *             }
 *         });
 *         ListNode dummy = new ListNode(0);
 *         ListNode p = dummy;
 *         for (ListNode node : lists) {
 *             if (node != null) queue.add(node);
 *         }
 *         while (!queue.isEmpty()) {
 *             p.next = queue.poll();
 *             p = p.next;
 *             if (p.next != null) queue.add(p.next);
 *         }
 *         return dummy.next;
 *     }
 *
 */
