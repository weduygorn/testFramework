package tests.search;

import org.testng.annotations.Test;
import pages.blocks.search.Offers;
import pages.modalwindows.ConditionDetails;
import tests.BaseTest;

import java.util.List;

import static data.DBlink.ROME_MILAN_OW;

public class ShowConditionDetailsOWAssertion extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void viewAllConditionsOneWay() {
        gotoUrl(APP_URL + dBlinkHelper.setupLink(ROME_MILAN_OW));
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        List<Offers> offersResults = searchOffersPage.getOffersResults();
        ConditionDetails popUp = searchOffersPage.clickShowConditionDetails(offersResults, 0);
        s_assert.assertTrue(popUp.getBody().contains("FR") || popUp.getBody().contains("INI") || popUp.getBody().contains("ICP"), "FR not found");
        s_assert.assertTrue(popUp.getBody().contains("Adult"), "Adult not found");
        s_assert.assertFalse(popUp.getBody().contains("Seat"), "seat not found");
        s_assert.assertTrue(popUp.getFooter().contains("Print"), "Print not found");
        popUp.clickX();
        s_assert.assertAll();
    }
}
