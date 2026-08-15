package leet_code._20;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/description/
public class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0)
            return false;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        List<Character> newArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            if (c == ')' || c == '}' || c == ']') {
                if (stack.size() == 0) return false;
                char d = stack.pop();
                if (d == '(' && c == ')' ||
                        d == '{' && c == '}' ||
                        d == '[' && c == ']')
                    continue;
                else
                    return false;
            }
        }
        return stack.size() == 0;
    }
}
