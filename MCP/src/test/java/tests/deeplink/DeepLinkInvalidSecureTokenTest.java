package tests.deeplink;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

/**
 * Created by osinskyi on 5/31/2017.
 */
public class DeepLinkInvalidSecureTokenTest extends BaseTest {


    @DataProvider
    private Object[][] negTokenLinks() {
        return new Object[][]{
                {"/request/C=1&PA[1]=30&PC[1]=0&PT[1]=E&OB=\n" +
                        "8700023$8700011$YYYYMMDD1447$YYYYMMDD1635$2430&SECURE_TOKEN="},

                {"/request/C=1&PA[1]=30&PC[1]=0&PT[1]=E&OB=\n" +
                        "8700023$8700011$YYYYMMDD1447$YYYYMMDD1635$2430&SECURE_TOKEN=123asdf"},
        };
    }

    @Test(groups = {"dev", "test", "demo"}, dataProvider = "negTokenLinks", priority = 1)
    public void invalidSecureTokenParametersTest(String mcpUrl) {
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        gotoUrl(APP_URL + mcpUrl);
        s_assert.assertTrue(searchOffersPage.dangerAlert.getText().contains("We are sorry, but we can not sell your requested journey online."), "wrong alert 1");
        s_assert.assertTrue(searchOffersPage.dangerAlert.getText().contains("Please visit one of our DB travel centers, authorised DB travel agency or via phone: (0049) 180 6 99 66 33"), "wrong alert 2");
        s_assert.assertTrue(searchOffersPage.dangerAlert.getText().contains("(0049) 180 6 99 66 33"), "wrong alert 3");
        s_assert.assertAll();
    }
}
