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
     * The Middle name.
     */
    private String middleName;

    /**
     * The Last name.
     */
    private String lastName;

    /**
     * The Date of birth.
     */
    private String dateOfBirth;

    private String gender;
    /**
     * The Issuing authority.
     */
    private String issuingAuthority;

    /**
     * The Document type.
     */
    private String documentType;

    /**
     * The Document title.
     */
    private String documentTitle;

    /**
     * The Issuing state.
     */
    private String docIssuer;

    /**
     * The Document number.
     */
    private String documentId;

    private String docIssuanceDate;

    /**
     * The License expiration date.
     */
    private String docExpirationDate;

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
    @XmlElement(name = "docId")
    public String getDocumentId() {
        return documentId;
    }

    /**
     * Sets document nuber.
     *
     * @param documentId the document nuber
     */
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    @XmlElement(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @XmlElement(name = "docIssuanceDate")
    public String getDocIssuanceDate() {
        return docIssuanceDate;
    }

    public void setDocIssuanceDate(String docIssuanceDate) {
        this.docIssuanceDate = docIssuanceDate;
    }

    @Override
    public String toString() {
        return "IDPDocument{" +
                "suffix='" + suffix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", issuingAuthority='" + issuingAuthority + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentTitle='" + documentTitle + '\'' +
                ", docIssuer='" + docIssuer + '\'' +
                ", documentId='" + documentId + '\'' +
                ", docIssuanceDate='" + docIssuanceDate + '\'' +
                ", docExpirationDate='" + docExpirationDate + '\'' +
                '}';
    }
}
