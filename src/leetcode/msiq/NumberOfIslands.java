package leetcode.msiq;

class NumberOfIslands {
    int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // Left, Right, Top, Down

    public static void main(String[] args) {
        NumberOfIslands obj = new NumberOfIslands();

        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] grid1 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

        System.out.println(obj.numIslands(grid1));
    }

    public int numIslands(char[][] grid) {
        int numberOfIsland = 0;

        int rowLength = grid.length;
        int columnLength = grid[0].length;

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                if (grid[i][j] == '1') {
                    numberOfIsland += findIslandDfs(grid, i, j);
                }
            }
        }

        return numberOfIsland;
    }

    public int findIslandDfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return 0;
        }
        grid[i][j] = '0';
        findIslandDfs(grid, i - 1, j);
        findIslandDfs(grid, i + 1, j);
        findIslandDfs(grid, i, j - 1);
        findIslandDfs(grid, i, j + 1);
        return 1;
    }
}