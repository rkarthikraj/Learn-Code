package leetcode.easy;

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Armstrong Number.
Memory Usage: 35.7 MB, less than 85.10% of Java online submissions for Armstrong Number.
 */
class Armstrong {
    public static void main(String[] args) {
        Armstrong obj = new Armstrong();
        int num = 153;
        System.out.println(obj.isArmstrong(num));
    }

    public boolean isArmstrong(int n) {
        int nums = n;
        int len = Integer.toString(n).length();
        int sum = 0;

        while (nums > 0) {
            int remainder = nums % 10;
            nums /= 10;
            int calc = (int) Math.pow(remainder, len);
            sum += calc;
        }

        if (sum == n) {
            return true;
        }

        return false;
    }
}