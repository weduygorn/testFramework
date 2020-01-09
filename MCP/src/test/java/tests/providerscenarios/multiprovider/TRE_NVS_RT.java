package tests.providerscenarios.multiprovider;

import org.testng.annotations.Test;
import tests.BaseTest;
import tests.testData.TestDataProvider;

public class TRE_NVS_RT extends BaseTest {

    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HannoverHbf_NapoliCentrale", dataProviderClass = TestDataProvider.class)
    public void RoundTripThreeAdultsFullFlowWithBahnCard(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("0000");
        searchPage.pasCount.click();
        searchPage.selectOptionFromDropdown("3 Passengers");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.setPas2BirthDate(ADULT_BIRTH_DATE);
        searchPage.setPas3BirthDate(CHILD_BIRTH_DATE);
        searchPage.activateRoundTrip();
        searchPage.addDaysToInwardDate(numberOfDaysInward);
        searchPage.setInwardTime("0000");
        searchPage.pas1SelectDiscount.click();
        searchOffersPage.selectOptionFromDropdown("BahnCard 25, 1st class");
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
//        refundConditionsPage.getRefundButton.click();
//        s_assert.assertTrue(refundPage.retrieveDetails.bookingStatus.getText().equals("Cancelled"),"status not found");
        s_assert.assertAll();
    }

    @Test(groups = {"prod"}, dataProvider = "treDB3", dataProviderClass = TestDataProvider.class)
    public void TRE_DB_PROD_RT(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("0000");
        searchPage.pasCount.click();
        searchPage.selectOptionFromDropdown("3 Passengers");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.setPas2BirthDate(ADULT_BIRTH_DATE);
        searchPage.setPas3BirthDate(CHILD_BIRTH_DATE);
        searchPage.activateRoundTrip();
        searchPage.addDaysToInwardDate(numberOfDaysInward);
        searchPage.setInwardTime("0000");
        searchPage.pas1SelectDiscount.click();
        searchOffersPage.selectOptionFromDropdown("BahnCard 25, 1st class");
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
        s_assert.assertTrue(passengerDetailsPage.pageTitle.getText().equals("Passenger details"), "not passenger details page");
        s_assert.assertAll();
    }
}
