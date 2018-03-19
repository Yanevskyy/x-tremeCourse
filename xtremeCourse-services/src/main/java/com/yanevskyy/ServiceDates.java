package com.yanevskyy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Checks string if  date is valid.
 */
class ServiceDates implements ParserDates {
    private static Logger LOGGER = LoggerFactory.getLogger(ServiceDates.class);
    private QualifierDates mQualifierDates;
    private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    public ServiceDates(QualifierDates qualifierDates) {
        mQualifierDates = qualifierDates;
    }

    public String parseDate(String date) throws ParseException {
        LOGGER.info("Parse string " + date);
        return mQualifierDates.getDayOfWeek(getValidDate(date));
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
