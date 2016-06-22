package com.medallies.lifemedid.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "uploader")
public class Uploader {


    private String transactionId;

    private String registarId;

    private String organizationId;

    @XmlElement(name = "transactionID")
    public String getTransactionId () {
        return transactionId;
    }

    public void setTransactionId (String transactionId) {
        this.transactionId = transactionId;
    }

    @XmlElement(name = "registarID")
    public String getRegistarId () {
        return registarId;
    }

    public void setRegistarId (String registarId) {
        this.registarId = registarId;
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
                ", registarId='" + registarId + '\'' +
                ", organizationId='" + organizationId + '\'' +
                '}';
    }
}
