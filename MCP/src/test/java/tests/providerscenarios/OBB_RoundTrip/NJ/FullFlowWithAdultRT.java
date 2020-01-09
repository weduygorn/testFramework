package tests.providerscenarios.OBB_RoundTrip.NJ;

import org.testng.annotations.Test;
import tests.BaseTest;
import tests.testData.TestDataProvider;

public class FullFlowWithAdultRT extends BaseTest {

    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void e2eRoundTripRefundForAdult(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("2000");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.activateRoundTrip();
        searchPage.addDaysToInwardDate(numberOfDaysInward);
        searchPage.setInwardTime("2000");
        searchPage.clickSearchButton();
        connectionResultPage.selectFirstConnection();
        connectionResultPage.selectFirstConnection();
        searchOffersPage.returnJourneys.get(0).click();
        if (driver.getPageSource().contains("Please choose preferable comfort or compartment type")) {
            upsalePage.continueButton.click();
        }
        searchOffersPage.continueButton.get(0).click();
        if (driver.getPageSource().contains("Please choose preferable comfort or compartment type")) {
            upsalePage.continueButton.click();
        }
        ticketAndReservationPage.returnJourneyButton.click();
        ticketAndReservationPage.continueButton.click();
        passengerDetailsPage.fillPas1Data();
        passengerDetailsPage.continueButton.click();
        checkAndBookPage.detailedInformation.checkBox.click();
        checkAndBookPage.proceedToPayment.click();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        s_assert.assertTrue(ticketPage.getTicketTitle().contains("Thank you for your booking, it is successfully processed."), "not a ticket page");
        String bookingID = ticketPage.bookingID.getText().replaceAll("Booking ID: ", "");
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingID);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingID + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }
}
