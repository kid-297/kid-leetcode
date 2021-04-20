package com.kid.leetcode;

public class Q7Reverse {

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     *
     * 示例 1:
     *
     * 输入: 123
     * 输出: 321
     *  示例 2:
     *
     * 输入: -123
     * 输出: -321
     * 示例 3:
     *
     * 输入: 120
     * 输出: 21
     * 注意:
     *
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，
     * 如果反转后整数溢出那么就返回 0。
     * TODO 采用取余方式做一遍
     */

    public int reverse(int x) {
        String xs = x + "";
        String symbol = "";
        int end = 0;
        if (x <= 0){
            symbol = xs.charAt(0)+"";
            end = 1;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = xs.length() - 1; i >= end; i--) {
            stringBuilder.append(xs.charAt(i));
        }

        long aLong = Long.valueOf(symbol + stringBuilder.toString());
        if (aLong > Integer.MAX_VALUE || aLong < Integer.MIN_VALUE){
            return 0;
        }
        return (int)aLong;
    }

    public static void main(String[] args) {
        Q7Reverse q7Reverse = new Q7Reverse();
        final int reverse = q7Reverse.reverse(1534236469);
        System.out.println(reverse);
    }
}
