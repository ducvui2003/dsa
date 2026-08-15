package dsa.string;

/**
 * https://leetcode.com/problems/longest-common-prefix/description
 */

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class LongestCommonPrefix {
    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String result = "";
        String first = strs[0];
        if (first.length() == 0) {
            return "";
        }
        int left = 0;
        outer: while (true) {
            for (int j = 0; j < strs.length - 1; j++) {
                if (strs[j + 1].length() - left <= 0 || strs[j].length() - left <= 0)
                    break outer;
                if (strs[j].charAt(left) != strs[j + 1].charAt(left)) {
                    break outer;
                }
            }
            result += first.charAt(left);
            left++;
        }
        return result;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        // important
        Arrays.sort(strs);
        String result = "";
        int n = strs.length;
        if (n == 1) {
            return "";
        }
        char[] first = strs[0].toCharArray();
        char[] last = strs[n - 1].toCharArray();
        for (int j = 0; j < Math.min(first.length, last.length); j++) {
            if (first[j] != last[j]) {
                break;
            }
            result += first[j];
        }
        return result;
    }

    @Test
    public void testLongestCommonPrefix() {
        assertEquals(longestCommonPrefix1(new String[] { "a", "ac" }), "a");
        assertEquals(longestCommonPrefix2(new String[] { "a", "ac" }), "a");
    }
}
