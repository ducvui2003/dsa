package dsa.string;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 1) {
            return List.of(List.of(strs[0]));
        }
        Map<List<Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            List<Integer> key = this.getKey(str);
            List<String> value = map.get(key);
            if (value == null)
                value = new ArrayList<>();
            value.add(str);
            map.put(key, value);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<List<Integer>, List<String>> e : map.entrySet()) {
            result.add(e.getValue());
        }
        return result;
    }

    // public List<List<String>> groupAnagrams(List<String> strs) {
    // List<String> sorted = new ArrayList<>();
    // Map<String, String>
    // for (String str : strs) {
    // sorted.add(Collections.sort(str.chars().mapToObj(c -> (char)
    // c).collect(Collectors.toList()));
    // }
    // return sorted;
    // }

    public List<Integer> getKey(String str) {
        int[] arr = new int[26];
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            int index = aChar - 97;
            arr[index] = arr[index] + 1;
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] str = new String[] { "pots", "tops" };
        GroupAnagram g = new GroupAnagram();
        System.out.println(g.groupAnagrams(str));
    }
}
