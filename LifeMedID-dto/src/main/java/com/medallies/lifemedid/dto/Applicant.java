package com.medallies.lifemedid.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The type Applicant.
 */
//TODO add namespace to applicant check with architect
@XmlRootElement(name = "applicant")
public class Applicant {

    private String suffix;

    /**
     * The First name.
     */
    private String firstName;

    private String middleName;

    /**
     * The Last name.
     */
    private String lastName;

    private String gender;
    private String levelOfAssurance;

    /**
     * The Date of birth.
     */
    private String dateOfBirth;

    /**
     * The Id.
     */
    private String id;

    @XmlElement(name = "suffix")
    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    @XmlElement(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    @XmlElement(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    @XmlElement(name = "gender")
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement(name = "levelOfAssurance")
    public String getLevelOfAssurance() {
        return levelOfAssurance;
    }

    public void setLevelOfAssurance(String levelOfAssurance) {
        this.levelOfAssurance = levelOfAssurance;
    }

    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    @XmlElement(name = "dateOfBirth")
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets date of birth.
     *
     * @param dateOfBirth the date of birth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    @XmlElement(name = "id")
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Applicant)) return false;

        Applicant applicant = (Applicant) o;

        if (getFirstName() != null ? !getFirstName().equals(applicant.getFirstName()) : applicant.getFirstName()
                != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(applicant.getLastName()) : applicant.getLastName() !=
                null)
            return false;
        if (getDateOfBirth() != null ? !getDateOfBirth().equals(applicant.getDateOfBirth()) : applicant
                .getDateOfBirth() != null)
            return false;
        return !(getId() != null ? !getId().equals(applicant.getId()) : applicant.getId() != null);

    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + (getId() != null ? getId().hashCode() : 0);
        return result;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Applicant{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
