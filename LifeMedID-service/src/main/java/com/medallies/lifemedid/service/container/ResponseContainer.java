package com.medallies.lifemedid.service.container;


import com.medallies.lifemedid.exception.response.ErrorContainer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The type Response container.
 *
 * @param <T> the type parameter
 */
@XmlRootElement(name = "response")
public class ResponseContainer<T> {

    /**
     * The Payload.
     */
    private T payload;

    /**
     * The Error container.
     */
    private ErrorContainer errorContainer;

    /**
     * Gets payload.
     *
     * @return the payload
     */
    @XmlElement(name = "payload")
    public T getPayload () {
        return payload;
    }

    /**
     * Sets payload.
     *
     * @param payload the payload
     */
    public void setPayload (T payload) {
        this.payload = payload;
    }

    /**
     * Gets error container.
     *
     * @return the error container
     */
    @XmlElement(name = "error_container")
    public ErrorContainer getErrorContainer () {
        return errorContainer;
    }

    /**
     * Sets error container.
     *
     * @param errorContainer the error container
     */
    public void setErrorContainer (ErrorContainer errorContainer) {
        this.errorContainer = errorContainer;
    }
}
