package org.raddelgo14.MainGame;

import java.sql.Time;

public class TimeThread {

    public int hours;
    public int minutes;

    public TimeThread(){
        this.hours = 0;
        this.minutes = 0;
    }

    public void advanceTime(){
        minutes++;
        if (minutes == 60){
            minutes = 0;
            hours++;
        }
    }


    public int getTimeH(){
        return hours;
    }

    @Deprecated
    public int getTimeM(){
        return minutes;
    }

    public String getTimeMinutes(){
        if (minutes < 10){
            return "0" + minutes;
        }else{
            return String.valueOf(minutes);
        }
    }
}
