package com.kid.leetcode.util;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/7/29 14:14
 */
public class LinkUtil {

    public static void add(Integer data, com.kid.leetcode.util.ListNode head){
        com.kid.leetcode.util.ListNode temp = head;
        //找到链表最后一个
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new com.kid.leetcode.util.ListNode(data);
    }

   public static void addNode(Integer data1,Integer data2 ,Node head){
        Node temp = head;
        //找到链表最后一个
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(data1);
        if (data2 == null){
            return;
        }
        temp.next.random = new Node(data2);

    }

    public static com.kid.leetcode.util.ListNode getListNode(int [] l){
        com.kid.leetcode.util.ListNode head1 = new com.kid.leetcode.util.ListNode(0);
        for (int i = 0; i < l.length; i++) {
            LinkUtil.add(l[i],head1);
        }
        return head1.next;
    }

    public static void printListNode(com.kid.leetcode.util.ListNode listNode){
        while (listNode != null){
            System.out.print(listNode.val+",");
            listNode = listNode.next;
        }
    }

}
