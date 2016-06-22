package com.medallies.lifemedid.converter;

import com.medallies.lifemedid.constants.DAOConstants;
import com.medallies.lifemedid.domain.Applicant;
import com.medallies.lifemedid.dto.LifeMedDocument;
import com.medallies.lifemedid.dto.Uploader;
import com.medallies.lifemedid.exception.IllegalArgumentValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Life med doc domain dto converter.
 */
public class LifeMedDocDomainDTOConverter {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(LifeMedDocDomainDTOConverter.class);

    /**
     * The constant ZERO.
     */
    private static final int ZERO = DAOConstants.ZERO;

    /**
     * Gets converted lifeMedDocument dTO from lifeMedDocument domain.
     *
     * @param lifeMedDocumentDTO    the lifeMedDocument dTO
     * @param lifeMedDocumentDomain the lifeMedDocument domain
     * @return the converted lifeMedDocument dTO from lifeMedDocument domain
     */
    public static LifeMedDocument getConvertedDTOFromDomain (LifeMedDocument lifeMedDocumentDTO,
                                                             com.medallies.lifemedid.domain.LifeMedDocument
                                                                     lifeMedDocumentDomain) {

        if (lifeMedDocumentDomain == null) {
            String message = "Parameter lifeMedDocumentDomain is required for conversion";
            logger.error(message);
            throw new NullPointerException(message);
        }

        if (lifeMedDocumentDTO == null) {
            lifeMedDocumentDTO = new LifeMedDocument( );
            logger.warn(" Creating lifeMedDocumentDTO, received null object");
        }

        Uploader uploaderDTO = new Uploader();

        //Note changes according to new structure
        uploaderDTO.setTransactionId(lifeMedDocumentDomain.getTransactionId( ));
        uploaderDTO.setRegistarId(lifeMedDocumentDomain.getRegisterId());
        uploaderDTO.setOrganizationId(lifeMedDocumentDomain.getOrganizationId( ));

        try {

            lifeMedDocumentDTO.setUploader(uploaderDTO);

            lifeMedDocumentDTO.setApplicant(ApplicantDomainDTOConverter.getConvertedDTOFromDomain(new com.medallies
                    .lifemedid.dto.Applicant( ), lifeMedDocumentDomain.getApplicant( )));

            lifeMedDocumentDTO.setIdpDocumentList(IDPDocumentDomainDTOConverter.getConvertedListDTOFromDomain
                    (lifeMedDocumentDomain.getApplicant( ).getIdpDocuments( )));
        } catch ( Exception exception ) {
            logger.error("Exception occurred while trying to convert/ access Applicant or IDPDocuments", exception);
            if (exception instanceof NullPointerException) {
                throw new NullPointerException("Object is null");
            }
            if (exception instanceof IndexOutOfBoundsException) {
                throw new IndexOutOfBoundsException(" Tried to access an element in list not available");
            }

            if (exception instanceof IllegalArgumentValueException) {
                throw new IllegalArgumentException(exception.getMessage( ));
            }

            // Note should never happen
            throw new RuntimeException(exception.getMessage( ));
        }
        return lifeMedDocumentDTO;
    }

    /**
     * Gets converted lifeMedDocument dTO list.
     *
     * @param lifeMedDocuments the lifeMedDocuments
     * @return the converted lifeMedDocument dTO list
     */
    public static List<LifeMedDocument> getConvertedListDTOFromDomain (List<com.medallies.lifemedid.domain
            .LifeMedDocument> lifeMedDocuments) {

        List<LifeMedDocument> lifeMedDocumentDTOList = new ArrayList<LifeMedDocument>( );
        for (com.medallies.lifemedid.domain.LifeMedDocument lifeMedDocumentDomain : lifeMedDocuments) {

            LifeMedDocument lifeMedDocumentDTO = new LifeMedDocument( );
            lifeMedDocumentDTO = getConvertedDTOFromDomain(lifeMedDocumentDTO, lifeMedDocumentDomain);
            lifeMedDocumentDTOList.add(lifeMedDocumentDTO);
        }
        return lifeMedDocumentDTOList;
    }

    /**
     * Gets converted lifeMedDocument domain from lifeMedDocument dTO.
     * Note this method is used for creating lifeMedDocuments
     *
     * @param lifeMedDocumentDomain the lifeMedDocument domain
     * @param lifeMedDocumentDTO    the lifeMedDocument dTO
     * @return the converted lifeMedDocument domain from lifeMedDocument dTO
     */
    public static com.medallies.lifemedid.domain.LifeMedDocument
    getConvertedDomainFromDTO (com.medallies.lifemedid.domain.LifeMedDocument lifeMedDocumentDomain, LifeMedDocument
            lifeMedDocumentDTO) {

        if (lifeMedDocumentDTO == null) {
            String message = "Parameter lifeMedDocumentDTO is required for conversion";
            logger.error(message);
            throw new NullPointerException(message);
        }
        if (lifeMedDocumentDomain == null) {
            lifeMedDocumentDomain = new com.medallies.lifemedid.domain.LifeMedDocument( );
            logger.warn("Creating lifeMedDocumentDomain, received null object");
        }

        boolean flag = false;
        StringBuilder stringBuilder = new StringBuilder(" Value must not be null for ");

        Uploader uploaderDTO = lifeMedDocumentDTO.getUploader();

        if(uploaderDTO == null) {
            String message = "Parameter uploaderDTO is required for conversion";
            throw new NullPointerException(message);
        }

        if (!StringUtils.isEmpty(uploaderDTO.getTransactionId( ))) {
            lifeMedDocumentDomain.setTransactionId(uploaderDTO.getTransactionId( ));
        } else {
            flag = true;
            stringBuilder.append(" Uploader TransactionId,");
        }

        if (!StringUtils.isEmpty(uploaderDTO.getRegistarId())) {
            lifeMedDocumentDomain.setRegisterId(uploaderDTO.getRegistarId());
        } else {
            flag = true;
            stringBuilder.append(" Uploader PersonId,");
        }

        if (!StringUtils.isEmpty(uploaderDTO.getOrganizationId( ))) {
            lifeMedDocumentDomain.setOrganizationId(uploaderDTO.getOrganizationId( ));
        } else {
            flag = true;
            stringBuilder.append(" Uploader OrganizationId,");
        }

        if (lifeMedDocumentDTO.getIdpDocumentList( ) != null && !lifeMedDocumentDTO.getIdpDocumentList( ).isEmpty( )) {
            if (lifeMedDocumentDTO.getApplicant( ) != null) {
                Applicant applicantDomain = new Applicant( );
                applicantDomain.setIdpDocuments(IDPDocumentDomainDTOConverter.getConvertedListDomainFromDTO
                        (lifeMedDocumentDTO.getIdpDocumentList( ), applicantDomain));
                applicantDomain = ApplicantDomainDTOConverter.getConvertedDomainFromDTO(applicantDomain,
                        lifeMedDocumentDTO.getApplicant( ));
                lifeMedDocumentDomain.setApplicant(applicantDomain);
                lifeMedDocumentDomain.setIdpDocumentList(applicantDomain.getIdpDocuments());

                //Note so alow creation with hibernate need to add these lines
                applicantDomain.setLifeMedDocument(lifeMedDocumentDomain);
            } else {

                flag = true;
                stringBuilder.append(" LifeMedDocument Applicant,");
            }
        } else {

            flag = true;
            stringBuilder.append(" LifeMedDocument IDPDocument,");
        }

        lifeMedDocumentDomain.setTimeStamp(new Date( ));


//            lifeMedDocument.setShopLifeMedDocument();
        if (flag) {
            logger.error(stringBuilder.toString( ));
            throw new IllegalArgumentValueException(stringBuilder.toString( ));
        }

        logger.info(stringBuilder.toString( ));
        return lifeMedDocumentDomain;
    }

    /**
     * Gets converted lifeMedDocument domain list from lifeMedDocument dTO list.
     *
     * @param lifeMedDocumentDTOList the lifeMedDocument dTO list
     * @return the converted lifeMedDocument domain list from lifeMedDocument dTO list
     */
    public static List<com.medallies.lifemedid.domain.LifeMedDocument> getConvertedListDomainFromDTO
    (List<LifeMedDocument> lifeMedDocumentDTOList) {

        List<com.medallies.lifemedid.domain.LifeMedDocument> lifeMedDocumentDomainList = new ArrayList<com.medallies
                .lifemedid.domain.LifeMedDocument>( );
        for (LifeMedDocument lifeMedDocumentDTO : lifeMedDocumentDTOList) {
            com.medallies.lifemedid.domain.LifeMedDocument lifeMedDocumentDomain = new com.medallies.lifemedid.domain
                    .LifeMedDocument( );
            lifeMedDocumentDomain = getConvertedDomainFromDTO(lifeMedDocumentDomain, lifeMedDocumentDTO);
            lifeMedDocumentDomainList.add(lifeMedDocumentDomain);
        }
        return lifeMedDocumentDomainList;
    }
}
