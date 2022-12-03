package ru.meowmure.javacreditest.Clockshop;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import static javafx.scene.paint.Color.*;

import java.lang.reflect.AccessibleObject;
import java.util.Calendar;
import java.util.GregorianCalendar;

class ClockPane extends Pane {
    private Canvas canvas;
    private Clock clock;
    private GraphicsContext context;
    private int hours = 0, minutes = 0, seconds = 0;
    private double width = 350, height = 350;


    public ClockPane(Canvas canvas, Clock clock){
        this.canvas = canvas;
        context = canvas.getGraphicsContext2D();
        this.clock = clock;
    }

//    public void setCurrentTime() {
//        Calendar calendar = new GregorianCalendar();
//
//        this.hours = calendar.get(Calendar.HOUR_OF_DAY);
//        this.minutes = calendar.get(Calendar.MINUTE);
//        this.seconds = calendar.get(Calendar.SECOND);
//
//        PaintClock();
//    }
    public void setTime(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        System.out.println(hours + " " + minutes + " " + seconds);
    }
    protected void PaintClock() {

        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        double clockRadius = Math.min(width, height) * 0.8 * 0.5;
        double halfWidth = width / 2;
        double halfHeight = height / 2;
        double centerX = canvas.getWidth() / 2;
        double centerY = canvas.getWidth() / 2;


        context.setStroke(Color.DARKBLUE);
        context.strokeOval(canvas.getWidth() / 2 - halfWidth, canvas.getHeight() / 2 - halfHeight, width, height);
        context.fillText("12", centerX - 7, centerY - halfHeight + 11);
        context.fillText("9", centerX - halfWidth + 3, centerY + 3);
        context.fillText("3", centerX + halfWidth - 10, centerY + 5);
        context.fillText("6", centerX - 4, centerY + halfHeight - 3);

        if (clock.isTyped) {
            double slength = clockRadius * 0.8;
            double secondX = centerX + slength * Math.sin(seconds * (2 * Math.PI / 60));
            double secondY = centerX - slength * Math.cos(seconds * (2 * Math.PI / 60));

            context.setStroke(Color.RED);
            context.strokeLine(centerX, centerY, secondX, secondY);
        }

        double mlength = clockRadius * 0.65;
        double minuteX = centerX + mlength * Math.sin(minutes * (2 * Math.PI / 60));
        double minuteY = centerX - mlength * Math.cos(minutes * (2 * Math.PI / 60));

        context.setStroke(Color.BLACK);
        context.strokeLine(centerX, centerY, minuteX, minuteY);

        double hlength = clockRadius * 0.5;
        double hourX = centerX + hlength * Math.sin((hours % 12 + minutes / 60.0) * (2 * Math.PI / 12));
        double hourY = centerX - hlength * Math.cos((hours % 12 + minutes / 60.0) * (2 * Math.PI / 12));

        context.setStroke(Color.BLUE);
        context.strokeLine(centerX, centerY, hourX, hourY);

    }
}
