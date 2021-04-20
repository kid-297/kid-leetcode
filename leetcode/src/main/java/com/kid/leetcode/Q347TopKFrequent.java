package com.kid.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/9/7 11:28
 */
public class Q347TopKFrequent {

    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *  
     *
     * 提示：
     *
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
     * 你可以按任意顺序返回答案
     */

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k){
                if (queue.peek()[1] < count){
                    queue.poll();
                    queue.offer(new int[]{num,count});
                }
            }else {
                queue.offer(new int[]{num,count});
            }
        }

        int[] rs = new int[k];
        for (int i = 0; i < k; i++) {
            rs[i] = queue.poll()[0];
        }
        return rs;
    }

    public static void main(String[] args) {
        Q347TopKFrequent q347TopKFrequent = new Q347TopKFrequent();
        int[] ints = q347TopKFrequent.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(ints.length);
    }
}
