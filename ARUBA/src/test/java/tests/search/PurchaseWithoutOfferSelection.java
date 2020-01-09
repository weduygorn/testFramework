package tests.search;

import helpers.Logging;
import org.testng.annotations.Test;
import testData.TestDataProvider;
import tests.BaseTest;

import static pages.BasePage.attachText;

public class PurchaseWithoutOfferSelection  extends BaseTest implements Logging {

    @Test(groups = {"dev", "test", "demo", "stage"}, dataProvider = "searchByDeparture", dataProviderClass = TestDataProvider.class)
    public void negativePurchaseWithoutOfferSelection(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {

        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        LOG.info("JumpInLinkUrl: " + jumpInLink.getJumpInLinkUrl());
        attachText("CorrId", cfdPage.getCorrelationID());
//        cfdPage.removeHeader();
//        cfdPage.clickPurchaseButton();

        // TODO: Will be worked after anti bot solution implement for WebDriver execution
//        AllureAssert.assertEquals(cfdPage.getOfferSelectionErrorMessage(),"Please select offer before purchase.","Incorrect error message");
    }

}
