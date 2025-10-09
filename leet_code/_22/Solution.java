package leet_code._22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    int n;
    List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(10));
    }

    public List<String> generateParenthesis(int n) {
        this.n = n;
        Stack<String> st = new Stack<>();
        backtracking(0, 0, st);
        return this.result;
    }

    public void backtracking(int left, int right, Stack<String> st) {
        if (left == n && right == n) {
            this.result.add(String.join("", st));
            return;
        }
        if (left < n) {
            st.add("(");
            backtracking(left + 1, right, st);
            st.pop();
        }
        if (right < left) {
            st.add(")");
            backtracking(left, right + 1, st);
            st.pop();
        }
    }
}
