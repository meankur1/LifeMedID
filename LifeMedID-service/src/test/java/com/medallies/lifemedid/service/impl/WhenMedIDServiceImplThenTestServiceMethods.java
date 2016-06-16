package com.medallies.lifemedid.service.impl;

import com.medallies.lifemedid.constants.DAOConstants;
import com.medallies.lifemedid.constants.ServiceConstants;
import com.medallies.lifemedid.constants.TestConstants;
import com.medallies.lifemedid.dto.LifeMedDocument;
import com.medallies.lifemedid.dto.payload.LifeMedDocumentPayload;
import com.medallies.lifemedid.dto.request.RequestParams;
import com.medallies.lifemedid.service.MedIDService;
import com.medallies.lifemedid.service.container.LifeMedDocumentResponseContainer;
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
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;
import com.medallies.lifemedid.common.dummy.CreateDummyDocumentObjects;
/**
 * The type When med id service impl then test service methods.
 */
@ContextConfiguration(locations = { "/service_config_test.xml", "/db_config_test.xml" })
@RunWith(value = SpringJUnit4ClassRunner.class)
@Transactional
public class WhenMedIDServiceImplThenTestServiceMethods {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(WhenMedIDServiceImplThenTestServiceMethods.class);

    /**
     * The Med id service.
     */
    @Resource
    private MedIDService medIDService;

    /**
     * The Request params.
     */
    private RequestParams requestParams;

    /**
     * The Dummy life med document.
     */
    private LifeMedDocument dummyLifeMedDocument;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp () throws Exception {

        logger.debug(TestConstants.setUpMethodLoggerMsg);

        requestParams = new RequestParams( );
        requestParams.setIsError(true);
        dummyLifeMedDocument = CreateDummyDocumentObjects.createLifeMedDocumentDomain();
    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    @AfterTransaction
    public void tearDown () throws Exception {

        medIDService.deleteLifeMedIDData(dummyLifeMedDocument, requestParams, true);
        logger.debug(TestConstants.tearDownMethodLoggerMsg);
    }

    /**
     * Test save life med id data.
     *
     * @throws Exception the exception
     */
    @SuppressWarnings("unchecked")
    @Test
    @Rollback
    public void testSaveLifeMedIDData () throws Exception {

        String location = this.getClass( ).getCanonicalName( ) + "#SaveLifeMedIDData()";
        logger.debug("Starting " + location);

        Response response = medIDService.saveLifeMedIDData(dummyLifeMedDocument, requestParams);
        Assert.assertNotNull(TestConstants.nullMessage, response);
        Assert.assertEquals(TestConstants.notEqualsMessage, Response.Status.OK.getStatusCode( ), response.getStatus( ));
        Assert.assertNotNull(TestConstants.nullMessage, response.getEntity( ));

        LifeMedDocumentResponseContainer lifeMedDocumentResponseContainer = (LifeMedDocumentResponseContainer)
                response.getEntity( );
        Assert.assertNotNull(TestConstants.nullMessage, lifeMedDocumentResponseContainer.getTimestamp( ));
        Assert.assertNotNull(TestConstants.nullMessage, lifeMedDocumentResponseContainer.getTransactionId( ));
        Assert.assertNotNull(TestConstants.nullMessage, lifeMedDocumentResponseContainer.getStatus( ));

        Assert.assertFalse(TestConstants.trueMessage, lifeMedDocumentResponseContainer.getStatus( ).toUpperCase( )
                .equals(ServiceConstants.ERROR));
        Assert.assertTrue(TestConstants.falseMessage, StringUtils.isEmpty(lifeMedDocumentResponseContainer
                .getDescription( )));

        logger.debug("Finishing " + location);
    }

    /**
     * Test get all life med data.
     *
     * @throws Exception the exception
     */
    @SuppressWarnings("unchecked")
    @Test
    @Rollback
    public void testGetAllLifeMedData () throws Exception {

        String location = this.getClass( ).getCanonicalName( ) + "#GetAllLifeMedData()";
        logger.debug("Starting " + location);

        Response response = medIDService.getAllLifeMedData(requestParams);

        Assert.assertNotNull(TestConstants.nullMessage, response);
        Assert.assertEquals(TestConstants.notEqualsMessage, Response.Status.OK.getStatusCode( ), response.getStatus( ));
        Assert.assertNotNull(TestConstants.nullMessage, response.getEntity( ));

        LifeMedDocumentResponseContainer<LifeMedDocumentPayload<LifeMedDocument>> lifeMedDocumentResponseContainer =
                (LifeMedDocumentResponseContainer<LifeMedDocumentPayload<LifeMedDocument>>) response.getEntity( );
        Assert.assertNotNull(TestConstants.nullMessage, lifeMedDocumentResponseContainer.getPayload( ));
        Assert.assertNotNull(TestConstants.nullMessage, lifeMedDocumentResponseContainer.getPayload( ).getTList( ));
        Assert.assertFalse(TestConstants.trueMessage, lifeMedDocumentResponseContainer.getPayload( ).getTList( )
                .isEmpty( ));

        LifeMedDocument lifeMedDocument = lifeMedDocumentResponseContainer.getPayload( ).getTList( ).get(DAOConstants
                .ZERO);

        Assert.assertNotNull(TestConstants.nullMessage, lifeMedDocument);
        Assert.assertNotNull(TestConstants.nullMessage, lifeMedDocument.getApplicant( ));
        Assert.assertNotNull(TestConstants.nullMessage, lifeMedDocument.getUploader( ));
        Assert.assertNotNull(TestConstants.nullMessage, lifeMedDocument.getIdpDocumentList( ));

        Assert.assertFalse(TestConstants.nullMessage, lifeMedDocument.getIdpDocumentList( ).isEmpty( ));

        logger.debug("Finishing " + location);
    }
}