package com.yanevskyy;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServiceDayTest {
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    DaysDAO dayDao = mock(DaysDAO.class);

    @Test
    public void testReturnAllDaysOfWeek() throws Exception {
        String[] daysOfWeek = {"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
        Date[] dates = {DATE_FORMAT.parse("18.03.2018"),DATE_FORMAT.parse("19.03.2018"),DATE_FORMAT.parse("20.03.2018"),
                DATE_FORMAT.parse("21.03.2018"),DATE_FORMAT.parse("22.03.2018"),DATE_FORMAT.parse("23.03.2018"),
                DATE_FORMAT.parse("24.03.2018"),DATE_FORMAT.parse("25.03.2018"),};

        for (int i = 0; i < daysOfWeek.length; i++) {
            when(dayDao.getDayOfWeek(dates[i])).thenReturn(daysOfWeek[i]);
        }

        for (int i = 0; i < daysOfWeek.length; i++) {
            String result = dayDao.getDayOfWeek(dates[i]);
            assertEquals(daysOfWeek[i], result);
        }
    }

    @Test(expected = ParseException.class)
    public void testReturnFinishedFebruary2018() throws ParseException {
        Date february2018 = DATE_FORMAT.parse("29.02.2018");
        doThrow(new Exception()).when(dayDao).getDayOfWeek(february2018);

//        dayDao.getDayOfWeek(february2018);
    }

    @Test
    public void testReturnFinishedFebruary2016() throws ParseException {
        Date february2016 = DATE_FORMAT.parse("29.02.2016");
        when(dayDao.getDayOfWeek(february2016)).thenReturn("MONDAY");

        String result2016 = dayDao.getDayOfWeek(february2016);

        assertEquals("MONDAY", result2016);
    }

}