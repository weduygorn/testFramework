package tests.providerscenarios.multiprovider;

import org.testng.annotations.Test;
import tests.BaseTest;
import tests.testData.TestDataProvider;

public class PAO_TRE_OW extends BaseTest {
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "Marseille St. Charles_Milano Centrale", dataProviderClass = TestDataProvider.class)
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
}
