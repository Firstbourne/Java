package ru.meowmure.javacreditest.Clockshop;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import ru.meowmure.javacreditest.Exceptions.IncorrectNumberException;
import ru.meowmure.javacreditest.Exceptions.NotCompatibleTypeException;
import ru.meowmure.javacreditest.Exceptions.NotValidTimeException;

public class Clock {
    ClockPane clockPane;

    public boolean isTyped;
    private IntegerProperty seconds;
    private IntegerProperty minutes;
    private IntegerProperty hours;
    public IntegerProperty cost;
    public StringProperty mark;
    public StringProperty name;
    private Stage stage;

    public Clock(Stage stage) {
        seconds = new SimpleIntegerProperty();
        minutes = new SimpleIntegerProperty();
        hours = new SimpleIntegerProperty();
        cost = new SimpleIntegerProperty();
        mark =  new SimpleStringProperty();
        name = new SimpleStringProperty();
        clockPane = new ClockPane(stage);
    }

    public Clock(int cost, String mark, String name) {
        this.cost = new SimpleIntegerProperty(cost);
        this.mark = new SimpleStringProperty(mark);
        this.name = new SimpleStringProperty(name);
        seconds = minutes = hours = null;

    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public void setSeconds(int seconds) throws NotValidTimeException, NotCompatibleTypeException {
        if (!isTyped) throw new NotCompatibleTypeException("Seconds not available in this type");
        if (!(seconds >=0 && seconds < 60)) throw new NotValidTimeException("Seconds can be only between 0 and 59");
        this.seconds = new SimpleIntegerProperty(seconds);
    }


    public void setMinutes(int minutes) throws NotValidTimeException {
        if (!(minutes >= 0 && minutes < 60)) throw new NotValidTimeException("Minutes can be only from 0 to 59");
        this.minutes = new SimpleIntegerProperty(minutes);
    }


    public void setHours(int hours) throws NotValidTimeException {
        if (!(hours >= 0 && hours < 24)) throw new NotValidTimeException("Hours can be only from 0 to 23");
        this.hours = new SimpleIntegerProperty(hours);
    }


    public void setCost(int cost) throws IncorrectNumberException {
        if (cost < 0) throw new IncorrectNumberException("Price cannot be below zero");
        this.cost = new SimpleIntegerProperty(cost);
    }


    public void setMark(String mark) {
        this.mark = new SimpleStringProperty(mark);
    }


    @Override
    public String toString() {
        return name.getValue();
    }
}