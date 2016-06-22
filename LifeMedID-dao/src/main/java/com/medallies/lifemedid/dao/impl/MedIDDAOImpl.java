package com.medallies.lifemedid.dao.impl;

import com.medallies.lifemedid.constants.DAOConstants;
import com.medallies.lifemedid.dao.BasicDAO;
import com.medallies.lifemedid.dao.MedIDDAO;
import com.medallies.lifemedid.domain.IDPDocument;
import com.medallies.lifemedid.domain.LifeMedDocument;
import com.medallies.lifemedid.domain.TransactionDocs;
import com.medallies.lifemedid.exception.response.ErrorContainer;
import com.medallies.lifemedid.response.DAOResponse;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Med iddao.
 */
@Repository
@Transactional(propagation = Propagation.MANDATORY, isolation = Isolation.DEFAULT)
public class MedIDDAOImpl extends BasicDAO implements MedIDDAO {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(MedIDDAOImpl.class);

    /**
     * Save data into db dao response.
     *
     * @param lifeMedDocument the idp document list
     * @return the dao response
     */
    @Override
    @Transactional(propagation = Propagation.NESTED, isolation = Isolation.REPEATABLE_READ)
    public DAOResponse<LifeMedDocument> saveDataIntoDB (LifeMedDocument lifeMedDocument) {

        String location = this.getClass( ).getCanonicalName( ) + "#$saveDataIntoDB()";
        logger.debug("Starting " + location);

        DAOResponse<LifeMedDocument> lifeMedDocumentDAOResponse = new DAOResponse<LifeMedDocument>( );
        List<LifeMedDocument> lifeMedDocumentList = new ArrayList<LifeMedDocument>( );
        ErrorContainer errorContainer = new ErrorContainer( );

        try {
            this.openDBTransaction( );
//            for (IDPDocument idpDocument : lifeMedDocument.getIdpDocumentList( )) {
//                session.saveOrUpdate(idpDocument);
//            }
            session.saveOrUpdate(lifeMedDocument);
//            session.saveOrUpdate(lifeMedDocument);
            this.closeDBTransaction( );

//            this.openDBTransaction( );

//            session.saveOrUpdate(lifeMedDocument.getApplicant( ));
//            for (IDPDocument idpDocument: lifeMedDocument.getIdpDocumentList()) {
//                idpDocument.setApplicant(lifeMedDocument.getApplicant());
//                session.saveOrUpdate(lifeMedDocument);
//                session.saveOrUpdate(idpDocument);
//            }
//            for(TransactionDocs transactionDocs: lifeMedDocument.getTransactionDocsList()) {
//                session.save(transactionDocs);
//            }
            this.closeDBTransaction( );
            lifeMedDocumentDAOResponse.setCount(DAOConstants.ONE);

            // is create Request
            lifeMedDocumentDAOResponse.setCreate(true);
            // query ran successfully
            lifeMedDocumentDAOResponse.setRequestSuccess(true);

            // add the empty list then add the iDPDocuments object to it
            lifeMedDocumentDAOResponse.setResults(lifeMedDocumentList);
            lifeMedDocumentList.add(lifeMedDocument);

        } catch ( HibernateException exception ) {
//            logger.error("Hibernate exception occurred while trying to save LifeMedDocument", exception);
            this.handleExceptions(exception);
            errorContainer.addError(this.fillErrorContainer(location, exception).getCurrentError( ));
//                errorContainer = this.fillErrorContainer(location, exception);
        }


        lifeMedDocumentDAOResponse.setErrorContainer(errorContainer);
        logger.debug("Finishing " + location);

        return lifeMedDocumentDAOResponse;
    }

    /**
     * Gets all data from db.
     *
     * @return the all data from db
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
    public DAOResponse<LifeMedDocument> getAllDataFromDB () {

        String location = this.getClass( ).getCanonicalName( ) + "#getAllDataFromDB()";
        logger.debug("Starting " + location);

        DAOResponse<LifeMedDocument> lifeMedDocumentDAOResponse = new DAOResponse<LifeMedDocument>( );
        List<LifeMedDocument> lifeMedDocumentList;
        ErrorContainer errorContainer = new ErrorContainer( );

        try {
            this.openDBTransaction( );
            Query query = session.createQuery("from LifeMedDocument ");
            lifeMedDocumentList = query.list( );
            this.closeDBTransaction( );
            lifeMedDocumentDAOResponse.setCount(lifeMedDocumentList.size( ));

            // query ran successfully
            lifeMedDocumentDAOResponse.setRequestSuccess(true);

            // add the empty list then add the iDPDocuments object to it
            lifeMedDocumentDAOResponse.setResults(lifeMedDocumentList);

        } catch ( HibernateException exception ) {
            logger.error("Hibernate exception occurred while trying to save LifeMedDocument", exception);
            this.handleExceptions(exception);
            errorContainer.addError(this.fillErrorContainer(location, exception).getCurrentError( ));
//                errorContainer = this.fillErrorContainer(location, exception);
        }


        lifeMedDocumentDAOResponse.setErrorContainer(errorContainer);
        logger.debug("Finishing " + location);

        return lifeMedDocumentDAOResponse;
    }

    /**
     * Delete life med document dao response.
     *
     * @param lifeMedDocument the life med document
     * @return the dao response
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public DAOResponse<Integer> deleteLifeMedDocument (LifeMedDocument lifeMedDocument) {

        String location = this.getClass( ).getCanonicalName( ) + "#deleteLifeMedDocument()";
        logger.debug("Starting " + location);

        DAOResponse<Integer> lifeMedDocumentDAOResponse = new DAOResponse<Integer>( );
        List<Integer> deleteCounts = new ArrayList<Integer>( );
        ErrorContainer errorContainer = new ErrorContainer( );

        try {
            this.openDBTransaction( );

            Query query = session.createQuery("delete LifeMedDocument where transactionId=:transactionId");
            query.setString("transactionId", lifeMedDocument.getTransactionId( ));

            int deletedCount = query.executeUpdate( );
            deleteCounts.add(deletedCount);

            this.closeDBTransaction( );
            lifeMedDocumentDAOResponse.setCount(deleteCounts.size( ));

            // query ran successfully
            lifeMedDocumentDAOResponse.setRequestSuccess(true);
            lifeMedDocumentDAOResponse.setDelete(true);


            // add the empty list then add the iDPDocuments object to it
            lifeMedDocumentDAOResponse.setResults(deleteCounts);

        } catch ( HibernateException exception ) {
            logger.error("Hibernate exception occurred while trying to delete LifeMedDocument", exception);
            this.handleExceptions(exception);
            errorContainer.addError(this.fillErrorContainer(location, exception).getCurrentError( ));
//                errorContainer = this.fillErrorContainer(location, exception);
        }


        lifeMedDocumentDAOResponse.setErrorContainer(errorContainer);
        logger.debug("Finishing " + location);

        return lifeMedDocumentDAOResponse;
    }
}
