package com.kid.leetcode;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/9/15 18:09
 */
public class Q34SearchRange {

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 如果数组中不存在目标值，返回 [-1, -1]。
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     *
     */

    public int[] searchRange(int[] nums, int target) {
        if (nums == null){
            return new int[]{-1,-1};
        }
        int left = 0;
        int right = nums.length - 1;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        while (left <= right){
            int i = (right + left) / 2;
            int temp = nums[i];
            if (target == temp){
                for (int j = i; j >= left; j--) {
                    if (target != nums[j]){
                        break;
                    }
                    start = Math.min(start,j);
                }
                for (int j = i; j <= right; j++) {
                    if (target != nums[j]){
                        break;
                    }
                    end = Math.max(end,j);
                }
                break;
            }
            if (target < temp){
                right = i - 1;
            }else{
                left = i + 1;
            }
        }
        start = start == Integer.MAX_VALUE ? -1:start;
        end = end == Integer.MIN_VALUE ? -1 : end;
        return new int[]{start,end};
    }

    public static void main(String[] args) {
        Q34SearchRange q34SearchRange = new Q34SearchRange();
        int[] ints = q34SearchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(ints.toString());
    }
}
