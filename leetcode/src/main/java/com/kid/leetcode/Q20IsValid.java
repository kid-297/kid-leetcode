package com.kid.leetcode;

import java.util.*;

public class Q20IsValid {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     */

    public boolean isValid(String s) {
        if (null == s || "".equals(s) || s.length() % 2 != 0){
            return false;
        }

        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (map.containsValue(c)){
                deque.push(c);
            }
            if (map.containsKey(c)){
                if (deque.isEmpty() || map.get(c) != deque.peek()){
                    return false;
                }
                deque.pop();
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        Q20IsValid q20IsValid = new Q20IsValid();
        final boolean valid = q20IsValid.isValid("{[]}");
        System.out.println(valid);
    }
}
