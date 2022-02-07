package leetcode.others;

import java.util.Arrays;

class SmallestValueOfTheRearrangedNumber {
    public static void main(String[] args) {
        SmallestValueOfTheRearrangedNumber obj = new SmallestValueOfTheRearrangedNumber();
        //long num = -7605;
        long num = 63;
        System.out.println(obj.smallestNumber(num));
    }

    public long smallestNumber(long num) {
        long result = 0;
        if (num == 0)
            return result;

        boolean isNegative = false;
        if (num < 0) {
            isNegative = true;
        }

        long absNum = Math.abs(num);
        //System.out.println("Math.abs(num): " + absNum);
        String numStr = Long.toString(absNum);
        long[] numArr = new long[numStr.length()];
        int index = 0;
        while (absNum > 0) {
            numArr[index] = absNum % 10;
            absNum /= 10;
            index++;
        }

        if (!isNegative) {
            Arrays.sort(numArr);
            // System.out.println("SortedArr: " + Arrays.toString(numArr));

            int nonZeroValuePosition = 0;
            if (numArr[0] == 0) {
                for (int i = 0; i < numArr.length; i++) {
                    if (numArr[i] != 0) {
                        nonZeroValuePosition = i;
                        break;
                    }
                }

                numArr[0] = numArr[nonZeroValuePosition];
                numArr[nonZeroValuePosition] = 0;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numArr.length; i++) {
                sb.append(numArr[i]);
            }

            result = Long.parseLong(sb.toString());
        } else {
            Arrays.sort(numArr);
            //System.out.println("SortedArr: " + Arrays.toString(numArr));

            StringBuilder sb = new StringBuilder();
            for (int i = numArr.length - 1; i >= 0; i--) {
                sb.append(numArr[i]);
            }
            //System.out.println(sb.toString());
            result = Long.parseLong(sb.toString()) * -1;
        }

        return result;
    }
}