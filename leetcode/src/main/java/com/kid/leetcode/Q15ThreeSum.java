package com.kid.leetcode;

import java.util.*;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/8/5 11:23
 */
public class Q15ThreeSum {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *  
     *
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     */

    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);

        List<List<Integer>> rs = new ArrayList<>();

        for (int first = 0; first < nums.length; first++) {

            if (first>0 && nums[first] == nums[first-1]){
                continue;
            }

            int third = nums.length-1;
            int target = -nums[first];

            for (int second = first+1; second< nums.length; second++) {
                //略过与上一个相同的数据
                if (second > first + 1 && nums[second] == nums[second-1]){
                    continue;
                }

                //如果两数相加，大于第三数，则右指针向左移动
                while (second < third && nums[second] + nums[third] > target){
                    third--;
                }

                //如果两个指针相等，则代表走完一整段，则跳出本次循环
                if (second == third){
                    break;
                }

                //符合条件，添加数组
                if (nums[second] + nums[third] == target){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[first]);
                    temp.add(nums[second]);
                    temp.add(nums[third]);
                    rs.add(temp);
                }
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        Q15ThreeSum q15ThreeSum = new Q15ThreeSum();
        final List<List<Integer>> lists = q15ThreeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists.toString());
    }
}
