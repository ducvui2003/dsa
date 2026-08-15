package dsa.string;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EnDecode {

    public String encode(List<String> strs) {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            if (strs.get(i).isEmpty()) {
                out.append("¢");
            }
            char[] chars = strs.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                out.append((char) (chars[j] + 1));
            }
            if (i != strs.size() - 1) {
                out.append("¡");
            }
        }
        return out.toString();
    }

    public List<String> decode(String str) {
        StringTokenizer tokens = new StringTokenizer(str, "¡");
        List<String> out = new ArrayList<>();
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            if (token.equals("¢")) {
                out.add("");
                continue;
            }
            char[] arr = token.toCharArray();
            StringBuilder word = new StringBuilder();
            for (char c : arr) {
                word.append((char) (c - 1));
            }
            out.add(word.toString());
        }
        return out;
    }

    public static void main(String[] args) {

        List<String> str = List.of("", "   ", "!@#$%^&*()_+", "LongStringWithNoSpaces", "Another, String With, Commas");
        EnDecode en = new EnDecode();
        String encode = en.encode(str);
        System.out.println(en.decode(encode));
    }
}
