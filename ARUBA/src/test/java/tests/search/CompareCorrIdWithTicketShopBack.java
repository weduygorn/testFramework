package tests.search;

import helpers.Logging;
import org.testng.Assert;
import org.testng.annotations.Test;
import testData.TestDataProvider;
import tests.BaseTest;

import static pages.BasePage.attachText;

public class CompareCorrIdWithTicketShopBack extends BaseTest implements Logging {

    String corrId;
    String corrIdAfterBack;

    @Test(groups = {"dev", "test", "demo", "stage"}, dataProvider = "searchByArrival", dataProviderClass = TestDataProvider.class)
    public void compareCorrIdWithTicketShopBack(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {

        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        corrId = cfdPage.getCorrelationID();
        attachText("CorrId", corrId);
        LOG.info("JumpInLinkUrl: " + jumpInLink.getJumpInLinkUrl());
        connection = cfdPage.selectFirstAvailableConnection();
        cfdPage.clickPurchaseButton();
        LOG.info("JumpOutLinkUrl: " + jumpOutLink.getJumpOutLinkUrl());
        ticketShopPage.waitForElementVisible(ticketShopPage.shopContent, 30);
        ticketShopPage.clickBrowserBackToCFD();
        corrIdAfterBack = cfdPage.getCorrelationID();
        attachText("CorrIdAfterBack", corrIdAfterBack);
        Assert.assertFalse(corrId.equals(corrIdAfterBack), "Corr ID the same, " + corrId + " : " + corrIdAfterBack );
    }
}