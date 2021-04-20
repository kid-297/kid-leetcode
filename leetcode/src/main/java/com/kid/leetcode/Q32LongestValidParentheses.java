package com.kid.leetcode;

import java.util.Stack;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/8/31 16:53
 */
public class Q32LongestValidParentheses {

    /**
     * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
     *
     * 示例 1:
     *
     * 输入: "(()"
     * 输出: 2
     * 解释: 最长有效括号子串为 "()"
     * 示例 2:
     *
     * 输入: ")()())"
     * 输出: 4
     * 解释: 最长有效括号子串为 "()()"
     *
     */
    public int longestValidParentheses(String s) {
        int maxLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(i);
            }
            if (s.charAt(i) == ')'){
                stack.pop();
                if (stack.empty()){
                    stack.push(i);
                }else {
                    maxLength = Math.max(maxLength,i-stack.peek());
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Q32LongestValidParentheses q32LongestValidParentheses = new Q32LongestValidParentheses();
        int i = q32LongestValidParentheses.longestValidParentheses(")()())");
        System.out.println(i);
    }
}
