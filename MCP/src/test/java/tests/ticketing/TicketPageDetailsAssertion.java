package tests.ticketing;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysWeekend;


public class TicketPageDetailsAssertion extends BaseTest {

    @Test(priority = 1)
    public void ticketPageDetailsAssertions() {
        String mcpUrl = MunichVerona;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(0));
        searchOffersPage.continueButton.get(0).click();
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
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        s_assert.assertTrue(ticketPage.getTicketTitle().contains("Thank you for your booking, it is successfully processed."));
        s_assert.assertTrue(ticketPage.getTicketTitle().contains("Have a good journey!"), "assert1");
        System.out.println(ticketPage.finalContent.getText());
        s_assert.assertTrue(ticketPage.finalContent.getText().contains("Please pay attention to the ticket use rules"), "assert2");
        s_assert.assertTrue(ticketPage.finalContent.getText().contains("Order confirmation / online ticket(s) and use rules which are presented below have been sent to the following e-mail address"), "assert3");
        s_assert.assertTrue(ticketPage.finalContent.getText().contains(TEST_EMAIL), "assert4");
        s_assert.assertTrue(ticketPage.finalContent.getText().contains("Order confirmation and online ticket have been sent to the following e-mail address:"), "assert5");
        s_assert.assertTrue(ticketPage.finalContent.getText().contains("Please print the online ticket on\n" +
                "DIN A4-Format"), "assert6");
        s_assert.assertTrue(ticketPage.finalContent.getText().contains("Printed online ticket"), "assert7");
        s_assert.assertTrue(ticketPage.finalContent.getText().contains("Your ID"), "assert8");
        s_assert.assertAll();
    }


}
