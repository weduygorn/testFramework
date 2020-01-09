package tests.providerscenarios.multiprovider;

import org.testng.annotations.Test;
import tests.BaseTest;
import tests.testData.TestDataProvider;

public class PAO_NVS_OW extends BaseTest {
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "MunchenHbf_Vannes", dataProviderClass = TestDataProvider.class)
    public void e2eOWRefundForAdult(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("1000");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.clickSearchButton();
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.clickContinueButton(1);
        upsalePage.continueButton.click();
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
        bookingDetailsPage.getRefundConditionsButton.click();
        s_assert.assertTrue(refundConditionsPage.retrieveDetails.bookingStatus.getText().equals("Processed"), "status not found");
        s_assert.assertAll();

    }

    @Test(groups = {"prod"}, dataProvider = "MunchenHbf_Vannes", dataProviderClass = TestDataProvider.class)
    public void PAO_ORCHESTRATION_OW(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("1000");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.clickSearchButton();
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.clickContinueButton(0);
        upsalePage.continueButton.click();
        ticketAndReservationPage.continueButton.click();
        s_assert.assertTrue(passengerDetailsPage.pageTitle.getText().equals("Passenger details"), "not passenger details page");
        s_assert.assertAll();

    }
}
