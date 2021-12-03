package leetcode.msiq;

import java.util.ArrayList;
import java.util.List;

public class WinnerTicTacToe {
    public static void main(String[] args) {
        WinnerTicTacToe obj = new WinnerTicTacToe();
        //int[][] moves = {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}};
        //int[][] moves = {{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}};
        int[][] moves = {{0, 0}, {1, 1}};
        System.out.println(obj.tictactoe(moves));
    }

    public String tictactoe(int[][] moves) {
        List<String> playerA = new ArrayList<String>();
        List<String> playerB = new ArrayList<String>();

        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                playerA.add(moves[i][0] + "," + moves[i][1]);
                if (checkResult(playerA)) {
                    return "A";
                }
            } else {
                playerB.add(moves[i][0] + "," + moves[i][1]);
                if (checkResult(playerB)) {
                    return "B";
                }
            }
        }

        if (!checkResult(playerA) && !checkResult(playerB) && (playerA.size() + playerB.size() == 9)) {
            return "Draw";
        }


        return "Pending";


        //        System.out.println(playerA);
        //        System.out.println(playerB);
    }

    public Boolean checkResult(List<String> moves) {
        // {0,0}, {0,1}, {0,2}
        // {1,0}, {1,1}, {1,2}
        // {2,0}, {2,1}, {2,2}

        // {0,0}, {1,1}, {2,2}
        // {0,2}, {1,1}, {2,0}

        // {0,0}, {1,0}, {2,0}
        // {0,1}, {1,1}, {2,1}
        // {0,2}, {1,2}, {2,2}

        if (moves.contains("0,0") && moves.contains("0,1") && moves.contains("0,2")) {
            return true;
        }
        if (moves.contains("1,0") && moves.contains("1,1") && moves.contains("1,2")) {
            return true;
        }
        if (moves.contains("2,0") && moves.contains("2,1") && moves.contains("2,2")) {
            return true;
        }

        if (moves.contains("0,0") && moves.contains("1,1") && moves.contains("2,2")) {
            return true;
        }
        if (moves.contains("0,2") && moves.contains("1,1") && moves.contains("2,0")) {
            return true;
        }

        if (moves.contains("0,0") && moves.contains("1,0") && moves.contains("2,0")) {
            return true;
        }
        if (moves.contains("0,1") && moves.contains("1,1") && moves.contains("2,1")) {
            return true;
        }
        if (moves.contains("0,2") && moves.contains("1,2") && moves.contains("2,2")) {
            return true;
        }
        return false;
    }
}
