package com.medallies.lifemedid.service.container;

import com.medallies.lifemedid.dto.payload.LifeMedDocumentPayload;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * The type Customer response container.
 *
 * @param <T> the type parameter
 */
@XmlRootElement(name = "response", namespace = "http://localhost:8080/LifeMedID/")
@XmlSeeAlso({ LifeMedDocumentPayload.class, ResponseContainer.class })
public class LifeMedDocumentResponseContainer<T> extends ResponseContainer<T> {

    /**
     * The Transaction id.
     */
    private String transactionId;

    /**
     * The Status.
     */
    private String status;

    /**
     * The Timestamp.
     */
    private String timestamp;

    /**
     * The Description.
     */
    private String description;

    /**
     * Gets transaction id.
     *
     * @return the transaction id
     */
    @XmlElement
    public String getTransactionId () {
        return transactionId;
    }

    /**
     * Sets transaction id.
     *
     * @param transactionId the transaction id
     */
    public void setTransactionId (String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    @XmlElement
    public String getStatus () {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus (String status) {
        this.status = status;
    }

    /**
     * Gets timestamp.
     *
     * @return the timestamp
     */
    @XmlElement
    public String getTimestamp () {
        return timestamp;
    }

    /**
     * Sets timestamp.
     *
     * @param timestamp the timestamp
     */
    public void setTimestamp (String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    @XmlElement
    public String getDescription () {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription (String description) {
        this.description = description;
    }
}
