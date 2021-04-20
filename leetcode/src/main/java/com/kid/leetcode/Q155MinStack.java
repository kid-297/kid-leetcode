package com.kid.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/9/1 14:24
 */
public class Q155MinStack {

    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     *  
     *
     * 示例:
     *
     * 输入：
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     *
     * 输出：
     * [null,null,null,null,-3,null,0,-2]
     *
     * 解释：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     *  
     *
     * 提示：
     *
     * pop、top 和 getMin 操作总是在 非空栈 上调用。
     *
     */

    /** initialize your data structure here. */

    List<Integer> list = new LinkedList<>();

    int min = Integer.MAX_VALUE;
    int size = 0;

    public Q155MinStack() {

    }

    public void push(int x) {
        min = Math.min(min,x);
        list.add(x);
        size++;
    }

    public void pop() {
        int top = top();
        list.remove(size-1);
        size--;
        if (top == min){
            min = Integer.MAX_VALUE;
            for (int i = 0; i < size; i++) {
                min = Math.min(min,list.get(i));
            }
        }

    }

    public int top() {
        return list.get(size-1);
    }

    public int getMin() {
        if (size == 0){
            return 0;
        }
        return min;
    }

    public static void main(String[] args) {
        Q155MinStack q155MinStack = new Q155MinStack();
        q155MinStack.push(-2);
        q155MinStack.push(0);
        q155MinStack.push(-3);
        System.out.println(q155MinStack.getMin());
        q155MinStack.pop();
        System.out.println(q155MinStack.top());
        System.out.println(q155MinStack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 *     * MinStack minStack = new MinStack();
 *      * minStack.push(-2);
 *      * minStack.push(0);
 *      * minStack.push(-3);
 *      * minStack.getMin();   --> 返回 -3.
 *      * minStack.pop();
 *      * minStack.top();      --> 返回 0.
 *      * minStack.getMin();   --> 返回 -2.
 *      *  
 */
