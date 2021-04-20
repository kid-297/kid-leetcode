package com.kid.leetcode;

/**
 * @version V1.0
 * @Description: 双指针遍历和滑动窗口
 * @Auther: ly
 * @Date: 2020/8/3 09:48
 */
public class Q3LengthOfLongestSubstring {
    /**
     *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     *
     * 答题思路：采用滑动窗口的方式进行计算
     *
     * 1. 创建一个集合，记录不重复子串
     * 2. 如果当前元素重复了，则判断重复的元素的位置
     * 3. 移动窗口到该位置的下一个位置
     * 4. 继续记录不重复子串
     * 5. 比较最后一个子串和当前不重复子串的长度，选出最大值
     */

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()){
            return 0;
        }

        int count = 0;

        char[] chars = s.toCharArray();
        int pointer1 = 0;
        String temp = "";
        for (int i = 0; i < chars.length; i++) {
            if (pointer1 != i && temp.contains(chars[i]+"")){
                count = Math.max(count,i-pointer1);
                //判断当前重复值在字符串中的位置
                String temp1 = temp.substring(0,temp.indexOf(chars[i])+1);
                //计算出滑动长度
                pointer1 = pointer1 + temp1.length();
                //组成新的串
                temp = temp.substring(temp1.length(),temp.length())+chars[i]+"";
            }else{
                temp = temp + chars[i];
            }
        }
        if (count == 0){
            return chars.length;
        }
        return Math.max(count,temp.length());
    }

    public static void main(String[] args) {
        Q3LengthOfLongestSubstring length = new Q3LengthOfLongestSubstring();
        String s = "abcabcbb";
        System.out.println(s.indexOf('c'));
        int i = length.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
