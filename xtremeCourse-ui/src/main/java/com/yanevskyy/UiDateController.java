package com.yanevskyy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;

/**
 * Takes date on string format as parameter.
 */
public class UiDateController implements ReceiverDates {
    private static Logger LOGGER = LoggerFactory.getLogger(UiDateController.class);
    private ParserDates service;

    public UiDateController(ParserDates service) {
        this.service = service;
    }

    public String parseDate(String date) throws ParseException {
        LOGGER.info("Controller UI get date " + date);
            return service.parseDate(date);
    }
}
