package com.kid.leetcode;

import java.util.Arrays;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/8/28 15:15
 */
public class Q581FindUnsortedSubarray {

    /**
     *给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     *
     * 你找到的子数组应是最短的，请输出它的长度。
     *
     * 示例 1:
     *
     * 输入: [2, 6, 4, 8, 10, 9, 15]
     * 输出: 5
     * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
     * 说明 :
     *
     * 输入的数组长度范围在 [1, 10,000]。
     * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
     *
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] arrays = nums.clone();

        Arrays.sort(arrays);

        int left = nums.length;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!= arrays[i]){
                left = Math.min(left,i);
                right = Math.max(right,i);
            }
        }
        return (right-left) >= 0 ? (right-left+1) : 0;
    }

    public static void main(String[] args) {
        int[] nums ={2, 6, 4, 8, 10, 9, 15};
        Q581FindUnsortedSubarray q581FindUnsortedSubarray = new Q581FindUnsortedSubarray();
        int unsortedSubarray = q581FindUnsortedSubarray.findUnsortedSubarray(nums);
        System.out.println(unsortedSubarray);
    }

}
