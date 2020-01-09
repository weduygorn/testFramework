package tests.providerscenarios.OBB_OneWay.BUS_Swiss_routes.IC;

import org.testng.annotations.Test;
import tests.BaseTest;
import tests.testData.TestDataProvider;

public class FullFlowWithAdult extends BaseTest {

    @Test(groups = {"demo"}, dataProvider = "BaselSbb_Bern", dataProviderClass = TestDataProvider.class)
    public void e2eSingleTripForAdult(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("09:30");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.clickSearchButton();
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.clickContinueButton(0);
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
//        gotoUrl(APP_URL+URL_RETRIEVE);
//        retrievePage.retrieveBookingFillAndSubmit(bookingID);
//        bookingDetailsPage.getRefundConditionsButton.click();
//        refundConditionsPage.getRefundButton.click();
//        s_assert.assertTrue(refundPage.retrieveDetails.bookingStatus.getText().equals("Cancelled"),"status not found");
        s_assert.assertAll();
    }
}
