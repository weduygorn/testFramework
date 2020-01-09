package tests.search;

import helpers.AllureAssert;
import helpers.Logging;
import org.testng.annotations.Test;
import testData.TestDataProvider;
import tests.BaseTest;

import static pages.BasePage.attachText;

public class ScrollToLaterConnections extends BaseTest implements Logging {

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, dataProvider = "searchByDeparture", dataProviderClass = TestDataProvider.class)
    public void scrollToLaterConnections(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {

        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        attachText("CorrId", cfdPage.getCorrelationID());
        LOG.info("JumpInLinkUrl: " + jumpInLink.getJumpInLinkUrl());
        int connectionsBeforeScroll = cfdPage.getConnectionSizeInColumn(0);
        LOG.info("Before connections: " + connectionsBeforeScroll);
        cfdPage.clickLaterButton(0);
        int connectionsAfterScroll = cfdPage.getConnectionSizeInColumn(0);
        LOG.info("After connections: " + connectionsAfterScroll);
        AllureAssert.assertTrue(connectionsAfterScroll > connectionsBeforeScroll, "connectionsAfterScroll not > connectionsBeforeScroll");
    }

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, dataProvider = "checkNoOfferAvailableCardWithLater", dataProviderClass = TestDataProvider.class)
    public void checkNoOffersAvailableCardWithLater(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {

        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        attachText("CorrId", cfdPage.getCorrelationID());
        LOG.info("JumpInLinkUrl: " + jumpInLink.getJumpInLinkUrl());
        cfdPage.clickLaterButton(0);
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.offersContainer.noOfferAvailableCard), "No offer available card is not present");
    }

}
