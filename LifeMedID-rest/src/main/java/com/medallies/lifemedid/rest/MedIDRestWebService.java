package com.medallies.lifemedid.rest;

import com.medallies.lifemedid.common.response.ResponseUtility;
import com.medallies.lifemedid.dto.LifeMedDocument;
import com.medallies.lifemedid.dto.request.RequestParams;
import com.medallies.lifemedid.service.MedIDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * The type Med id rest web service.
 */
@Path("/{document : (?i)document}")
@Component
public class MedIDRestWebService {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(MedIDRestWebService.class);

    /**
     * The Med id service.
     */
    @Resource
    private MedIDService medIDService;

    /**
     * Save idp documents response.
     *
     * @param lifeMedDocument the life med document
     * @param isError         the is error
     * @return the response
     */
    @Path("/{lifemeddocument: (?i)lifemeddocument}")
    @POST
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response saveIDPDocuments (LifeMedDocument lifeMedDocument,
                                      @QueryParam("isError") @DefaultValue("true") boolean isError) {

        logger.debug("Initializing #saveIDPDocuments()");

        logger.debug("incoming data is", lifeMedDocument);
        RequestParams requestParams = new RequestParams( );
        requestParams.setIsError(isError);
        try {
            Response response = medIDService.saveLifeMedIDData(lifeMedDocument, requestParams);
            logger.debug("Finishing #saveIDPDocuments()");
            return response;
        } catch ( Exception exception ) {
            logger.error("Exception occurred while procesing request", exception);
            return ResponseUtility.internalServerErrorMsg("Internal Server Error while creating LifeMedDocument");
        }

//        return Response.ok( ).entity("Successful save of LifeMedID Documents Data").build( );

    }

    /**
     * Gets life med data.
     *
     * @param isError the is error
     * @return the life med data
     */
    @Path("/{getlifemeddocuments: (?i)getlifemeddocuments}")
    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response getLifeMedData (@QueryParam("isError") @DefaultValue("true") boolean isError) {

        logger.debug("Initializing #getLifeMedData()");

        RequestParams requestParams = new RequestParams( );
        requestParams.setIsError(isError);

        Response response = medIDService.getAllLifeMedData(requestParams);

        logger.debug("Finishing #getLifeMedData()");
        return response;

//        return Response.ok( ).entity("Successful save of LifeMedID Documents Data").build( );

    }
}
