package tests.search;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class WelcomePopupAssertion extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void firstPopupAssertion() {
        String mcpUrl = RomeMilanOWLink;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        String text = welcomePopup.popupText.getText();
        s_assert.assertTrue(text.contains("Dear customer, welcome on the website of"), "assert1");
        s_assert.assertTrue(text.contains("www.international-bahn.de"), "assert1a");
        s_assert.assertTrue(text.contains("Please note:\n" +
                "- Your \"meine Bahn\" account can not be used for bookings on this platform\n" +
                "- The GTC for international bookings apply\n" +
                "- More information you can find in our FAQs"), "assert2");
        s_assert.assertTrue(text.contains("We wish you a pleasant journey!"), "assert3");
        s_assert.assertTrue(text.contains("Don't show this message again."), "assert4");
        s_assert.assertTrue(welcomePopup.closeX.isDisplayed(), "assert5");
        welcomePopup.checkBoxDoNotShow.click();
        welcomePopup.continueBookingButton.click();
        s_assert.assertTrue(searchOffersPage.getElementDisplayedWarningMessage().getText().equals("Please type in the correct birth dates of the travellers in the format DD/MM/YYYY - this is necessary to get the fares for the sections abroad"), "please type in not found");
        s_assert.assertAll();
    }
}
