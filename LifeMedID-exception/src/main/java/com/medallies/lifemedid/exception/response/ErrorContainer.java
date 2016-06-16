package com.medallies.lifemedid.exception.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Error container.
 */
@XmlRootElement(name = "error_container")
public class ErrorContainer {

    /**
     * The Current error.
     */
    private Error currentError;

    /**
     * The Errors.
     */
    private List<Error> errors;

    /**
     * Instantiates a new Error container.
     */
    public ErrorContainer () {

        this.instantiateErrors( );
    }

    /**
     * Instantiates a new Error container.
     *
     * @param currentError the current error
     */
    public ErrorContainer (final Error currentError) {

        this.instantiateErrors( );
        this.setCurrentError(currentError);
    }

    /**
     * Instantiate errors.
     */
    private void instantiateErrors () {
        errors = new ArrayList<Error>( );
    }

    /**
     * Gets current error.
     *
     * @return the current error
     */
    public Error getCurrentError () {
        return currentError;
    }

    /**
     * Sets current error.
     *
     * @param currentError the current error
     */
    @XmlTransient
    public void setCurrentError (final Error currentError) {
        this.currentError = currentError;
        this.addError(currentError);
    }

    /**
     * Gets errors.
     *
     * @return the errors
     */
    public List<Error> getErrors () {
        return errors;
    }

    /**
     * Sets errors.
     *
     * @param errors the errors
     */
    @XmlElementWrapper(name = "errors")
    @XmlElement
    public void setErrors (final List<Error> errors) {
        this.errors = errors;
    }

    /**
     * This method is for adding a new currentError to the errors list object. To set the current currentError object
     * use setCurrentError
     *
     * @param error the error
     */
    public void addError (final Error error) {
        this.errors.add(error);
    }
}
