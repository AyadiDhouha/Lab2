import javafx.scene.paint.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;



public class ClockPane extends Pane{
    protected int hour ; 
    protected int minute ; 
    protected int second ; 
    
    protected Boolean hourHandVisible=true ;
    protected Boolean minuteHandVisible=true ;
    protected Boolean secondHandVisible=true ;
    
    protected double height;
    
    protected double width;
    
    
    EventHandler<ActionEvent> eventHandler = e->{
        
    setCurrentTime();
   
    
    };
    Timeline animation = new Timeline(
        new KeyFrame(Duration.millis(1000),eventHandler)
    );
    
    
        public void start(){
            animation.play();
        }
        
        public void stop(){
           animation.pause();

            
        }
    
        public Boolean gethourHandVisible() {

        return hourHandVisible; }

        /** Set a new hour */

        public void sethourHandVisible(Boolean hour) {

        this.hourHandVisible = hour;

        paintClock(); }
        
        
         public Boolean getminuteHandVisible() {

        return minuteHandVisible; }

        /** Set a new hour */

        public void setminuteHandVisible(Boolean minute) {

        this.minuteHandVisible = minute;

        paintClock(); }
        
        
        
        
        public Boolean getsecondHandVisible() {

        return secondHandVisible; }

        /** Set a new hour */

        public void setsecondHandVisible(Boolean second) {

        this.secondHandVisible = second;

        paintClock(); }
        
        
        
    
    
    
    
    
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

        public ClockPane(){
            setCurrentTime();
            height=250;
            width=250;
            animation.setCycleCount(Timeline.INDEFINITE);

            animation.play();
        }

        public ClockPane(int x ,int y , int z){
            hour=x;
            minute=y ;
            second = z;
            height=250;
            width=250;
            animation.setCycleCount(Timeline.INDEFINITE);

            animation.play();
            paintClock();
        }

        public void setCurrentTime(){
            Calendar calendar=new GregorianCalendar(); 

            hour =calendar.get(Calendar.HOUR_OF_DAY);
            minute =calendar.get(Calendar.MINUTE);
            second =calendar.get(Calendar.SECOND);

            paintClock();

        }

        

        private void paintClock(){
            double clockRadius = Math.min(getWidth(),getHeight()) * 0.8 *0.5;

            double centerX = getWidth() /2;

            double centerY = getHeight() /2;

            // Draw circle

            Circle circle = new Circle(centerX, centerY,clockRadius);

            circle.setFill(Color.WHITE);

            circle.setStroke(Color.BLACK);

            Text t1 = new Text(centerX - 5, centerY -clockRadius + 12, "12");

            Text t2 = new Text(centerX - clockRadius +3, centerY + 5, "9");

            Text t3 = new Text(centerX + clockRadius -10, centerY + 3, "3");

            Text t4 = new Text(centerX - 3, centerY +clockRadius - 3, "6");
            
            
            //draw second hand
            getChildren().clear();
            getChildren().addAll(circle, t1, t2,t3, t4);
            
            
            if(secondHandVisible){
                double sLength = clockRadius * 0.8;

                double secondX = centerX +sLength *Math.sin(second * (2 * Math.PI /60));

                double secondY = centerY - sLength*Math.cos(second * (2 * Math.PI /60));

                Line sLine = new Line(centerX,centerY, secondX, secondY);

                sLine.setStroke(Color.RED);
                getChildren().add(sLine);
            }


            //draw minute hand
             if(minuteHandVisible){
                    double mLength = clockRadius *0.65;

                    double xMinute = centerX +mLength *Math.sin(minute * (2 * Math.PI /60));

                    double minuteY = centerY -mLength *Math.cos(minute * (2 * Math.PI /60));

                    Line mLine = new Line(centerX,centerY, xMinute, minuteY);

                    mLine.setStroke(Color.BLUE);
                    getChildren().add(mLine);
             }
             
             
            // Draw hour hand
            
            if(hourHandVisible){
                
                double hLength = clockRadius * 0.5;

                double hourX = centerX + hLength *

                Math.sin((hour % 12 + minute /60.0) * (2 * Math.PI / 12));

                double hourY = centerY - hLength *

                Math.cos((hour % 12 + minute /60.0) * (2 * Math.PI / 12));

                Line hLine = new Line(centerX,centerY, hourX, hourY);

                hLine.setStroke(Color.GREEN);
                getChildren().add(hLine);
            }


            

            

        
    }
    
    @Override
    public void setWidth(double width)
    {

    super.setWidth(width);

    paintClock();

    }

    @Override
    public void setHeight(double height) {

    super.setHeight(height);

    paintClock(); }}
    