package com.medallies.lifemedid.common;

import com.medallies.lifemedid.constants.DAOConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The type Date commons.
 */
public class DateCommons {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(DateCommons.class);

    /**
     * The constant dateFormat.
     */
    private static String dateFormat = DAOConstants.DEFAULT_DATE_LIMIT_FORMAT;

    /**
     * Gets start date time.
     *
     * @param eventDate the event date
     * @return the start date time
     */
    public static Date getStartDateTime (final Date eventDate) {
        String location = DateCommons.class.getCanonicalName( ) + "#getStartDateTime()";
        logger.debug("Starting " + location);
        Calendar calendar = createNGetCustomCalendar(eventDate, 0);
        logger.debug("Finishing " + location);
        return calendar.getTime( );
    }

    /**
     * Gets end date time.
     *
     * @param eventDate the event date
     * @return the end date time
     */
    public static Date getEndDateTime (final Date eventDate) {

        String location = DateCommons.class.getCanonicalName( ) + "#getEndDateTime()";
        logger.debug("Starting " + location);
        Calendar calendar = createNGetCustomCalendar(eventDate, 59);
        logger.debug("Finishing " + location);
        return calendar.getTime( );
    }

    /**
     * Create n get custom calendar.
     *
     * @param date      the date
     * @param minsNSecs the mins n secs
     * @return the calendar
     */
    private static Calendar createNGetCustomCalendar (Date date, int minsNSecs) {

        Calendar calendar = Calendar.getInstance( );
        calendar.setTime(date);
        calendar.set(Calendar.SECOND, minsNSecs);
        calendar.set(Calendar.MINUTE, minsNSecs);
        return calendar;
    }

    /**
     * Update date to prev hour. Complex method for return the date taht was 1 hour before the date passed in
     *
     * @param eventDate the event date
     * @return the date
     */
    public static Date updateDateToPrevHour (final Date eventDate) {

        String location = DateCommons.class.getCanonicalName( ) + "#updateDateToPrevHour()";
        logger.debug("Starting " + location);
        Calendar calendar = Calendar.getInstance( );
        calendar.setTime(eventDate);
        int hour;
        if (calendar.get(Calendar.HOUR_OF_DAY) != 0) {
            hour = calendar.get(Calendar.HOUR_OF_DAY) - 1;
            calendar.set(Calendar.HOUR_OF_DAY, hour);
        } else {
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
                if (calendar.get(Calendar.MONTH) == 1) {
                    int year = calendar.get(Calendar.YEAR) - 1;
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, Calendar.DECEMBER);
                    calendar.set(Calendar.DAY_OF_MONTH, 31);
                } else {
                    int month = calendar.get(Calendar.MONTH) - 1;
                    calendar.set(Calendar.MONTH, month);
                    calendar.set(Calendar.DAY_OF_MONTH, calendar.getMaximum(Calendar.DAY_OF_MONTH));
                }

            } else {
                int day = calendar.get(Calendar.DAY_OF_MONTH) - 1;
                calendar.set(Calendar.DAY_OF_MONTH, day);
            }
        }
//        logger.debug( eventDate + " -- old \n" + calendar.getTime( ) + " -- new" );
        logger.info("New Date date is " + calendar.getTime( ));
        logger.debug("Finishing " + location);
        return calendar.getTime( );
    }

    /**
     * Gets date string from date timestamp.
     *
     * @param timestamp the timestamp
     * @return the date string from date timestamp
     */
    public static String getDateStringFromDateTimestamp (Date timestamp) {
        String location = "com.medallies.lifemedid.common.DateCommons#getDateStringFromDateTimestamp()";
        logger.debug("Starting " + location);

        String dateFormat = "yyyy-MMdd-HHmmss-SSSSSS";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        String dateString = simpleDateFormat.format(timestamp);

        logger.debug("Finishing " + location);
        return dateString;
    }
}
