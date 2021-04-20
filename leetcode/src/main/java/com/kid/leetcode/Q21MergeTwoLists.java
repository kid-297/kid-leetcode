package com.kid.leetcode;

import com.kid.leetcode.util.ListNode;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/9/8 19:52
 */
public class Q21MergeTwoLists {

    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     *
     *  
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null ){
            return l2;
        }else if (l2 == null){
            return l1;
        }else if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }

}
