package com.medallies.lifemedid.converter;

import com.medallies.lifemedid.dto.Applicant;
import com.medallies.lifemedid.exception.IllegalArgumentValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * The type Applicant domain dto converter.
 */
public class ApplicantDomainDTOConverter {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(ApplicantDomainDTOConverter.class);

    /**
     * Gets converted applicant dTO from applicant domain.
     *
     * @param applicantDTO    the applicant dTO
     * @param applicantDomain the applicant domain
     * @return the converted applicant dTO from applicant domain
     */
    public static Applicant getConvertedDTOFromDomain (Applicant applicantDTO, com.medallies.lifemedid.domain
            .Applicant applicantDomain) {

        if (applicantDomain == null) {
            String message = "Parameter applicantDomain is required for conversion";
            logger.error(message);
            throw new NullPointerException(message);
        }

        if (applicantDTO == null) {
            applicantDTO = new Applicant( );
            logger.warn(" Creating applicantDTO, received null object");
        }

        applicantDTO.setLevelOfAssurance(applicantDomain.getLevelOfAssurance( ));
        applicantDTO.setSuffix(applicantDomain.getSuffix( ));
        applicantDTO.setDateOfBirth(applicantDomain.getDateOfBirth( ));
        applicantDTO.setFirstName(applicantDomain.getFirstName( ));
        applicantDTO.setMiddleName(applicantDomain.getMiddleName( ));
        applicantDTO.setLastName(applicantDomain.getLastName( ));
        applicantDTO.setId(applicantDomain.getId( ));

        return applicantDTO;
    }

    /**
     * Gets converted applicant dTO list.
     *
     * @param applicants the applicants
     * @return the converted applicant dTO list
     */
    public static List<Applicant> getConvertedListDTOFromDomain (List<com.medallies.lifemedid.domain.Applicant>
                                                                         applicants) {

        List<Applicant> applicantDTOList = new ArrayList<Applicant>( );
        for (com.medallies.lifemedid.domain.Applicant applicant : applicants) {

            Applicant applicantDTO = new Applicant( );
            applicantDTO = getConvertedDTOFromDomain(applicantDTO, applicant);
            applicantDTOList.add(applicantDTO);
        }
        return applicantDTOList;
    }

    /**
     * Gets converted applicant domain from applicant dTO.
     *
     * @param applicantDomain the applicant domain
     * @param applicantDTO    the applicant dTO
     * @return the converted applicant domain from applicant dTO
     */
    public static com.medallies.lifemedid.domain.Applicant getConvertedDomainFromDTO (com.medallies.lifemedid.domain
                                                                                              .Applicant
                                                                                              applicantDomain,
                                                                                      Applicant applicantDTO) {

        if (applicantDTO == null) {
            String message = "Parameter applicantDTO is required for conversion";
            logger.error(message);
            throw new NullPointerException(message);
        }
        if (applicantDomain == null) {
            applicantDomain = new com.medallies.lifemedid.domain.Applicant( );
            logger.warn("Creating applicantDomain, received null object");
        }

        boolean flag = false;
        StringBuilder stringBuilder = new StringBuilder(" Value must not be null for ");

        if (!StringUtils.isEmpty(applicantDTO.getSuffix( ))) {
            applicantDomain.setSuffix(applicantDTO.getSuffix( ));
        } else {
            applicantDomain.setSuffix("");
        }

        if (!StringUtils.isEmpty(applicantDTO.getMiddleName( ))) {
            applicantDomain.setMiddleName(applicantDTO.getMiddleName( ));
        } else {
            applicantDomain.setMiddleName("");
        }

        if (!StringUtils.isEmpty(applicantDTO.getFirstName( ))) {
            applicantDomain.setFirstName(applicantDTO.getFirstName( ));
        } else {
            flag = true;
            stringBuilder.append(" Applicant First Name,");
        }

        if (!StringUtils.isEmpty(applicantDTO.getLastName( ))) {
            applicantDomain.setLastName(applicantDTO.getLastName( ));
        } else {
            flag = true;
            stringBuilder.append(" Applicant Last Name,");
        }

        if (!StringUtils.isEmpty(applicantDTO.getDateOfBirth( ))) {
            applicantDomain.setDateOfBirth(applicantDTO.getDateOfBirth( ));
        } else {
            flag = true;
            stringBuilder.append(" Applicant Date of Birth,");
        }

        if (!StringUtils.isEmpty(applicantDTO.getLevelOfAssurance( ))) {
            applicantDomain.setLevelOfAssurance(applicantDTO.getLevelOfAssurance( ));
        } else {
            flag = true;
            stringBuilder.append(" Applicant Level of Assurance,");
        }

        if (!StringUtils.isEmpty(applicantDTO.getId( ))) {
            applicantDomain.setId(applicantDTO.getId( ));
        } else {
            flag = true;
            stringBuilder.append(" Applicant Id,");
        }
//            applicant.setShopApplicant();
        if (flag) {
            logger.error(stringBuilder.toString( ));
            throw new IllegalArgumentValueException(stringBuilder.toString( ));
        }
        logger.info(stringBuilder.toString( ));
        return applicantDomain;
    }

    /**
     * Gets converted applicant domain list from applicant dTO list.
     *
     * @param applicantDTOList the applicant dTO list
     * @return the converted applicant domain list from applicant dTO list
     */
    public static List<com.medallies.lifemedid.domain.Applicant> getConvertedListDomainFromDTO (List<Applicant>
                                                                                                        applicantDTOList) {

        List<com.medallies.lifemedid.domain.Applicant> applicantDomainList = new ArrayList<com.medallies
                .lifemedid.domain.Applicant>( );
        for (Applicant applicantDTO : applicantDTOList) {
            com.medallies.lifemedid.domain.Applicant applicantDomain = new com.medallies.lifemedid.domain.Applicant( );
            applicantDomain = getConvertedDomainFromDTO(applicantDomain, applicantDTO);
            applicantDomainList.add(applicantDomain);
        }
        return applicantDomainList;
    }
}
