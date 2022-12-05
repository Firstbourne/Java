package ru.meowmure.javacreditest.Clockshop;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import ru.meowmure.javacreditest.Exceptions.IncorrectNumberException;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock implements Serializable {
    private transient ClockPane clockPane;
    public boolean isTyped;
    public int cost;
    public String mark;
    public String name;

    public int hours = 0, minutes = 0, seconds = 0;
    public int finalHours = 0, finalMinutes = 0, finalSeconds = 0;

    private double red, green, blue;

    public GregorianCalendar timeStart;
    public GregorianCalendar timeEnd;


    public Clock(Group group, Color color) {
        clockPane = new ClockPane(group, this, color);
        timeStart = new GregorianCalendar();
        red = color.getRed();
        green = color.getGreen();
        blue = color.getBlue();
    }

    public Clock(int cost, String mark, String name) {
        this.cost = cost;
        this.mark = mark;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) throws IncorrectNumberException {
        if (cost < 0) throw new IncorrectNumberException("Price cannot be below zero");
        this.cost = cost;
    }


    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setTime(int hours, int minutes, int seconds) {
        finalSeconds = seconds;
        finalMinutes = minutes;
        finalHours = hours;
        timeStart = new GregorianCalendar();
    }

    public void clockRestored(Group group) {
        clockPane = new ClockPane(group, this, Color.color(red, green, blue));
    }

    public ClockPane getClockPane() {
        return clockPane;
    }

    public void setClockPane(ClockPane clockPane) {
        this.clockPane = clockPane;
    }

    public void draw() {
        timeEnd = new GregorianCalendar();
        seconds = timeEnd.get(Calendar.SECOND) - timeStart.get(Calendar.SECOND) + finalSeconds;
        minutes = timeEnd.get(Calendar.MINUTE) - timeStart.get(Calendar.MINUTE) + finalMinutes;
        hours = timeEnd.get(Calendar.HOUR) - timeStart.get(Calendar.HOUR) + finalHours;
        clockPane.PaintClock(hours, minutes, seconds);
    }


    @Override
    public String toString() {
        return name;
    }
}