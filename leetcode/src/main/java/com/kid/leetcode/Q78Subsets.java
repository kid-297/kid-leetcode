package com.kid.leetcode;

import java.util.*;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/8/26 13:36
 */
public class Q78Subsets {

    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 说明：解集不能包含重复的子集。
     *
     * 示例:
     *
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     */

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());

        for (int num : nums){
            List<List<Integer>> newList = new ArrayList<>();

            for (List<Integer> curr : lists) {
                newList.add( new ArrayList<Integer>(curr){{add(num);}});
            }

            for (List<Integer> curr : newList) {
                lists.add(curr);
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Q78Subsets q78Subsets = new Q78Subsets();
        List<List<Integer>> subsets = q78Subsets.subsets(nums);
        for (int i = 0; i < subsets.size(); i++) {
            System.out.println(subsets.get(i).toString());
        }
    }
}