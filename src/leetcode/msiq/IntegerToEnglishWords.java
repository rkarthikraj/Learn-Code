package leetcode.msiq;

import java.util.HashMap;
import java.util.Map;

/*
Not Working.
 */
class IntegerToEnglishWords {
    public static void main(String[] args) {
        IntegerToEnglishWords obj = new IntegerToEnglishWords();
        int num1 = 1;
        int num2 = 10;
        int num3 = 30;
        int num4 = 11;
        int num5 = 1234567;
        int num6 = 1234567891;
        int num7 = 100;
        int num8 = 110;
        int num9 = 131;
        int num10 = 120;
        int num11 = 0;
        int num12 = 111;

//        System.out.println(obj.numberToWords(num1));
//        System.out.println(obj.numberToWords(num2));
//        System.out.println(obj.numberToWords(num3));
//        System.out.println(obj.numberToWords(num4));
//        System.out.println(obj.numberToWords(num5));
//        System.out.println(obj.numberToWords(num6));
//        System.out.println(obj.numberToWords(num7));
//        System.out.println(obj.numberToWords(num8));
//        System.out.println(obj.numberToWords(num9));
//        System.out.println(obj.numberToWords(num10));
//        System.out.println(obj.numberToWords(num11));
        System.out.println(obj.numberToWords(num12));
    }

    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();

        Map<Integer, String> hmOnes = new HashMap<>();
        hmOnes.put(0, "Zero");
        hmOnes.put(1, "One");
        hmOnes.put(2, "Two");
        hmOnes.put(3, "Three");
        hmOnes.put(4, "Four");
        hmOnes.put(5, "Five");
        hmOnes.put(6, "Six");
        hmOnes.put(7, "Seven");
        hmOnes.put(8, "Eight");
        hmOnes.put(9, "Nine");

        Map<Integer, String> hmTens = new HashMap<>();
        hmTens.put(1, "Ten");
        hmTens.put(2, "Twenty");
        hmTens.put(3, "Thirty");
        hmTens.put(4, "Forty");
        hmTens.put(5, "Fifty");
        hmTens.put(6, "Sixty");
        hmTens.put(7, "Seventy");
        hmTens.put(8, "Eighty");
        hmTens.put(9, "Ninety");

        Map<Integer, String> hmTeen = new HashMap<>();
        hmTeen.put(10, "Ten");
        hmTeen.put(11, "Eleven");
        hmTeen.put(12, "Twelve");
        hmTeen.put(13, "Thirteen");
        hmTeen.put(14, "Fourteen");
        hmTeen.put(15, "Fifteen");
        hmTeen.put(16, "Sixteen");
        hmTeen.put(17, "Seventeen");
        hmTeen.put(18, "Eighteen");
        hmTeen.put(19, "Nineteen");
        hmTeen.put(20, "Twenty");

        Map<Integer, String> hmBig = new HashMap<>();
        hmBig.put(0, "");
        hmBig.put(1, "Thousand");
        hmBig.put(2, "Million");
        hmBig.put(3, "Billion");
        hmBig.put(4, "Trillion");

        if (num < 10) {
            return hmOnes.get(num);
        }

        int big = 0;
        while (num > 0) {
            if (num >= 10 && num <= 20) {
                sb.insert(0, hmBig.get(big) + " ");
                sb.insert(0, hmTeen.get(num) + " ");
                num /= 1000;
                big++;
                continue;
            }

            int splitByHundred = num % 1000;
            num /= 1000;
            sb.insert(0, hmBig.get(big) + " ");

            int i = 0;
            while (splitByHundred > 0) {
                int rem = splitByHundred % 10;
                splitByHundred /= 10;

                if (i == 0) {
                    if (rem > 0) {
                        sb.insert(0, hmOnes.get(rem) + " ");
                    }
                } else if (i == 1) {
                    if (rem >= 1) {
                        sb.insert(0, hmTens.get(rem) + " ");
                    } else {
                        if (rem != 0) {
                            sb.insert(0, hmOnes.get(rem) + " ");
                        }
                    }
                } else {
                    sb.insert(0, "Hundred ");
                    sb.insert(0, hmOnes.get(rem) + " ");
                }

                i++;
            }


            big++;
        }
        return sb.toString().trim();
    }
}
