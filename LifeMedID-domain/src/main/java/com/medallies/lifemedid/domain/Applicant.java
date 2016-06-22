package com.medallies.lifemedid.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The type Applicant.
 */
@Entity
@Table(name = "applicants")
public class Applicant {

    /**
     * The Id.
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * The Suffix.
     */
    @Column(name = "suffix")
    private String suffix;

    /**
     * The First name.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * The Middle name.
     */
    @Column(name = "middle_name")
    private String middleName;

    /**
     * The Last name.
     */
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "level_of_assurance")
    private String levelOfAssurance;

    @Column(name = "gender")
    private String gender;

    /**
     * The Date of birth.
     */
    @Column(name = "date_of_birth")
    private String dateOfBirth;

    /**
     * The Created date.
     */
    @Column(name = "created_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    /**
     * The Updated date.
     */
    @Column(name = "updated_date")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date updatedDate;

    /**
     * The Life med document.
     */
    @OneToOne(mappedBy = "applicant", cascade = { CascadeType.REFRESH, CascadeType.PERSIST })
    private LifeMedDocument lifeMedDocument;

    /**
     * The Idp documents.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "applicant")
    private List<IDPDocument> idpDocuments;

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId () {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId (String id) {
        this.id = id;
    }

    /**
     * Gets suffix.
     *
     * @return the suffix
     */
    public String getSuffix () {
        return suffix;
    }

    /**
     * Sets suffix.
     *
     * @param suffix the suffix
     */
    public void setSuffix (String suffix) {
        this.suffix = suffix;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName () {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets middle name.
     *
     * @return the middle name
     */
    public String getMiddleName () {
        return middleName;
    }

    /**
     * Sets middle name.
     *
     * @param middleName the middle name
     */
    public void setMiddleName (String middleName) {
        this.middleName = middleName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName () {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getLevelOfAssurance () {
        return levelOfAssurance;
    }

    public void setLevelOfAssurance (String levelOfAssusance) {
        this.levelOfAssurance = levelOfAssusance;
    }

    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public String getDateOfBirth () {
        return dateOfBirth;
    }

    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth (String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets created date.
     *
     * @return the created date
     */
    public Date getCreatedDate () {
        return createdDate;
    }

    /**
     * Sets created date.
     *
     * @param createdDate the created date
     */
    public void setCreatedDate (Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets updated date.
     *
     * @return the updated date
     */
    public Date getUpdatedDate () {
        return updatedDate;
    }

    /**
     * Sets updated date.
     *
     * @param updatedDate the updated date
     */
    public void setUpdatedDate (Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * Gets life med document.
     *
     * @return the life med document
     */
    public LifeMedDocument getLifeMedDocument () {
        return lifeMedDocument;
    }

    /**
     * Sets life med document.
     *
     * @param lifeMedDocument the life med document
     */
    public void setLifeMedDocument (LifeMedDocument lifeMedDocument) {
        this.lifeMedDocument = lifeMedDocument;
    }

    /**
     * Gets idp documents.
     *
     * @return the idp documents
     */
    public List<IDPDocument> getIdpDocuments () {
        return idpDocuments;
    }

    /**
     * Sets idp documents.
     *
     * @param idpDocuments the idp documents
     */
    public void setIdpDocuments (List<IDPDocument> idpDocuments) {
        this.idpDocuments = idpDocuments;
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
        if (!( o instanceof Applicant )) return false;

        Applicant applicant = (Applicant) o;

        if (!getId( ).equals(applicant.getId( ))) return false;
        if (!getFirstName( ).equals(applicant.getFirstName( ))) return false;
        if (!getLastName( ).equals(applicant.getLastName( ))) return false;
        return getDateOfBirth( ).equals(applicant.getDateOfBirth( ));

    }

    /**
     * Hash code int.
     *
     * @return the int
     */
    @Override
    public int hashCode () {
        int result = getId( ).hashCode( );
        result = 31 * result + getFirstName( ).hashCode( );
        result = 31 * result + getLastName( ).hashCode( );
        result = 31 * result + getDateOfBirth( ).hashCode( );
        return result;
    }
}
