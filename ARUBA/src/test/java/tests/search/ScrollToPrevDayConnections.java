package tests.search;

import helpers.AllureAssert;
import helpers.Logging;
import org.testng.annotations.Test;
import testData.TestDataProvider;
import tests.BaseTest;

import static helpers.DateTimeHelper.getDate;
import static pages.BasePage.attachText;

public class ScrollToPrevDayConnections extends BaseTest implements Logging {

    @Test(groups = {"dev", "test", "demo", "stage", "prod"}, dataProvider = "scrollToPrevDayConnections", dataProviderClass = TestDataProvider.class)
    public void scrollToPrevDayConnections(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {

        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        attachText("CorrId", cfdPage.getCorrelationID());
        LOG.info("JumpInLinkUrl: " + jumpInLink.getJumpInLinkUrl());
        cfdPage.clickPrevDateButton();
        AllureAssert.assertEquals(cfdPage.getColumnsDateSize(), 4);
        AllureAssert.assertTrue(cfdPage.columnDatesArray().contains(getDate("dd.MM.yyyy","+5days")), "Column date is not correct");
    }
}