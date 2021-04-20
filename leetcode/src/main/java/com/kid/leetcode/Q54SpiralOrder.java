package com.kid.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/8/24 09:38
 */
public class Q54SpiralOrder {

    /**
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     *
     * 示例 1:
     *
     * 输入:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * 输出: [1,2,3,6,9,8,7,4,5]
     * 示例 2:
     *
     * 输入:
     * [
     *   [1, 2, 3, 4],
     *   [5, 6, 7, 8],
     *   [9,10,11,12]
     * ]
     * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rs = new ArrayList<>();

        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return rs;
        }

        //方向  true-横向；false-纵向；
        boolean direction = true;
        //true-正向遍历; false-逆向遍历;
        boolean identifier = true;
        int identifierCount = 0;

        int x = 0;
        int y = 0;

        int x1 = 0;
        //数组横向长度
        int x2 = matrix.length-1;
        int y1 = 0;
        //数组纵向长度
        int y2 = matrix[0].length-1;
        int changeCount = 0;

        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            rs.add(matrix[x][y]);

            if (direction){
                if (identifier) {
                    y++;
                } else {
                    y--;
                }
                if (y > y2 || y < y1){
                    direction = false;
                    identifierCount++;
                    changeCount++;
                    if (identifier) {
                        x++;
                        y--;
                    } else {
                        x--;
                        y++;
                    }
                }
            }else{
                if (identifier) {
                    x++;
                } else {
                    x--;
                }
                if (x > x2 || x < x1){
                    direction = true;
                    identifierCount++;
                    changeCount++;
                    if (identifier) {
                        y--;
                        x--;
                    } else {
                        y++;
                        x++;
                    }
                }
            }

            //遍历方向变化
            if (identifierCount == 2){
                identifier = !identifier;
                identifierCount = 0;
            }

            if (changeCount % 3 == 0 && changeCount != 0 && (x == x1+1)){
                x1 ++;
                y1 ++;
                x2 --;
                y2 --;
                changeCount--;
            }
        }

        return rs;
    }

    public static void main(String[] args) {
        Q54SpiralOrder q54SpiralOrder = new Q54SpiralOrder();
        int [][] matrix= {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}};

        //[1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,13,14,19]
        //[1,2,3,4,5,10,15,20,25,24,23,22,21,16,11,6,7,8,9,14,19,18,17,12,13]
        int [][] matrix1= {
                {1,2,3},
                {5,6,7},
                {9,10,11}};
        List<Integer> integerList = q54SpiralOrder.spiralOrder(matrix);
        System.out.println(integerList.toString());
    }

}
