package tests.providerscenarios.PAO;

import org.testng.annotations.Test;
import tests.BaseTest;
import tests.testData.TestDataProvider;

public class FullFlowAdultChildInfantOW extends BaseTest {

    @Test(groups = {"dev", "test", "demo"}, dataProvider = "ParisGareDeLyon_NiceVille", dataProviderClass = TestDataProvider.class)
    public void OneWayAdultChildInfantFullFlow(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("0000");
        searchPage.pasCount.click();
        searchPage.selectOptionFromDropdown("3 Passengers");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.setPas2BirthDate(CHILD_BIRTH_DATE);
        searchPage.setPas3BirthDate(INFANT_BIRTH_DATE);
        searchPage.clickSearchButton(true);
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.continueButton.get(0).click();
        if (driver.getPageSource().contains("Please choose preferable comfort or compartment type")) {
            upsalePage.continueButton.click();
        }
        ticketAndReservationPage.continueButton.click();
        passengerDetailsPage.fillPas1Data();
        passengerDetailsPage.fillPas2Data();
        passengerDetailsPage.fillPas3Data();
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
//        s_assert.assertTrue(refundConditionsPage.retrieveDetails.bookingStatus.getText().equals("Processed"),"status not found");
        s_assert.assertAll();
    }
}
