package com.kid.leetcode;

public class Q14LongestCommonPrefix {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     *
     * 示例 1:
     *
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * 示例 2:
     *
     * 输入: ["dog","racecar","car"]
     * 输出: ""
     * 解释: 输入不存在公共前缀。
     * 说明:
     *
     * 所有输入只包含小写字母 a-z 。
     *
     */

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        //取第一个参数作为对照组
        char[] contrast = strs[0].toCharArray();
        int point = 0;

        StringBuilder rs = new StringBuilder("");

        for (int i = 1; i < strs.length; i++) {
            if (contrast == null){
                break;
            }
            final char[] chars = strs[i].toCharArray();
            for (int j = 0; j < Math.min(chars.length,contrast.length); j++) {
                if (contrast[point] != chars[j]) {
                    break;
                }
                rs.append(contrast[point]+"");
                point++;
            }
            contrast = rs.toString().toCharArray();
            point = 0;
            rs.delete(0,rs.length());
        }
        for (char c : contrast) {
            rs.append(c);
        }
        return rs.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        Q14LongestCommonPrefix q14LongestCommonPrefix = new Q14LongestCommonPrefix();
        final String s = q14LongestCommonPrefix.longestCommonPrefix(strs);
        System.out.println(s);
    }
}
