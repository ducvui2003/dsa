package classroom.bit_operator;

public class MyDate {
    int date;

    public MyDate(int date) {
        this.date = date;
    }

    public MyDate(int day, int month, int year) {
        this.setDay(day);
        this.setMonth(month);
        this.setYear(year);
    }

    public int getDay() {
        int mask = 31; // 0000 0000 ... 0001 1111
        return date & mask;
    }

    public int getMonth() {
        int mask = 15; // 0000 0000 0000 ... 1111
        return (this.date >> 5) & mask;
    }

    public int getYear() {
        return this.date >> 9;
    }

    public void setDay(int day) {
        this.date = this.date | day;
    }

    public void setMonth(int month) {
        this.date = this.date | (month << 5);
    }

    public void setYear(int year) {
        this.date = this.date | (year << 9);
    }

    @Override
    public String toString() {
        //"DD/MM/YYYY"
        return this.getDay() + "/" + this.getMonth() + "/" + this.getYear();
    }
}
