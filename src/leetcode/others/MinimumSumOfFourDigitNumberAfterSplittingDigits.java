package leetcode.others;

import java.util.Arrays;

class MinimumSumOfFourDigitNumberAfterSplittingDigits {
    public static void main(String[] args) {
        MinimumSumOfFourDigitNumberAfterSplittingDigits obj = new MinimumSumOfFourDigitNumberAfterSplittingDigits();
        int num = 2932;
        System.out.println(obj.minimumSum(num));
    }

    public int minimumSum(int num) {
        int[] numArr = new int[4];
        int i = 0;
        while (num > 0) {
            numArr[i] = num % 10;
            num /= 10;
            i++;
        }

        Arrays.sort(numArr);
        System.out.println(Arrays.toString(numArr));

        int num1 = ((numArr[0] * 10) + numArr[2]);
        int num2 = ((numArr[1] * 10) + numArr[3]);

        return num1 + num2;
    }
}