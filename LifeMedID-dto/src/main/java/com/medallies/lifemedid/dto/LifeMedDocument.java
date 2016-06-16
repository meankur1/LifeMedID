package com.medallies.lifemedid.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;

/**
 * The type Life med document.
 */
@XmlSeeAlso(value = { Applicant.class, IDPDocument.class })
@XmlRootElement(name = "lifeMedDocument")
public class LifeMedDocument {

    /**
     * The Idp document list.
     */
    private List<IDPDocument> idpDocumentList;

    /**
     * The Applicant.
     */
    private Applicant applicant;

    private Uploader uploader;

    @XmlElement(name = "uploader")
    public Uploader getUploader () {
        return uploader;
    }

    public void setUploader (Uploader uploader) {
        this.uploader = uploader;
    }

    /**
     * Gets idp document list.
     *
     * @return the idp document list
     */
    @XmlElement(name = "IDPdocs")
    public List<IDPDocument> getIdpDocumentList () {
        return idpDocumentList;
    }

    /**
     * Sets idp document list.
     *
     * @param idpDocumentList the idp document list
     */
    public void setIdpDocumentList (List<IDPDocument> idpDocumentList) {
        this.idpDocumentList = idpDocumentList;
    }

    /**
     * Gets applicant.
     *
     * @return the applicant
     */
    @XmlElement(name = "applicant")
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

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (!( o instanceof LifeMedDocument )) return false;

        LifeMedDocument that = (LifeMedDocument) o;

        if (getIdpDocumentList( ) != null ? !getIdpDocumentList( ).equals(that.getIdpDocumentList( )) : that
                .getIdpDocumentList( ) != null)
            return false;
        if (getApplicant( ) != null ? !getApplicant( ).equals(that.getApplicant( )) : that.getApplicant( ) != null)
            return false;
        return !( getUploader( ) != null ? !getUploader( ).equals(that.getUploader( )) : that.getUploader( ) != null );

    }

    @Override
    public int hashCode () {
        int result = getIdpDocumentList( ) != null ? getIdpDocumentList( ).hashCode( ) : 0;
        result = 31 * result + ( getApplicant( ) != null ? getApplicant( ).hashCode( ) : 0 );
        result = 31 * result + ( getUploader( ) != null ? getUploader( ).hashCode( ) : 0 );
        return result;
    }

    @Override
    public String toString () {
        return "LifeMedDocument{" +
                "idpDocumentList=" + idpDocumentList +
                ", applicant=" + applicant +
                ", uploader=" + uploader +
                '}';
    }
}
