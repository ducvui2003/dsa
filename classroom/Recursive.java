package classroom;

public class Recursive {
    int x = y;
    static int y = 1;

    public static void main(String[] args) {
//        int i = 129;
//        int iDigit = digits(i);
//        System.out.println("Digit");
//        System.out.println(iDigit);
//
//        int decValue = 6;
//        System.out.println("Bin value");
//        decToBin(decValue);
//
//        int valueReverse = 123;
//        System.out.println();
//        System.out.println("Reverse");
//        reverse(valueReverse);

        Recursive r = new Recursive();
        System.out.println(r.x);
        System.out.println(r.y);
    }

    static void decToBin(int n) {
        if (n / 2 == 0)
            System.out.print(n % 2);
        else {
            decToBin(n / 2);
            System.out.print(n % 2);
        }
    }

    static void reverse(int n) {
        if (n < 10)
            System.out.print(n);
        else {
            System.out.print(n % 10);
            reverse(n / 10);
        }

    }

    static int digits(int n) {
        if (n < 10)
            return 1;
        return 1 + digits(n / 10);
    }
}
