package com.kid.leetcode;

import java.util.Arrays;

public class Q945MinIncrementForUnique {

    /**
     * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
     *
     * 返回使 A 中的每个值都是唯一的最少操作次数。
     *
     * 示例 1:
     *
     * 输入：[1,2,2]
     * 输出：1
     * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
     * 示例 2:
     *
     * 输入：[3,2,1,2,1,7]
     * 输出：6
     * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
     * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
     * 提示：
     *
     * 0 <= A.length <= 40000
     * 0 <= A[i] < 40000
     *
     */

    public int minIncrementForUnique(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        Arrays.sort(A);
        int change = 0;

        int temp = A[0];
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (temp == A[i]){
                count ++;
            }else{
                temp++;
                if (count != 0){
                    change = change + count - 1;
                    count--;
                }
                i--;
            }
        }
        if (count != 0){
            while (count != 0){
                count --;
                change += count;
            }
        }
        return change;
    }

    public static void main(String[] args) {
        int[] A = {2,2,2,2,1};
        Q945MinIncrementForUnique q945MinIncrementForUnique = new Q945MinIncrementForUnique();
        final int i = q945MinIncrementForUnique.minIncrementForUnique(A);
        System.out.println(i);
    }
}
