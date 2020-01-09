package tests.providerscenarios.PAO.deeplink;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class FullFlowRTDeepLink extends BaseTest {
    @Test(groups = {"demo", "test", "dev"})
    public void PAORTDeepLink() {
        String mcpUrl = ParisNiceRTLink;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDDOUT", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        mcpUrl = mcpUrl.replaceAll("YYYYMMDDIN", currentDatePlusNDaysNotWeekend(numberOfDaysInward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        System.out.println(mcpUrl);
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.returnJourneys.get(0).click();
        upsalePage.continueButton.click();
        searchOffersPage.continueButton.get(0).click();
        upsalePage.continueButton.click();
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
        bookingDetailsPage.getRefundConditionsButton.click();
        refundConditionsPage.getRefundButton.click();
        s_assert.assertTrue(refundPage.retrieveDetails.bookingStatus.getText().equals("Cancelled"),"status not found");
        s_assert.assertAll();


    }
}
