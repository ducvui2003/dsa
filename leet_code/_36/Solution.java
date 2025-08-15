package leet_code._36;
/*
 * https://leetcode.com/problems/valid-sudoku/description/
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                int value = board[i][j];
                if (value < 0 || value > n + 1 || seen[value]) {
                    return false;
                }
                seen[value] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n+1];
            for (int j = 0; j < n; j++) {
                int value = board[j][i];
                if (value < 0 || value > n + 1 || seen[value]) {
                    return false;
                }
                seen[value] = true;
            }
        }

        return true;

    }

    public boolean checkValidByArrBoolean(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n + 1];
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                if (value < 0 || value > n + 1 || seen[value]) {
                    return false;
                }
                seen[value] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            boolean[] seen = new boolean[n+1];
            for (int j = 0; j < n; j++) {
                int value = matrix[j][i];
                if (value < 0 || value > n + 1 || seen[value]) {
                    return false;
                }
                seen[value] = true;
            }
        }

        return true;

    }

    public static void main(String[] args) {
    }
}
