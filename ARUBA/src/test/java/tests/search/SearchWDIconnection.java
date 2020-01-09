package tests.search;

import helpers.AllureAssert;
import helpers.Logging;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestDataProvider;
import tests.BaseTest;

import static pages.BasePage.attachText;

public class SearchWDIconnection extends BaseTest implements Logging {

    @Test(groups = "prod", dataProvider = "searchWDI", dataProviderClass = TestDataProvider.class)
    public void searchWDIconnection(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        attachText("CorrId", cfdPage.getCorrelationID());
        LOG.info("JumpInLinkUrl: " + jumpInLink.getJumpInLinkUrl());
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.headingContainer.subheadingFrom), "Subheading 'From' is not present!");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.headingContainer.subheadingTo), "Subheading 'To' is not present!");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.headingContainer.subheadingDate), "Subheading 'Date' is not present!");
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(timeValue));
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(dateValue));
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(searchMode));
        connection = cfdPage.selectFirstAvailableConnection();
        softAssert.assertAll();
    }

    @Test(groups = {"dev", "test", "demo", "stage"}, dataProvider = "searchWDI", dataProviderClass = TestDataProvider.class)
    public void searchWDIconnectionAndPurchase(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        attachText("CorrId", cfdPage.getCorrelationID());
        LOG.info("JumpInLinkUrl: " + jumpInLink.getJumpInLinkUrl());
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.headingContainer.subheadingFrom), "Subheading 'From' is not present!");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.headingContainer.subheadingTo), "Subheading 'To' is not present!");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.headingContainer.subheadingDate), "Subheading 'Date' is not present!");
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(timeValue));
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(dateValue));
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(searchMode));
        connection = cfdPage.selectFirstAvailableConnection();
        cfdPage.clickPurchaseButton();
        LOG.info("JumpOutLinkUrl: " + jumpOutLink.getJumpOutLinkUrl());
        AllureAssert.assertNotNull(jumpOutLink.getConnection());
        Assert.assertTrue(ticketShopPage.isElementPresent(ticketShopPage.shopContent), "Ticket shop content missing!");
        softAssert.assertAll();
    }
}
