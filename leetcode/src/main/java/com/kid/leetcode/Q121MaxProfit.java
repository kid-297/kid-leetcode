package com.kid.leetcode;

public class Q121MaxProfit {

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意：你不能在买入股票前卖出股票。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2:
     *
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */

    /**
     * 因此，我们只需要遍历价格数组一遍，记录历史最低点，然后在每一天考虑这么一个问题：如果我是在历史最低点买进的，
     * 那么我今天卖出能赚多少钱？当考虑完所有天数之时，我们就得到了最好的答案。
     * @param prices
     * @return
     */

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }

        int min = Integer.MAX_VALUE;

        int maxPrice = 0;

        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i],min);
            maxPrice = Math.max(prices[i]-min,maxPrice);
        }
        return maxPrice;
    }

    public static void main(String[] args) {
        Q121MaxProfit q121MaxProfit = new Q121MaxProfit();
        //final int i = q121MaxProfit.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        //final int i = q121MaxProfit.maxProfit(new int[]{7,6,4,3,1});
        //final int i = q121MaxProfit.maxProfit(new int[]{2,4,1});
        //final int i = q121MaxProfit.maxProfit(new int[]{2,1,4});
        //final int i = q121MaxProfit.maxProfit(new int[]{2,1});
        //final int i = q121MaxProfit.maxProfit(new int[]{1,2});
        final int i = q121MaxProfit.maxProfit(new int[]{2,1,2,0,1});
        //final int i = q121MaxProfit.maxProfit(new int[]{3,2,6,5,0,3});
        System.out.println(i);
    }
}
