import java.text.SimpleDateFormat;
import java.util.Date;

public class Clocks {
    private final int millisPerHour = 3600000;
    private final int millisPerMinute = 60000;
    private int hours;
    private int minutes;
    private int price;
    private String mark;
    public Clocks() {
        hours = 0;
        minutes = 0;
        price = 0;
        mark = "";
    }
    public void setTime(int hours, int minutes) {
        this.minutes = minutes % 60;
        this.hours = hours % 24 + minutes / 60;

    }

    public void setTime(int millis) {
        hours = millis % millisPerHour;
        millis = millis / millisPerHour;
        minutes = millis % millisPerMinute;
    }

    public void addTime(int hours, int minutes) {
        this.minutes += minutes;
        this.hours += hours + this.minutes / 60;
        this.minutes %= 60;
        this.hours %= 24;
    }

    public void addTime(int millis) {
        this.minutes += millis / millisPerMinute;
        this.minutes %= 60;
        this.hours += millis / millisPerHour + minutes / 60;
        this.hours %= 60;
    }

    public int[] getTime() {
        int[] time = new int[2];
        time[0] = hours;
        time[1] = minutes;
        return  time;
    }

    public int getMillis() {
        return hours*millisPerHour + minutes*millisPerMinute;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void printTime() {
        if (hours < 10) {
            if (minutes < 10) {
                System.out.println("0" + hours + ":" + "0" + minutes);
            } else {
                System.out.println("0" + hours + ":" + minutes);
            }
        } else {
            System.out.println(hours + ":" + minutes);
        }
    }
}
