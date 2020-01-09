package tests.search;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class NavigateHeaderTest extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void navigateHeaderTest() {
        String mcpUrl = RomeMilanOWLink;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        s_assert.assertTrue(searchOffersPage.navigateHeader.offersItem.getText().equals("Offers"), "offers text");
        s_assert.assertTrue(searchOffersPage.navigateHeader.offersItem.getAttribute("href").equals("https://www.bahn.de/en/view/offers/index.shtml?dbkanal_007=L04_S02_D002_KIN0059_TOP-NAVI-ANGEBOTE_LZ01"), "offers link");
        s_assert.assertTrue(searchOffersPage.navigateHeader.bookingInformation.getText().equals("Booking information"));
        s_assert.assertTrue(searchOffersPage.navigateHeader.bookingInformation.getAttribute("href").equals("https://www.bahn.de/en/view/booking-information/index.shtml?dbkanal_007=L04_S02_D002_KIN0059_TOP-NAVI-BUCHUNG_LZ01"), "booking information link");
        s_assert.assertTrue(searchOffersPage.navigateHeader.trainFleet.getText().equals("Train fleet"));
        s_assert.assertTrue(searchOffersPage.navigateHeader.trainFleet.getText().equals("https://www.bahn.de/en/view/trains/index.shtml?dbkanal_007=L04_S02_D002_KIN0059_TOP-NAVI-ZUGFLOTTE_LZ01"), "Train fleet link");
    }
}
