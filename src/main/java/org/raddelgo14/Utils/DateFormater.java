package org.raddelgo14.Utils;

public class DateFormater {

    public static String formatDate(int seconds){
        int hours = seconds / 3600;
        int secAndMin = seconds % 3600;

        int minutes = secAndMin / 60;
        int second = secAndMin % 60;

        return hours + " H " + minutes + " M " + second + " S";
    }
}
