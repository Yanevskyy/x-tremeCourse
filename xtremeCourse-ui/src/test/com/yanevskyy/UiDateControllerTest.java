package com.yanevskyy;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UiDateControllerTest {
    ParserDates parser = mock(ServiceDates.class);
    ReceiverDates receiver = new UiDateController(parser);

    @Test
    public void testReturnAllDaysOfWeek() throws Exception {
        String[] daysOfWeek = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        String[] dates =
                {"18.03.2018", "19.03.2018", "20.03.2018", "21.03.2018", "22.03.2018", "23.03.2018", "24.03.2018", "25.03.2018"};
        for (int i = 0; i < daysOfWeek.length; i++) {
            when(parser.parseDate(dates[i])).thenReturn(daysOfWeek[i]);
        }

        for (int i = 0; i < daysOfWeek.length; i++) {
            String result = receiver.parseDate(dates[i]);

            assertEquals(daysOfWeek[i], result);
        }
    }

    @Test
    public void testReturnFinishedFebruary2016() throws ParseException {
        when(parser.parseDate("29.02.2016")).thenReturn("MONDAY");

        String result2016 = receiver.parseDate("29.02.2016");

        assertEquals("MONDAY!", result2016);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testReturnParseExceptionWhetTakeWord() throws ParseException {
        when(parser.parseDate("Date")).thenThrow(ParseException.class);
        thrown.expect(ParseException.class);
        receiver.parseDate("Date");
    }

    @Test
    public void testReturnExceptionIllegal() throws ParseException {
        when(parser.parseDate(null)).thenThrow(new IllegalArgumentException("Date can't be null"));
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Date can't be null");
        receiver.parseDate(null);
    }

    @Test
    public void testReturnFinishedFebruary2018() throws ParseException {
        when(parser.parseDate("29.02.2018")).thenThrow(ParseException.class);
        thrown.expect(ParseException.class);
        receiver.parseDate("29.02.2018");
    }

    @Test
    public void testReturnParseExceptionWhetTakeIncorrectArgument() throws ParseException {
        when(parser.parseDate("-2.02.2018")).thenThrow(ParseException.class);
        thrown.expect(ParseException.class);
        receiver.parseDate("-2.02.2018");
    }

}