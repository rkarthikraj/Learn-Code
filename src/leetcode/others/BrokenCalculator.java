package leetcode.others;

class BrokenCalculator {
    int count = 0;

    public static void main(String[] args) {
        BrokenCalculator obj = new BrokenCalculator();
        System.out.println("Expected: 2 -- " + obj.brokenCalc(2, 3));
        System.out.println("Expected: 2 -- " + obj.brokenCalc(5, 8));
        System.out.println("Expected: 3 -- " + obj.brokenCalc(3, 10));
    }

    public int brokenCalc(int startValue, int target) {
        int count = 0;

        while(target > startValue) {
            count++;
            if(target % 2 == 0) {
                target /= 2;
            } else {
                target++;
            }
        }

        return count + (startValue - target);
    }

    public int brokenCalcMySol(int startValue, int target) {
        if (target == startValue) {
            return count;
        }

        if (target % 2 == 0 && target > startValue) {
            target /= 2;
            count++;
        } else {
            target += 1;
            count++;
        }

        brokenCalc(startValue, target);

        return count;
    }

}