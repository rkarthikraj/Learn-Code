package leetcode.msiq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class WordSearchII {
    public static void main(String[] args) {
        WordSearchII obj = new WordSearchII();
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};

        System.out.println(obj.findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> hs = new HashSet<>();

        for (int w = 0; w < words.length; w++) {
            int count = 0;
            boolean[][] visited = new boolean[board.length][board[0].length];

            for (int r = 0; r < board.length; r++) {
                for (int c = 0; c < board[r].length; c++) {
                    if (board[r][c] == words[w].charAt(0) && dfs(board, visited, words[w], r, c, count)) {
                        hs.add(words[w]);
                    }
                }
            }
        }

        List<String> result = new ArrayList<>(hs);
        return result;
    }

    public boolean dfs(char[][] board, boolean[][] visited, String word, int r, int c, int count) {
        if (count == word.length())
            return true;

        if (r < 0 || c < 0 || r >= board.length || c >= board[r].length || visited[r][c] || board[r][c] != word.charAt(count)) {
            return false;
        }

        visited[r][c] = true;

        boolean found = dfs(board, visited, word, r + 1, c, count + 1) || dfs(board, visited, word, r - 1, c, count + 1) || dfs(board, visited, word, r, c + 1, count + 1) || dfs(board, visited, word, r, c - 1, count + 1);

        visited[r][c] = false;

        return found;
    }
}