package tests.search;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class MixedBahnCard2classMessageAssertion extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void bahnCardMix2classTest() {
        String mcpUrl = "/request/C=2&PA[1]=30&PC[1]=2&PT[1]=E&PA[2]=30&PC[2]=4&PT[2]=E&OB=8000261$8300120$YYYYMMDD1311$YYYYMMDD1811$EC+89";
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.setPasTwoBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        s_assert.assertTrue(driver.getPageSource().contains("A combination of different BahnCards is not possible. Please book travelers with different BahnCard discounts separately."));
        s_assert.assertAll();
    }
}
