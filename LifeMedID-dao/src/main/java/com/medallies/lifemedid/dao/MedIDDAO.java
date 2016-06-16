package com.medallies.lifemedid.dao;

import com.medallies.lifemedid.domain.LifeMedDocument;
import com.medallies.lifemedid.response.DAOResponse;

import javax.annotation.Resource;

/**
 * The interface Med iddao.
 */
@Resource
public interface MedIDDAO {

    /**
     * Save data into db dao response.
     *
     * @param lifeMedDocument the life med document
     * @return the dao response
     */
    DAOResponse<LifeMedDocument> saveDataIntoDB (LifeMedDocument lifeMedDocument);

    /**
     * Gets all data from db.
     *
     * @return the all data from db
     */
    DAOResponse<LifeMedDocument> getAllDataFromDB ();

    DAOResponse<Integer> deleteLifeMedDocument (LifeMedDocument lifeMedDocument);
}
