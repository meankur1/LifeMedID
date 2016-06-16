package com.medallies.lifemedid.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "uploader")
public class Uploader {


    private String transactionId;

    private String personId;

    private String organizationId;

    @XmlElement(name = "transactionID")
    public String getTransactionId () {
        return transactionId;
    }

    public void setTransactionId (String transactionId) {
        this.transactionId = transactionId;
    }

    @XmlElement(name = "personID")
    public String getPersonId () {
        return personId;
    }

    public void setPersonId (String personId) {
        this.personId = personId;
    }

    @XmlElement(name = "orgID")
    public String getOrganizationId () {
        return organizationId;
    }

    public void setOrganizationId (String organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!( o instanceof Uploader )) return false;

        Uploader uploader = (Uploader) o;

        if (getTransactionId( ) != null ? !getTransactionId( ).equals(uploader.getTransactionId( )) : uploader
                .getTransactionId( ) != null)
            return false;
        if (getPersonId( ) != null ? !getPersonId( ).equals(uploader.getPersonId( )) : uploader.getPersonId( ) != null)
            return false;
        return !( getOrganizationId( ) != null ? !getOrganizationId( ).equals(uploader.getOrganizationId( )) : uploader
                .getOrganizationId( ) != null );

    }

    @Override
    public int hashCode () {
        int result = getTransactionId( ) != null ? getTransactionId( ).hashCode( ) : 0;
        result = 31 * result + ( getPersonId( ) != null ? getPersonId( ).hashCode( ) : 0 );
        result = 31 * result + ( getOrganizationId( ) != null ? getOrganizationId( ).hashCode( ) : 0 );
        return result;
    }

    @Override
    public String toString () {
        return "Uploader{" +
                "transactionId='" + transactionId + '\'' +
                ", personId='" + personId + '\'' +
                ", organizationId='" + organizationId + '\'' +
                '}';
    }
}
