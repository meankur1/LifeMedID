package com.medallies.lifemedid.service.builder;


import com.medallies.lifemedid.common.DateCommons;
import com.medallies.lifemedid.constants.DAOConstants;
import com.medallies.lifemedid.constants.ServiceConstants;
import com.medallies.lifemedid.converter.LifeMedDocDomainDTOConverter;
import com.medallies.lifemedid.dto.LifeMedDocument;
import com.medallies.lifemedid.dto.Uploader;
import com.medallies.lifemedid.dto.payload.LifeMedDocumentPayload;
import com.medallies.lifemedid.dto.request.RequestParams;
import com.medallies.lifemedid.exception.IllegalArgumentValueException;
import com.medallies.lifemedid.exception.response.Error;
import com.medallies.lifemedid.exception.response.ErrorContainer;
import com.medallies.lifemedid.response.DAOResponse;
import com.medallies.lifemedid.service.container.LifeMedDocumentResponseContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type LifeMedDocument response builder.
 */
public class LifeMedDocumentResponseBuilder {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(LifeMedDocumentResponseBuilder.class);

    /**
     * Build lifeMedDocument response container.
     * Note fro saving data
     *
     * @param lifeMedDocumentDAOResponse the lifeMedDocument dAO response
     * @param uploader                   the uploader
     * @return Returns a response object for lifeMedDocuments
     */
    public static LifeMedDocumentResponseContainer build (DAOResponse<com.medallies.lifemedid.domain.LifeMedDocument>
                                                                  lifeMedDocumentDAOResponse,
                                                          Uploader uploader) {

        if (lifeMedDocumentDAOResponse == null) {
            lifeMedDocumentDAOResponse = new DAOResponse<com.medallies.lifemedid.domain.LifeMedDocument>( );
            logger.warn("Parameter lifeMedDocumentDAOResponse was passed as null");
        }
        logger.debug("Starting building of LifeMedDocument Response");
        /**
         * If these lines are executed an error has occurred is indicated normally unless request is a delete request
         * in that case count will still 1 depending on how many are deleted
         */
        if (lifeMedDocumentDAOResponse.getResults( ) == null || lifeMedDocumentDAOResponse.getResults( ).isEmpty( )) {
            // for delete success this will be true
            if (!lifeMedDocumentDAOResponse.isDelete( ) && !lifeMedDocumentDAOResponse.isRequestSuccess( )) {
                lifeMedDocumentDAOResponse.setCount(DAOConstants.ZERO);
            }
            lifeMedDocumentDAOResponse.setResults(new ArrayList<com.medallies.lifemedid.domain.LifeMedDocument>( ));
        }
        String location = "LifeMedDocumentResponseContainer<T>" + ServiceConstants.HASH + "build()";

        LifeMedDocumentResponseContainer lifeMedDocumentResponseContainer = new LifeMedDocumentResponseContainer( );

        ErrorContainer errorContainer = lifeMedDocumentDAOResponse.getErrorContainer( );
        if (errorContainer == null) {
            errorContainer = new ErrorContainer( );
        }
        try {

            Date timestamp = lifeMedDocumentDAOResponse.getResults( ).get(DAOConstants.ZERO).getTimeStamp( );
            String timeStampString = DateCommons.getDateStringFromDateTimestamp(timestamp);

            lifeMedDocumentResponseContainer.setTimestamp(timeStampString);
            lifeMedDocumentResponseContainer.setStatus(DAOConstants.OK);
            lifeMedDocumentResponseContainer.setTransactionId(uploader.getTransactionId());

        } catch ( IllegalArgumentValueException e ) {
            logger.error("Failed due to invalid values", e);
            errorContainer.addError(new Error(location, e));
        } catch ( NullPointerException e ) {
            logger.error("Failed due to null object", e);
            errorContainer.addError(new Error(location, e));
        } catch ( Exception e ) {
            logger.error("Unexpected error while converting domain to dto object", e);
            errorContainer.addError(new Error(location, e));
        }
//        lifeMedDocumentResponseContainer.setPayload( lifeMedDocument );
//        lifeMedDocumentResponseContainer.setErrorContainer( isError ? errorContainer : null );

        logger.debug("Completing building of LifeMedDocument Response");
        return lifeMedDocumentResponseContainer;
    }


    /**
     * Build life med document response container for getting all life med documents.
     * Note for getting all the data from DB or for fetching particular data
     *
     * @param lifeMedDocumentDAOResponse the life med document dao response
     * @param requestParams              the request params
     * @return the life med document response container
     */
    public static LifeMedDocumentResponseContainer<LifeMedDocumentPayload>
    build (DAOResponse<com.medallies.lifemedid.domain.LifeMedDocument> lifeMedDocumentDAOResponse,
           RequestParams requestParams) {

        if (lifeMedDocumentDAOResponse == null) {
            lifeMedDocumentDAOResponse = new DAOResponse<com.medallies.lifemedid.domain.LifeMedDocument>( );
            logger.warn("Parameter lifeMedDocumentDAOResponse was passed as null");
        }
        logger.debug("Starting building of LifeMedDocument Response");

        String location = "LifeMedDocumentResponseContainer<T>" + ServiceConstants.HASH + "build()";

        LifeMedDocumentResponseContainer<LifeMedDocumentPayload> lifeMedDocumentResponseContainer
                = new LifeMedDocumentResponseContainer<LifeMedDocumentPayload>( );

        LifeMedDocumentPayload<LifeMedDocument> lifeMedDocumentPayload
                = new LifeMedDocumentPayload<LifeMedDocument>( );

        ErrorContainer errorContainer = lifeMedDocumentDAOResponse.getErrorContainer( );

        if (errorContainer == null) {
            errorContainer = new ErrorContainer( );
        }

        try {

            lifeMedDocumentResponseContainer.setPayload(lifeMedDocumentPayload);

            List<LifeMedDocument> lifeMedDocumentListDTO
                    = LifeMedDocDomainDTOConverter.getConvertedListDTOFromDomain(lifeMedDocumentDAOResponse
                    .getResults( ));

            lifeMedDocumentPayload.setCount(lifeMedDocumentListDTO.size( ));
            lifeMedDocumentPayload.setTList(lifeMedDocumentListDTO);


        } catch ( IllegalArgumentValueException exception ) {
            logger.error("Failed due to invalid values", exception);
            errorContainer.addError(new Error(location, exception));
        } catch ( NullPointerException exception ) {
            logger.error("Failed due to null object", exception);
            errorContainer.addError(new Error(location, exception));
        } catch ( Exception exception ) {
            logger.error("Unexpected error while converting domain to dto object", exception);
            errorContainer.addError(new Error(location, exception));
        } finally {

            if (requestParams.isError( )) {
                lifeMedDocumentResponseContainer.setErrorContainer(errorContainer);
            }
        }
//        lifeMedDocumentResponseContainer.setPayload( lifeMedDocument );
//        lifeMedDocumentResponseContainer.setErrorContainer( isError ? errorContainer : null );

        logger.debug("Completing building of LifeMedDocument Response");
        return lifeMedDocumentResponseContainer;
    }

    /**
     * Build error.
     *
     * @param location  the location of the error
     * @param isError   the is error
     * @param exception the exception
     * @return the lifeMedDocument response container
     */
    public static LifeMedDocumentResponseContainer buildError (String location, boolean isError,
                                                               Exception exception) {

        logger.debug("Starting building of Error for LifeMedDocument Response");

        LifeMedDocumentResponseContainer lifeMedDocumentResponseContainer = new LifeMedDocumentResponseContainer( );
        ErrorContainer errorContainer;
        if (isError) {
            errorContainer = new ErrorContainer( );
            com.medallies.lifemedid.exception.response.Error error = new Error(location, exception);
            errorContainer.addError(error);
            lifeMedDocumentResponseContainer.setErrorContainer(errorContainer);
        }

        logger.debug("Ending building of LifeMedDocument Response");
        return lifeMedDocumentResponseContainer;
    }
}
