package ru.meowmure.javacreditest.Clockshop;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import ru.meowmure.javacreditest.Exceptions.IncorrectNumberException;
import ru.meowmure.javacreditest.Exceptions.NotCompatibleTypeException;
import ru.meowmure.javacreditest.Exceptions.NotValidTimeException;

public class Clock {
    private ClockPane clockPane;
    public boolean isTyped;
    public Integer cost;
    public String mark;
    public String name;


    public Clock(Canvas canvas) {

        clockPane = new ClockPane(canvas, this);
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
        clockPane.setTime(hours, minutes, seconds);
    }

    public void draw() {
        clockPane.PaintClock();
    }

    @Override
    public String toString() {
        return name;
    }
}