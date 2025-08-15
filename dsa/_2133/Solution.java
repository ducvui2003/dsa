package dsa._2133;

import java.util.*;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/description/
 * */
public class Solution {
    public boolean checkValid(int[][] matrix) {
        int size = matrix.length;
        Map<String, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != size)
                return false;
            Set<Integer> value = Arrays.stream(matrix[i]).boxed().collect(Collectors.toSet());
            if (value.size() != size) {
                return false;
            }
            map.put("r_" + i, value);
            for (int j = 0; j < matrix[i].length; j++) {
                value = map.getOrDefault("c_" + i, new HashSet<>());
                value.add(matrix[i][j]);
                map.put("c_" + i, value);

                if (i == size - 1 && j == size - 1) {
                    if (value.size() != size) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkValidBySumRow(int[][] matrix) {
        int size = matrix.length;
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += i + 1;
        }
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> value = Arrays.stream(matrix[i]).boxed().collect(Collectors.toSet());
            if (value.size() != size) {
                return false;
            }
            int c = Arrays.stream(matrix[i]).sum();
            if (c != sum)
                return false;
        }
        int[][] matrixRev = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrixRev[i][j] = matrix[j][i];
            }
        }
        for (int i = 0; i < matrixRev.length; i++) {
            Set<Integer> value = Arrays.stream(matrix[i]).boxed().collect(Collectors.toSet());
            if (value.size() != size) {
                return false;
            }
            int c = Arrays.stream(matrixRev[i]).sum();
            if (c != sum)
                return false;
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
        int[][] matrix = {
                {1, 1,1},
                {1,2,3},
                {1,2,3}
        };

        Solution solution = new Solution();
        System.out.println(solution.checkValidByArrBoolean(matrix));
    }
}
