package com.kid.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/8/25 09:34
 */
public class Q73SetZeroes {

    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
     *
     * 示例 1:
     *
     * 输入:
     * [
     *   [1,1,1],
     *   [1,0,1],
     *   [1,1,1]
     * ]
     * 输出:
     * [
     *   [1,0,1],
     *   [0,0,0],
     *   [1,0,1]
     * ]
     * 示例 2:
     *
     * 输入:
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     * 输出:
     * [
     *   [0,0,0,0],
     *   [0,4,5,0],
     *   [0,3,1,0]
     * ]
     * 进阶:
     *
     * 一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
     * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
     * 你能想出一个常数空间的解决方案吗？
     *  原地算法：输入的被输出的覆盖掉
     */
    public void setZeroes(int[][] matrix) {

        if (matrix.length == 0 || matrix[0].length == 0){
            return;
        }

        int x = matrix.length;
        int y = matrix[0].length;

        //记录 x 和 y ,然后输出的时候全部替换
        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();

        for (int i = 0; i < x ; i++) {
            for (int j = 0; j < y; j++) {
                if (matrix[i][j] == 0){
                    xSet.add(i);
                    ySet.add(j);
                }
            }
        }

        Iterator<Integer> xIterator = xSet.iterator();
        while (xIterator.hasNext()){
            Integer next = xIterator.next();
            int column = 0;
            while (column < y){
                matrix[next][column] = 0;
                column++;
            }
        }

        Iterator<Integer> yIterator = ySet.iterator();
        while (yIterator.hasNext()){
            int row = 0;
            Integer next = yIterator.next();
            while (row < x){
                matrix[row][next] = 0;
                row++;
            }
        }
        System.out.println(matrix);
    }

    public static void main(String[] args) {
        Q73SetZeroes q73SetZeroes = new Q73SetZeroes();
        int [][] matrix1= {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        q73SetZeroes.setZeroes(matrix1);
    }

}
