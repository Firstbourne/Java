package ru.meowmure.javacreditest.Clockshop;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import static javafx.scene.paint.Color.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

class ClockPane extends Pane {
    Stage stage;
    Group group;
    private int hours, minutes, seconds;
    private double Width = 350, Height = 350;
    public ClockPane(Stage stage){
        this.stage = stage;
        setCurrentTime();
    }
    public void setCurrentTime() {
        Calendar calendar = new GregorianCalendar();

        this.hours = calendar.get(Calendar.HOUR_OF_DAY);
        this.minutes = calendar.get(Calendar.MINUTE);
        this.seconds = calendar.get(Calendar.SECOND);

        PaintClock();

        stage.getScene().setRoot(group);
    }
    protected void PaintClock() {

        group = new Group();

        double clockRadius = Math.min(Width, Height) * 0.8 *0.5;
        double centerX = Width / 2;
        double centerY = Height / 2;

        Circle circle = new Circle(centerX,centerY,clockRadius);
        circle.setFill(WHITE);
        circle.setStroke(DARKBLUE);
        Text text = new Text(centerX - 5 , centerY -clockRadius +12, "12");
        Text text1 = new Text(centerX - clockRadius + 3, centerY - 5,"9");
        Text text2 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text text3 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

        double slength = clockRadius * 0.8;
        double secondX = centerX + slength * Math.sin(seconds *(2 * Math.PI / 60));
        double secondY = centerX - slength * Math.cos(seconds *(2 * Math.PI / 60));
        Line sline = new Line(centerX,centerY,secondX,secondY);
        sline.setStroke(RED);

        double mlength = clockRadius * 0.65;
        double minuteX = centerX + mlength * Math.sin(minutes *(2 * Math.PI / 60));
        double minuteY = centerX - mlength * Math.cos(minutes *(2 * Math.PI / 60));
        Line mline = new Line(centerX,centerY,minuteX,minuteY);
        mline.setStroke(BLUE);


        double hlength = clockRadius * 0.5;
        double hourX = centerX + hlength * Math.sin((hours % 12 + minutes / 60.0) *(2 * Math.PI / 12));
        double hourY = centerX - hlength * Math.cos((hours % 12 + minutes / 60.0)*(2 * Math.PI / 12));
        Line hline = new Line(centerX,centerY,hourX,hourY);
        hline.setStroke(BLACK);

        //StackPane stackPane = new StackPane(sline,mline,hline);

        //RotateTransition rotateTransition = new RotateTransition(Duration.seconds(1), sline);

        //rotateTransition.setFromAngle(0);
        //rotateTransition.setToAngle(360);
        //rotateTransition.setCycleCount(4);

        group.getChildren().addAll(circle,text,text1,text2,text3,sline,mline,hline);
    }
}
