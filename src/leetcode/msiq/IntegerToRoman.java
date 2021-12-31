package leetcode.msiq;

/*
https://leetcode.com/problems/integer-to-roman/
Runtime: 4 ms, faster than 79.04% of Java online submissions for Integer to Roman.
Memory Usage: 38.4 MB, less than 84.49% of Java online submissions for Integer to Roman.
 */
public class IntegerToRoman {
    private Numerals[] numerals = {new Numerals("M", 1000), new Numerals("CM", 900), new Numerals("D", 500), new Numerals("CD", 400), new Numerals("C", 100), new Numerals("XC", 90), new Numerals("L", 50), new Numerals("XL", 40), new Numerals("X", 10), new Numerals("IX", 9), new Numerals("V", 5), new Numerals("IV", 4), new Numerals("I", 1)};

    public static void main(String[] args) {
        IntegerToRoman obj = new IntegerToRoman();
        int num = 3;
        obj.intToRoman(num);
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        String result = "";

        for (Numerals numeral : numerals) {
            int answer = num / numeral.value;
            if (answer != 0) {
                // System.out.println(numeral.symbol + "\t" + numeral.value + "\tNum: " + num + "\tRem: " + answer);
                while (answer > 0) {
                    sb.append(numeral.symbol);
                    answer--;
                }
                num %= numeral.value;
            }
        }
        result = sb.toString();
        System.out.println("result: " + result);

        return result;
    }

    class Numerals {
        public String symbol;
        public int value;

        Numerals(String symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }
    }
}
