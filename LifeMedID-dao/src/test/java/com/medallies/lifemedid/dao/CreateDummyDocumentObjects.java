package com.medallies.lifemedid.dao;

import com.medallies.lifemedid.domain.Applicant;
import com.medallies.lifemedid.domain.IDPDocument;
import com.medallies.lifemedid.domain.LifeMedDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The type Create dummy document objects.
 */
public class CreateDummyDocumentObjects {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(CreateDummyDocumentObjects.class);

    /**
     * Create life med document domain life med document.
     *
     * @return the life med document
     */
    public static LifeMedDocument createLifeMedDocumentDomain () {

        LifeMedDocument lifeMedDocumentDomain = new LifeMedDocument( );

        lifeMedDocumentDomain.setTransactionId("transaction-test-1");
        lifeMedDocumentDomain.setRegisterId("person-test-1");
        lifeMedDocumentDomain.setOrganizationId("org-test-1");
        lifeMedDocumentDomain.setTimeStamp(new Date());

        Applicant applicantDomain = new Applicant( );
        applicantDomain.setId("ID12");
        applicantDomain.setFirstName("firstName12");
        applicantDomain.setLevelOfAssurance("level1");
        applicantDomain.setLastName("lastName12");
        applicantDomain.setDateOfBirth("12-01-1989");
        applicantDomain.setLifeMedDocument(lifeMedDocumentDomain);

        IDPDocument idpDocumentDomain = new IDPDocument( );

        idpDocumentDomain.setDocumentType("A1");
        idpDocumentDomain.setDocumentNumber("PP-123-431-9633");
        idpDocumentDomain.setDocumentTitle("Passport");

        idpDocumentDomain.setFirstName("firstName12");
        idpDocumentDomain.setLastName("lastName12");
        idpDocumentDomain.setMiddleName("firstName12");
        idpDocumentDomain.setDateOfBirth("12-01-1989");

        idpDocumentDomain.setDocExpirationDate("12-02-2019");

        idpDocumentDomain.setDocIssuer("ND");
        idpDocumentDomain.setIssuingAuthority("ND");


        idpDocumentDomain.setApplicant(applicantDomain);

        List<IDPDocument> idpDocumentList = new ArrayList<IDPDocument>( );
        idpDocumentList.add(idpDocumentDomain);

        lifeMedDocumentDomain.setApplicant(applicantDomain);
        applicantDomain.setIdpDocuments(idpDocumentList);

        return lifeMedDocumentDomain;

    }
}
