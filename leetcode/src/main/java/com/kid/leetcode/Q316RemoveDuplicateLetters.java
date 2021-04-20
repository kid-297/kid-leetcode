package com.kid.leetcode;

import java.util.*;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/9/4 14:41
 */
public class Q316RemoveDuplicateLetters {

    /**
     * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。
     * 需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: "bcabc"
     * 输出: "abc"
     * 示例 2:
     *
     * 输入: "cbacdcbc"
     * 输出: "acdb"
     */

    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        Map<Character,Integer> last_oc = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            last_oc.put(s.charAt(i),i);
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (! set.contains(c)){
                while (!stack.isEmpty() && c < stack.peek() && last_oc.get(stack.peek()) > i){
                    final Character pop = stack.pop();
                    set.remove(pop);
                }
                set.add(c);
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for (Character c : stack) {
            sb.append(c.charValue());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Q316RemoveDuplicateLetters q316RemoveDuplicateLetters = new Q316RemoveDuplicateLetters();
        final String bcabc = q316RemoveDuplicateLetters.removeDuplicateLetters("bcabc");
        System.out.println(bcabc);
    }
}
