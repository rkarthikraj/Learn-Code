package alogs.backtracking;

import java.util.Arrays;

public class SudokuSolver {
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

        System.out.println(Arrays.deepToString(board));
    }

    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    public boolean helper(char[][] board, int row, int col) {
        if (row == board.length) {
            return true;
        }

        int newRow = 0;
        int newColumn = 0;

        if (col == board.length - 1) {
            newRow = row + 1;
            newColumn = 0;
        } else {
            newRow = row;
            newColumn = col + 1;
        }

        if (board[row][col] != '.') {
            if (helper(board, newRow, newColumn)) {
                return true;
            }
        } else {
            for (int i = 1; i <= 9; i++) {
                if (isValidPlacement(board, row, col, i)) {
                    board[row][col] = (char) (i + '0');
                    if (helper(board, newRow, newColumn)) {
                        return true;
                    } else {
                        board[row][col] = '.';
                    }
                }
            }
        }

        return false;
    }

    public boolean isValidPlacement(char[][] board, int row, int col, int number) {
        // Row
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == (char) (number + '0')) {
                return false;
            }
        }

        // Column
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == (char) (number + '0')) {
                return false;
            }
        }

        // Grid
        int sr = 3 * (row / 3);
        int sc = 3 * (col / 3);

        for (int r = sr; r < sr + 3; r++) {
            for (int c = sc; c < sc + 3; c++) {
                if (board[r][c] == (char) (number + '0')) {
                    return false;
                }
            }
        }

        return true;
    }
}
