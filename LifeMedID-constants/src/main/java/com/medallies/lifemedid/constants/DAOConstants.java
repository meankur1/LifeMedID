package com.medallies.lifemedid.constants;

/**
 * The type DAO constants.
 */
public final class DAOConstants {

    /**
     * The constant ONE.
     */
    public static final int ONE = 1;

    /**
     * The constant ZERO.
     */
    public static final int ZERO = 0;

    /**
     * The constant THREE.
     */
    public static final int THREE = 3;

    /**
     * The constant TWO.
     */
    public static final int TWO = 2;

    /**
     * The constant ASC.
     */
    public static final String ASC = "asc";

    /**
     * The constant DESC.
     */
    public static final String DESC = "desc";


    /**
     * The constant DEFAULT_PAGE_LIMIT.
     */
    public static final int DEFAULT_PAGE_LIMIT = 25;

    /**
     * The constant STRING_ZERO.
     */
    public static final String STRING_ZERO = "0";

    /**
     * The constant DEFAULT_STRING_PAGE_LIMIT.
     */
    public static final String DEFAULT_STRING_PAGE_LIMIT = "25";

    /**
     * The constant FALSE.
     */
    public static final String FALSE = "false";

    /**
     * The constant HASH.
     */
    public static final String HASH = "#";

    /**
     * The constant IS_ERROR.
     */
    public static final boolean IS_ERROR = false;

    /**
     * The constant TIME_FORMAT.
     */
    public static final String TIME_FORMAT = "HH:mm";

    /**
     * The constant TIME_SEPARATOR_FORMAT.
     */
    public static final String TIME_SEPARATOR_FORMAT = ":";

    /**
     * The constant DEFAULT_DATE_FORMAT. "yyyy-MM-dd HH:mm:ss"
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

    /**
     * The constant DEFAULT_DATE_LIMIT_FORMAT.
     */
    public static final String DEFAULT_DATE_LIMIT_FORMAT = "yy-MM-dd";

    /**
     * The constant STRING.
     */
    public static final String STRING = "string";

    /**
     * The constant LIST_STRING.
     */
    public static final String LIST_STRING = "List";

    /**
     * The constant LONG.
     */
    public static final String LONG = "long";

    /**
     * The constant DOUBLE.
     */
    public static final String DOUBLE = "double";

    /**
     * The constant OK.
     */
    public static final String OK = "OK";


    /**
     * To string from number.
     *
     * @param number the number
     * @return the string
     */
    public static String toStringFromNumber (final int number) {

        Integer integer = number;
        return integer.toString( );
    }

    /**
     * To number from string.
     *
     * @param number the number
     * @return the integer
     */
    public static Integer toNumberFromString (final String number) {

        return Integer.parseInt(number);
    }
}
