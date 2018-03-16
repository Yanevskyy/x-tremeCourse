package com.yanevskyy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;


/**
 * Takes date on string format as parameter.
 */
public class DateController implements Controller{
    private static Logger LOGGER = LoggerFactory.getLogger(DateController.class);
    private Service service = new DateService();
    public String parseDate(String date) throws ParseException {
        LOGGER.info("Controller UI get date " + date);
            return service.parseDate(date);
    }
}
