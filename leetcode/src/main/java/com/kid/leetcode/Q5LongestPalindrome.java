package com.kid.leetcode;

public class Q5LongestPalindrome {

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     *
     *
     * 解题思路：采用动态规划方式进行解题
     *
     */

    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        int maxLength = 1;
        int begin = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        final char[] chars = s.toCharArray();
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]){
                    dp[i][j] = false;
                }else{
                    if (j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j-i+1 > maxLength){
                    maxLength = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLength);
    }

    public static void main(String[] args) {
        Q5LongestPalindrome q5LongestPalindrome = new Q5LongestPalindrome();
        final String aba = q5LongestPalindrome.longestPalindrome("cbbd");
        System.out.println(aba);
    }
}
