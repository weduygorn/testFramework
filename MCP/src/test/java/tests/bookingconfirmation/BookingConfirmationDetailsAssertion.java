package tests.bookingconfirmation;

import org.testng.annotations.Test;
import pages.modalwindows.Conditions;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysWeekend;

public class BookingConfirmationDetailsAssertion extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void checkBookingPageDetailsAssertion() throws InterruptedException{
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
        s_assert.assertTrue(checkAndBookPage.titleCheckAndBook.getText().equals("Check your booking here"), "assert1");
        s_assert.assertTrue(checkAndBookPage.journeyOW.journeyTitle.getText().equals("Outward journey"), "assert2");
        s_assert.assertTrue(checkAndBookPage.journeyOW.journeyStations.getText().contains("Munich Hbf"), "assert3");
        s_assert.assertTrue(checkAndBookPage.journeyOW.journeyStations.getText().contains("Verona Porta Nuova"), "assert4");
        // s_assert.assertTrue(checkAndBookPage.journeyOW.journeyDate.getText().contains(currentDatePlusNDaysTipSearchNotWeekend(numberOfDaysOutward)),"assert5");
        s_assert.assertTrue(checkAndBookPage.journeyOW.journeyTime.getText().contains("13:34"), "assert6");
        s_assert.assertTrue(checkAndBookPage.journeyOW.journeyTime.getText().contains("18:58"), "assert7");
        s_assert.assertTrue(checkAndBookPage.journeyOW.journeyTrain.getText().contains("EC 89"), "assert8");
        s_assert.assertTrue(checkAndBookPage.journeyOW.journeyReserve.getText().contains("No seat reservation"), "assert9");
        s_assert.assertTrue(checkAndBookPage.jOurneyOffersOW.journeyOffersTitle.getText().equals("Your selected offer"), "assert10");
        s_assert.assertTrue(checkAndBookPage.jOurneyOffersOW.journeyOfferTitle.getText().equals("Outward journey"), "assert11");
        s_assert.assertTrue(checkAndBookPage.jOurneyOffersOW.journeyOfferClass.getText().equals("2. Class"), "assert12");
        s_assert.assertTrue(checkAndBookPage.jOurneyOffersOW.journeyOfferTicketType.getText().equals("Online ticket(s)"), "assert13");
        s_assert.assertTrue(checkAndBookPage.jOurneyOffersOW.journeyOfferCompany.getText().contains("EC"), "assert14");
//        s_assert.assertTrue(checkAndBookPage.jOurneyOffersOW.journeyOfferColumnInfo.getText().contains("Super Sparpreis Europa Italien"),"assert15");
        System.out.println(checkAndBookPage.jOurneyOffersOW.journeyOfferConditions.getText());
//        s_assert.assertTrue(checkAndBookPage.jOurneyOffersOW.journeyOfferConditions.getText().contains("Ticket may not be changed nor refunded."),"assert155");
        s_assert.assertTrue(checkAndBookPage.jOurneyOffersOW.journeyOfferPrice.getText().contains("EUR"), "assert 16");
        s_assert.assertTrue(checkAndBookPage.jOurneyOffersOW.journeyOfferTotalPriceText.getText().equals("Total price"), "assert 17");
        s_assert.assertTrue(checkAndBookPage.jOurneyOffersOW.journeyOfferTotalPrice.getText().contains("EUR"), "assert 18");
        //Check Read more popup
        searchOffersPage.showConditionDetails.get(0).click();
        Conditions modal = new Conditions(driver);
        String body = modal.body.getText();
        //s_assert.assertTrue(body.contains("Ticket can be")||body.contains("Ticket may not be"),"Ticket can be not found");
        s_assert.assertTrue(body.contains("EC") || body.contains("INI") || body.contains("ICP"), "EC not found");
        s_assert.assertTrue(body.contains("Adult"), "Adult not found");
        s_assert.assertTrue(modal.footer.getText().contains("Print"), "Print not found");
        modal.closeX.click();
        searchOffersPage.waitForElement(searchOffersPage.showConditionDetails.get(0));
        // check detailed information section
        s_assert.assertTrue(checkAndBookPage.detailedInformation.detailedInformationTitle.getText().equals("Detailed information"), "assert19");
        String detailInfo = checkAndBookPage.detailedInformation.getText();
        s_assert.assertTrue(detailInfo.contains("Passenger"), "assert 20");
        s_assert.assertTrue(detailInfo.contains("Contact details"), "assert 21");
        s_assert.assertTrue(detailInfo.contains("Ticket type"), "assert 22");
        s_assert.assertTrue(detailInfo.contains("Mr name surname"), "assert 23");
        s_assert.assertTrue(detailInfo.contains(TEST_EMAIL), "assert 24");
        s_assert.assertTrue(detailInfo.contains("I accept the GTC for online ticket bookings at www.international-bahn.de."), "assert 25");
        s_assert.assertTrue(detailInfo.contains("Ticket in PDF-Format, to be printed at home. Only valid for the passenger stated (and accompanying passengers if applicable), not transferable. Passenger must present personal identification on the train (ID card, passport, BahnCard, electronic residence permit or asylum registration confirmation)."), "assert 26");
        s_assert.assertTrue(checkAndBookPage.totalAmountToPay.getText().equals("Total amount to pay"), "assert 27");
        s_assert.assertTrue(checkAndBookPage.totalPrice.getText().contains("EUR"), "assert 28");
        s_assert.assertAll();
    }

}
