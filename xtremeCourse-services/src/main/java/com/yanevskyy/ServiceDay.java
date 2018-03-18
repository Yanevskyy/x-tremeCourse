package com.yanevskyy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Checks string if  date is valid.
 */
class ServiceDay implements ParserDay {
    private static Logger LOGGER = LoggerFactory.getLogger(ServiceDay.class);
    private FinderDay mFinderDay = new DaysDAO();
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    public String parseDate(String date) throws ParseException {
        LOGGER.info("Parse string " + date);
        return mFinderDay.getDayOfWeek(getValidDate(date));
    }

    private Date getValidDate(String date) throws ParseException {
        LOGGER.info("Check format date");
        if (date == null) {
            throw new IllegalArgumentException("Date can't be null");
        }
        DATE_FORMAT.setLenient(false);
        return DATE_FORMAT.parse(date);
    }


}
