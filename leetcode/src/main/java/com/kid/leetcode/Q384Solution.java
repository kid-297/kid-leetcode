package com.kid.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/8/27 15:56
 */
public class Q384Solution {

    /**
     * 打乱一个没有重复元素的数组。
     *
     *  
     *
     * 示例:
     *
     * // 以数字集合 1, 2 和 3 初始化数组。
     * int[] nums = {1,2,3};
     * Solution solution = new Solution(nums);
     *
     * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
     * solution.shuffle();
     *
     * // 重设数组到它的初始状态[1,2,3]。
     * solution.reset();
     *
     * // 随机返回数组[1,2,3]打乱后的结果。
     * solution.shuffle();
     *
     */

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */
    int[] NUMS;
    Random random = new Random();
    public Q384Solution(int[] nums) {
        NUMS = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return NUMS;
    }
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] arrays = new int[NUMS.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < NUMS.length; i++) {
            list.add(NUMS[i]);
        }
        for (int i = 0;i < NUMS.length; i++) {
            int nextInt = random.nextInt(list.size());
            arrays[i] = list.get(nextInt);

            list.remove(nextInt);
        }

        return arrays;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Q384Solution obj = new Q384Solution(nums);
        int[] param_2 = obj.shuffle();
        System.out.println(param_2.toString());
        int[] param_1 = obj.reset();
        System.out.println(param_1.toString());
    }
}
