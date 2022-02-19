package leetcode.others;

public class ReverseDigit {
    public static void main(String[] args) {
        ReverseDigit obj = new ReverseDigit();
        int n = -123;
        System.out.println(obj.reverse(n));
    }

    public int reverse(int x) {
        int result = 0;
        int absValue = Math.abs(x);
        while (absValue != 0) {
            result *= 10;
            int remainder = absValue % 10;
            absValue /= 10;
            result += remainder;
        }
        return x < 0 ? result * -1 : result;
    }
}
