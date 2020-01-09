package tests.bookingconfirmation;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class BookingConfirmation5PaxBahnIncludedNoReservationAssertion extends BaseTest {
    @Test(groups = {"dev", "test"})
    public void bookingConfirmation5PasNoReservationBahnCardIncluded() {
        String mcpUrl = MunichRoma;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDDOUT", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.searchOptions.passengerCount.click();
        searchOffersPage.selectOptionFromDropdown("5 Passengers");
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.setPasTwoBirthDate(CHILD_BIRTH_DATE);
        searchOffersPage.setPasThreeBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.setPasFourBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.setPasFiveBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.searchOptions.discountCardsPasOne.click();
        searchOffersPage.selectOptionFromDropdown("BahnCard 25, 1st class");
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
        passengerDetailsPage.passengersDetails.pasTwoSalutation.click();
        passengerDetailsPage.selectOptionFromDropdown("Mr");
        passengerDetailsPage.passengersDetails.pasTwoName.sendKeys("nameOne");
        passengerDetailsPage.passengersDetails.pasTwoSurname.sendKeys("surname");
        passengerDetailsPage.passengersDetails.pasThreeSalutation.click();
        passengerDetailsPage.selectOptionFromDropdown("Mr");
        passengerDetailsPage.passengersDetails.pasThreeName.sendKeys("nameTwo");
        passengerDetailsPage.passengersDetails.pasThreeSurname.sendKeys("surname");
        passengerDetailsPage.passengersDetails.pasFourSalutation.click();
        passengerDetailsPage.selectOptionFromDropdown("Mr");
        passengerDetailsPage.passengersDetails.pasFourName.sendKeys("nameThree");
        passengerDetailsPage.passengersDetails.pasFourSurname.sendKeys("surname");
        passengerDetailsPage.passengersDetails.pasFiveSalutation.click();
        passengerDetailsPage.selectOptionFromDropdown("Mr");
        passengerDetailsPage.passengersDetails.pasFiveName.sendKeys("nameFour");
        passengerDetailsPage.passengersDetails.pasFiveSurname.sendKeys("surname");
        passengerDetailsPage.continueButton.click();
        s_assert.assertTrue(checkAndBookPage.titleCheckAndBook.getText().equals("Check your booking here"), "seems not booking confirmation page");
        s_assert.assertAll();
    }
}
