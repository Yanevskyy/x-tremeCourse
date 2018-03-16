package com.yanevskyy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;


/**
 * Takes date on string format as parameter.
 */
public class DateController {
    private static Logger LOGGER = LoggerFactory.getLogger(DateController.class);

    public static void main(String[] args) {
        DateService dateService = new DateService();

        for (String date : args) {
            LOGGER.info("Start program with param " + date);
            try {
                System.out.println(dateService.parseDate(date));
            } catch (ParseException e) {
                LOGGER.info("Error parse. Incorrect format of date");
                e.printStackTrace();
            }
        }
    }
}
