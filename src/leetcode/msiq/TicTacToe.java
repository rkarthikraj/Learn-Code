package leetcode.msiq;

class TicTacToe {
    public static void main(String[] args) {
        TicTacToeOptimizedSolution obj = null;
        // String[] operations = {"TicTacToe", "move", "move", "move", "move", "move", "move", "move"};
        // int[][] values = {{3}, {0, 0, 1}, {0, 2, 2}, {2, 2, 1}, {1, 1, 2}, {2, 0, 1}, {1, 0, 2}, {2, 1, 1}};
        // int[][] values = {{3}, {0, 0, 1}, {0, 2, 2}, {2, 2, 1}, {1, 1, 2}, {1, 2, 1}, {2, 0, 2}, {0, 1, 1}};

        // String[] operations = {"TicTacToe", "move", "move", "move"};
        // int[][] values = {{2}, {0, 0, 2}, {1, 1, 1}, {0, 1, 2}};

        String[] operations = {"TicTacToe", "move", "move", "move"};
        int[][] values = {{2}, {0, 1, 2}, {1, 0, 1}, {1, 1, 2}};

        for (int i = 0; i < values.length; i++) {
            String operation = operations[i];

            switch (operation) {
                case "TicTacToe":
                    obj = new TicTacToeOptimizedSolution(values[i][0]);
                    break;
                case "move":
                    System.out.println("Result: " + obj.move(values[i][0], values[i][1], values[i][2]));
                    // obj.move(values[i][0], values[i][1], values[i][2]);
                    break;
            }
        }

        System.out.println();
        // obj.printGrid();
    }
}

class TicTacToeOptimizedSolution {
    int[] rows;
    int[] cols;
    int diagonalLR;
    int diagonalRL;
    int n;

    public TicTacToeOptimizedSolution(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        int currentPlayer = player == 1 ? 1 : -1;

        rows[row] += currentPlayer;
        cols[col] += currentPlayer;

        if (row == col) {
            diagonalLR += currentPlayer;
        }

        if (col == (n - row - 1)) {
            diagonalRL += currentPlayer;
        }

        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonalLR) == n || Math.abs(diagonalRL) == n) {
            return player;
        }

        return 0;
    }
}

class TicTacToeNaiveSolution {
    int n;
    int[][] grid;

    public TicTacToeNaiveSolution(int n) {
        this.n = n;
        grid = new int[n][n];
    }

    public int move(int row, int col, int player) {
        grid[row][col] = player;
        int winner = checkWinner(grid);
        if (winner != 0) {
            return winner;
        } else {
            return 0;
        }
    }

    public int checkWinner(int[][] grid) {
        boolean player1DiagonalResult = diagonalLeftToRight(grid, 1);
        if (player1DiagonalResult) {
            return 1;
        }

        boolean player2DiagonalResult = diagonalLeftToRight(grid, 2);
        if (player2DiagonalResult) {
            return 2;
        }

        boolean player1DiagonalRightToLeftResult = diagonalRightToLeft(grid, 1);
        if (player1DiagonalRightToLeftResult) {
            return 1;
        }

        boolean player2DiagonalRightToLeftResult = diagonalRightToLeft(grid, 2);
        if (player2DiagonalRightToLeftResult) {
            return 2;
        }

        boolean player1RowResult = row(grid, 1);
        if (player1RowResult) {
            return 1;
        }

        boolean player2RowResult = row(grid, 2);
        if (player2RowResult) {
            return 2;
        }

        boolean player1ColumnResult = column(grid, 1);
        if (player1ColumnResult) {
            return 1;
        }

        boolean player2ColumnResult = column(grid, 2);
        if (player2ColumnResult) {
            return 2;
        }

        return 0;
    }

    public boolean diagonalLeftToRight(int[][] grid, int player) {
        boolean isPlayerDiagonal = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isPlayerDiagonal) {
                    if (i == j) {
                        if (grid[i][j] != player) {
                            isPlayerDiagonal = false;
                            break;
                        }
                    }
                }
            }
        }

        if (isPlayerDiagonal) {
            return true;
        } else {
            return false;
        }
    }

    public boolean diagonalRightToLeft(int[][] grid, int player) {
        boolean isPlayerDiagonal = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isPlayerDiagonal) {
                    if (j == (n - i - 1)) {
                        // System.out.println(i + " - " + j + " -- " + grid[i][j]);
                        if (grid[i][j] != player) {
                            isPlayerDiagonal = false;
                            break;
                        }
                    }
                }
            }
        }

        if (isPlayerDiagonal) {
            return true;
        } else {
            return false;
        }
    }

    public boolean row(int[][] grid, int player) {
        boolean isPlayerRowWin = true;
        for (int i = 0; i < n; i++) {
            isPlayerRowWin = true;
            for (int j = 0; j < n; j++) {
                if (isPlayerRowWin) {
                    if (grid[i][j] != player) {
                        isPlayerRowWin = false;
                        break;
                    }
                }
            }

            if (isPlayerRowWin) {
                return true;
            }
        }

        if (isPlayerRowWin) {
            return true;
        } else {
            return false;
        }
    }

    public boolean column(int[][] grid, int player) {
        boolean isPlayerColumnWin = true;
        for (int i = 0; i < n; i++) {
            isPlayerColumnWin = true;
            for (int j = 0; j < n; j++) {
                if (isPlayerColumnWin) {
                    if (grid[j][i] != player) {
                        isPlayerColumnWin = false;
                        break;
                    }
                }
            }

            if (isPlayerColumnWin) {
                return true;
            }
        }

        if (isPlayerColumnWin) {
            return true;
        } else {
            return false;
        }
    }

    public void printGrid() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
    }
}