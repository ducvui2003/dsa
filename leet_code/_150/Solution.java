package leet_code._150;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/

public class Solution {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack();
        for (String token : tokens) {
            if (token.equals("+")) {
                int n2 = st.pop();
                int n1 = st.pop();
                st.push(n1 + n2);
            } else if (token.equals("-")) {
                int n2 = st.pop();
                int n1 = st.pop();
                st.push(n1 - n2);
            } else if (token.equals("*")) {
                int n2 = st.pop();
                int n1 = st.pop();
                st.push(n1 * n2);
            } else if (token.equals("/")) {
                int n2 = st.pop();
                int n1 = st.pop();
                st.push(n1 / n2);
            } else
                st.push(Integer.valueOf(token));

        }
        return st.pop();
    }

    public static void main(String[] args) {
        String[] s = new String[]{
                "2", "1", "+", "3", "*"
        };
        System.out.println(evalRPN(s));
    }
}