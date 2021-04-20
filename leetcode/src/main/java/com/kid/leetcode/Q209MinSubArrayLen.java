package com.kid.leetcode;

public class Q209MinSubArrayLen {

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     *
     *  
     *
     * 示例：
     *
     * 输入：s = 7, nums = [2,3,1,2,4,3]
     *
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     *  
     *
     * 进阶：
     *
     * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
     */

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length <= 1){
            return nums.length;
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;;

        while (left < nums.length && right < nums.length) {
            sum = sum + nums[right];
            while (sum >= s){
                min = Math.min(min,right-left+1);
                sum = sum - nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        Q209MinSubArrayLen q209MinSubArrayLen = new Q209MinSubArrayLen();
        //final int i = q209MinSubArrayLen.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
        //final int i = q209MinSubArrayLen.minSubArrayLen(8, new int[]{2, 3, 1, 2, 4, 3});
        final int i = q209MinSubArrayLen.minSubArrayLen(3, new int[]{1, 1});
        System.out.println(i);
    }
}
