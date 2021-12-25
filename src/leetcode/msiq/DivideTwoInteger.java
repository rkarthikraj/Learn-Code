package leetcode.msiq;

class DivideTwoInteger {
    public static void main(String[] args) {
        DivideTwoInteger obj = new DivideTwoInteger();
        System.out.println(obj.divide(7, -3));
        System.out.println(obj.divide(-2147483648, -1));
        System.out.println(obj.divide(-1, -1));
    }

    public int divide(int dividend, int divisor) {
        int quotient = 0;
        while (dividend - divisor >= 0) {
            quotient++;
            dividend -= divisor;
        }
        return quotient;
    }
}