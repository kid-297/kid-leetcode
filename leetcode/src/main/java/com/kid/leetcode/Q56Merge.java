package com.kid.leetcode;

import java.util.Arrays;

public class Q56Merge {

    /**
     * 给出一个区间的集合，请合并所有重叠的区间。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2:
     *
     * 输入: intervals = [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
     *
     *  
     *
     * 提示：
     *
     * intervals[i][0] <= intervals[i][1]
     */

    public int[][] merge(int[][] intervals) {
        if (intervals == null){
            return null;
        }

        //1.先给数组第一层排序
        Arrays.sort(intervals,(v1,v2) -> v1[0] - v2[0]);
        //2.指定一个记录输出的对象
        int rs[][] = new int[intervals.length][2];
        //3.指定输出对象的数组下标
        int index = -1;
        for (int i = 0; i < intervals.length; i++) {
            //如果当前循环的左区间大于当前结果集中右区间，则整段存放到输出对象中。
            if (index == -1 || intervals[i][0] > rs[index][1]){
                rs[++index] = intervals[i];
            }else{
                rs[index][1] = Math.max(rs[index][1],intervals[i][1]);
            }
        }

        return Arrays.copyOf(rs, index + 1);
    }

    public static void main(String[] args) {
        Q56Merge q56Merge = new Q56Merge();
        final int[][] merge = q56Merge.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println(merge);
    }
}