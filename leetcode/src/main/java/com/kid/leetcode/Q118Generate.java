package com.kid.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q118Generate {
    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     *
     *
     *
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     *
     * 示例:
     *
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0){
            return Collections.emptyList();
        }
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> first = new ArrayList<>();
        first.add(1);
        lists.add(first);

        for (int i = 1; i < numRows; i++) {
            List<Integer> one = new ArrayList<>();
            List<Integer> last = lists.get(i-1);
            for (int j = 0; j <= i ; j++) {
                if (j == 0 || i == j){
                    one.add(1);
                }else{
                    one.add(last.get(j-1) + last.get(j));
                }
            }
            lists.add(one);
        }
        return lists;
    }

    public static void main(String[] args) {
        Q118Generate q118Generate = new Q118Generate();
        final List<List<Integer>> generate = q118Generate.generate(5);
        for (int i = 0; i < generate.size(); i++) {
            final List<Integer> integers = generate.get(i);
            for (int j = 0; j < integers.size(); j++) {
                System.out.print(integers.get(j));
            }
            System.out.println("");
        }
    }
}
