package com.medallies.lifemedid.service.impl;

import com.medallies.lifemedid.common.LifeMedDocumentValidator;
import com.medallies.lifemedid.common.response.ResponseUtility;
import com.medallies.lifemedid.constants.DAOConstants;
import com.medallies.lifemedid.constants.ServiceConstants;
import com.medallies.lifemedid.converter.LifeMedDocDomainDTOConverter;
import com.medallies.lifemedid.dao.MedIDDAO;
import com.medallies.lifemedid.dto.LifeMedDocument;
import com.medallies.lifemedid.dto.request.RequestParams;
import com.medallies.lifemedid.response.DAOResponse;
import com.medallies.lifemedid.service.MedIDService;
import com.medallies.lifemedid.service.builder.LifeMedDocumentResponseBuilder;
import com.medallies.lifemedid.service.container.LifeMedDocumentResponseContainer;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;

/**
 * The type Med id service.
 */
@Service
public class MedIDServiceImpl implements MedIDService {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(MedIDServiceImpl.class);

    /**
     * The Med iddao.
     */
    @Resource
    private MedIDDAO medIDDAO;

    /**
     * Save life med id data response.
     *
     * @param lifeMedDocDTO the idp document
     * @param requestParams the request params
     * @return the response
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Response saveLifeMedIDData (LifeMedDocument lifeMedDocDTO, RequestParams requestParams) {

        String location = this.getClass( ).getCanonicalName( ) + "#saveLifeMedIDData()";
        logger.debug("Starting " + location);

        LifeMedDocumentResponseContainer lifeMedDocumentResponseContainer = new LifeMedDocumentResponseContainer( );
        String errorMsg = "Unknown Error";

        try {
            errorMsg = LifeMedDocumentValidator.validate(lifeMedDocDTO);
        } catch ( Exception exception ) {
            logger.error("Error occurred during validation " + location, exception);
            ResponseUtility.internalServerErrorMsg("Server encountered a severe non recoverable exception");
        }


        if (!StringUtils.isEmpty(errorMsg)) {

            lifeMedDocumentResponseContainer.setStatus(ServiceConstants.ERROR);
            lifeMedDocumentResponseContainer.setDescription(errorMsg);

            return Response.status(Response.Status.BAD_REQUEST).entity(lifeMedDocumentResponseContainer).build( );
        }

        //TODO perform some validation then call dao
        DAOResponse<com.medallies.lifemedid.domain.LifeMedDocument> lifemedidDAOResponse;
        try {
            com.medallies.lifemedid.domain.LifeMedDocument lifeMedDocumentDomain = LifeMedDocDomainDTOConverter
                    .getConvertedDomainFromDTO(null, lifeMedDocDTO);


            lifemedidDAOResponse = medIDDAO.saveDataIntoDB(lifeMedDocumentDomain);

            if (lifemedidDAOResponse.getResults( ) != null && lifemedidDAOResponse.getResults( ).size( ) ==
                    DAOConstants.ONE) {

                lifeMedDocumentResponseContainer
                        = LifeMedDocumentResponseBuilder.build(lifemedidDAOResponse, lifeMedDocDTO.getUploader( ));

                return Response.ok( ).entity(lifeMedDocumentResponseContainer).build( );

            }
        } catch ( Exception exception ) {

            if (exception instanceof HibernateException) {
                lifeMedDocumentResponseContainer = LifeMedDocumentResponseBuilder.buildError(location, requestParams
                        .isError( ), exception);
//                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity
// (lifeMedDocumentResponseContainer).build();
            }

            lifeMedDocumentResponseContainer.setDescription("Exception occurred while trying to save to database");
            lifeMedDocumentResponseContainer.setStatus(ServiceConstants.ERROR);
            logger.error("Service Layer exception " + location, exception);
//            ResponseUtility.internalServerErrorMsg("Server encountered a severe non recoverable exception");
        }

        logger.debug("Finishing " + location);
        return Response.ok(lifeMedDocumentResponseContainer).build( );
    }

    /**
     * Gets all life med data.
     *
     * @param requestParams the request params
     * @return the all life med data
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Response getAllLifeMedData (RequestParams requestParams) {

        String location = this.getClass( ).getCanonicalName( ) + "#getAllLifeMedData()";
        logger.debug("Starting " + location);

//        String errorMsg = IDPDocumentValidator.validate(idpDocument);

        //TODO perform some validation then call dao
        DAOResponse<com.medallies.lifemedid.domain.LifeMedDocument> lifeMedDocumentDAOResponse;
        try {

            lifeMedDocumentDAOResponse = medIDDAO.getAllDataFromDB( );

            if (lifeMedDocumentDAOResponse.getResults( ) != null && lifeMedDocumentDAOResponse.getResults( ).size( ) >=
                    DAOConstants.ONE) {

                LifeMedDocumentResponseContainer lifeMedDocumentResponseContainer
                        = LifeMedDocumentResponseBuilder.build(lifeMedDocumentDAOResponse, requestParams);
                return Response.ok( ).entity(lifeMedDocumentResponseContainer).build( );

            }
        } catch ( Exception exception ) {
            logger.error("Service Layer exception", exception);

            ResponseUtility.internalServerErrorMsg("Server encountered a severe non recoverable exception");
        }

        logger.debug("Finishing " + location);
        return Response.ok( ).build( );
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Response deleteLifeMedIDData (LifeMedDocument lifeMedDocumentDTO, RequestParams requestParams, boolean
            hasPermission) {

        String location = this.getClass( ).getCanonicalName( ) + "#deleteLifeMedIDData()";
        logger.debug("Starting " + location);

        if(!hasPermission) {
            return ResponseUtility.unauthorizedAccess("You DO NOT have access to invoke this method");
        }

        com.medallies.lifemedid.domain.LifeMedDocument lifeMedDocumentDomain = LifeMedDocDomainDTOConverter.getConvertedDomainFromDTO(null, lifeMedDocumentDTO);
        DAOResponse<Integer> integerDAOResponse = medIDDAO.deleteLifeMedDocument(lifeMedDocumentDomain);

        if(!integerDAOResponse.getErrorContainer().getErrors().isEmpty()) {
            return ResponseUtility.internalServerErrorMsg("Failed to perform delete request");
        }
        logger.debug("Finishing " + location);
        return Response.status(Response.Status.OK).entity(integerDAOResponse).build( );
    }
}
