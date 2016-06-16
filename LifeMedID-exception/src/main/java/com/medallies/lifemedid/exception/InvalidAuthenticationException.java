package com.medallies.lifemedid.exception;

/**
 * The type Invalid authentication exception.
 */
public class InvalidAuthenticationException extends RuntimeException {

    /**
     * The Message.
     */
    private String message = "Authentication Failure ";

    /**
     * Instantiates a new Invalid authentication exception.
     */
    public InvalidAuthenticationException () {
        super( );
    }

    /**
     * Instantiates a new Invalid authentication exception.
     *
     * @param message the message
     */
    public InvalidAuthenticationException (String message) {

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
