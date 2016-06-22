package com.medallies.lifemedid.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "uploader")
public class Uploader {


    private String transactionId;

    private String registerId;

    private String organizationId;

    @XmlElement(name = "transactionID")
    public String getTransactionId () {
        return transactionId;
    }

    public void setTransactionId (String transactionId) {
        this.transactionId = transactionId;
    }

    @XmlElement(name = "registerID")
    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    @XmlElement(name = "orgID")
    public String getOrganizationId () {
        return organizationId;
    }

    public void setOrganizationId (String organizationId) {
        this.organizationId = organizationId;
    }


    @Override
    public String toString () {
        return "Uploader{" +
                "transactionId='" + transactionId + '\'' +
                ", registerId='" + registerId + '\'' +
                ", organizationId='" + organizationId + '\'' +
                '}';
    }
}
