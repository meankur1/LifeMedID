package com.medallies.lifemedid.exception;

/**
 * This class is ListEmptyException
 */
public class ListEmptyException extends RuntimeException {

    // private static final Logger logger = Logger.getLogger( ListEmptyException.class );

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = -4617909591581505624L;

    /**
     * The Message.
     */
    private String message = "   \nEmpty List or invoked an incorrect time ";

    /**
     * Instantiates a new List empty exception.
     */
    public ListEmptyException () {

        super( );
    }

    /**
     * Instantiates a new List empty exception.
     *
     * @param message the message
     */
    public ListEmptyException (String message) {

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
    @Override
    public String toString () {

        return message;
    }
}
