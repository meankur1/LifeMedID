package com.medallies.lifemedid.exception;

/**
 * Created by Bloom/Rono on 4/14/2015. This class is EmptyPropertyException
 */
public class EmptyPropertyException extends Exception {

    /**
     * The Message.
     */
    private String message = "Exception occurred while constructing an email";

    /**
     * Constructs a new exception with {@code null} as its detail message. The cause is not initialized, and may
     * subsequently be initialized by a call to {@link #initCause}.
     */
    public EmptyPropertyException () {

        super( );
    }

    /**
     * Constructs a new exception with the specified detail message. The cause is not initialized, and may subsequently
     * be initialized by a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the method.
     */
    public EmptyPropertyException (final String message) {

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
