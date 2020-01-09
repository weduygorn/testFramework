package tests.search;

import helpers.AllureAssert;
import helpers.Logging;
import org.testng.annotations.Test;
import testData.TestDataProvider;
import tests.BaseTest;

import static pages.BasePage.attachText;

public class CheckAntiRobotSolution extends BaseTest implements Logging {

    @Test(groups = "prod",dataProvider = "searchByDeparture", dataProviderClass = TestDataProvider.class)
    public void antiRobotSolutionEnabled(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {

        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        attachText("CorrId", cfdPage.getCorrelationID());
        LOG.info("JumpInLinkUrl: " + jumpInLink.getJumpInLinkUrl());
        connection = cfdPage.selectFirstAvailableConnection();
        cfdPage.clickPurchaseButton();
        AllureAssert.assertEquals(cfdPage.getTextOnRequestErrorMessage(),"Sorry, your surfing activity was defined as unusual and suspicious. Please try again at a later point.");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.backButton));
    }
}