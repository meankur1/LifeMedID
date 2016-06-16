package com.medallies.lifemedid.converter;

import com.medallies.lifemedid.constants.DAOConstants;
import com.medallies.lifemedid.domain.Applicant;
import com.medallies.lifemedid.dto.IDPDocument;
import com.medallies.lifemedid.exception.IllegalArgumentValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Idp document domain dto converter.
 */
public class IDPDocumentDomainDTOConverter {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(IDPDocumentDomainDTOConverter.class);

    /**
     * The constant ZERO.
     */
    private static final int ZERO = DAOConstants.ZERO;

    /**
     * Gets converted iDPDocument dTO from iDPDocument domain.
     *
     * @param iDPDocumentDTO    the iDPDocument dTO
     * @param iDPDocumentDomain the iDPDocument domain
     * @return the converted iDPDocument dTO from iDPDocument domain
     */
    public static IDPDocument getConvertedDTOFromDomain (IDPDocument iDPDocumentDTO, com.medallies.lifemedid.domain
            .IDPDocument iDPDocumentDomain) {

        if (iDPDocumentDomain == null) {
            String message = "Parameter iDPDocumentDomain is required for conversion";
            logger.error(message);
            throw new NullPointerException(message);
        }

        if (iDPDocumentDTO == null) {
            iDPDocumentDTO = new IDPDocument( );
            logger.warn(" Creating iDPDocumentDTO, received null object");
        }

        iDPDocumentDTO.setFirstName(iDPDocumentDomain.getFirstName( ));
        iDPDocumentDTO.setLastName(iDPDocumentDomain.getLastName( ));
        iDPDocumentDTO.setMiddleName(iDPDocumentDomain.getMiddleName( ));
        iDPDocumentDTO.setDateOfBirth(iDPDocumentDomain.getDateOfBirth( ));

        iDPDocumentDTO.setDocIssuer(iDPDocumentDomain.getDocIssuer( ));
        iDPDocumentDTO.setIssuingAuthority(iDPDocumentDomain.getIssuingAuthority( ));

        iDPDocumentDTO.setDocExpirationDate(iDPDocumentDomain.getDocExpirationDate( ));

        iDPDocumentDTO.setDocumentType(iDPDocumentDomain.getDocumentType( ));
        iDPDocumentDTO.setDocumentTitle(iDPDocumentDomain.getDocumentTitle( ));
        iDPDocumentDTO.setDocumentNumber(iDPDocumentDomain.getDocumentNumber( ));

        return iDPDocumentDTO;
    }

    /**
     * Gets converted iDPDocument dTO list.
     *
     * @param iDPDocuments the iDPDocuments
     * @return the converted iDPDocument dTO list
     */
    public static List<IDPDocument> getConvertedListDTOFromDomain (List<com.medallies.lifemedid.domain.IDPDocument>
                                                                           iDPDocuments) {

        List<IDPDocument> iDPDocumentDTOList = new ArrayList<IDPDocument>( );
        for (com.medallies.lifemedid.domain.IDPDocument iDPDocument : iDPDocuments) {

            IDPDocument iDPDocumentDTO = new IDPDocument( );
            iDPDocumentDTO = getConvertedDTOFromDomain(iDPDocumentDTO, iDPDocument);
            iDPDocumentDTOList.add(iDPDocumentDTO);
        }
        return iDPDocumentDTOList;
    }

    /**
     * Gets converted iDPDocument domain from iDPDocument dTO.
     *
     * @param iDPDocumentDomain the iDPDocument domain
     * @param iDPDocumentDTO    the iDPDocument dTO
     * @return the converted iDPDocument domain from iDPDocument dTO
     */
    public static com.medallies.lifemedid.domain.IDPDocument getConvertedDomainFromDTO (com.medallies.lifemedid
                                                                                                .domain.IDPDocument
                                                                                                iDPDocumentDomain,
                                                                                        IDPDocument iDPDocumentDTO) {

        if (iDPDocumentDTO == null) {
            String message = "Parameter iDPDocumentDTO is required for conversion";
            logger.error(message);
            throw new NullPointerException(message);
        }
        if (iDPDocumentDomain == null) {
            iDPDocumentDomain = new com.medallies.lifemedid.domain.IDPDocument( );
            logger.warn("Creating iDPDocumentDomain, received null object");
        }

        boolean flag = false;
        StringBuilder stringBuilder = new StringBuilder(" Value must not be null for ");

        if (!StringUtils.isEmpty(iDPDocumentDTO.getFirstName( ))) {
            iDPDocumentDomain.setFirstName(iDPDocumentDTO.getFirstName( ));
        } else {
            flag = true;
            stringBuilder.append(" IDPDocument First Name,");
        }

        if (!StringUtils.isEmpty(iDPDocumentDTO.getLastName( ))) {
            iDPDocumentDomain.setLastName(iDPDocumentDTO.getLastName( ));
        } else {
            flag = true;
            stringBuilder.append(" IDPDocument Last Name,");
        }

        if (!StringUtils.isEmpty(iDPDocumentDTO.getDocumentType( ))) {
            iDPDocumentDomain.setDocumentType(iDPDocumentDTO.getDocumentType( ));
        } else {
            flag = true;
            stringBuilder.append(" IDPDocument DocumentType,");
        }

        if (!StringUtils.isEmpty(iDPDocumentDTO.getDocumentTitle( ))) {
            iDPDocumentDomain.setDocumentTitle(iDPDocumentDTO.getDocumentTitle( ));
        } else {
            flag = true;
            stringBuilder.append(" IDPDocument DocumentTitle,");
        }

        if (!StringUtils.isEmpty(iDPDocumentDTO.getDocumentNumber( ))) {
            iDPDocumentDomain.setDocumentNumber(iDPDocumentDTO.getDocumentNumber( ));
        } else {
            flag = true;
            stringBuilder.append(" IDPDocument DocumentNumber,");
        }

        if (!StringUtils.isEmpty(iDPDocumentDTO.getDateOfBirth( ))) {
            iDPDocumentDomain.setDateOfBirth(iDPDocumentDTO.getDateOfBirth( ));
        } else {
            flag = true;
            stringBuilder.append(" IDPDocument Date of Birth,");
        }

        if (!StringUtils.isEmpty(iDPDocumentDTO.getDocIssuer( ))) {
            iDPDocumentDomain.setDocIssuer(iDPDocumentDTO.getDocIssuer( ));
        } else {
            flag = true;
            stringBuilder.append(" IDPDocument Document Issuer,");
        }

        if (!StringUtils.isEmpty(iDPDocumentDTO.getIssuingAuthority( ))) {
            iDPDocumentDomain.setIssuingAuthority(iDPDocumentDTO.getIssuingAuthority( ));
        } else {
            flag = true;
            stringBuilder.append(" IDPDocument Issuing Authority,");
        }

        if (!StringUtils.isEmpty(iDPDocumentDTO.getDocExpirationDate( ))) {
            iDPDocumentDomain.setDocExpirationDate(iDPDocumentDTO.getDocExpirationDate( ));
        } else {
            flag = true;
            stringBuilder.append(" IDPDocument Document Expiration Date,");
        }

        if (!StringUtils.isEmpty(iDPDocumentDTO.getMiddleName( ))) {
            iDPDocumentDomain.setMiddleName(iDPDocumentDTO.getMiddleName( ));
        } else {

            iDPDocumentDomain.setMiddleName("");
        }

        if (!StringUtils.isEmpty(iDPDocumentDTO.getSuffix( ))) {
            iDPDocumentDomain.setSuffix(iDPDocumentDTO.getSuffix( ));
        } else {

            iDPDocumentDomain.setSuffix("");
        }


        if (flag) {
            logger.error(stringBuilder.toString( ));
            throw new IllegalArgumentValueException(stringBuilder.toString( ));
        }
        logger.info(stringBuilder.toString( ));
        return iDPDocumentDomain;
    }

    /**
     * Gets converted iDPDocument domain list from iDPDocument dTO list.
     *
     * @param iDPDocumentDTOList the iDPDocument dTO list
     * @param applicantDomain    the applicant domain
     * @return the converted iDPDocument domain list from iDPDocument dTO list
     */
    public static List<com.medallies.lifemedid.domain.IDPDocument> getConvertedListDomainFromDTO (List<IDPDocument>
                                                                                                          iDPDocumentDTOList, Applicant applicantDomain) {

        List<com.medallies.lifemedid.domain.IDPDocument> iDPDocumentDomainList = new ArrayList<com.medallies
                .lifemedid.domain.IDPDocument>( );
        for (IDPDocument iDPDocumentDTO : iDPDocumentDTOList) {
            com.medallies.lifemedid.domain.IDPDocument iDPDocumentDomain = new com.medallies.lifemedid.domain
                    .IDPDocument( );
            iDPDocumentDomain = getConvertedDomainFromDTO(iDPDocumentDomain, iDPDocumentDTO);
            // Note add below line only for save/ create support for Hibernate bi directional
            iDPDocumentDomain.setApplicant(applicantDomain);

            iDPDocumentDomainList.add(iDPDocumentDomain);
        }
        return iDPDocumentDomainList;
    }

}
