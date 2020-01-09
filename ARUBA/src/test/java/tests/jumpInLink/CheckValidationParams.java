package tests.jumpInLink;

import helpers.AllureAssert;
import helpers.Logging;
import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.getDate;

public class CheckValidationParams extends BaseTest implements Logging {

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=1)
    public void checkErrorMessageWithEmptyOriginUIC() {
        jumpInLink.build(
                "en",
                "",
                "Bern",
                "8014309",
                "Offenburg",
                 getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"),
                "D",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                 jumpInLink.generateSecureToken("", "Bern", "8014309", "Offenburg",
                         getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"), "D", "TT", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.errorOnRequestMessage));
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"An unexpected error has occured.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=2)
    public void checkErrorMessageWithWrongOriginUIC() {
        jumpInLink.build(
                "en",
                "9999999999999",
                "Bern",
                "8014309",
                "Offenburg",
                 getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"),
                "D",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                 jumpInLink.generateSecureToken("9999999999999", "Bern", "8014309", "Offenburg",
                         getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"), "D", "TT", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.mainError));
        AllureAssert.assertEquals(cfdPage.getTextMainError(),"An unexpected error has occured. Please try again at a later point.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.retryEnquiryBtn));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=3)
    public void checkErrorMessageWithEmptyOriginName() {
        jumpInLink.build(
                "en",
                "8507000",
                "",
                "8014309",
                "Offenburg",
                 getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"),
                "D",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                 jumpInLink.generateSecureToken("8507000", "", "8014309", "Offenburg",
                        getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"), "D", "TT", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.errorOnRequestMessage));
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"An unexpected error has occured.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=4)
    public void checkErrorMessageWithEmptyDestinationUIC() {
        jumpInLink.build(
                "en",
                "8507000",
                "Bern",
                "",
                "Offenburg",
                 getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"),
                "D",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                 jumpInLink.generateSecureToken("8507000", "Bern", "", "Offenburg",
                        getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"), "D", "TT", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.errorOnRequestMessage));
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"An unexpected error has occured.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=5)
    public void checkErrorMessageWithWrongDestinationUIC() {
        jumpInLink.build(
                "en",
                "8507000",
                "Bern",
                "9999999999999",
                "Offenburg",
                 getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"),
                "D",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                 jumpInLink.generateSecureToken("8507000", "Bern", "9999999999999", "Offenburg",
                        getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"), "D", "TT", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.mainError));
        AllureAssert.assertEquals(cfdPage.getTextMainError(),"An unexpected error has occured. Please try again at a later point.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.retryEnquiryBtn));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=6)
    public void checkErrorMessageWithEmptyDestinationName() {
        jumpInLink.build(
                "en",
                "8507000",
                "Bern",
                "8014309",
                "",
                 getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"),
                "D",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                jumpInLink.generateSecureToken("8507000", "Bern", "8014309", "",
                        getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"), "D", "TT", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.errorOnRequestMessage));
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"An unexpected error has occured.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=7)
    public void checkErrorMessageWithEmptyDateTime() {
        jumpInLink.build(
                "en",
                "8507000",
                "Bern",
                "8014309",
                "Offenburg",
                "",
                "D",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                 jumpInLink.generateSecureToken("8507000", "Bern", "8014309", "Offenburg",
                        "", "D", "TT", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.errorOnRequestMessage));
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"An unexpected error has occured.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=8)
    public void checkErrorMessageWithWrongDateTime() {
        jumpInLink.build(
                "en",
                "8507000",
                "Bern",
                "8014309",
                "Offenburg",
                "Wrong",
                "D",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                jumpInLink.generateSecureToken("8507000", "Bern", "8014309", "Offenburg",
                        "Wrong", "D", "TT", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.errorOnRequestMessage));
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"An unexpected error has occured.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=9)
    public void checkErrorMessageWithEmptySearchMode() {
        jumpInLink.build(
                "en",
                "8507000",
                "Bern",
                "8014309",
                "Offenburg",
                getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"),
                "",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                jumpInLink.generateSecureToken("8507000", "Bern", "8014309", "Offenburg",
                        getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"), "", "TT", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.errorOnRequestMessage));
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"An unexpected error has occured.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=10)
    public void checkErrorMessageWithWrongSearchMode() {
        jumpInLink.build(
                "en",
                "8507000",
                "Bern",
                "8014309",
                "Offenburg",
                getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"),
                "Wrong",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                jumpInLink.generateSecureToken("8507000", "Bern", "8014309", "Offenburg",
                        getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"), "Wrong", "TT", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.errorOnRequestMessage));
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"An unexpected error has occured.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=11)
    public void checkErrorMessageWithEmptyLayoutMode() {
        jumpInLink.build(
                "en",
                "8507000",
                "Bern",
                "8014309",
                "Offenburg",
                getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"),
                "D",
                "",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                jumpInLink.generateSecureToken("8507000", "Bern", "8014309", "Offenburg",
                        getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"), "D", "", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.errorOnRequestMessage));
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"An unexpected error has occured.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=12)
    public void checkErrorMessageWithWrongLayoutMode() {
        jumpInLink.build(
                "en",
                "8507000",
                "Bern",
                "8014309",
                "Offenburg",
                getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"),
                "D",
                "Wrong",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                jumpInLink.generateSecureToken("8507000", "Bern", "8014309", "Offenburg",
                        getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"), "D", "Wrong", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.errorOnRequestMessage));
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"An unexpected error has occured.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=13)
    public void checkErrorMessageWithEmptyCurrencyRate() {
        jumpInLink.build(
                "en",
                "8507000",
                "Bern",
                "8014309",
                "Offenburg",
                getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"),
                "D",
                "TT",
                "",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                jumpInLink.generateSecureToken("8507000", "Bern", "8014309", "Offenburg",
                        getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"), "D", "TT", "", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.errorOnRequestMessage));
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"An unexpected error has occured.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=14)
    public void checkErrorMessageWithoutDigitsInCurrencyRate() {
        jumpInLink.build(
                "en",
                "8507000",
                "Bern",
                "8014309",
                "Offenburg",
                getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"),
                "D",
                "TT",
                "Wrong",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                jumpInLink.generateSecureToken("8507000", "Bern", "8014309", "Offenburg",
                        getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"), "D", "TT", "Wrong", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.errorOnRequestMessage));
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"An unexpected error has occured.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=15)
    public void checkErrorMessageWithEmptyBackURL() {
        jumpInLink.build(
                "en",
                "8507000",
                "Bern",
                "8014309",
                "Offenburg",
                getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"),
                "D",
                "TT",
                "1.2",
                "",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                jumpInLink.generateSecureToken("8507000", "Bern", "8014309", "Offenburg",
                        getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"), "D", "TT", "1.2", "", "https://test-www.sbb.ch/ticketshop/b2c/"));
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.errorOnRequestMessage));
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"An unexpected error has occured.");
        AllureAssert.assertFalse(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=16)
    public void checkErrorMessageWithEmptySecureToken() {
        jumpInLink.build(
                "en",
                "8507000",
                "Bern",
                "8014309",
                "Offenburg",
                getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"),
                "D",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                "");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.errorOnRequestMessage));
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"An unexpected error has occured.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, priority=17)
    public void checkErrorMessageWithWrongSecureToken() {
        jumpInLink.build(
                "en",
                "8507000",
                "Bern",
                "8014309",
                "Offenburg",
                getDate("yyyy-MM-dd'T'hh:mm:ss", "+7days"),
                "D",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                "Wrong");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.errorOnRequestMessage));
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"An unexpected error has occured.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }
}