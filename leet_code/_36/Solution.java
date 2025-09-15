package leet_code._36;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/valid-sudoku/description/
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] columns = new HashSet[9];
        HashSet<Character>[] squares = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                int box = (i / 3) * 3 + (j / 3);
                char value = board[i][j];
                if (!rows[i].contains(value) &&
                        !columns[j].contains(value) &&
                        !squares[box].contains(value)) {
                    rows[i].add(value);
                    columns[j].add(value);
                    squares[box].add(value);
                } else
                    return false;
            }
        }
        return true;
    }

    public boolean isValidSudokuWithBoolean(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] columns = new boolean[9][9];
        boolean[][] squares = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                int box = (i / 3) * 3 + (j / 3);
                int value = board[i][j] - '1';
                if (rows[i][value] || columns[j][value] || squares[box][value]) return false;
                rows[i][value] = true;
                columns[j][value] = true;
                squares[box][value] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    }
}
