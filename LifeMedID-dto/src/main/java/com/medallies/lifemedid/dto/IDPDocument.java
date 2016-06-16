package com.medallies.lifemedid.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The type Idp documents.
 */
//TODO add namespace to idpdocs check with architect
@XmlRootElement(name = "IDPdocs")
public class IDPDocument {

    private String suffix;

    /**
     * The First name.
     */
    private String firstName;

    /**
     * The Last name.
     */
    private String lastName;

    /**
     * The Middle name.
     */
    private String middleName;

    /**
     * The Date of birth.
     */
    private String dateOfBirth;

    /**
     * The Issuing authority.
     */
    private String issuingAuthority;

    /**
     * The Issuing state.
     */
    private String docIssuer;

    /**
     * The License expiration date.
     */
    private String docExpirationDate;

    /**
     * The Document type.
     */
    private String documentType;

    /**
     * The Document title.
     */
    private String documentTitle;

    /**
     * The Document number.
     */
    private String documentNumber;


    @XmlElement(name = "suffix")
    public String getSuffix () {
        return suffix;
    }

    public void setSuffix (String suffix) {
        this.suffix = suffix;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    @XmlElement(name = "firstName")
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
     * Gets last name.
     *
     * @return the last name
     */
    @XmlElement(name = "lastName")
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

    /**
     * Gets middle name.
     *
     * @return the middle name
     */
    @XmlElement(name = "middleName")
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
     * Gets date of birth.
     *
     * @return the date of birth
     */
    @XmlElement(name = "dateOfBirth")
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

    /**
     * Gets issuing authority.
     *
     * @return the issuing authority
     */
    @XmlElement(name = "issuingAuthority")
    public String getIssuingAuthority () {
        return issuingAuthority;
    }

    /**
     * Sets issuing authority.
     *
     * @param issuingAuthority the issuing authority
     */
    public void setIssuingAuthority (String issuingAuthority) {
        this.issuingAuthority = issuingAuthority;
    }

    /**
     * Gets issuing state.
     *
     * @return the issuing state
     */
    @XmlElement(name = "docIssuer")
    public String getDocIssuer () {
        return docIssuer;
    }

    /**
     * Sets issuing state.
     *
     * @param docIssuer the issuing state
     */
    public void setDocIssuer (String docIssuer) {
        this.docIssuer = docIssuer;
    }

    /**
     * Gets license expiration date.
     *
     * @return the license expiration date
     */
    @XmlElement(name = "docExpirationDate")
    public String getDocExpirationDate () {
        return docExpirationDate;
    }

    /**
     * Sets license expiration date.
     *
     * @param docExpirationDate the license expiration date
     */
    public void setDocExpirationDate (String docExpirationDate) {
        this.docExpirationDate = docExpirationDate;
    }

    /**
     * Gets document type.
     *
     * @return the document type
     */
    @XmlElement(name = "docType")
    public String getDocumentType () {
        return documentType;
    }

    /**
     * Sets document type.
     *
     * @param documentType the document type
     */
    public void setDocumentType (String documentType) {
        this.documentType = documentType;
    }

    /**
     * Gets document title.
     *
     * @return the document title
     */
    @XmlElement(name = "docTitle")
    public String getDocumentTitle () {
        return documentTitle;
    }

    /**
     * Sets document title.
     *
     * @param documentTitle the document title
     */
    public void setDocumentTitle (String documentTitle) {
        this.documentTitle = documentTitle;
    }

    /**
     * Gets document number.
     *
     * @return the document number
     */
    @XmlElement(name = "docNumber")
    public String getDocumentNumber () {
        return documentNumber;
    }

    /**
     * Sets document nuber.
     *
     * @param documentNumber the document nuber
     */
    public void setDocumentNumber (String documentNumber) {
        this.documentNumber = documentNumber;
    }


    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!( o instanceof IDPDocument )) return false;

        IDPDocument that = (IDPDocument) o;

        if (getFirstName( ) != null ? !getFirstName( ).equals(that.getFirstName( )) : that.getFirstName( ) != null)
            return false;
        if (getLastName( ) != null ? !getLastName( ).equals(that.getLastName( )) : that.getLastName( ) != null)
            return false;
        if (getMiddleName( ) != null ? !getMiddleName( ).equals(that.getMiddleName( )) : that.getMiddleName( ) != null)
            return false;
        if (getDateOfBirth( ) != null ? !getDateOfBirth( ).equals(that.getDateOfBirth( )) : that.getDateOfBirth( ) !=
                null)
            return false;
        if (getIssuingAuthority( ) != null ? !getIssuingAuthority( ).equals(that.getIssuingAuthority( )) : that
                .getIssuingAuthority( ) != null)
            return false;
        if (getDocIssuer( ) != null ? !getDocIssuer( ).equals(that.getDocIssuer( )) : that.getDocIssuer( ) != null)
            return false;
        if (getDocExpirationDate( ) != null ? !getDocExpirationDate( ).equals(that.getDocExpirationDate( )) : that
                .getDocExpirationDate( ) != null)
            return false;
        if (getDocumentType( ) != null ? !getDocumentType( ).equals(that.getDocumentType( )) : that.getDocumentType(

        ) != null)
            return false;
        if (getDocumentTitle( ) != null ? !getDocumentTitle( ).equals(that.getDocumentTitle( )) : that
                .getDocumentTitle( ) != null)
            return false;
        return !( getDocumentNumber( ) != null ? !getDocumentNumber( ).equals(that.getDocumentNumber( )) : that
                .getDocumentNumber( ) != null );

    }

    @Override
    public int hashCode () {
        int result = getFirstName( ) != null ? getFirstName( ).hashCode( ) : 0;
        result = 31 * result + ( getLastName( ) != null ? getLastName( ).hashCode( ) : 0 );
        result = 31 * result + ( getMiddleName( ) != null ? getMiddleName( ).hashCode( ) : 0 );
        result = 31 * result + ( getDateOfBirth( ) != null ? getDateOfBirth( ).hashCode( ) : 0 );
        result = 31 * result + ( getIssuingAuthority( ) != null ? getIssuingAuthority( ).hashCode( ) : 0 );
        result = 31 * result + ( getDocIssuer( ) != null ? getDocIssuer( ).hashCode( ) : 0 );
        result = 31 * result + ( getDocExpirationDate( ) != null ? getDocExpirationDate( ).hashCode( ) : 0 );
        result = 31 * result + ( getDocumentType( ) != null ? getDocumentType( ).hashCode( ) : 0 );
        result = 31 * result + ( getDocumentTitle( ) != null ? getDocumentTitle( ).hashCode( ) : 0 );
        result = 31 * result + ( getDocumentNumber( ) != null ? getDocumentNumber( ).hashCode( ) : 0 );
        return result;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString () {
        return "IDPDocument{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", docIssuer='" + docIssuer + '\'' +
                ", docExpirationDate='" + docExpirationDate + '\'' +
                ", documentType='" + documentType + '\'' +
                '}';
    }
}
