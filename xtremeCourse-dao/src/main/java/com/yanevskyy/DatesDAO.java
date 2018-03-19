package com.yanevskyy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;

/**
 * Converts date to date of week in format of string
 */
class DatesDAO implements QualifierDates {
    private static Logger LOGGER = LoggerFactory.getLogger(QualifierDates.class);

    public String getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int indexDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        LOGGER.info("Gets day of week " + indexDayOfWeek);

        String dayOfWeek;

        switch (indexDayOfWeek){
            case 1 : dayOfWeek = DaysOfWeek.SUNDAY.name(); break;
            case 2 : dayOfWeek =  DaysOfWeek.MONDAY.name(); break;
            case 3 : dayOfWeek =  DaysOfWeek.TUESDAY.name(); break;
            case 4 : dayOfWeek =  DaysOfWeek.WEDNESDAY.name(); break;
            case 5 : dayOfWeek =  DaysOfWeek.THURSDAY.name(); break;
            case 6 : dayOfWeek =  DaysOfWeek.FRIDAY.name(); break;
            case 7 : dayOfWeek =  DaysOfWeek.SATURDAY.name(); break;
            default: dayOfWeek =  indexDayOfWeek + " is not day of week";
        }
        LOGGER.info("Day with index " + indexDayOfWeek + " is day of week " + dayOfWeek);
        return dayOfWeek;
    }
}
