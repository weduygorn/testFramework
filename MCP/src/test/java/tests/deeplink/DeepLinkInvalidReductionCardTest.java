package tests.deeplink;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class DeepLinkInvalidReductionCardTest extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void invalidReductionCardTest() {
        String mcpUrl = "/request/C=1&PA[1]=30&PC[1]=7&PT[1]=E&OB=8700023$8700011$YYYYMMDD1447$YYYYMMDD1635$2430";
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        s_assert.assertTrue(searchOffersPage.alert.getText().contains("Sorry, your reduction card can't be applied for this booking. Please choose a supported discount card if applicable."), "wrong alert 1");
        s_assert.assertTrue(searchOffersPage.alert.getText().contains("You may also contact our service center for support under phone:"), "wrong alert 2");
        s_assert.assertTrue(searchOffersPage.alert.getText().contains("+49 (0)180 6 62 70 01"), "wrong alert 3");
        s_assert.assertAll();
    }
}
