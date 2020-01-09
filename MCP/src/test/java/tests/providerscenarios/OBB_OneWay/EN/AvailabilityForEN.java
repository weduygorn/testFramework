package tests.providerscenarios.OBB_OneWay.EN;

import org.testng.annotations.Test;
import tests.BaseTest;

public class AvailabilityForEN extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void trainEN() {
        gotoUrl(APP_URL);
        searchPage.setFrom("Feldkirch");
        searchPage.setTo("Villach Hbf");
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("2240");
        searchPage.pasCount.click();
        searchPage.selectOptionFromDropdown("3 Passengers");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.setPas2BirthDate(CHILD_BIRTH_DATE);
        searchPage.setPas3BirthDate(INFANT_BIRTH_DATE);
        searchPage.clickSearchButton(true);
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.continueButton.get(0).click();
        s_assert.assertTrue(upsalePage.upsaleBlock.getText().contains("EN"), "not EN train");
        s_assert.assertTrue(upsalePage.upsaleBlock.getText().contains("2nd class: seat incl."), "assert1");
        s_assert.assertTrue(upsalePage.upsaleBlock.getText().contains("with 3 beds"), "assert2");
        s_assert.assertTrue(upsalePage.upsaleBlock.getText().contains("with 2 beds"), "assert2");
        upsalePage.continueButton.click();
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

    @Test(groups = {"prod"})
    public void OBB_EN_PROD_OW() {
        gotoUrl(APP_URL);
        searchPage.setFrom("Feldkirch");
        searchPage.setTo("Villach Hbf");
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("2240");
        searchPage.pasCount.click();
        searchPage.selectOptionFromDropdown("3 Passengers");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.setPas2BirthDate(CHILD_BIRTH_DATE);
        searchPage.setPas3BirthDate(INFANT_BIRTH_DATE);
        searchPage.clickSearchButton(true);
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.continueButton.get(0).click();
        s_assert.assertTrue(upsalePage.upsaleBlock.getText().contains("EN"), "not EN train");
        s_assert.assertTrue(upsalePage.upsaleBlock.getText().contains("2nd class: seat incl."), "assert1");
        s_assert.assertTrue(upsalePage.upsaleBlock.getText().contains("with 3 beds"), "assert2");
        s_assert.assertTrue(upsalePage.upsaleBlock.getText().contains("with 2 beds"), "assert3");
        s_assert.assertTrue(upsalePage.infantWarning.getText().contains("Children aged from 0 to 5 years can travel free of charge on night trains (NJ and EN) without an assigned seat/berth/bed. To guarantee separate seat/berth/bed, birth date of young children was modified to request a child fare. If you don´t need a separate place for your young children, please"), "assert4");
        upsalePage.continueButton.click();
        ticketAndReservationPage.continueButton.click();
        s_assert.assertTrue(passengerDetailsPage.pageTitle.getText().equals("Passenger details"), "not passenger details page");
        s_assert.assertAll();
    }
}
