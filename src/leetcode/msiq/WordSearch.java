package leetcode.msiq;

import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/word-search/
Runtime: 95 ms, faster than 73.99% of Java online submissions for Word Search.
Memory Usage: 37.5 MB, less than 42.53% of Java online submissions for Word Search.
Solved after watching youtube video.
https://www.youtube.com/watch?v=vYYNp0Jrdv0 */
class WordSearch {
    List<Character> temp = new LinkedList<>();

    public static void main(String[] args) {
        WordSearch obj = new WordSearch();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        System.out.println(obj.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int count, String word) {
        if (count == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(count)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' ';
        boolean found = dfs(board, i, j - 1, count + 1, word) || dfs(board, i, j + 1, count + 1, word) || dfs(board, i - 1, j, count + 1, word) || dfs(board, i + 1, j, count + 1, word);
        board[i][j] = temp;

        return found;
    }
}