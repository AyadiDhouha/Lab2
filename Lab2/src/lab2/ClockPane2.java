import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Calendar;

import java.util.GregorianCalendar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.scene.layout.Pane;

import javafx.scene.paint.Color;

import javafx.scene.shape.Circle;

import javafx.scene.shape.Line;

import javafx.scene.text.Text;
import javafx.util.Duration;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LENOVO
 */
public class ClockPane2 extends Pane {

private int hour;

private int minute;

private int second;
private Boolean hourHandVisible=true;
private Boolean minuteHandVisible=true;
private Boolean secondHandVisible=true;

//animation 
EventHandler <ActionEvent> eventHandler = e ->{   
   setCurrentTime();
    };
    Timeline animation = new Timeline(
        new KeyFrame(Duration.millis(1000),eventHandler)
    );
    
        //methode start
       public void start(){
            animation.play();
        }
        //methode stop
        public void stop(){
           animation.pause();

            
       }

/** Construct a default clock with the
current time*/
 
  
public ClockPane2() {

setCurrentTime();
animation.play();
}

/** Construct a clock with specified
hour, minute, and second */

public ClockPane2(int hour,int
minute,int second) {

this.hour = hour;

this.minute = minute;

this.second = second;

animation.play();

}
//geters 
public Boolean gethourHandVisible() {

    return hourHandVisible; }
public Boolean getminuteHandVisible() {

    return minuteHandVisible; }
public Boolean getsecondHandVisible() {

    return secondHandVisible; }
//seters
public void sethourHandVisible(Boolean h ){
this.hourHandVisible=h;
paintClock();
}
public void setminuteHandVisible(Boolean m ){
this.minuteHandVisible=m;
paintClock();
}
public void setsecondHandVisible(Boolean s ){
this.secondHandVisible=s;
paintClock();
}

/** Return hour */

public int getHour() {

return hour; }

/** Set a new hour */

public void setHour(int hour) {

this.hour = hour;

paintClock(); }

/** Return minute */

public int getMinute() {

return minute; }

/** Set a new minute */

public void setMinute(int minute)
{

this.minute = minute;

paintClock(); }

/** Return second */

public int getSecond() {

return second; }

/** Set a new second */

public void setSecond(int second)
{

this.second = second;

paintClock(); }

/* Set the current time for the
clock */

public void setCurrentTime() {

// Construct a calendar for the current date and time

Calendar calendar = new
GregorianCalendar();

// Set current hour, minute and second

this.hour =
calendar.get(Calendar.HOUR_OF_DAY);

this.minute =
calendar.get(Calendar.MINUTE);

this.second =
calendar.get(Calendar.SECOND);

paintClock(); // Repaint the clock

}

private void paintClock() {
getChildren().clear();
// Initialize clock parameters

double clockRadius = Math.min(getWidth(),
getHeight()) * 0.8 * 0.5;

double centerX = getWidth() /2;

double centerY = getHeight() /2;

// Draw circle

Circle circle = new Circle(centerX, centerY,
clockRadius);

circle.setFill(Color.WHITE);

circle.setStroke(Color.BLACK);

Text t1 = new Text(centerX - 5, centerY -
clockRadius + 12, "12");

Text t2 = new Text(centerX - clockRadius +
3, centerY + 5, "9");

Text t3 = new Text(centerX + clockRadius -
10, centerY + 3, "3");

Text t4 = new Text(centerX - 3, centerY +
clockRadius - 3, "6");
getChildren().addAll(circle, t1, t2,
t3, t4);
// Draw second hand
if(secondHandVisible){
double sLength = clockRadius * 0.8;

double secondX = centerX +
sLength *

Math.sin(second * (2 * Math.PI /
60));

double secondY = centerY - sLength
*

Math.cos(second * (2 * Math.PI /
60));

Line sLine = new Line(centerX,
centerY, secondX, secondY);

sLine.setStroke(Color.RED);
getChildren().add(sLine);}

// Draw minute hand
if(minuteHandVisible){
double mLength = clockRadius *
0.65;

double xMinute = centerX +
mLength *

Math.sin(minute * (2 * Math.PI /
60));

double minuteY = centerY -
mLength *

Math.cos(minute * (2 * Math.PI /
60));

Line mLine = new Line(centerX,
centerY, xMinute, minuteY);

mLine.setStroke(Color.BLUE);
getChildren().add(mLine);}

// Draw hour hand

double hLength = clockRadius * 0.5;

double hourX = centerX + hLength *

Math.sin((hour % 12 + minute /
60.0) * (2 * Math.PI / 12));

double hourY = centerY - hLength *

Math.cos((hour % 12 + minute /
60.0) * (2 * Math.PI / 12));

Line hLine = new Line(centerX,
centerY, hourX, hourY);

hLine.setStroke(Color.GREEN);
getChildren().add(hLine);





}

@Override

public void setWidth(double width)
{

super.setWidth(width);

paintClock();

}

@Override

public void setHeight(double
height) {

super.setHeight(height);

paintClock(); }


  


}
