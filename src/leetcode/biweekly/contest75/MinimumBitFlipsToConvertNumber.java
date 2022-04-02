package leetcode.biweekly.contest75;

class MinimumBitFlipsToConvertNumber {
    public static void main(String[] args) {
        MinimumBitFlipsToConvertNumber obj = new MinimumBitFlipsToConvertNumber();
        System.out.println(obj.minBitFlips(10, 7));
        System.out.println(obj.minBitFlips(3, 4));
    }

    public int minBitFlips(int start, int goal) {
        int minFlips = 0;

        StringBuilder startSB = new StringBuilder();
        StringBuilder goalSB = new StringBuilder();

        while (start > 0) {
            int rem = start % 2;
            startSB.insert(0, rem);
            start /= 2;
        }

        while (goal > 0) {
            int rem = goal % 2;
            goalSB.insert(0, rem);
            goal /= 2;
        }

//        System.out.println("Start: " + startSB);
//        System.out.println("Goal: " + goalSB);

        int startLength = startSB.length();
        int goalLength = goalSB.length();

        if (startLength < goalLength) {
            int msb = goalLength - startLength;
            while (msb > 0) {
                startSB.insert(0, 0);
                msb--;
            }
        } else if (goalLength < startLength) {
            int msb = startLength - goalLength;
            while (msb > 0) {
                goalSB.insert(0, 0);
                msb--;
            }
        }

//        System.out.println("Start: " + startSB);
//        System.out.println("Goal: " + goalSB);

        for (int i = 0; i < startSB.length(); i++) {
            if (startSB.charAt(i) != goalSB.charAt(i)) {
                minFlips++;
            }
        }

        return minFlips;
    }
}