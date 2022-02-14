package leetcode.weekly.contest280;

class CountOperationsToObtainZero {
    public static void main(String[] args) {
        CountOperationsToObtainZero obj = new CountOperationsToObtainZero();
        int num1 = 5;
        int num2 = 4;
        System.out.println(obj.countOperations(num1, num2));
    }

    public int countOperations(int num1, int num2) {
        int count = 0;

        while (num1 > 0 && num2 > 0) {
            if (num1 <= num2) {
                num2 = num2 - num1;
            } else if (num1 > num2) {
                num1 = num1 - num2;
            }
            count++;
        }

        return count;
    }
}