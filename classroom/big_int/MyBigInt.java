package classroom.big_int;

import java.util.Arrays;

public class MyBigInt {
    String value;
    int length;
    String reverse;

    public MyBigInt(String value) {
        this.value = value;
        this.length = value.trim().length();
        this.reverse = reverse(value);
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public int[] multiply(MyBigInt other) {
        int[] arr = new int[this.length + other.length];
        for (int i = 0; i < other.length; i++) {
            int a = Integer.parseInt(other.reverse.substring(i, i + 1));
            for (int j = 0; j < this.reverse.length(); j++) {
                int b = Integer.parseInt(this.reverse.substring(j, j + 1));
                int value = arr[i + j];
                if (value == 0) {
                    arr[i + j] = (a * b) % 10;
                } else {
                    arr[i + j] = (value + (a * b)) % 10;
                }

                // Remainder
                int mind =  (value + (a * b)) / 10;
                if (mind != 0) {
                    arr[i + j + 1] += mind;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        MyBigInt bigInt1 = new MyBigInt("789");
        MyBigInt bigInt2 = new MyBigInt("120021");
        int[] arr = bigInt1.multiply(bigInt2);
        System.out.println(Arrays.toString(arr));
    }
}
