package com.yanevskyy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

/**
 * @author Yanevskyy Igor igor2000@inbox.ru.
 */
public class App {
    private static Logger LOGGER = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        QualifierDates qualifierDates = new DatesDAO();
        ParserDates parserDates = new ServiceDates(qualifierDates);
        for (String date : args) {
            LOGGER.info("Start program with param " + date);
            try {
                System.out.println(parserDates.parseDate(date));
            } catch (ParseException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }
}
