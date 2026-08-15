package leet_code._125;

/*
 * https://leetcode.com/problems/valid-palindrome/
 * */
public class Solution {
    public boolean isPalindrome(String s) {
         StringBuilder sb = new StringBuilder(s.trim().toLowerCase());
         if (sb.length() == 1 || sb.length() == 0)
             return true;
         int left = 0;
         int right = sb.length() - 1;
         while (left < right) {
             char leftChar = sb.charAt(left);
             if (!((leftChar >= 97 && leftChar <= 122) || (leftChar >= 48 && leftChar <= 57))) {
                 sb.deleteCharAt(left);
                 right--;
                 continue;
             }
             char rightChar = sb.charAt(right);
             if (!((rightChar >= 97 && rightChar <= 122) || (rightChar >= 48 && rightChar <= 57))) {
                 sb.deleteCharAt(right);
                 right--;
                 continue;
             }
             if (leftChar != rightChar) {
                 return false;
             }
             left++;
             right--;
         }
         return true;
    }

    public boolean isPalindromeOpt(String s) {
        if (s.length() == 1 || s.length() == 0)
            return true;
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (chars[left] >= 'A' && chars[left] <= 'Z')
                chars[left] += 32;
            if (chars[right] >= 'A' && chars[right] <= 'Z')
                chars[right] += 32;
            if (!((chars[left] >= '0' && chars[left] <= '9') || (chars[left] >= 'a' && chars[left] <= 'z'))) {
                left++;
                continue;
            }
            if (!((chars[right] >= '0' && chars[right] <= '9') || (chars[right] >= 'a' && chars[right] <= 'z'))) {
                right--;
                continue;
            }
            if (chars[left] != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindromeOpt("A man, a plan, a canal: Panama"));
    }
}
