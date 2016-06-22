package com.medallies.lifemedid.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * The type Life med document.
 */
@Entity
@Table(name = "lifemedid_transactions")
public class LifeMedDocument implements Serializable{

    /**
     * The Lifemed id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long lifemedId;

    /**
     * The Transaction id.
     */
    @Column(name = "transaction_id")
    private String transactionId;

    /**
     * The Organization id.
     */
    @Column(name = "organization_id")
    private String organizationId;

    /**
     * The Person id.
     */
    @Column(name = "registar_id")
    private String registerId;

    /**
     * The Time stamp.
     */
    @Column(name = "time_stamp")
    private Date timeStamp;

    /**
     * The Updated.
     */
    @Column(name = "updated")
    private Date updated;

    /**
     * The Applicant.
     */
    @OneToOne( cascade = {CascadeType.ALL})
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    private Applicant applicant;

    @OneToMany(mappedBy = "lifeMedDocument", cascade = {CascadeType.ALL})
    private List<TransactionDocs> transactionDocsList;

    /**
     * Gets lifemed id.
     *
     * @return the lifemed id
     */
    public Long getLifemedId () {
        return lifemedId;
    }

    /**
     * Sets lifemed id.
     *
     * @param lifemedId the lifemed id
     */
    public void setLifemedId (Long lifemedId) {
        this.lifemedId = lifemedId;
    }

    /**
     * Gets transaction id.
     *
     * @return the transaction id
     */
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
     * Gets organization id.
     *
     * @return the organization id
     */
    public String getOrganizationId () {
        return organizationId;
    }

    /**
     * Sets organization id.
     *
     * @param orgId the org id
     */
    public void setOrganizationId (String orgId) {
        this.organizationId = orgId;
    }

    /**
     * Gets person id.
     *
     * @return the person id
     */
    public String getRegisterId () {
        return registerId;
    }

    /**
     * Sets person id.
     *
     * @param personId the person id
     */
    public void setRegisterId (String personId) {
        this.registerId = personId;
    }

    /**
     * Gets time stamp.
     *
     * @return the time stamp
     */
    public Date getTimeStamp () {
        return timeStamp;
    }

    /**
     * Sets time stamp.
     *
     * @param timeStamp the time stamp
     */
    public void setTimeStamp (Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Gets updated.
     *
     * @return the updated
     */
    public Date getUpdated () {
        return updated;
    }

    /**
     * Sets updated.
     *
     * @param updated the updated
     */
    public void setUpdated (Date updated) {
        this.updated = updated;
    }

    /**
     * Gets applicant.
     *
     * @return the applicant
     */
    public Applicant getApplicant () {
        return applicant;
    }

    /**
     * Sets applicant.
     *
     * @param applicant the applicant
     */
    public void setApplicant (Applicant applicant) {
        this.applicant = applicant;
    }

    public List<TransactionDocs> getTransactionDocsList () {
        return transactionDocsList;
    }

    public void setTransactionDocsList (List<TransactionDocs> transactionDocsList) {
        this.transactionDocsList = transactionDocsList;
    }

    /**
     * Equals boolean.
     *
     * @param o the o
     * @return the boolean
     */
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!( o instanceof LifeMedDocument )) return false;

        LifeMedDocument that = (LifeMedDocument) o;

        if (getLifemedId( ) != null ? !getLifemedId( ).equals(that.getLifemedId( )) : that.getLifemedId( ) != null)
            return false;
        if (!getTransactionId( ).equals(that.getTransactionId( ))) return false;
        if (!getOrganizationId( ).equals(that.getOrganizationId( ))) return false;
        if (!getRegisterId( ).equals(that.getRegisterId( ))) return false;
        return !( getTimeStamp( ) != null ? !getTimeStamp( ).equals(that.getTimeStamp( )) : that.getTimeStamp( ) !=
                null );

    }

    /**
     * Hash code int.
     *
     * @return the int
     */
    @Override
    public int hashCode () {
        int result = getLifemedId( ) != null ? getLifemedId( ).hashCode( ) : 0;
        result = 31 * result + getTransactionId( ).hashCode( );
        result = 31 * result + getOrganizationId( ).hashCode( );
        result = 31 * result + getRegisterId( ).hashCode( );
        result = 31 * result + ( getTimeStamp( ) != null ? getTimeStamp( ).hashCode( ) : 0 );
        return result;
    }
}
