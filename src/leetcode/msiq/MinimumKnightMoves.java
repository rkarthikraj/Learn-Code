package leetcode.msiq;

class MinimumKnightMoves {
    int[][] DIRS = {{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}};

    public static void main(String[] args) {
        MinimumKnightMoves obj = new MinimumKnightMoves();
        int x = 5, y = 5;
        obj.minKnightMoves(x, y);
    }

    public int minKnightMoves(int destX, int destY) {
        int count = 0;

        int initX = 0;
        int initY = 0;

        for (int[] value : DIRS) {
            int firstX = initX + value[0];
            int firstY = initY + value[1];

            if (firstX > 0 && firstY > 0) {
                System.out.println("FirstX: " + firstX + ", FirstY: " + firstY);
                helper(value[0], value[1], initX, initY, destX, destY);
            }
        }

        return count;
    }

    public void helper(int dirsX, int dirsY, int firstX, int firstY, int x, int y) {
        for (int[] value : DIRS) {
            if (value[0] != dirsX && value[1] != dirsY) {

                firstX += value[0];
                firstY += value[1];

                if (firstX > 0 && firstY > 0 && firstX <= x && firstY <= y) {
                    System.out.println("\tV: " + value[0] + "-" + value[1] + "  M:" + firstX + "-" + firstY);
                }
            }
        }
    }
} 