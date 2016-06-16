package com.medallies.lifemedid.common;


import com.medallies.lifemedid.constants.DAOConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The type NumberCommons.
 */
public class NumberCommons {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(NumberCommons.class);

    /**
     * Convert to long array long [ ].
     *
     * @param split the split
     * @return the long [ ]
     */
    public static Long[] convertToLongArray (final String[] split) {

        Long longArray[] = new Long[ split.length ];
        for (int i = 0; i < split.length; i++) {
            try {
                longArray[ i ] = Long.parseLong(split[ i ]);
            } catch ( RuntimeException exception ) {
                logger.debug("Failed to parse long value for string value: " + split[ i ]);
            }
        }
        return longArray;
    }

    /**
     * Convert to double array double [ ].
     *
     * @param split the split
     * @return the double [ ]
     */
    public static Double[] convertToDoubleArray (final String[] split) {

        Double doubleArray[] = new Double[ split.length ];
        for (int i = 0; i < split.length; i++) {
            try {
                doubleArray[ i ] = Double.parseDouble(split[ i ]);
            } catch ( RuntimeException exception ) {
                logger.debug("Failed to parse double value for string value: " + split[ i ]);
            }
        }
        return doubleArray;
    }

    /**
     * Validate type of object string.
     *
     * @param value the value
     * @return the string
     */
    public static String validateTypeOfObject (final Object value) {

        try {
            Long long1 = Long.parseLong(String.valueOf(value));
            return DAOConstants.LONG;
        } catch ( RuntimeException ex ) {
            logger.debug("Value provided was not of long type");
        }
        try {
            Double double1 = Double.parseDouble(String.valueOf(value));
            return DAOConstants.DOUBLE;
        } catch ( RuntimeException ex ) {
            logger.debug("Value provided was not of double type");
        }
        logger.debug("Provided Value was: " + value);
        return DAOConstants.STRING;
    }
}