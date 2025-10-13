package leet_code._739;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/daily-temperatures/description/
public class Solution {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] result = new int[temperatures.length];
        st.push(0);
        for (int i = 1; i < result.length; i++) {
            int top = st.peek();
            if (temperatures[i] > temperatures[top]) {
                while (!st.isEmpty()) {
                    int j = st.pop();
                    if (temperatures[j] >= temperatures[i]) {
                        st.push(j);
                        break;
                    }
                    result[j] = i - j;
                }
            }
            st.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] in = new int[]{34,80,80,34,34,80,80,80,80,34};
        System.out.println(Arrays.toString(dailyTemperatures(in)));
    }
}
