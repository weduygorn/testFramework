package tests.search;

import helpers.SearchParams;
import org.testng.annotations.Test;
import pages.blocks.search.Offers;
import pages.modalwindows.ConditionDetails;
import tests.BaseTest;

import java.util.List;

import static data.DBlink.ROME_MILAN_RT;

public class ShowConditionDetailsRTAssertion extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void viewAllConditionsRT() {
        gotoUrl(APP_URL + dBlinkHelper.setupLink(ROME_MILAN_RT));
        welcomePopup.close();
        SearchParams searchParams = setupDefaultSearchParams();
        searchPage.makeSearch(searchParams);
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOfferByConditions(outwardOffersResults, "Ticket can be exchanged and refunded.", 2);
        upsalePage.clickContinueButton();
        List<Offers> returnOffersResults = searchOffersPage.getOffersResults();
        ConditionDetails popUp = searchOffersPage.clickShowConditionDetails(returnOffersResults, 0);
        s_assert.assertTrue(popUp.getBody().contains("Adult"), "Adult not found");
        popUp.clickX();
        s_assert.assertAll();
    }
}
