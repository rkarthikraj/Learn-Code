package leetcode.ds1;

class LargestIsland {
    int COUNT = 0;

    public int maxAreaOfIsland(int[][] grid) {
        int sizeOfIsland = 0;

        int rowLength = grid.length;
        int columnLength = grid[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (grid[i][j] == 1) {
                    sizeOfIsland = Math.max(sizeOfIsland, findIslandDfs(grid, i, j));
                    COUNT = 0;
                }
            }
        }

        return sizeOfIsland;
    }

    public int findIslandDfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        COUNT++;

        findIslandDfs(grid, i - 1, j);
        findIslandDfs(grid, i + 1, j);
        findIslandDfs(grid, i, j - 1);
        findIslandDfs(grid, i, j + 1);

        return COUNT;
    }

    public static void main(String[] args) {
        LargestIsland obj = new LargestIsland();
        int[][] island = {{0, 0, 0, 0, 0, 0, 0, 0}};
        System.out.println(obj.maxAreaOfIsland(island));
    }
}