package leetcode.others;

class MinimumMovesToReachTargetScore {
    public static void main(String[] args) {
        MinimumMovesToReachTargetScore obj = new MinimumMovesToReachTargetScore();
        System.out.println(obj.minMoves(5, 0));
        System.out.println(obj.minMoves(19, 2));
        System.out.println(obj.minMoves(10, 4));
    }

    public int minMoves(int target, int maxDoubles) {
        if (target == 0)
            return 0;
        int count = 0;
        while (target != 1) {
            if (maxDoubles == 0) {
                return count + target - 1;
            }

            if (target % 2 == 0) {
                target = target / 2;
                count++;
                maxDoubles--;
            } else {
                target--;
                count++;
            }
        }
        return count;
    }
}