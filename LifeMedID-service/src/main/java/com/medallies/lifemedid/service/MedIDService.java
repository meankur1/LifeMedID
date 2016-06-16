package com.medallies.lifemedid.service;

import com.medallies.lifemedid.dto.LifeMedDocument;
import com.medallies.lifemedid.dto.request.RequestParams;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;


/**
 * The interface Med id service.
 */
@Service
public interface MedIDService {

    /**
     * Save life med id data response.
     *
     * @param lifeMedDocument the life med document
     * @param requestParams   the request params
     * @return the response
     */
    Response saveLifeMedIDData (LifeMedDocument lifeMedDocument, RequestParams requestParams);

    /**
     * Gets all life med data.
     *
     * @param requestParams the request params
     * @return the all life med data
     */
    Response getAllLifeMedData (RequestParams requestParams);

    Response deleteLifeMedIDData (LifeMedDocument dummyLifeMedDocument, RequestParams requestParams, boolean hasPermission);
}
