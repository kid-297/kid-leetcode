package com.kid.leetcode;

/**
 * @version V1.0
 * @Description:
 * @Auther: ly
 * @Date: 2020/8/21 17:08
 */
public class Q43Multiply {

    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     *
     * 示例 1:
     *
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     *
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 说明：
     *
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理
     */
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        //计算每一位相乘的结果，记录list
        String temp = "0";
        for (int i = num1.length()-1; i >= 0 ; i--) {
            StringBuilder oneSum = new StringBuilder();
            //进位
            int carry = 0;
            //错位补0
            for (int j = num1.length()-1; j > i; j--) {
                oneSum.append(0);
            }
            int num1Char = (num1.charAt(i)-48);
            //每位相乘
            for (int j = num2.length()-1; j >= 0; j--) {

                int num2Char = (num2.charAt(j)-48);
                int one = num1Char * num2Char + carry;
                oneSum.append(one % 10);
                carry = one / 10;
            }
            if (carry != 0) {
                oneSum.append(carry % 10);
            }
            //两数相加
            temp = addSum(oneSum.reverse().toString(),temp);
        }
        return temp;
    }

    /**
     * 两数相加
     * @param num1
     * @param num2
     * @return
     */
    public String addSum (String num1,String num2){
        int carry = 0;
        //结果相加
        int n1 = num1.length()-1;
        int n2 = num2.length()-1;
        StringBuilder temp = new StringBuilder();
        while (n1 >= 0 || n2 >= 0 || carry != 0){
            int a1 = n1 >= 0 ? (num1.charAt(n1)-48):0;
            int a2 = n2 >= 0 ? (num2.charAt(n2)-48):0;
            int sum = a1 + a2 + carry;
            temp.append(sum % 10 );
            carry = sum/10;
            n1--;
            n2--;
        }
        temp.reverse();
        return temp.toString();
    }

    public static void main(String[] args) {
        String num1 = "123456789";
        String num2 = "987654321";
        Q43Multiply q43Multiply = new Q43Multiply();
        String multiply = q43Multiply.multiply(num1, num2);
        System.out.println(multiply);
    }


}
