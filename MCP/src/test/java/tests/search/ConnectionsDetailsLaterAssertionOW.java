package tests.search;


import helpers.SearchParams;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.testData.TestDataProvider;

import static data.Stations.MILAN;
import static data.Stations.ROME;


public class ConnectionsDetailsLaterAssertionOW extends BaseTest {

    @Test(groups = {"dev", "test", "demo"}, dataProvider = "RomaTermini_MilanoCentrale", dataProviderClass = TestDataProvider.class)
    public void connectionDetailsLaterAssertionOW() {
        gotoUrl(APP_URL);
        s_assert.assertTrue(searchPage.searchTitle.getText().equals("International booking"), "search title");
        SearchParams searchParams = setupSearchParams(ROME, MILAN, "0000");
        searchPage.makeSearch(searchParams);
        //connection result page
        s_assert.assertTrue(connectionResultPage.topInfoOneWay.outwardJourney.getText().equals("Outward journey"), "outward journey");
        connectionResultPage.waitForElement(connectionResultPage.connectionHeaders.stationStop);
        int startCount = connectionResultPage.allConnections.size();
        connectionResultPage.waitForElement(connectionResultPage.later);
        connectionResultPage.clickLaterButton();
        int afterOneLaterCount = connectionResultPage.allConnections.size();
        s_assert.assertTrue(afterOneLaterCount > startCount, "Later not show more offers");
        connectionResultPage.clickLaterButton();
        int afterTwoLaterCount = connectionResultPage.allConnections.size();
        s_assert.assertTrue(afterTwoLaterCount > afterOneLaterCount, "Later not show more offers after second press");
        connectionResultPage.clickLaterButton();
        int afterThreeLaterCount = connectionResultPage.allConnections.size();
        s_assert.assertTrue(afterThreeLaterCount > afterTwoLaterCount, "Later not show more offers after third press");
        s_assert.assertAll();
    }

}
