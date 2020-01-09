package tests.providerscenarios.PAO;

import org.testng.annotations.Test;
import tests.BaseTest;
import tests.testData.TestDataProvider;

public class ThalysFullFlowRT extends BaseTest {
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "ParisNord_BruxellesMidi", dataProviderClass = TestDataProvider.class)
    public void RoundTripAdultChildFullFlow(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("1000");
        searchPage.pasCount.click();
        searchPage.selectOptionFromDropdown("2 Passengers");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.setPas2BirthDate(CHILD_BIRTH_DATE);
        searchPage.activateRoundTrip();
        searchPage.addDaysToInwardDate(numberOfDaysInward);
        searchPage.setInwardTime("1000");
        searchPage.clickSearchButton();
        connectionResultPage.selectFirstConnection();
        connectionResultPage.selectFirstConnection();
        searchOffersPage.returnJourneys.get(1).click();
        if (driver.getPageSource().contains("Please choose preferable comfort or compartment type")) {
            upsalePage.continueButton.click();
        }
        searchOffersPage.clickContinueButton(0);
        if (driver.getPageSource().contains("Please choose preferable comfort or compartment type")) {
            upsalePage.continueButton.click();
        }
        ticketAndReservationPage.returnJourneyButton.click();
        ticketAndReservationPage.continueButton.click();
        passengerDetailsPage.fillPas1Data();
        passengerDetailsPage.fillPas2Data();
        passengerDetailsPage.continueButton.click();
        checkAndBookPage.detailedInformation.checkBox.click();
        checkAndBookPage.proceedToPayment.click();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        s_assert.assertTrue(ticketPage.getTicketTitle().contains("Thank you for your booking, it is successfully processed."), "not a ticket page");
        String bookingID = ticketPage.bookingID.getText().replaceAll("Booking ID: ", "");
        gotoUrl(APP_URL+URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingID);
        bookingDetailsPage.getRefundConditionsButton.click();
        refundConditionsPage.getRefundButton.click();
        s_assert.assertTrue(refundPage.retrieveDetails.bookingStatus.getText().equals("Cancelled"),"status not found");
        s_assert.assertAll();
    }

    @Test(groups = {"prod"}, dataProvider = "ParisNord_BruxellesMidi", dataProviderClass = TestDataProvider.class)
    public void PAO_THALYS_PROD_RT(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("1000");
        searchPage.pasCount.click();
        searchPage.selectOptionFromDropdown("2 Passengers");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.setPas2BirthDate(CHILD_BIRTH_DATE);
        searchPage.activateRoundTrip();
        searchPage.addDaysToInwardDate(numberOfDaysInward);
        searchPage.setInwardTime("1000");
        searchPage.clickSearchButton();
        connectionResultPage.selectFirstConnection();
        connectionResultPage.selectFirstConnection();
        searchOffersPage.returnJourneys.get(1).click();
        if (driver.getPageSource().contains("Please choose preferable comfort or compartment type")) {
            upsalePage.continueButton.click();
        }
        searchOffersPage.clickContinueButton(0);
        if (driver.getPageSource().contains("Please choose preferable comfort or compartment type")) {
            upsalePage.continueButton.click();
        }
        ticketAndReservationPage.returnJourneyButton.click();
        ticketAndReservationPage.continueButton.click();
        s_assert.assertTrue(passengerDetailsPage.pageTitle.getText().equals("Passenger details"), "not passenger details page");
        s_assert.assertAll();
    }
}
