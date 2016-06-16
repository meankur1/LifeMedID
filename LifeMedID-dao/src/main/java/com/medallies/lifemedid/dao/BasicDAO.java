package com.medallies.lifemedid.dao;

import com.medallies.lifemedid.dto.request.RequestParams;
import com.medallies.lifemedid.exception.response.Error;
import com.medallies.lifemedid.exception.response.ErrorContainer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * The type Basic dAO.
 */
public class BasicDAO {

	/**
	 * The constant logger.
	 */
	protected static final Logger logger = LoggerFactory.getLogger(BasicDAO.class);

	/**
	 * The Session.
	 */
	protected Session session;

	/**
	 * The Transaction.
	 */
	protected Transaction transaction;

	/**
	 * The Session factory.
	 */
	@Resource
    protected SessionFactory sessionFactory;

	/**
	 * Open dB transaction.
	 */
	protected void openDBTransaction () {
        logger.debug(" Trying to open Hibernate DB Transaction ");
        try {
            if (sessionFactory == null) {
                NullPointerException exception = new NullPointerException("Session " + "Factory is Null");
                logger.error("Session Factory inject is Null", exception);
                throw exception;
            }
            session = sessionFactory.getCurrentSession( );
            // Note Hib transaction vs spring Transaction
            // transaction = session.beginTransaction();
        } catch ( Exception e ) {
            logger.error("Current Session error from Session Factory, either Transaction Manager Config issue "
                    + "or no DB Connection ", e);
        }
        logger.debug("Hibernate DB Transaction Opened");
    }

	/**
	 * Close dB transaction.
	 */
	protected void closeDBTransaction () {

        logger.debug("Trying to Flush Hibernate Transaction");
        if (session != null) {
            session.flush( );
        }
        logger.debug("Flushed Hibernate DB Transaction");
    }

	/**
	 * Handle exceptions.
	 *
	 * @param exception the exception
	 */
	protected void handleExceptions (HibernateException exception) {

        // if (transaction != null) {
        // transaction.rollback();
        // }
        logger.error("Hibernate Exception occurred with \nmessage: " + exception.getMessage( ), exception);
    }

	/**
	 * Fill error container.
	 *
	 * @param location  the location
	 * @param exception the exception
	 * @return the error container
	 */
	protected ErrorContainer fillErrorContainer (String location, Exception exception) {

        logger.debug("**** Recording Error Container Object");
        ErrorContainer errorContainer = new ErrorContainer( );
        errorContainer.addError(new Error(location, exception));
        return errorContainer;
    }


	/**
	 * Ge page query string.
	 *
	 * @param requestParams the request params
	 * @param tableName     the table name
	 * @return the string
	 */
	public String gePageQuery (final RequestParams requestParams, final String tableName) {

        String pageQuery = " from " + tableName + " ";

        Long startLimit = requestParams.getStartLimit( );
        Long endLimit = requestParams.getEndLimit( );
        Integer pageSize = requestParams.getPageSize( );

        // Note Priority, default page order is ascending
        String id = tableName.toLowerCase( ) + "Id";
        if (startLimit != null && endLimit != null) {
            if (startLimit > endLimit && startLimit > 0 && endLimit > 0) {
                long temp = startLimit;
                startLimit = endLimit;
                endLimit = temp;
            }
            pageQuery += " where " + id + ">=" + startLimit + " and " + id + "<=" + endLimit + " order by " + id + " " +
					"ASC";
        } else
            // Note Second Priority, default page order is ascending
            if (startLimit != null && pageSize != null) {
                pageQuery += " where " + id + ">=" + startLimit + " order by " + id + " ASC ";//limit "+pageSize;
            }
        return pageQuery;
    }

	/**
	 * Gets session factory.
	 *
	 * @return the session factory
	 */
	public SessionFactory getSessionFactory () {

        return sessionFactory;
    }

	/**
	 * Sets session factory.
	 *
	 * @param sessionFactory the session factory
	 */
	public void setSessionFactory (SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

}

/*
 * // IMP DELIMITER $$
 * 
 * USE `bloom`$$
 * 
 * DROP TRIGGER -- !50032 IF EXISTS `trigger_date_insert_shops`$$
 * 
 * CREATE -- !50017 DEFINER = 'root'@'localhost' TRIGGER `trigger_date_insert_shops` BEFORE INSERT ON `shops` FOR EACH
 * ROW BEGIN SET NEW.created_date = NOW(); SET NEW.updated_date = NOW(); END; $$
 * 
 * DELIMITER ;
 */
/*
 * DELIMITER $$
 * 
 * USE `bloom`$$
 * 
 * DROP TRIGGER -- !50032 IF EXISTS `trigger_update_date_modify_shops`$$
 * 
 * CREATE -- !50017 DEFINER = 'root'@'localhost' TRIGGER `trigger_update_date_modify_shops` BEFORE UPDATE ON `shops` FOR
 * EACH ROW BEGIN SET NEW.updated_date = NOW(); END; $$
 * 
 * DELIMITER ;
 */
