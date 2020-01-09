package tests.ticketandreservation;

import org.testng.annotations.Test;
import tests.BaseTest;

import static data.DBlink.ROME_MILAN_OW;

public class TicketAndReservationTicketOWAssertion extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void ticketAndReservationAccommodationSegmentsOneWay() {
        gotoUrl(APP_URL + dBlinkHelper.setupLink(ROME_MILAN_OW));
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(0));
        searchOffersPage.continueButton.get(0).click();
        upsalePage.continueButton.click();
        String accommodationSectionText = ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.getText();
        s_assert.assertTrue(accommodationSectionText.contains("Travel segment"), "Travel segment: FR (Frecciarossa)");
        s_assert.assertTrue(accommodationSectionText.contains("Roma Termini"), "Roma Termini");
        s_assert.assertTrue(accommodationSectionText.contains("Milano Centrale"), "Milano Centrale");
        s_assert.assertTrue(accommodationSectionText.contains("Location of the seat"), "Location of the seats not found");
        s_assert.assertTrue(accommodationSectionText.contains("Any"), "Any not found");
        s_assert.assertTrue(accommodationSectionText.contains("Window"), "Window not found");
        s_assert.assertTrue(accommodationSectionText.contains("Middle"), "Middle not found");
        s_assert.assertTrue(accommodationSectionText.contains("Window (single)"), "Window (single) not found");
        s_assert.assertAll();
    }
}
