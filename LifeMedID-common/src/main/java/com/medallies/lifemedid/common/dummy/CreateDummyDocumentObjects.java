package com.medallies.lifemedid.common.dummy;

import com.medallies.lifemedid.dto.Applicant;
import com.medallies.lifemedid.dto.IDPDocument;
import com.medallies.lifemedid.dto.LifeMedDocument;
import com.medallies.lifemedid.dto.Uploader;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Create dummy document objects.
 */
public class CreateDummyDocumentObjects {

    /**
     * Create life med document domain life med document.
     *
     * @return the life med document
     */
    public static LifeMedDocument createLifeMedDocumentDomain () {

        LifeMedDocument lifeMedDocumentDTO = new LifeMedDocument( );

        Uploader uploaderDTO = new Uploader();

        uploaderDTO.setTransactionId("transaction-test-2");
        uploaderDTO.setPersonId("person-test-2");
        uploaderDTO.setOrganizationId("org-test-2");

        Applicant applicantDTO = new Applicant( );
        applicantDTO.setId("ID12");
        applicantDTO.setFirstName("firstName12");
        applicantDTO.setLastName("lastName12");
        applicantDTO.setLevelOfAssurance("level2");
        applicantDTO.setDateOfBirth("1989-11-12");

        IDPDocument idpDocumentDTO = new IDPDocument( );

        idpDocumentDTO.setDocumentType("A1");
        idpDocumentDTO.setDocumentNumber("PP-123-431-9622");
        idpDocumentDTO.setDocumentTitle("Passport");

        idpDocumentDTO.setFirstName("firstName12");
        idpDocumentDTO.setLastName("lastName12");
        idpDocumentDTO.setMiddleName("firstName12");
        idpDocumentDTO.setDateOfBirth("1989-03-12");
        idpDocumentDTO.setDocExpirationDate("2019-02-12");
        idpDocumentDTO.setDocIssuer("MN");
        idpDocumentDTO.setIssuingAuthority("MN");

        List<IDPDocument> idpDocumentList = new ArrayList<IDPDocument>( );
        idpDocumentList.add(idpDocumentDTO);

        lifeMedDocumentDTO.setUploader(uploaderDTO);
        lifeMedDocumentDTO.setApplicant(applicantDTO);
        lifeMedDocumentDTO.setIdpDocumentList(idpDocumentList);

        return lifeMedDocumentDTO;

    }
}
