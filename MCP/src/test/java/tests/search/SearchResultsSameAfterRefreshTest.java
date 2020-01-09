package tests.search;

import org.testng.annotations.Test;
import tests.BaseTest;

import static data.DBlink.ROME_MILAN_OW;

/**
 * Created by osinskyi on 4/6/2017.
 */
public class SearchResultsSameAfterRefreshTest extends BaseTest {


    @Test(groups = {"dev", "test", "demo"})
    public void searchResultsAfterRefreshSameAsBefore() {
        gotoUrl(APP_URL + dBlinkHelper.setupLink(ROME_MILAN_OW));
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        Integer firstSearchSelectsCount = searchOffersPage.continueButton.size();
        searchOffersPage.clickChangeAllData();
        searchOffersPage.clickRefreshButton();
        Integer secondSearchSelectsCount = searchOffersPage.continueButton.size();
        s_assert.assertTrue(firstSearchSelectsCount.equals(secondSearchSelectsCount), "different offers size after refresh");
        s_assert.assertAll();
    }

}
