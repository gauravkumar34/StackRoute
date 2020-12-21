package com.stackroute.datetime;

import java.util.Calendar;

public class FindDay {

    // write logic to find day of the date and return result
    public String findDay(int month, int day, int year) {
        if (month > 12)
            return "Give month in range";
        if (day > 31)
            return "Give day in range";
        if (month == 0 && day == 0 && year == 0)
            return "Give month in range" + "Give day in range" + "Give year in range";
        if (day == 0 && month == 0)
            return "Give month in range" + "Give day in range";
        if (year == 0 && month == 0)
            return "Give month in range" + "Give year in range";
        if (year == 0 && day == 0)
            return "Give day in range" + "Give year in range";

        if (day < 0)
            return "Give day in range";
        if (month < 0)
            return "Give month in range";
        if (year < 1000 || year > 3000)
            return "Give year in range";

        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day);
        String dayOfWeek = getDayOfWeek(c.get(Calendar.DAY_OF_WEEK));
        return dayOfWeek.toUpperCase();
    }

    private String getDayOfWeek(int value) {
        String day = "";
        switch (value) {
            case 1:
                day = "Sunday";
                break;
            case 2:
                day = "Monday";
                break;
            case 3:
                day = "Tuesday";
                break;
            case 4:
                day = "Wednesday";
                break;
            case 5:
                day = "Thursday";
                break;
            case 6:
                day = "Friday";
                break;
            case 7:
                day = "Saturday";
                break;
        }
        return day;
    }
}
