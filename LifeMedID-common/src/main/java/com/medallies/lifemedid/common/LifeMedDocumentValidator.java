package com.medallies.lifemedid.common;

import com.medallies.lifemedid.constants.DAOConstants;
import com.medallies.lifemedid.dto.Applicant;
import com.medallies.lifemedid.dto.IDPDocument;
import com.medallies.lifemedid.dto.LifeMedDocument;
import com.medallies.lifemedid.dto.Uploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * The type Life med document validator.
 */
public class LifeMedDocumentValidator {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(LifeMedDocumentValidator.class);

    /**
     * Validate string.
     *
     * @param lifeMedDocumentDTO the life med documents
     * @return the string
     * @throws Exception the exception
     */
    public static String validate (LifeMedDocument lifeMedDocumentDTO) throws Exception {

        String location = LifeMedDocumentValidator.class.getCanonicalName( ) + "#validate()";
        logger.debug("Starting " + location);

        List<IDPDocument> idpDocumentList = lifeMedDocumentDTO.getIdpDocumentList( );
        StringBuilder stringBuilder = new StringBuilder( );

        boolean flag = checkIDPDocumentNType(idpDocumentList);
        if (!flag) {
            return "Please provide 1 from Type A or 2 documents from Type B";
        }
        stringBuilder.append("For IDPDocumentList: ");
        for (IDPDocument idpDocument : idpDocumentList) {

            stringBuilder.append(validateIDPDocument(idpDocument));
        }
        if (stringBuilder.toString( ).endsWith(": ")) {
            stringBuilder = new StringBuilder( );
        }

        stringBuilder.append("For Applicant: ");
        stringBuilder.append(validateApplicant(lifeMedDocumentDTO.getApplicant( )));
        if (stringBuilder.toString( ).endsWith(": ")) {
            stringBuilder = new StringBuilder( );
        }

        stringBuilder.append("For Uploader: ");
        stringBuilder.append(validateUploader(lifeMedDocumentDTO.getUploader( )));
        if (stringBuilder.toString( ).endsWith(": ")) {
            stringBuilder = new StringBuilder( );
        }

        if (!stringBuilder.toString( ).isEmpty( )) {
            return stringBuilder.delete(stringBuilder.length( ) - 2, stringBuilder.length( )).toString( );
        }

        logger.debug("Finishing " + location);

        if (!stringBuilder.toString( ).trim( ).isEmpty( )) {
            return stringBuilder.toString( );
        }
        return null;
    }

    /**
     * Validate uploader string.
     *
     * @param uploader the uploader
     * @return the string
     * @throws Exception the exception
     */
    public static String validateUploader (Uploader uploader) throws Exception {

        boolean flag;
        StringBuilder stringBuilder = new StringBuilder( );

        if (uploader == null) {
            return "Uploader is null and its properties are not provided";
        }

        Field fields[] = uploader.getClass( ).getDeclaredFields( );
        for (Field field : fields) {

            try {
                field.setAccessible(true);
                if (StringUtils.isEmpty(field.get(uploader))) {
                    flag = true;
                } else {
                    if (field.getName( ).endsWith("Date") || field.getName( ).startsWith("date")) {
                        flag = !validateDate(field.get(uploader).toString( ));
                    } else {
                        flag = !validateString(field.get(uploader).toString( ));
                    }
                }
                if (flag) {
                    stringBuilder.append(" Field ").append(field.getName( )).append(" is missing, ");
                }

                field.setAccessible(false);
            } catch ( IllegalAccessException exception ) {
                logger.error("Could not access field: " + field, exception);
                throw exception;
            } catch ( Exception exception ) {
                logger.error("Unknown exception occurred while trying to access field: " + field);
                throw exception;
            }
        }

        return stringBuilder.toString( ).isEmpty( ) ? "" : stringBuilder.toString( );
    }

    /**
     * Validate applicant string.
     *
     * @param applicant the applicant
     * @return the string
     * @throws Exception the exception
     */
    public static String validateApplicant (Applicant applicant) throws Exception {

        boolean flag;
        StringBuilder stringBuilder = new StringBuilder( );

        if (applicant == null) {
            return "Applicant is null and its properties are not provided";
        }

        Field fields[] = applicant.getClass( ).getDeclaredFields( );
        for (Field field : fields) {

            try {
                field.setAccessible(true);
                if (StringUtils.isEmpty(field.get(applicant))) {
                    flag = true;
                } else {
                    if (field.getName( ).endsWith("Date") || field.getName( ).startsWith("date")) {
                        flag = !validateDate(field.get(applicant).toString( ));
                    } else {
                        flag = !validateString(field.get(applicant).toString( ));
                    }
                }
                if (flag) {
                    stringBuilder.append(" Field ").append(field.getName( )).append(" is missing, ");
                }

                field.setAccessible(false);
            } catch ( IllegalAccessException exception ) {
                logger.error("Could not access field: " + field, exception);
                throw exception;
            } catch ( Exception exception ) {
                logger.error("Unknown exception occurred while trying to access field: " + field);
                throw exception;
            }
        }

        return stringBuilder.toString( ).isEmpty( ) ? "" : stringBuilder.toString( );
    }

    /**
     * Validate idp document string.
     *
     * @param idpDocument the idp document
     * @return the string
     * @throws Exception the exception
     */
    public static String validateIDPDocument (IDPDocument idpDocument) throws Exception {

        boolean flag;
        StringBuilder stringBuilder = new StringBuilder( );

        if (idpDocument == null) {
            return "IDPDocument is null and its properties are not provided";
        }

        Field fields[] = idpDocument.getClass( ).getDeclaredFields( );
        for (Field field : fields) {

            try {
                field.setAccessible(true);
                if (StringUtils.isEmpty(field.get(idpDocument))) {
                    flag = true;
                } else {
                    if (field.getName( ).endsWith("Date") || field.getName( ).startsWith("date")) {
                        flag = !validateDate(field.get(idpDocument).toString( ));
                    } else {
                        flag = !validateString(field.get(idpDocument).toString( ));
                    }
                }
                if (flag) {
                    stringBuilder.append(" Field ").append(field.getName( )).append(" is missing, ");
                }

                field.setAccessible(false);
            } catch ( IllegalAccessException exception ) {
                logger.error("Could not access field: " + field, exception);
                throw exception;
            } catch ( Exception exception ) {
                logger.error("Unknown exception occurred while trying to access field: " + field);
                throw exception;
            }
        }

        return stringBuilder.toString( ).isEmpty( ) ? "" : stringBuilder.toString( );
    }

    /**
     * Validate date boolean.
     *
     * @param dateString the date string
     * @return the boolean
     */
    public static boolean validateDate (String dateString) {

        String dataFormat = DAOConstants.DEFAULT_DATE_FORMAT;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dataFormat);

        if (StringUtils.isEmpty(dateString)) {
            return false;
        }

        String dateParts[] = dateString.split("-");

        // Note validate date contains 3 parts
        if (dateParts.length != 3) {
            return false;
        }

        // Note validate date year length
        if (dateParts[ 0 ].length( ) != 4) {
            return false;
        }

        // Note validate date month length
        if (dateParts[ 1 ].length( ) < 0 || dateParts[ 1 ].length( ) > 3) {
            return false;
        }

        // Note validate date day length
        if (dateParts[ 2 ].length( ) < 0 || dateParts[ 2 ].length( ) > 3) {
            return false;
        }
        // Note Validae month and day
        int month = Integer.parseInt(dateParts[ 1 ]);
        int day = Integer.parseInt(dateParts[ 2 ]);

        if (( day < 1 || day > 31 ) || ( month < 1 ) || month > 12) return false;

        try {
            Date date = simpleDateFormat.parse(dateString);
            if (date == null) {
                return false;
            }
        } catch ( ParseException exception ) {
            logger.error("Date Parse exception for Date: " + dateString, exception);
            return false;
        }
        return true;

    }

    /**
     * This method is for custom string validations like length extra
     *
     * @param data the data
     * @return boolean boolean
     */
    public static boolean validateString (String data) {

        return !StringUtils.isEmpty(data);
    }

    /**
     * Check idp document n type boolean.
     *
     * @param idpDocumentList the idp document list
     * @return the boolean
     */
    public static boolean checkIDPDocumentNType (List<IDPDocument> idpDocumentList) {

        for (IDPDocument idpDocument : idpDocumentList) {
            if (idpDocument.getDocumentType( ).startsWith("B") && idpDocumentList.size( ) == DAOConstants.TWO)
                return true;
            else if (idpDocument.getDocumentType( ).startsWith("A") && idpDocumentList.size( ) == DAOConstants.ONE) {
                return true;
            }
        }
        return false;
    }

}
