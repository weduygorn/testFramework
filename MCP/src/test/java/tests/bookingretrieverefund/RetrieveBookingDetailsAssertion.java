package tests.bookingretrieverefund;


import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysWeekend;

public class RetrieveBookingDetailsAssertion extends BaseTest {
    String bookingID = "";

    @Test(groups = {"dev", "test", "demo"}, priority = 1)
    public void retrievePageDetailsAssertions() {
        String mcpUrl = MunichVerona;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(1));
        searchOffersPage.clickContinueButton(1);
        upsalePage.continueButton.click();
        ticketAndReservationPage.continueButton.click();
        passengerDetailsPage.passengersDetails.pasOneSalutation.click();
        passengerDetailsPage.selectOptionFromDropdown("Mr");
        passengerDetailsPage.passengersDetails.pasOneName.sendKeys("name");
        passengerDetailsPage.passengersDetails.pasOneSurname.sendKeys("surname");
        passengerDetailsPage.passengersDetails.pasOneEmail.sendKeys(TEST_EMAIL);
        passengerDetailsPage.passengersDetails.pasOnePhone.sendKeys(TEST_PHONE);
        passengerDetailsPage.passengersDetails.pasOneStreetNumber.sendKeys(STREET);
        passengerDetailsPage.passengersDetails.pasOnePostcodeNumber.sendKeys(POSTCODE);
        passengerDetailsPage.passengersDetails.pasOneCity.sendKeys(CITY);
        passengerDetailsPage.continueButton.click();
        checkAndBookPage.detailedInformation.checkBox.click();
        checkAndBookPage.proceedToPayment.click();
        s_assert.assertTrue(paymentPage.paymentTitle.getText().equals("Payment"));
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        s_assert.assertTrue(ticketPage.getTicketTitle().contains("Thank you for your booking, it is successfully processed."), "Thank you for your booking not found");
//        bookingID = ticketPage.bookingID.getText().replaceAll("Booking ID: ","");
//        gotoUrl(APP_URL+URL_RETRIEVE);
//        s_assert.assertTrue(retrievePage.titleRetrievePage.getText().equals("Order Search"),"Order Search not found");
//        s_assert.assertTrue(retrievePage.pleaseEnterMessage.getText().equals("Please enter your booking ID and e-mail address to get your booking details and, if required, to cancel the booking."),"Please enter not found");
//        s_assert.assertTrue(retrievePage.bookingIDLabel.getText().equals("Booking ID"), "Booking ID not found");
//        s_assert.assertTrue(retrievePage.EmailLabel.getText().equals("E-mail"),"email not found");
//        retrievePage.bookingID.sendKeys(bookingID);
//        retrievePage.email.sendKeys(TEST_EMAIL);
//        retrievePage.captcha.sendKeys(CAPTCHA_CODE);
//        retrievePage.searchButton.click();
//        s_assert.assertTrue(bookingDetailsPage.titleBookingDetails.getText().equals("Booking details"),"Booking details not found");
//        s_assert.assertTrue(bookingDetailsPage.subtitleBookingDetails.getText().equals("Your booking tickets Outward journey"),"Your booking tickets Outward journey not found");
//        s_assert.assertTrue(bookingDetailsPage.retrieveDetails.bookingPNRtitle.getText().equals("Booking PNR"),"Booking PNR not found");
//        s_assert.assertTrue(bookingDetailsPage.retrieveDetails.bookingDateTitle.getText().equals("Booking date"),"Booking date not found");
//        s_assert.assertTrue(bookingDetailsPage.retrieveDetails.personMadeBookingTitle.getText().equals("Person made the booking"),"Person made the booking not found");
//        s_assert.assertTrue(bookingDetailsPage.retrieveDetails.travellersTitle.getText().equals("Traveller(s)"),"Traveller(s) not found");
//        s_assert.assertTrue(bookingDetailsPage.retrieveDetails.statusTitle.getText().equals("Status"),"Status not found");
//        s_assert.assertTrue(bookingDetailsPage.retrieveDetails.bookingPNR.getText().equals(bookingID),"booking ID not correspond");
//        s_assert.assertTrue(bookingDetailsPage.retrieveDetails.bookingDate.getText().contains(" "),"booking date  not found");
//        s_assert.assertTrue(bookingDetailsPage.retrieveDetails.personMadeBooking.getText().contains("name")&bookingDetailsPage.retrieveDetails.personMadeBooking.getText().contains("surname"),"person made name surname not found");
//        s_assert.assertTrue(bookingDetailsPage.retrieveDetails.travellers.getText().contains("name")&bookingDetailsPage.retrieveDetails.travellers.getText().contains("surname"),"travellers name surname not found");
//        s_assert.assertTrue(bookingDetailsPage.retrieveDetails.bookingStatus.getText().equals("Processed"),"status not found");
//        s_assert.assertTrue(bookingDetailsPage.retrieveTicket.receiptTitle.getText().equals("Receipt"),"Receipt not found");
//        s_assert.assertTrue(bookingDetailsPage.retrieveTicket.dateOfTravelTitle.getText().equals("Date of travel"),"Date of travel not found");
//        s_assert.assertTrue(bookingDetailsPage.retrieveTicket.descriptionTitle.getText().equals("Description"),"Description not found");
//        s_assert.assertTrue(bookingDetailsPage.retrieveTicket.receiptNumberTitle.getText().equals("Receipt number"),"Receipt number not found");
//        s_assert.assertTrue(bookingDetailsPage.retrieveTicket.priceTitle.getText().equals("Price"),"Price not found");
//        String ticketRetrieved = bookingDetailsPage.retrieveTicket.retrievedTicket.getText();
//        s_assert.assertTrue(ticketRetrieved.contains("Online ticket(s)"),"Online ticket(s) not found");
//        s_assert.assertTrue(ticketRetrieved.contains("Ticket conditions"),"Ticket conditions not found");
//        s_assert.assertTrue(ticketRetrieved.contains("0 EUR"),"0 EUR not found");
//        s_assert.assertTrue(ticketRetrieved.contains("Total"),"Total not found");
        s_assert.assertAll();
    }

//    @Test(groups = {"dev","test","demo"},dependsOnMethods = "retrievePageDetailsAssertions", priority = 2)
//    public void refundPageDetailsAssertions() {
//        gotoUrl(APP_URL+URL_RETRIEVE);
//        retrievePage.bookingID.sendKeys(bookingID);
//        retrievePage.email.sendKeys(TEST_EMAIL);
//        retrievePage.captcha.sendKeys(CAPTCHA_CODE);
//        retrievePage.searchButton.click();
//        s_assert.assertTrue(bookingDetailsPage.titleBookingDetails.getText().equals("Booking details"),"Booking details not found");
//        bookingDetailsPage.getRefundConditionsButton.click();
//        s_assert.assertTrue(refundConditionsPage.titleRefundConditions.getText().equals("Refund conditions"),"title1");
//        s_assert.assertTrue(refundConditionsPage.subtitleRefundConditions.getText().equals("Cancellation of outward journey"),"Your booking tickets Outward journey not found");
//        s_assert.assertTrue(refundConditionsPage.retrieveDetails.bookingPNRtitle.getText().equals("Booking PNR"),"Booking PNR not found");
//        s_assert.assertTrue(refundConditionsPage.retrieveDetails.bookingDateTitle.getText().equals("Booking date"),"Booking date not found");
//        s_assert.assertTrue(refundConditionsPage.retrieveDetails.personMadeBookingTitle.getText().equals("Person made the booking"),"Person made the booking not found");
//        s_assert.assertTrue(refundConditionsPage.retrieveDetails.travellersTitle.getText().equals("Traveller(s)"),"Traveller(s) not found");
//        s_assert.assertTrue(refundConditionsPage.retrieveDetails.statusTitle.getText().equals("Status"),"Status not found");
//        s_assert.assertTrue(refundConditionsPage.retrieveDetails.bookingPNR.getText().equals(bookingID),"booking ID not correspond");
//        s_assert.assertTrue(refundConditionsPage.retrieveDetails.bookingDate.getText().contains(" "),"booking date  not found");
//        s_assert.assertTrue(refundConditionsPage.retrieveDetails.personMadeBooking.getText().contains("name")&bookingDetailsPage.retrieveDetails.personMadeBooking.getText().contains("surname"),"person made name surname not found");
//        s_assert.assertTrue(refundConditionsPage.retrieveDetails.travellers.getText().contains("name")&bookingDetailsPage.retrieveDetails.travellers.getText().contains("surname"),"travellers name surname not found");
//        s_assert.assertTrue(refundConditionsPage.retrieveDetails.bookingStatus.getText().equals("Processed"),"status not found");
//        s_assert.assertTrue(refundConditionsPage.retrieveTicket.receiptTitle.getText().equals("Receipt"),"Receipt not found");
//        s_assert.assertTrue(refundConditionsPage.retrieveTicket.dateOfTravelTitle.getText().equals("Date of travel"),"Date of travel not found");
//        s_assert.assertTrue(refundConditionsPage.retrieveTicket.descriptionTitle.getText().equals("Description"),"Description not found");
//        s_assert.assertTrue(refundConditionsPage.retrieveTicket.receiptNumberTitle.getText().equals("Receipt number"),"Receipt number not found");
//        s_assert.assertTrue(refundConditionsPage.retrieveTicket.priceTitle.getText().equals("Price"),"Price not found");
//        String ticketRetrieved = refundConditionsPage.retrieveTicket.retrievedTicket.getText();
//        s_assert.assertTrue(ticketRetrieved.contains("Online ticket(s)"),"Online ticket(s) not found");
//        s_assert.assertTrue(ticketRetrieved.contains("Ticket conditions"),"Ticket conditions not found");
//        s_assert.assertTrue(ticketRetrieved.contains("0 EUR"),"0 EUR not found");
//        s_assert.assertTrue(ticketRetrieved.contains("Total"),"Total not found");
//        s_assert.assertTrue(ticketRetrieved.contains("Refund amount"),"Refund amount not found");
//        s_assert.assertTrue(refundConditionsPage.messageInBottom.getText().equals("Your ticket(s) will be canceled and the refundable amount credited to your credit card or PayPal account."),"Your ticket(s) will be canceled and the refundable amount credited to your credit card or PayPal account");
//        //refund
//        refundConditionsPage.getRefundButton.click();
//        s_assert.assertTrue(refundPage.titleRefund.getText().equals("Booking refunded"),"title2");
//        s_assert.assertTrue(refundPage.subtitlesRefund.get(0).getText().contains("Your booking"),"Your booking");
//        s_assert.assertTrue(refundPage.subtitlesRefund.get(0).getText().contains("has been successfully refunded"),"has been successfully refunded");
//        s_assert.assertTrue(refundPage.subtitlesRefund.get(1).getText().contains("The amount of"),"The amount of");
//        s_assert.assertTrue(refundPage.subtitlesRefund.get(1).getText().contains("will be credited to your credit card or PayPal account."),"will be credited to your credit card or PayPal account.");
//        s_assert.assertTrue(refundPage.retrieveDetails.bookingPNRtitle.getText().equals("Booking PNR"),"Booking PNR not found");
//        s_assert.assertTrue(refundPage.retrieveDetails.bookingDateTitle.getText().equals("Booking date"),"Booking date not found");
//        s_assert.assertTrue(refundPage.retrieveDetails.personMadeBookingTitle.getText().equals("Person made the booking"),"Person made the booking not found");
//        s_assert.assertTrue(refundPage.retrieveDetails.travellersTitle.getText().equals("Traveller(s)"),"Traveller(s) not found");
//        s_assert.assertTrue(refundPage.retrieveDetails.statusTitle.getText().equals("Status"),"Status not found");
//        s_assert.assertTrue(refundPage.retrieveDetails.bookingPNR.getText().equals(bookingID),"booking ID not correspond");
//        s_assert.assertTrue(refundPage.retrieveDetails.bookingDate.getText().contains(" "),"booking date  not found");
//        s_assert.assertTrue(refundPage.retrieveDetails.personMadeBooking.getText().contains("name")&bookingDetailsPage.retrieveDetails.personMadeBooking.getText().contains("surname"),"person made name surname not found");
//        s_assert.assertTrue(refundPage.retrieveDetails.travellers.getText().contains("name")&bookingDetailsPage.retrieveDetails.travellers.getText().contains("surname"),"travellers name surname not found");
//        s_assert.assertTrue(refundPage.retrieveDetails.bookingStatus.getText().equals("Cancelled"),"status not found");
//        s_assert.assertTrue(refundPage.retrieveTicket.receiptTitle.getText().equals("Receipt"),"Receipt not found");
//        s_assert.assertTrue(refundPage.retrieveTicket.dateOfTravelTitle.getText().equals("Date of travel"),"Date of travel not found");
//        s_assert.assertTrue(refundPage.retrieveTicket.descriptionTitle.getText().equals("Description"),"Description not found");
//        s_assert.assertTrue(refundPage.retrieveTicket.receiptNumberTitle.getText().equals("Receipt number"),"Receipt number not found");
//        s_assert.assertTrue(refundPage.retrieveTicket.priceTitle.getText().equals("Price"),"Price not found");
//        ticketRetrieved = refundPage.retrieveTicket.retrievedTicket.getText();
//        s_assert.assertTrue(ticketRetrieved.contains("Online ticket(s)"),"Online ticket(s) not found");
//        s_assert.assertTrue(ticketRetrieved.contains("Ticket conditions"),"Ticket conditions not found");
//        s_assert.assertTrue(ticketRetrieved.contains("0 EUR"),"0 EUR not found");
//        s_assert.assertTrue(ticketRetrieved.contains("Total"),"Total not found");
//        s_assert.assertTrue(ticketRetrieved.contains("Refund amount"),"Refund amount not found");
//        s_assert.assertTrue(refundPage.totalRefundedAmount.getText().equals("Total amount refunded"),"Total amount refunded");
//
//        s_assert.assertAll();
//    }
}
