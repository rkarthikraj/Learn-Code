package leetcode.biweekly.contest70;

import java.util.Arrays;

class FindThreeConsecutiveIntegersThatSumToAGivenNumber {
    public static void main(String[] args) {
        FindThreeConsecutiveIntegersThatSumToAGivenNumber obj = new FindThreeConsecutiveIntegersThatSumToAGivenNumber();
        long num1 = 33;
        long num2 = 4;
        long num3 = 223993367;
        long num4 = 11;
        System.out.println(Arrays.toString(obj.sumOfThree(num1)));
        System.out.println(Arrays.toString(obj.sumOfThree(num2)));
        System.out.println(Arrays.toString(obj.sumOfThree(num3)));
        System.out.println(Arrays.toString(obj.sumOfThree(num4)));
    }

    public long[] sumOfThree(long num) {
        long[] result = new long[3];
        if ((num % 3) == 0) {
            long x = num / 3;
            long v1 = x - 1;
            long v2 = x;
            long v3 = x + 1;
            long sum = v1 + v2 + v3;

            if (sum == num) {
                result[0] = v1;
                result[1] = v2;
                result[2] = v3;
                return result;
            }
        }

        return new long[]{};
    }

    public long[] sumOfThree1(long num) {
        long[] result = new long[3];
        long mid = num / 2;

        for (long i = 1; i <= mid; i++) {
            int windowsSize = 3;
            long sum = 0;
            while (windowsSize > 0) {
                sum += i;
                windowsSize--;
            }
            if (sum == num) {
                result[0] = i - 1;
                result[1] = i;
                result[2] = i + 1;
                return result;
            }
        }

        return new long[]{};
    }
}