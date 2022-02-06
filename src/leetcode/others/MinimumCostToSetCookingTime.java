package leetcode.others;

class MinimumCostToSetCookingTime {
    public static void main(String[] args) {
        MinimumCostToSetCookingTime obj = new MinimumCostToSetCookingTime();
        int startAt = 1;
        int moveCost = 2;
        int pushCost = 1;
        int targetSeconds = 600;
        System.out.println(obj.minCostSetTime(startAt, moveCost, pushCost, targetSeconds));
    }

    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < 10000; ++i) {
            int[] timeArr = new int[4];
            int idx = 3;
            int number = i;
            while (number > 0) {
                timeArr[idx] = number % 10;
                number /= 10;
                idx--;
            }

            int minToSec = ((timeArr[0] * 10) + timeArr[1]) * 60;
            int seconds = timeArr[2] * 10 + timeArr[3];


            if (minToSec + seconds == targetSeconds) {
                System.out.println("Time: " + timeArr[0] + "" + timeArr[1] + ":" + timeArr[2] + "" + timeArr[3]);
                minCost = Math.min(minCost, findCost(timeArr, startAt, moveCost, pushCost));
            }
        }

        return minCost;
    }

    public int findCost(int[] timeArr, int startAt, int moveCost, int pushCost) {
        int cost = 0;

        if (timeArr[2] == 0 && timeArr[1] == 0 && timeArr[0] == 0) {
            timeArr = new int[]{timeArr[3]};
        } else if (timeArr[1] == 0 && timeArr[0] == 0) {
            timeArr = new int[]{timeArr[2], timeArr[3]};
        } else if (timeArr[0] == 0) {
            timeArr = new int[]{timeArr[1], timeArr[2], timeArr[3]};
        }

        for (int i = 0; i < timeArr.length; i++) {
            cost += pushCost;
            if (startAt != timeArr[i]) {
                cost += moveCost;
            }
            startAt = timeArr[i];
        }
        return cost;
    }
}