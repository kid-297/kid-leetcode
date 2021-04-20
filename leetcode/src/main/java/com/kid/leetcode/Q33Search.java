package com.kid.leetcode;

public class Q33Search {

    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     * 你可以假设数组中不存在重复的元素。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     * 示例 1:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     *
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     *
     */
    public int search(int[] nums, int target) {
        if (nums == null){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int i = (left + right)/2;
            int temp = nums[i];
            if (temp == target){
                return i;
            }
            //左边有序，右边无序
            if (nums[left] <= temp ){
                if (nums[left] <= target && target < temp){
                    right = i-1;
                }else {
                    left = i+1;
                }
            }else{
                //右边有序，左边无序
                if (nums[right] >= target && target > temp){
                    left = i+1;
                }else {
                    right = i-1;
                }
            }
        }
        return -1;
    }
}
