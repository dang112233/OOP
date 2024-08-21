package hus.oop.lab5;

public class MyTime {
    private int hour = 0;
    private  int minute = 0;
    private int second = 0;

    public MyTime() {

    }

    public MyTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setTime(int hour, int minute, int second) {
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        }
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        }
        if (second >= 0 && second <= 59) {
            this.second = second;
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour <= 23) {
            this.hour = hour;
        }
        return;
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute <= 59) {
            this.minute = minute;
        }
        return;
    }

    public void setSecond(int second) {
        if (second >= 0 && second <= 59) {
            this.second = second;
        }
        return;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public MyTime nextSecond() {
        if(this.second == 59) {
            if(this.minute == 59) {
                return new MyTime((this.hour + 1)%24, 0, 0);
            } else {
                return new MyTime(this.hour,(this.minute + 1)%60, 0);
            }
        } else {
            return new MyTime(this.hour, this.minute, this.second +1);
        }
    }

    public MyTime nextMinute() {
        if(this.minute == 59) {
            return new MyTime((this.hour + 1)%24, 0, this.second);
        } else {
            return new MyTime(this.hour, (this.minute + 1), this.second);
        }
    }

    public MyTime nextHour() {
        if(this.hour == 23) {
            return new MyTime(0, this.minute, this.second);
        } else {
            return new MyTime((this.hour +1), this.minute, this.second);
        }
    }

    public MyTime previousSecond() {
        if (this.second == 0) {
            if(this.minute == 0) {
                if(this.hour == 0) {
                    return new MyTime(23, 59, 59);
                } else {
                    return new MyTime((this.hour - 1), 59, 59);
                }
            } else {
                return new MyTime(this.hour, (this.minute - 1), 59);
            }
        } else {
            return new MyTime(this.hour, this.minute, (this.minute -1));
        }
    }

    public MyTime previousMinute() {
        if(this.minute == 0) {
            if(this.hour == 0) {
                return new MyTime(23, 59, this.second);
            } else {
                return new MyTime(this.hour, 59, this.second);
            }
        } else {
            return new MyTime(this.hour, (this.minute - 1), this.second);
        }
    }

    public MyTime previousHour() {
        if(this.hour == 0) {
            return new MyTime(23, this.minute, this.second);
        } else {
            return new MyTime((this.hour - 1), this.minute, this.second);
        }
    }
}
