package com.kid.leetcode;

import java.util.Stack;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/9/3 16:06
 */
public class Q224Calculate {
    /**
     * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
     *
     * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
     *
     * 示例 1:
     *
     * 输入: "1 + 1"
     * 输出: 2
     * 示例 2:
     *
     * 输入: " 2-1 + 2 "
     * 输出: 3
     * 示例 3:
     *
     * 输入: "(1+(4+5+2)-3)+(6+8)"
     * 输出: 23
     * 说明：
     *
     * 你可以假设所给定的表达式都是有效的。
     * 请不要使用内置的库函数 eval。
     *
     * @param s
     * @return
     */

    public int calculate(String s) {

        Stack<Integer> stack = new Stack();
        //总值
        int sum = 0;
        //当前值
        int current = 0;
        //符号 默认+
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                current = 10 * current + (c - '0');
            }else if( c == '('){
                stack.push(sum);
                stack.push(sign);
                sign = 1;
                sum = 0;
            }else if( c == ')'){
                sum += current * sign;
                sum *= stack.pop();
                sum += stack.pop();
                current = 0;
            }else if( c == '+'){
                sum += current * sign;
                sign = 1;
                current = 0;
            }else if( c == '-'){
                sum += current * sign;
                sign = -1;
                current = 0;
            }
        }

        return sum + (sign * current);
    }
    public static void main(String[] args) {
        Q224Calculate q224Calculate = new Q224Calculate();
        int calculate = q224Calculate.calculate("(1+(4+5+2)-3)+(6+8)");
        System.out.println(calculate);
    }
}
