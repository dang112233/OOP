package hus.oop.lab5;

public class MyDate {

    private int year;
    private int month;
    private int day;

    private static String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"};
    private static int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    public boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999) {
            return false;
        }
        if (month < 1 || month > 12) {
            return false;
        }
        int maxDay = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) {
            maxDay = 29;
        }
        return day >= 1 && day <= maxDay;
    }

    public int getDayOfWeek(int year, int month, int day) {
        int y = year - (month < 3 ? 1 : 0);
        int m = month + (month < 3 ? 12 : 0);
        return (day + (26 * m - 2) / 10 + y + y / 4 + y / 400 - y / 100) % 7;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return String.format("%s %d %s %d", DAYS[getDayOfWeek(year, month, day)], day, MONTHS[month - 1], year);
    }

    public MyDate nextDay() {
        int nextDay = day + 1;
        int nextMonth = month;
        int nextYear = year;
        if (nextDay > DAYS_IN_MONTHS[month - 1]) {
            nextDay = 1;
            nextMonth++;
            if (nextMonth > 12) {
                nextMonth = 1;
                nextYear++;
            }
        }
        return new MyDate(nextYear, nextMonth, nextDay);
    }

    public MyDate nextMonth() {
        int nextMonth = month + 1;
        int nextYear = year;
        if (nextMonth > 12) {
            nextMonth = 1;
            nextYear++;
        }
        return new MyDate(nextYear, nextMonth, day);
    }

    public MyDate nextYear() {
        return new MyDate(year + 1, month, day);
    }

    public MyDate previousDay() {
        int previousDay = day - 1;
        int previousMonth = month;
        int previousYear = year;
        if (previousDay < 1) {
            previousDay = DAYS_IN_MONTHS[month - 2];
            previousMonth--;
        }
        return new MyDate(previousYear, previousMonth, previousDay);
    }

    public MyDate previousMonth() {
        int previousMonth = month - 1;
        int previousYear = year;
        if (previousMonth < 1) {
            previousMonth = 12;
            previousYear--;
        }
        return new MyDate(previousYear, previousMonth, day);
    }

    public MyDate previousYear() {
        return new MyDate(year - 1, month, day);
    }
}
