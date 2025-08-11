package classroom.bit_operator;

public class Main {
    public static void main(String[] args) {
        // Decimal: 1036916
        // Binary: 1111 1101 0010 0111 0100 / 32 11+9
        // Binary <<12  : 1111 1101 0010 0111 0100
        MyDate date = new MyDate(1036916);

        System.out.println("Day " + date.getDay());
        System.out.println("Month " + date.getMonth());
        System.out.println("Year " + date.getYear());
        System.out.println(date);

        MyDate date2 = new MyDate(20, 4, 2025);
        System.out.println(date2);
    }
}
