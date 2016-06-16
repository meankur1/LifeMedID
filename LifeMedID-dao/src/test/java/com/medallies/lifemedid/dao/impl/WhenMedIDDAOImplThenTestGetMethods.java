package com.medallies.lifemedid.dao.impl;

import com.medallies.lifemedid.constants.DAOConstants;
import com.medallies.lifemedid.constants.TestConstants;
import com.medallies.lifemedid.dao.MedIDDAO;
import com.medallies.lifemedid.domain.LifeMedDocument;
import com.medallies.lifemedid.response.DAOResponse;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * The type When med iddao impl then test get methods.
 */
@ContextConfiguration(locations = { "/db_config_test.xml" })
@RunWith(value = SpringJUnit4ClassRunner.class)
@Transactional
public class WhenMedIDDAOImplThenTestGetMethods {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(WhenMedIDDAOImplThenTestGetMethods.class);

    /**
     * The Med iddao.
     */
    @Resource
    private MedIDDAO medIDDAO;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp () throws Exception {
        logger.debug(TestConstants.setUpMethodLoggerMsg);

    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public void tearDown () throws Exception {

        logger.debug(TestConstants.tearDownMethodLoggerMsg);
    }

    /**
     * Test get all data from db.
     *
     * @throws Exception the exception
     */
    @SuppressWarnings("unchecked")
    @Test
    @Rollback
    public void testGetAllDataFromDB () throws Exception {

        String location = this.getClass( ).getCanonicalName( ) + "#testGetAllDataFromDB()";
        logger.debug("Starting " + location);

        DAOResponse<LifeMedDocument> lifeMedDocumentDAOResponse = medIDDAO.getAllDataFromDB( );

        //Note Test DAOREsponse Properties 1st
        Assert.assertNotNull(TestConstants.nullMessage, lifeMedDocumentDAOResponse);
        Assert.assertNotNull(TestConstants.nullMessage, lifeMedDocumentDAOResponse.getResults( ));
        Assert.assertFalse(TestConstants.trueMessage, lifeMedDocumentDAOResponse.getResults( ).isEmpty( ));
        Assert.assertEquals(TestConstants.notEqualsMessage, lifeMedDocumentDAOResponse.getCount( ),
                lifeMedDocumentDAOResponse.getResults( ).size( ));

        //Note Test ErrorContainer
        Assert.assertNotNull(TestConstants.nullMessage, lifeMedDocumentDAOResponse.getErrorContainer( ));
        Assert.assertNotNull(TestConstants.notNullMessage, lifeMedDocumentDAOResponse.getErrorContainer( ).getErrors(

        ));
        Assert.assertTrue(TestConstants.notNullMessage, lifeMedDocumentDAOResponse.getErrorContainer( ).getErrors( )
                .isEmpty( ));

        LifeMedDocument lifeMedDocumentDomain = lifeMedDocumentDAOResponse.getResults( ).get(DAOConstants.ZERO);

        //Note Test LifeMedDocument properties and inner classes primarily
        Assert.assertNotNull(TestConstants.nullMessage, lifeMedDocumentDomain);
        Assert.assertNotNull(TestConstants.nullMessage, lifeMedDocumentDomain.getApplicant( ));
        Assert.assertNotNull(TestConstants.nullMessage, lifeMedDocumentDomain.getApplicant( ).getIdpDocuments( ));
        Assert.assertFalse(TestConstants.trueMessage, lifeMedDocumentDomain.getApplicant( ).getIdpDocuments( )
                .isEmpty( ));

        logger.debug("Finishing " + location);
    }
}