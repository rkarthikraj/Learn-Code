package alogs.backtracking;

public class SudokuSolver1 {
    public static void main(String[] args) {
        SudokuSolver obj = new SudokuSolver();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        obj.solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    public boolean helper(char[][] board, int row, int col) {
        if (col == 9) {
            row += 1;
            col = 0;
        }

        if (row == 9) {
            return true;
        }

        if (board[row][col] != '.') {
            return helper(board, row, col + 1);
        }

        for (char i = '1'; i <= '9'; i++) {
            if (isValidPlacement(board, row, col, i)) {
                board[row][col] = i;
                if (helper(board, row, col + 1)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }

        return false;
    }

    public boolean isValidPlacement(char[][] board, int row, int col, char number) {
        // Row
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == number) {
                return false;
            }
        }

        // Column
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == number) {
                return false;
            }
        }

        // Grid
        int sr = 3 * (row / 3);
        int sc = 3 * (col / 3);

        for (int r = sr; r < sr + 3; r++) {
            for (int c = sc; c < sc + 3; c++) {
                if (board[r][c] == number) {
                    return false;
                }
            }
        }

        return true;
    }
}
