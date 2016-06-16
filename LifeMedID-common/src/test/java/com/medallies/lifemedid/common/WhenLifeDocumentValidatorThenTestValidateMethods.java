package com.medallies.lifemedid.common;

import com.medallies.lifemedid.common.dummy.CreateDummyDocumentObjects;
import com.medallies.lifemedid.constants.TestConstants;
import com.medallies.lifemedid.dto.Applicant;
import com.medallies.lifemedid.dto.IDPDocument;
import com.medallies.lifemedid.dto.LifeMedDocument;
import com.medallies.lifemedid.dto.Uploader;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * The type When idp document validator then test validate methods.
 */
@RunWith(value = BlockJUnit4ClassRunner.class)
public class WhenLifeDocumentValidatorThenTestValidateMethods {

    /**
     * The constant logger.
     */
    private static final Logger logger = LoggerFactory.getLogger(WhenLifeDocumentValidatorThenTestValidateMethods.class);

    /**
     * The Life med document.
     */
    private LifeMedDocument lifeMedDocumentDTO, dummyLifeMedDocument;


    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp () throws Exception {
        logger.debug(TestConstants.setUpMethodLoggerMsg);

        lifeMedDocumentDTO = new LifeMedDocument( );

        Applicant applicant = new Applicant( );
        applicant.setDateOfBirth("1989-02-15");
        applicant.setFirstName("First Name");
        applicant.setLastName("Last Name");
        applicant.setId("TestID1");

        IDPDocument idpDocument = new IDPDocument( );

        idpDocument.setDateOfBirth("1975-12-01");
        idpDocument.setDocumentType("A1");
        idpDocument.setFirstName("First Name");
        idpDocument.setLastName("Last Name");
        idpDocument.setMiddleName("Middle Name");
        idpDocument.setDocIssuer("ND");
        idpDocument.setDocExpirationDate("2015-12-01");

        List<IDPDocument> idpDocumentList = new ArrayList<IDPDocument>( );

        idpDocumentList.add(idpDocument);

        Uploader uploader = new Uploader();

        uploader.setTransactionId("TransactionTest1");
        uploader.setPersonId("PersonTest1");
        uploader.setOrganizationId("OrgTest1");


        lifeMedDocumentDTO.setUploader(uploader);
        lifeMedDocumentDTO.setApplicant(applicant);
        lifeMedDocumentDTO.setIdpDocumentList(idpDocumentList);

        dummyLifeMedDocument = CreateDummyDocumentObjects.createLifeMedDocumentDomain();

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
     * Test validate with valid values.
     *
     * @throws Exception the exception
     */
    @Test(expected = Test.None.class)
    public void testValidateWithValidValues () throws Exception {

        String location = this.getClass( ).getCanonicalName( ) + "#testValidateWithValidValues()";
        logger.debug("Starting " + location);

        String validation = LifeMedDocumentValidator.validate(lifeMedDocumentDTO);
        logger.info(validation);
        Assert.assertNull(TestConstants.notNullMessage, validation);

        validation = LifeMedDocumentValidator.validate(dummyLifeMedDocument);
        logger.info(validation);
        Assert.assertNull(TestConstants.notNullMessage, validation);

        logger.debug("Finishing " + location);
    }

    /**
     * Test validate with in valid values.
     *
     * @throws Exception the exception
     */
    @Test(expected = Test.None.class)
    public void testValidateWithInValidValues () throws Exception {

        String location = this.getClass( ).getCanonicalName( ) + "#testValidateWithValidValues()";
        logger.debug("Starting " + location);

        lifeMedDocumentDTO.getIdpDocumentList( ).get(TestConstants.ZERO).setFirstName(null);
        lifeMedDocumentDTO.getIdpDocumentList( ).get(TestConstants.ZERO).setLastName(" ");


        lifeMedDocumentDTO.getApplicant( ).setFirstName(null);
        lifeMedDocumentDTO.getApplicant( ).setLastName(" ");

        lifeMedDocumentDTO.setUploader(null);

        String validation = LifeMedDocumentValidator.validate(lifeMedDocumentDTO);
        Assert.assertNotNull(TestConstants.nullMessage, validation);

        logger.debug("Finishing " + location);
    }

    /**
     * Test validate date with valid dates.
     *
     * @throws Exception the exception
     */
    @Test
    public void testValidateDateWithValidDates () throws Exception {

        String location = this.getClass( ).getCanonicalName( ) + "#testValidateDateWithValidDates()";
        logger.debug("Starting " + location);

        Assert.assertTrue(LifeMedDocumentValidator.validateDate("1975-12-05"));
        Assert.assertTrue(LifeMedDocumentValidator.validateDate("1975-12-05"));
        Assert.assertTrue(LifeMedDocumentValidator.validateDate("1975-12-05"));

        logger.debug("Finishing " + location);
    }


    /**
     * Test validate date with in valid dates.
     *
     * @throws Exception the exception
     */
    @Test
    public void testValidateDateWithInValidDates () throws Exception {

        String location = this.getClass( ).getCanonicalName( ) + "#testValidateDateWithInValidDates()";
        logger.debug("Starting " + location);

        Assert.assertFalse(LifeMedDocumentValidator.validateDate("1975-112-05"));
        Assert.assertFalse(LifeMedDocumentValidator.validateDate("1975-12-55"));
        Assert.assertFalse(LifeMedDocumentValidator.validateDate("19752-12-05"));
        Assert.assertFalse(LifeMedDocumentValidator.validateDate("sdfsf"));
        Assert.assertFalse(LifeMedDocumentValidator.validateDate("dsfsd-1975-12-05"));
        Assert.assertFalse(LifeMedDocumentValidator.validateDate("-100"));

        logger.debug("Finishing " + location);
    }

    /**
     * Test validate string.
     *
     * @throws Exception the exception
     */
    @Test
    public void testValidateString () throws Exception {

        String location = this.getClass( ).getCanonicalName( ) + "#ValidateString()";
        logger.debug("Starting " + location);

        Assert.assertFalse(TestConstants.trueMessage, LifeMedDocumentValidator.validateString(""));
        Assert.assertFalse(TestConstants.trueMessage, LifeMedDocumentValidator.validateString(null));
        Assert.assertTrue(TestConstants.falseMessage, LifeMedDocumentValidator.validateString(TestConstants.DEFAULT_DESCRIPTION));
        logger.debug("Finishing " + location);
    }
}