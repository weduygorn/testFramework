package tests.deeplink;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class DeepLinkParametersInterpretationAssertion extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void deepLinkParametersInterpretationAssertionSearchTest() {
        String mcpUrl = "/request/C=1&PC[1]=0&PT[1]=E&PC[2]=1&PT[2]=B&PC[3]=2&PT[3]=K&" +
                "PC[4]=3&PT[4]=E&PC[5]=4&PT[5]=E&" +
                "OB=" +
                "8300263$8300046$YYYYMMDD0600$YYYYMMDD0855$9600&T=201712301400";
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        s_assert.assertTrue(searchOffersPage.searchOptions.passengerCount.getText().equals("5 Passengers"), "wrong count of passengers");
        ////pas1////
        s_assert.assertTrue(searchOffersPage.searchOptions.discountCardsPasOne.getText().equals("Select discount card..."), "pas one card");
        ////pas2////
        s_assert.assertTrue(searchOffersPage.searchOptions.getText().contains("BahnCard 25, 1st class"), "pas two card");
        ////pas3////
        s_assert.assertTrue(searchOffersPage.searchOptions.getText().contains("BahnCard 25, 2nd class"), "pas three card");
        ////pas4////
        s_assert.assertTrue(searchOffersPage.searchOptions.getText().contains("BahnCard 50, 1st class"), "pas four card");
        ////pas5////
        s_assert.assertTrue(searchOffersPage.searchOptions.getText().contains("BahnCard 50, 2nd class"), "pas five card");
        s_assert.assertTrue(searchOffersPage.searchOptions.refreshButton.isDisplayed(), "refresh not displayed");
        s_assert.assertAll();
    }

}
