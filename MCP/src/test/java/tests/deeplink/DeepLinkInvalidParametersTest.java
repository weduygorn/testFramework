package tests.deeplink;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class DeepLinkInvalidParametersTest extends BaseTest {
    @DataProvider
    private Object[][] negLinks() {
        return new Object[][]{

                {"/request/C=3&PA[1]=30&PC[1]=0&PT[1]=E&OB=" +
                        "8700023$8700011$YYYYMMDD1447$YYYYMMDD1635$2430"},

                {"/request/C=1&PA[1]=30&PC[1]=0&PT[1]=E&OB=" +
                        "8723$8700011$YYYYMMDD1447$YYYYMMDD1635$2430"},
                {"/request/C=1&PA[1]=30&PC[1]=0&PT[1]=E&OB=" +
                        "8700023$8700011$YYYYMMDD1447$BLA1635$2430"},
        };
    }

    @Test(groups = {"dev", "test"}, dataProvider = "negLinks", priority = 1)
    public void invalidLinksParametersTest(String mcpUrl) {
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        s_assert.assertTrue(searchOffersPage.dangerAlert.getText().contains("We are sorry, but we can not sell your requested journey online."), "wrong alert 1");
        s_assert.assertTrue(searchOffersPage.dangerAlert.getText().contains("Please visit one of our DB travel centers, authorised DB travel agency or via phone: (0049) 180 6 99 66 33"), "wrong alert 2");
        s_assert.assertTrue(searchOffersPage.dangerAlert.getText().contains(" (0049) 180 6 99 66 33 (20 cents per call from a German landline, max. 60 cents per call from a German"), "wrong alert 3");
        s_assert.assertAll();
    }
}
