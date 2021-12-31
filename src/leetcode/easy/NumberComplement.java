package leetcode.easy;

/*
https://leetcode.com/problems/number-complement/
Runtime: 0 ms, faster than 100.00% of Java online submissions for Number Complement.
Memory Usage: 35.5 MB, less than 95.97% of Java online submissions for Number Complement.
 */
class NumberComplement {
    public static void main(String[] args) {
        NumberComplement obj = new NumberComplement();
        int num = 20161211;
        obj.findComplement(num);
    }

    public int findComplement(int num) {
        StringBuilder complementSB = new StringBuilder();
        int result = 0;
        int power = 0;
        while (num > 0) {
            int remainder = num % 2;
            if (remainder == 1) {
                complementSB.append(0);
            } else {
                complementSB.append(1);
                result += 1 * Math.pow(2, power);
            }
            num = num / 2;
            power++;
        }
        System.out.println("Sum: " + result);

        return result;
    }
}