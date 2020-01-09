package tests.e2e;

import helpers.AllureAssert;
import helpers.Logging;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.getDate;
import static pages.BasePage.attachText;

public class E2E extends BaseTest implements Logging {

    private String date = getDate("dd.MM.yyyy","+10days");

    @Parameters({"originName", "destinationName", "time", "searchMode"})
    @Test(groups = "prod")
    public void searchAvailableConnection(String originName, String destinationName, String time, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, date, time, searchMode);
        sbbHomePage.clickCfdButton();

        LOG.info("JumpInLinkUrl: " + jumpInLink.getJumpInLinkUrl());

        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.headingContainer.subheadingFrom), "Subheading 'From' is not present!");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.headingContainer.subheadingTo), "Subheading 'To' is not present!");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.headingContainer.subheadingDate), "Subheading 'Date' is not present!");
        softAssert.assertEquals(cfdPage.getSubheadingFromText(), originName);
        softAssert.assertEquals(cfdPage.getSubheadingToText(), destinationName);
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(time));
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(date));
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(searchMode));
        attachText("CorrId", cfdPage.getCorrelationID());
        connection = cfdPage.selectFirstAvailableConnection();
        softAssert.assertAll();
    }

    @Parameters({"originName", "destinationName", "time", "searchMode"})
    @Test(groups = {"dev", "test", "demo", "stage"})
    public void searchAvailableConnectionAndPurchase(String originName, String destinationName, String time, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, date, time, searchMode);
        sbbHomePage.clickCfdButton();

        LOG.info("JumpInLinkUrl: " + jumpInLink.getJumpInLinkUrl());

        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.headingContainer.subheadingFrom), "Subheading 'From' is not present!");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.headingContainer.subheadingTo), "Subheading 'To' is not present!");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.headingContainer.subheadingDate), "Subheading 'Date' is not present!");
        softAssert.assertEquals(cfdPage.getSubheadingFromText(), originName);
        softAssert.assertEquals(cfdPage.getSubheadingToText(), destinationName);
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(time));
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(date));
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(searchMode));
        attachText("CorrId", cfdPage.getCorrelationID());
        connection = cfdPage.selectFirstAvailableConnection();
        cfdPage.clickPurchaseButton();
        LOG.info("JumpOutLinkUrl: " + jumpOutLink.getJumpOutLinkUrl());
        AllureAssert.assertNotNull(jumpOutLink.getConnection());
        Assert.assertTrue(ticketShopPage.isElementPresent(ticketShopPage.shopContent), "Ticket shop content missing!");
        softAssert.assertAll();
    }
}
