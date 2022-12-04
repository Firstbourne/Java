package ru.meowmure.javacreditest.Clockshop;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import ru.meowmure.javacreditest.Exceptions.IncorrectNumberException;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Clock {
    private ClockPane clockPane;
    public boolean isTyped;
    public Integer cost;
    public String mark;
    public String name;

    public int hours = 0;
    public int minutes = 0;
    public int seconds = 0;

    public GregorianCalendar timeStart;
    public GregorianCalendar timeEnd;


    public Clock(Group group, Color color) {
        clockPane = new ClockPane(group, this, color);
        timeStart = new GregorianCalendar();
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
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
        timeStart = new GregorianCalendar();
    }


    public ClockPane getClockPane() {
        return clockPane;
    }

    public void setClockPane(ClockPane clockPane) {
        this.clockPane = clockPane;
    }

    public void draw() {
        timeEnd = new GregorianCalendar();
        seconds = timeEnd.get(Calendar.SECOND) - timeStart.get(Calendar.SECOND) + seconds;
        minutes = timeEnd.get(Calendar.MINUTE) - timeStart.get(Calendar.MINUTE) + minutes;
        hours = timeEnd.get(Calendar.HOUR) - timeStart.get(Calendar.HOUR) + hours;
        clockPane.PaintClock(hours, minutes, seconds);
    }


    @Override
    public String toString() {
        return name;
    }
}