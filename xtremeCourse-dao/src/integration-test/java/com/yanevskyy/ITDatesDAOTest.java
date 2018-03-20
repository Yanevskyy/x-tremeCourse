package com.yanevskyy;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ITDatesDAOTest {
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    private QualifierDates datesDAO = new DatesDAO();
    private String[] daysOfWeek = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};

    @Test
    public void returnDayOfWeekWhenTakeEightDays() throws Exception {
        String[] calendarDays =
                {"18.03.2018", "19.03.2018", "20.03.2018", "21.03.2018", "22.03.2018", "23.03.2018", "24.03.2018", "25.03.2018"};

        for (int i = 0; i < daysOfWeek.length; i++) {
            Date dateTest = DATE_FORMAT.parse(calendarDays[i]);
            String result = datesDAO.getDayOfWeek(dateTest);
            assertEquals(daysOfWeek[i], result);
        }
    }

}