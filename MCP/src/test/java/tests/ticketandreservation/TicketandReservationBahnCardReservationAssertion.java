package tests.ticketandreservation;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class TicketandReservationBahnCardReservationAssertion extends BaseTest {
    @Test(groups = {"dev", "test"})
    public void ticketAndReservationBahnCardReservationAccomodations() {
        String mcpUrl = MunichRoma;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDDOUT", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.searchOptions.discountCardsPasOne.click();
        searchOffersPage.selectOptionFromDropdown("BahnCard 25, 1st class");
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(1));
        searchOffersPage.clickContinueButton(1);
        upsalePage.continueButton.click();
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationYourJourneyOneWay.bodyPart2.getText().contains("includes BahnCard 25, 1st class discount"), "bahn card not found in side bar");
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationYourJourneyOneWay.getText().contains("Reservation"), "Reservation present in side bar");
        String total = ticketAndReservationPage.ticketAndReservationYourJourneyOneWay.total.getText();
        String reservationPrice = ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.prices.get(0).getText();
        ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.checkBoxIcon.get(0).click();
//        s_assert.assertFalse(ticketAndReservationPage.ticketAndReservationYourJourneyOneWay.footer.getText().contains(total),"wrong total found in sidebar");
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationYourJourneyOneWay.getText().contains(reservationPrice), "reservation price not found in sidebar");
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationYourJourneyOneWay.getText().contains("Reservation"), "text reservation not found in sidebar");
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationYourJourneyOneWay.total.getText().contains(((Float.valueOf(total.replaceAll(",", ".")) + Float.valueOf(reservationPrice.replaceAll(",", "."))) + "").replaceAll("\\.", ",")), "wrong sum in sidebar");
        String accommodationSectionText = ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.getText();
        s_assert.assertTrue(accommodationSectionText.contains("Location of the seat"), "Location of the seat not found");
        //s_assert.assertTrue(accommodationSectionText.contains("Compartment type"),"Compartment type not found");
        s_assert.assertTrue(accommodationSectionText.contains("Any"), "Any not found");
        s_assert.assertTrue(accommodationSectionText.contains("Window"), "Window not found");
        s_assert.assertTrue(accommodationSectionText.contains("Aisle"), "Aisle not found");
        // s_assert.assertTrue(accommodationSectionText.contains("Compartment"),"Compartment not found");
        s_assert.assertAll();
    }
}
