package com.medallies.lifemedid.dao.impl;

import com.medallies.lifemedid.constants.TestConstants;
import com.medallies.lifemedid.dao.CreateDummyDocumentObjects;
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
 * The type When med iddao impl then test create methods.
 */
@ContextConfiguration(locations = { "/db_config_test.xml" })
@RunWith(value = SpringJUnit4ClassRunner.class)
@Transactional
public class WhenMedIDDAOImplThenTestCreateMethods {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(WhenMedIDDAOImplThenTestCreateMethods.class);

    /**
     * The Med iddao.
     */
    @Resource
    private MedIDDAO medIDDAO;

    /**
     * The Life med document domain.
     */
    private LifeMedDocument lifeMedDocumentDomain;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp () throws Exception {
        logger.debug(TestConstants.setUpMethodLoggerMsg);

        lifeMedDocumentDomain = CreateDummyDocumentObjects.createLifeMedDocumentDomain( );
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
     * Test save data into db.
     *
     * @throws Exception the exception
     */
    @SuppressWarnings("unchecked")
    @Test
    @Rollback
    public void testSaveDataIntoDB () throws Exception {

        String location = this.getClass( ).getCanonicalName( ) + "#testSaveDataIntoDB()";
        logger.debug("Starting " + location);

        DAOResponse<LifeMedDocument> lifeMedDocumentDAOResponse = medIDDAO.saveDataIntoDB(lifeMedDocumentDomain);

        Assert.assertNotNull(lifeMedDocumentDAOResponse);
        Assert.assertTrue(lifeMedDocumentDAOResponse.getCount( ) > 0);
        Assert.assertTrue(lifeMedDocumentDAOResponse.isRequestSuccess( ));

        logger.debug("Finishing " + location);
    }
}