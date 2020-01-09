package tests.search;

import org.testng.annotations.Test;
import tests.BaseTest;

import static data.DBlink.ROME_MILAN_OW;

public class ShowDetailsOWAssertion extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void showDetailsOneWay() {

        gotoUrl(APP_URL + dBlinkHelper.setupLink(ROME_MILAN_OW));
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.clickShowDetails();
        String body = searchOffersPage.hidedInfo.getText();
        s_assert.assertTrue(body.contains("Station/Stop"), "Station/Stop not found");
        s_assert.assertTrue(body.contains("Time"), "Time not found");
        s_assert.assertTrue(body.contains("Product"), "Product not found");
        s_assert.assertTrue(body.contains("Further Information"), "Further Information not found");
        s_assert.assertTrue(body.contains("Rome Termini"), "Rome Termini not found");
        s_assert.assertTrue(body.contains("Milan Main Station"), "Milan Main Station not found");
        s_assert.assertTrue(body.contains("dep"), "dep not found");
        s_assert.assertTrue(body.toLowerCase().contains("rom"), "rom not found");
        s_assert.assertTrue(body.contains("arr"), "arr  not found");
        s_assert.assertTrue(searchOffersPage.showDetails.getText().equals("Hide details"), "Hide details  not found");
        searchOffersPage.clickShowDetails();
        s_assert.assertTrue(searchOffersPage.showDetails.getText().equals("Show details"), "Show details  not found");
        s_assert.assertAll();
    }
}
