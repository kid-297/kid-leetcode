package com.kid.leetcode;

import java.util.Arrays;
import java.util.List;

public class Q16ThreeSumClosest {

    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     *
     *  
     *
     * 示例：
     *
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     *  
     *
     * 提示：
     *
     * 3 <= nums.length <= 10^3
     * -10^3 <= nums[i] <= 10^3
     * -10^4 <= target <= 10^4
     */
    public int threeSumClosest(int[] nums, int target) {
        //排序  从小到大
        Arrays.sort(nums);
        int best = 10000000;

        for (int first = 0; first < nums.length; first++) {

            //遇到相同的，略过
            if (first>0 && nums[first] == nums[first-1]){
                continue;
            }

            int second = first + 1;
            int third = nums.length-1;
            while (second < third){
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == target){
                    return target;
                }
                if(Math.abs(target-best) > Math.abs(target-sum)){
                    best = sum;
                }
                if (sum >= target){
                    third--;
                    //去除重复值
                    while (second < third && nums[third] == nums[third+1]){
                        third--;
                    }
                }else{
                    second++;
                    //去除重复值
                    while (second < third && nums[second] == nums[second-1]){
                        second++;
                    }
                }
            }
            if (second == third){
                continue;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        Q16ThreeSumClosest q16ThreeSumClosest = new Q16ThreeSumClosest();
        int sum = q16ThreeSumClosest.threeSumClosest(new int[]{-1,2,1,-4},1);
        System.out.println(sum);
    }
}
