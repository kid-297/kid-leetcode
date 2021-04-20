package com.kid.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q6Convert {

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     *
     * string convert(string s, int numRows);
     * 示例 1:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     *
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     *
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     */
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }
        //设置存放Z字型list
        List<StringBuilder> temp = new ArrayList<>();
        //初始化列表
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            temp.add(new StringBuilder());
        }
        //设置list 指针
        int point = 0;
        //是否变化标识
        boolean isChange = false;
        //遍历原字符串
        for (char c :  s.toCharArray()) {
            temp.get(point).append(c);
            //如果到列的最后一行或者第一行，则变化标识
            if (point == numRows-1 || point == 0){
                isChange = !isChange;
            }
            if (isChange){
                point ++;
            }else {
                point --;
            }
        }
        //遍历组装好的Z字形列表，输出结果
        StringBuilder rs = new StringBuilder();
        for (StringBuilder str: temp) {
            rs.append(str);
        }
        return rs.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        Q6Convert q6Convert = new Q6Convert();
        final String convert = q6Convert.convert(s, numRows);
        System.out.println(convert);
    }
}
