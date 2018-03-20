package com.yanevskyy;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServiceDayTest {
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
    QualifierDates dateDAO = mock(DatesDAO.class);
    ParserDates parserDate = new ServiceDates(dateDAO);

    @Test
    public void testReturnAllDaysOfWeek() throws Exception {
        String[] daysOfWeek = {"SUNDAY","MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
        String[] dates =
                {"18.03.2018","19.03.2018","20.03.2018","21.03.2018","22.03.2018","23.03.2018","24.03.2018","25.03.2018"};

        for (int i = 0; i < daysOfWeek.length; i++) {
            when(dateDAO.getDayOfWeek(DATE_FORMAT.parse(dates[i]))).thenReturn(daysOfWeek[i]);
        }

        for (int i = 0; i < daysOfWeek.length; i++) {
            String result = parserDate.parseDate(dates[i]);
            assertEquals(daysOfWeek[i], result);
        }
    }

    @Test
    public void testReturnFinishedFebruary2016() throws ParseException {
        when(dateDAO.getDayOfWeek(DATE_FORMAT.parse("29.02.2016"))).thenReturn("MONDAY");

        String result2016 = parserDate.parseDate("29.02.2016");

        assertEquals("MONDAY", result2016);
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testReturnParseExceptionWhetTakeWord() throws ParseException {
        thrown.expect(ParseException.class);
        parserDate.parseDate("Date");
    }

    @Test
    public void testReturnExceptionIllegal() throws ParseException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Date can't be null");
        parserDate.parseDate(null);
    }

    @Test
    public void testReturnFinishedFebruary2018() throws ParseException {
        thrown.expect(ParseException.class);
        parserDate.parseDate("29.02.2018");
    }

    @Test
    public void testReturnParseExceptionWhetTakeIncorrectArgument() throws ParseException {
        thrown.expect(ParseException.class);
        parserDate.parseDate("-2.02.2018");
    }





}