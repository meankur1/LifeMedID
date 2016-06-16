package com.medallies.lifemedid.exception;

/**
 * The type No data found exception.
 */
public class NoDataFoundException extends Exception {

    /**
     * The Message.
     */
    private String message = "Exception occurred while trying to fetch existing data";

    /**
     * Constructs a new exception with {@code null} as its detail message. The cause is not initialized, and may
     * subsequently be initialized by a call to {@link #initCause}.
     */
    public NoDataFoundException () {

        super( );
    }

    /**
     * Constructs a new exception with the specified detail message. The cause is not initialized, and may subsequently
     * be initialized by a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the method.
     */
    public NoDataFoundException (final String message) {

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
    @Override
    public String toString () {

        return message;
    }
}
