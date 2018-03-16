package com.yanevskyy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Checks string if  date is valid.
 */
class DateService {
    private static Logger LOGGER = LoggerFactory.getLogger(DateService.class);
    private DateDAO dateDAO = new DateDAO();
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    String parseDate(String date) throws ParseException {
        LOGGER.info("Parse string " + date);
        return dateDAO.getDayOfWeek(getValidDate(date));
    }

    private Date getValidDate(String date) throws ParseException {
        LOGGER.info("Check format date");
        if (date == null) {
            throw new NullPointerException("Date can't be null");
        }
        DATE_FORMAT.setLenient(false);
        return DATE_FORMAT.parse(date);
    }
}
