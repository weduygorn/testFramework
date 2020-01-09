package tests.localization;

import helpers.GsonUtils;
import helpers.Logging;
import org.testng.annotations.Test;
import testData.TestDataProvider;
import tests.BaseTest;

import static helpers.DateTimeHelper.getDate;
import static pages.BasePage.attachText;

public class CheckTranslations extends BaseTest implements Logging {

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, dataProvider = "checkTranslations", dataProviderClass = TestDataProvider.class)
    public void checkDeutschLanguageByFooter(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        cfdPage.selectLanguage("de");
        attachText("CorrId", cfdPage.getCorrelationID());
        LOG.info("JumpInLinkUrl: " + jumpInLink.getJumpInLinkUrl());
        softAssert.assertEquals(cfdPage.getHeadingText(), GsonUtils.getText("heading", cfdPage.LANGUAGE), "Heading text not as expected");
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(GsonUtils.getText("searchDepartureMode", cfdPage.LANGUAGE)), "SearchMode text not as expected");
        softAssert.assertEquals(cfdPage.getEarlierButtonText(), GsonUtils.getText("earlierButton", cfdPage.LANGUAGE), "Earlier button text not as expected");
        softAssert.assertEquals(cfdPage.getLaterButtonText(), GsonUtils.getText("laterButton", cfdPage.LANGUAGE), "Later button text not as expected");
        softAssert.assertTrue(cfdPage.getDepTime(0).contains(GsonUtils.getText("connectionDep", cfdPage.LANGUAGE)), "Departure text not as expected");
        softAssert.assertTrue(cfdPage.getArrTime(0).contains(GsonUtils.getText("connectionArr", cfdPage.LANGUAGE)), "Arrival text not as expected");
        softAssert.assertTrue(cfdPage.getChanges(0).contains(GsonUtils.getText("connectionChange", cfdPage.LANGUAGE)), "Changes text not as expected");
        softAssert.assertTrue(cfdPage.getDurationText(0).contains(GsonUtils.getText("connectionDuration", cfdPage.LANGUAGE)), "Duration text not as expected");
        softAssert.assertTrue(cfdPage.getSecondClassTextLabel(0).contains(GsonUtils.getText("connection2Class", cfdPage.LANGUAGE)), "2nd Class text not as expected");
        softAssert.assertTrue(cfdPage.getFirstClassTextLabel(0).contains(GsonUtils.getText("connection1Class", cfdPage.LANGUAGE)), "1st Class text not as expected");
        softAssert.assertEquals(cfdPage.getPurchaseButtonText(), GsonUtils.getText("purchaseButton", cfdPage.LANGUAGE), "Purchase button text not as expected");
        softAssert.assertEquals(cfdPage.getBackButtonText(), GsonUtils.getText("backButton", cfdPage.LANGUAGE), "Back button text not as expected");
        softAssert.assertAll();
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, dataProvider = "checkTranslations", dataProviderClass = TestDataProvider.class)
    public void checkItalianoLanguageByFooter(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        cfdPage.selectLanguage("it");
        attachText("CorrId", cfdPage.getCorrelationID());
        LOG.info("JumpInLinkUrl: " + jumpInLink.getJumpInLinkUrl());
        softAssert.assertEquals(cfdPage.getHeadingText(), GsonUtils.getText("heading", cfdPage.LANGUAGE), "Heading text not as expected");
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(GsonUtils.getText("searchDepartureMode", cfdPage.LANGUAGE)), "SearchMode text not as expected");
        softAssert.assertEquals(cfdPage.getEarlierButtonText(), GsonUtils.getText("earlierButton", cfdPage.LANGUAGE), "Earlier button text not as expected");
        softAssert.assertEquals(cfdPage.getLaterButtonText(), GsonUtils.getText("laterButton", cfdPage.LANGUAGE), "Later button text not as expected");
        softAssert.assertTrue(cfdPage.getDepTime(0).contains(GsonUtils.getText("connectionDep", cfdPage.LANGUAGE)), "Departure text not as expected");
        softAssert.assertTrue(cfdPage.getArrTime(0).contains(GsonUtils.getText("connectionArr", cfdPage.LANGUAGE)), "Arrival text not as expected");
        softAssert.assertTrue(cfdPage.getChanges(0).contains(GsonUtils.getText("connectionChange", cfdPage.LANGUAGE)), "Changes text not as expected");
        softAssert.assertTrue(cfdPage.getDurationText(0).contains(GsonUtils.getText("connectionDuration", cfdPage.LANGUAGE)), "Duration text not as expected");
        softAssert.assertTrue(cfdPage.getSecondClassTextLabel(0).contains(GsonUtils.getText("connection2Class", cfdPage.LANGUAGE)), "2nd Class text not as expected");
        softAssert.assertTrue(cfdPage.getFirstClassTextLabel(0).contains(GsonUtils.getText("connection1Class", cfdPage.LANGUAGE)), "1st Class text not as expected");
        softAssert.assertEquals(cfdPage.getPurchaseButtonText(), GsonUtils.getText("purchaseButton", cfdPage.LANGUAGE), "Purchase button text not as expected");
        softAssert.assertEquals(cfdPage.getBackButtonText(), GsonUtils.getText("backButton", cfdPage.LANGUAGE), "Back button text not as expected");
        softAssert.assertAll();
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, dataProvider = "checkTranslations", dataProviderClass = TestDataProvider.class)
    public void checkFrançaisLanguageByFooter(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        cfdPage.selectLanguage("fr");
        attachText("CorrId", cfdPage.getCorrelationID());
        LOG.info("JumpInLinkUrl: " + jumpInLink.getJumpInLinkUrl());
        softAssert.assertEquals(cfdPage.getHeadingText(), GsonUtils.getText("heading", cfdPage.LANGUAGE), "Heading text not as expected");
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(GsonUtils.getText("searchDepartureMode", cfdPage.LANGUAGE)), "SearchMode text not as expected");
        softAssert.assertEquals(cfdPage.getEarlierButtonText(), GsonUtils.getText("earlierButton", cfdPage.LANGUAGE), "Earlier button text not as expected");
        softAssert.assertEquals(cfdPage.getLaterButtonText(), GsonUtils.getText("laterButton", cfdPage.LANGUAGE), "Later button text not as expected");
        softAssert.assertTrue(cfdPage.getDepTime(0).contains(GsonUtils.getText("connectionDep", cfdPage.LANGUAGE)), "Departure text not as expected");
        softAssert.assertTrue(cfdPage.getArrTime(0).contains(GsonUtils.getText("connectionArr", cfdPage.LANGUAGE)), "Arrival text not as expected");
        softAssert.assertTrue(cfdPage.getChanges(0).contains(GsonUtils.getText("connectionChange", cfdPage.LANGUAGE)), "Changes text not as expected");
        softAssert.assertTrue(cfdPage.getDurationText(0).contains(GsonUtils.getText("connectionDuration", cfdPage.LANGUAGE)), "Duration text not as expected");
        softAssert.assertTrue(cfdPage.getSecondClassTextLabel(0).contains(GsonUtils.getText("connection2Class", cfdPage.LANGUAGE)), "2nd Class text not as expected");
        softAssert.assertTrue(cfdPage.getFirstClassTextLabel(0).contains(GsonUtils.getText("connection1Class", cfdPage.LANGUAGE)), "1st Class text not as expected");
        softAssert.assertEquals(cfdPage.getPurchaseButtonText(), GsonUtils.getText("purchaseButton", cfdPage.LANGUAGE), "Purchase button text not as expected");
        softAssert.assertEquals(cfdPage.getBackButtonText(), GsonUtils.getText("backButton", cfdPage.LANGUAGE), "Back button text not as expected");
        softAssert.assertAll();
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, dataProvider = "checkTranslations", dataProviderClass = TestDataProvider.class)
    public void checkEnglishLanguageByFooter(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        cfdPage.selectLanguage("en");
        attachText("CorrId", cfdPage.getCorrelationID());
        LOG.info("JumpInLinkUrl: " + jumpInLink.getJumpInLinkUrl());
        softAssert.assertEquals(cfdPage.getHeadingText(), GsonUtils.getText("heading", cfdPage.LANGUAGE), "Heading text not as expected");
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(GsonUtils.getText("searchDepartureMode", cfdPage.LANGUAGE)), "SearchMode text not as expected");
        softAssert.assertEquals(cfdPage.getEarlierButtonText(), GsonUtils.getText("earlierButton", cfdPage.LANGUAGE), "Earlier button text not as expected");
        softAssert.assertEquals(cfdPage.getLaterButtonText(), GsonUtils.getText("laterButton", cfdPage.LANGUAGE), "Later button text not as expected");
        softAssert.assertTrue(cfdPage.getDepTime(0).contains(GsonUtils.getText("connectionDep", cfdPage.LANGUAGE)), "Departure text not as expected");
        softAssert.assertTrue(cfdPage.getArrTime(0).contains(GsonUtils.getText("connectionArr", cfdPage.LANGUAGE)), "Arrival text not as expected");
        softAssert.assertTrue(cfdPage.getChanges(0).contains(GsonUtils.getText("connectionChange", cfdPage.LANGUAGE)), "Changes text not as expected");
        softAssert.assertTrue(cfdPage.getDurationText(0).contains(GsonUtils.getText("connectionDuration", cfdPage.LANGUAGE)), "Duration text not as expected");
        softAssert.assertTrue(cfdPage.getSecondClassTextLabel(0).contains(GsonUtils.getText("connection2Class", cfdPage.LANGUAGE)), "2nd Class text not as expected");
        softAssert.assertTrue(cfdPage.getFirstClassTextLabel(0).contains(GsonUtils.getText("connection1Class", cfdPage.LANGUAGE)), "1st Class text not as expected");
        softAssert.assertEquals(cfdPage.getPurchaseButtonText(), GsonUtils.getText("purchaseButton", cfdPage.LANGUAGE), "Purchase button text not as expected");
        softAssert.assertEquals(cfdPage.getBackButtonText(), GsonUtils.getText("backButton", cfdPage.LANGUAGE), "Back button text not as expected");
        softAssert.assertAll();
    }

    @Test()
    public void checkDeutschLanguageByLink() {
        jumpInLink.build(
                "de",
                "8507000",
                "Bern",
                "8014309",
                "Offenburg",
                getDate("yyyy-MM-dd'T'hh:mm:ss", "+Month"),
                "D",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                jumpInLink.generateSecureToken("8507000", "Bern", "8014309", "Offenburg",
                        getDate("yyyy-MM-dd'T'hh:mm:ss", "+Month"), "D", "TT", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));

        softAssert.assertEquals(cfdPage.getHeadingText(), GsonUtils.getText("heading", jumpInLink.LANGUAGE), "Heading text not as expected");
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(GsonUtils.getText("searchDepartureMode", jumpInLink.LANGUAGE)), "SearchMode text not as expected");
        softAssert.assertEquals(cfdPage.getEarlierButtonText(), GsonUtils.getText("earlierButton", jumpInLink.LANGUAGE), "Earlier button text not as expected");
        softAssert.assertEquals(cfdPage.getLaterButtonText(), GsonUtils.getText("laterButton", jumpInLink.LANGUAGE), "Later button text not as expected");
        softAssert.assertTrue(cfdPage.getDepTime(0).contains(GsonUtils.getText("connectionDep", jumpInLink.LANGUAGE)), "Departure text not as expected");
        softAssert.assertTrue(cfdPage.getArrTime(0).contains(GsonUtils.getText("connectionArr", jumpInLink.LANGUAGE)), "Arrival text not as expected");
        softAssert.assertTrue(cfdPage.getChanges(0).contains(GsonUtils.getText("connectionChange", jumpInLink.LANGUAGE)), "Changes text not as expected");
        softAssert.assertTrue(cfdPage.getDurationText(0).contains(GsonUtils.getText("connectionDuration", jumpInLink.LANGUAGE)), "Duration text not as expected");
        softAssert.assertTrue(cfdPage.getSecondClassTextLabel(0).contains(GsonUtils.getText("connection2Class", jumpInLink.LANGUAGE)), "2nd Class text not as expected");
        softAssert.assertTrue(cfdPage.getFirstClassTextLabel(0).contains(GsonUtils.getText("connection1Class", jumpInLink.LANGUAGE)), "1st Class text not as expected");
        softAssert.assertEquals(cfdPage.getPurchaseButtonText(), GsonUtils.getText("purchaseButton", jumpInLink.LANGUAGE), "Purchase button text not as expected");
        softAssert.assertEquals(cfdPage.getBackButtonText(), GsonUtils.getText("backButton", jumpInLink.LANGUAGE), "Back button text not as expected");
        softAssert.assertAll();
    }

    @Test()
    public void checkItalianoLanguageByLink() {
        jumpInLink.build(
                "it",
                "8507000",
                "Bern",
                "8014309",
                "Offenburg",
                getDate("yyyy-MM-dd'T'hh:mm:ss", "+Month"),
                "D",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                jumpInLink.generateSecureToken("8507000", "Bern", "8014309", "Offenburg",
                        getDate("yyyy-MM-dd'T'hh:mm:ss", "+Month"), "D", "TT", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));

        softAssert.assertEquals(cfdPage.getHeadingText(), GsonUtils.getText("heading", jumpInLink.LANGUAGE), "Heading text not as expected");
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(GsonUtils.getText("searchDepartureMode", jumpInLink.LANGUAGE)), "SearchMode text not as expected");
        softAssert.assertEquals(cfdPage.getEarlierButtonText(), GsonUtils.getText("earlierButton", jumpInLink.LANGUAGE), "Earlier button text not as expected");
        softAssert.assertEquals(cfdPage.getLaterButtonText(), GsonUtils.getText("laterButton", jumpInLink.LANGUAGE), "Later button text not as expected");
        softAssert.assertTrue(cfdPage.getDepTime(0).contains(GsonUtils.getText("connectionDep", jumpInLink.LANGUAGE)), "Departure text not as expected");
        softAssert.assertTrue(cfdPage.getArrTime(0).contains(GsonUtils.getText("connectionArr", jumpInLink.LANGUAGE)), "Arrival text not as expected");
        softAssert.assertTrue(cfdPage.getChanges(0).contains(GsonUtils.getText("connectionChange", jumpInLink.LANGUAGE)), "Changes text not as expected");
        softAssert.assertTrue(cfdPage.getDurationText(0).contains(GsonUtils.getText("connectionDuration", jumpInLink.LANGUAGE)), "Duration text not as expected");
        softAssert.assertTrue(cfdPage.getSecondClassTextLabel(0).contains(GsonUtils.getText("connection2Class", jumpInLink.LANGUAGE)), "2nd Class text not as expected");
        softAssert.assertTrue(cfdPage.getFirstClassTextLabel(0).contains(GsonUtils.getText("connection1Class", jumpInLink.LANGUAGE)), "1st Class text not as expected");
        softAssert.assertEquals(cfdPage.getPurchaseButtonText(), GsonUtils.getText("purchaseButton", jumpInLink.LANGUAGE), "Purchase button text not as expected");
        softAssert.assertEquals(cfdPage.getBackButtonText(), GsonUtils.getText("backButton", jumpInLink.LANGUAGE), "Back button text not as expected");
        softAssert.assertAll();
    }

    @Test()
    public void checkFrançaisLanguageByLink() {
        jumpInLink.build(
                "fr",
                "8507000",
                "Bern",
                "8014309",
                "Offenburg",
                getDate("yyyy-MM-dd'T'hh:mm:ss", "+Month"),
                "D",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                jumpInLink.generateSecureToken("8507000", "Bern", "8014309", "Offenburg",
                        getDate("yyyy-MM-dd'T'hh:mm:ss", "+Month"), "D", "TT", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));

        softAssert.assertEquals(cfdPage.getHeadingText(), GsonUtils.getText("heading", jumpInLink.LANGUAGE), "Heading text not as expected");
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(GsonUtils.getText("searchDepartureMode", jumpInLink.LANGUAGE)), "SearchMode text not as expected");
        softAssert.assertEquals(cfdPage.getEarlierButtonText(), GsonUtils.getText("earlierButton", jumpInLink.LANGUAGE), "Earlier button text not as expected");
        softAssert.assertEquals(cfdPage.getLaterButtonText(), GsonUtils.getText("laterButton", jumpInLink.LANGUAGE), "Later button text not as expected");
        softAssert.assertTrue(cfdPage.getDepTime(0).contains(GsonUtils.getText("connectionDep", jumpInLink.LANGUAGE)), "Departure text not as expected");
        softAssert.assertTrue(cfdPage.getArrTime(0).contains(GsonUtils.getText("connectionArr", jumpInLink.LANGUAGE)), "Arrival text not as expected");
        softAssert.assertTrue(cfdPage.getChanges(0).contains(GsonUtils.getText("connectionChange", jumpInLink.LANGUAGE)), "Changes text not as expected");
        softAssert.assertTrue(cfdPage.getDurationText(0).contains(GsonUtils.getText("connectionDuration", jumpInLink.LANGUAGE)), "Duration text not as expected");
        softAssert.assertTrue(cfdPage.getSecondClassTextLabel(0).contains(GsonUtils.getText("connection2Class", jumpInLink.LANGUAGE)), "2nd Class text not as expected");
        softAssert.assertTrue(cfdPage.getFirstClassTextLabel(0).contains(GsonUtils.getText("connection1Class", jumpInLink.LANGUAGE)), "1st Class text not as expected");
        softAssert.assertEquals(cfdPage.getPurchaseButtonText(), GsonUtils.getText("purchaseButton", jumpInLink.LANGUAGE), "Purchase button text not as expected");
        softAssert.assertEquals(cfdPage.getBackButtonText(), GsonUtils.getText("backButton", jumpInLink.LANGUAGE), "Back button text not as expected");
        softAssert.assertAll();
    }

    @Test()
    public void checkEnglishLanguageByLink() {
        jumpInLink.build(
                "en",
                "8507000",
                "Bern",
                "8014309",
                "Offenburg",
                getDate("yyyy-MM-dd'T'hh:mm:ss", "+Month"),
                "D",
                "TT",
                "1.2",
                "https://test-www.sbb.ch/en/buying",
                "https://test-www.sbb.ch/ticketshop/b2c/",
                jumpInLink.generateSecureToken("8507000", "Bern", "8014309", "Offenburg",
                        getDate("yyyy-MM-dd'T'hh:mm:ss", "+Month"), "D", "TT", "1.2", "https://test-www.sbb.ch/en/buying", "https://test-www.sbb.ch/ticketshop/b2c/"));

        softAssert.assertEquals(cfdPage.getHeadingText(), GsonUtils.getText("heading", jumpInLink.LANGUAGE), "Heading text not as expected");
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(GsonUtils.getText("searchDepartureMode", jumpInLink.LANGUAGE)), "SearchMode text not as expected");
        softAssert.assertEquals(cfdPage.getEarlierButtonText(), GsonUtils.getText("earlierButton", jumpInLink.LANGUAGE), "Earlier button text not as expected");
        softAssert.assertEquals(cfdPage.getLaterButtonText(), GsonUtils.getText("laterButton", jumpInLink.LANGUAGE), "Later button text not as expected");
        softAssert.assertTrue(cfdPage.getDepTime(0).contains(GsonUtils.getText("connectionDep", jumpInLink.LANGUAGE)), "Departure text not as expected");
        softAssert.assertTrue(cfdPage.getArrTime(0).contains(GsonUtils.getText("connectionArr", jumpInLink.LANGUAGE)), "Arrival text not as expected");
        softAssert.assertTrue(cfdPage.getChanges(0).contains(GsonUtils.getText("connectionChange", jumpInLink.LANGUAGE)), "Changes text not as expected");
        softAssert.assertTrue(cfdPage.getDurationText(0).contains(GsonUtils.getText("connectionDuration", jumpInLink.LANGUAGE)), "Duration text not as expected");
        softAssert.assertTrue(cfdPage.getSecondClassTextLabel(0).contains(GsonUtils.getText("connection2Class", jumpInLink.LANGUAGE)), "2nd Class text not as expected");
        softAssert.assertTrue(cfdPage.getFirstClassTextLabel(0).contains(GsonUtils.getText("connection1Class", jumpInLink.LANGUAGE)), "1st Class text not as expected");
        softAssert.assertEquals(cfdPage.getPurchaseButtonText(), GsonUtils.getText("purchaseButton", jumpInLink.LANGUAGE), "Purchase button text not as expected");
        softAssert.assertEquals(cfdPage.getBackButtonText(), GsonUtils.getText("backButton", jumpInLink.LANGUAGE), "Back button text not as expected");
        softAssert.assertAll();
    }


}
