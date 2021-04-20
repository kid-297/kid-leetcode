package com.kid.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q202IsHappy {

    /**
     * 编写一个算法来判断一个数 n 是不是快乐数。
     *
     * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
     *
     * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
     *
     *  
     *
     * 示例：
     *
     * 输入：19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     */
    List<Integer> temp = new ArrayList<>();
    public boolean isHappy(int n) {
        int sum = 0;
        int cur = 0;
        int num = n;
        while (true){
            //计算int 类型每个值的平方，并相加赋值给sum
            while (num > 0){
                cur = num % 10;
                sum += cur*cur;
                num = num/10;
            }
            num = sum;

            if (num == 1){
                return true;
            }
            if (temp.contains(sum)){
                return false;
            }
            temp.add(sum);
            sum = 0;
        }
    }

    public static void main(String[] args) {
        Q202IsHappy isHappy = new Q202IsHappy();
        final boolean happy = isHappy.isHappy(19);
        System.out.println(happy);
    }
}

/**
 * 使用快慢指针方法，只要两个指针的结果不相等，则一直跑下去，且一定是快乐数
 * 如果指针相等，则表示重复，则进入循环，则不是快乐数
 * 快慢指针，快的一次跳两格，慢的一次跳一格。
 */
class Solution {

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }

    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = getNext(n);
        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));
        }
        return fastRunner == 1;
    }
}
