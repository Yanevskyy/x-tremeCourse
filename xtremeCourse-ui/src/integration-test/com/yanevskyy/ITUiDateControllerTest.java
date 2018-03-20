package com.yanevskyy;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class UiDateControllerIntegrationTest {
    QualifierDates dao = new DatesDAO();
    ParserDates parser = new ServiceDates(dao);
    ReceiverDates receiver = new UiDateController(parser);

    @Test
    public void testReturnAllDaysOfWeek() throws Exception {
        String[] daysOfWeek = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        String[] dates =
                {"18.03.2018", "19.03.2018", "20.03.2018", "21.03.2018", "22.03.2018", "23.03.2018", "24.03.2018", "25.03.2018"};

        for (int i = 0; i < daysOfWeek.length; i++) {
            String result = receiver.parseDate(dates[i]);

            assertEquals(daysOfWeek[i], result);
        }
    }

    @Test
    public void testReturnFinishedFebruary2016() throws ParseException {
        String result2016 = receiver.parseDate("29.02.2016");

        assertEquals("MONDAY", result2016);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testReturnParseExceptionWhetTakeWord() throws ParseException {
        thrown.expect(ParseException.class);
        receiver.parseDate("Date");
    }

    @Test
    public void testReturnExceptionIllegal() throws ParseException {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Date can't be null");
        receiver.parseDate(null);
    }

    @Test
    public void testReturnFinishedFebruary2018() throws ParseException {
        thrown.expect(ParseException.class);
        receiver.parseDate("29.02.2018");
    }

    @Test
    public void testReturnParseExceptionWhetTakeIncorrectArgument() throws ParseException {
        thrown.expect(ParseException.class);
        receiver.parseDate("-2.02.2018");
    }


}