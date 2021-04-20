package com.kid.leetcode;

public class Q1143LongestCommonSubsequence {

    /**
     * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
     *
     * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
     *
     * 若这两个字符串没有公共子序列，则返回 0。
     *
     *  
     *
     * 示例 1:
     *
     * 输入：text1 = "abcde", text2 = "ace"
     * 输出：3
     * 解释：最长公共子序列是 "ace"，它的长度为 3。
     * 示例 2:
     *
     * 输入：text1 = "abc", text2 = "abc"
     * 输出：3
     * 解释：最长公共子序列是 "abc"，它的长度为 3。
     * 示例 3:
     *
     * 输入：text1 = "abc", text2 = "def"
     * 输出：0
     * 解释：两个字符串没有公共子序列，返回 0。
     *  
     *
     * 提示:
     *
     * 1 <= text1.length <= 1000
     * 1 <= text2.length <= 1000
     * 输入的字符串只含有小写英文字符。
     *
     */

    public int longestCommonSubsequence(String text1, String text2) {
        /**
         *   使用二维数组做动态规划， 首先，找出动态公式
         *   1. 如果横和列上的字母相等，则获取其上对角线的值+1
         *   2. 如果不相等，则获取其左边或者上边的最大值
         *   3. 注意初始化数组的时候，横坐标和纵坐标的长度都要+1.空余出"" 和 "" 相对比等于0的值。
         */

        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0){
            return 0;
        }
        //先填充第一行和第一列为0
        int[][] pg = new int[text1.length()+1][text2.length()+1];
        for (int i = 0; i <= text1.length(); i++) {
            pg[i][0] = 0;
        }
        for (int i = 0; i <= text2.length(); i++) {
            pg[0][i] = 0;
        }
        //此动态公式需要先计算出横坐标，所以以纵坐标为最外层循环
        for (int j = 1; j <= text2.length(); j++) {
            for (int i = 1; i <= text1.length(); i++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    pg[i][j] = pg[i-1][j-1] + 1;
                }else{
                    pg[i][j] = Math.max(pg[i][j-1],pg[i-1][j]);
                }
            }
        }
        return pg[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        Q1143LongestCommonSubsequence q1143LongestCommonSubsequence = new Q1143LongestCommonSubsequence();
        final int i = q1143LongestCommonSubsequence.longestCommonSubsequence("abcde", "ace");
        System.out.println(i);
    }
}
