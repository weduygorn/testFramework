package tests.search;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class BreadcrumbsHeaderTest extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void breadcrumbsHeaderTest() {
        String mcpUrl = RomeMilanOWLink;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        s_assert.assertTrue(searchOffersPage.breadcrumbsHeader.internationalBooking.getText().equals("International booking"), "international booking step");
        s_assert.assertTrue(searchOffersPage.breadcrumbsHeader.searchStep.getText().equals("Search"), "search step");
        s_assert.assertTrue(searchOffersPage.breadcrumbsHeader.selectStep.getText().equals("Select"), "select step");
        s_assert.assertTrue(searchOffersPage.breadcrumbsHeader.selectStep.getText().equals("Ticket & reservation"), "Ticket & reservation step");
        s_assert.assertTrue(searchOffersPage.breadcrumbsHeader.selectStep.getText().equals("Check & book"), "Check & book step");
        s_assert.assertTrue(searchOffersPage.breadcrumbsHeader.selectStep.getText().equals("Payment"), "Payment step");
        s_assert.assertTrue(searchOffersPage.breadcrumbsHeader.selectStep.getText().equals("Confirmation"), "Confirmation step");
    }
}
