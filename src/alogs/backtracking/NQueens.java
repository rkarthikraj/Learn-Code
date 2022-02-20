package alogs.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        NQueens obj = new NQueens();
        System.out.println(obj.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(board, result, 0);
        return result;
    }

    public void helper(char[][] board, List<List<String>> result, int col) {
        if (col == board.length) {
            saveBoard(board, result);
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isValidPlacement(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, result, col + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean isValidPlacement(int row, int col, char[][] board) {
        // Horizontal
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // Vertical
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Upper Left
        int r1 = row;
        int c1 = col;
        while (r1 >= 0 && c1 >= 0) {
            if (board[r1][c1] == 'Q') {
                return false;
            }
            r1--;
            c1--;
        }

        // Upper Right
        int r2 = row;
        int c2 = col;
        while (r2 >= 0 && c2 < board[r2].length) {
            if (board[r2][c2] == 'Q') {
                return false;
            }
            r2--;
            c2++;
        }

        // Lower Left
        int r3 = row;
        int c3 = col;
        while (c3 >= 0 && r3 < board.length) {
            if (board[r3][c3] == 'Q') {
                return false;
            }
            r3++;
            c3--;
        }

        // Lower Right
        int r4 = row;
        int c4 = col;
        while (r4 < board.length && c4 < board[r4].length) {
            if (board[r4][c4] == 'Q') {
                return false;
            }
            r4++;
            c4++;
        }

        return true;
    }

    private void saveBoard(char[][] board, List<List<String>> result) {
        String row = "";
        List<String> newBoard = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            row = "";
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == 'Q') {
                    row += 'Q';
                } else {
                    row += '.';
                }
            }
            newBoard.add(row);
        }

        result.add(newBoard);
    }
}
