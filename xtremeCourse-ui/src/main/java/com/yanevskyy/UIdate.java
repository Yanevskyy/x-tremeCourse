package com.yanevskyy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

/**
 * Takes date on string format as parameter.
 */
public class UIdate implements ControllerDay{
    private static Logger LOGGER = LoggerFactory.getLogger(UIdate.class);
    private ParserDay service = new ServiceDay();
    public String parseDate(String date) throws ParseException {
        LOGGER.info("Controller UI get date " + date);
            return service.parseDate(date);
    }
}
