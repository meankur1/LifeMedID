package com.medallies.lifemedid.exception;

import com.medallies.lifemedid.constants.DAOConstants;

/**
 * Created by IntelliJ IDEA.
 */
public class IllegalSearchListSizeException extends RuntimeException {

    /**
     * The Message.
     */
    private String message = "Size of Search String keywords cannot be Greater than "
            + DAOConstants.THREE + " OR Less " + "Than " + DAOConstants.ONE;

    /**
     * Instantiates a new Illegal search list size exception.
     */
    public IllegalSearchListSizeException () {
        super( );
    }

    /**
     * Instantiates a new Illegal search list size exception.
     *
     * @param message the message
     */
    public IllegalSearchListSizeException (String message) {

        super(message);
        this.message = message + this.message;
    }

    /**
     * Gets error.
     *
     * @return the error
     */
    public String getError () {
        return message;
    }

    /**
     * To string.
     *
     * @return the string
     */
    public String toString () {
        return message;
    }
}
