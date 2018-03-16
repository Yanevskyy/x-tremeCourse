package com.yanevskyy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * Converts date to date of week in format of string
 */
class DateDAO implements DAO{
    private static Logger LOGGER = LoggerFactory.getLogger(DAO.class);

    public String getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        LOGGER.info("Gets day of week " + dayOfWeek);

        switch (dayOfWeek){
            case 1 : return DaysOfWeek.SUNDAY.name();
            case 2 : return DaysOfWeek.MONDAY.name();
            case 3 : return DaysOfWeek.TUESDAY.name();
            case 4 : return DaysOfWeek.WEDNESDAY.name();
            case 5 : return DaysOfWeek.THURSDAY.name();
            case 6 : return DaysOfWeek.FRIDAY.name();
            case 7 : return DaysOfWeek.SATURDAY.name();
            default: return "";
        }
    }
}
