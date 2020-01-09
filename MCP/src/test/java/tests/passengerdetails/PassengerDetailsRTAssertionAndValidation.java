package tests.passengerdetails;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class PassengerDetailsRTAssertionAndValidation extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void passengerDetailsRTTestDetailsAssertionAndValidation() {
        String mcpUrl = RomeMilanRTLink;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDDOUT", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        mcpUrl = mcpUrl.replaceAll("YYYYMMDDIN", currentDatePlusNDaysNotWeekend(numberOfDaysInward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.returnJourneys.get(0));
        String priceOutward = getTextByXpath(searchOffersPage.price2);
        searchOffersPage.returnJourneys.get(1).click();
        upsalePage.waitForElement(upsalePage.continueButton);
        upsalePage.continueButton.click();
        String priceReturn = getTextByXpath(searchOffersPage.price2);
        priceOutward = priceOutward.replaceAll(" EUR", "").replaceAll(",", ".");
        priceReturn = priceReturn.replaceAll(" EUR", "").replaceAll(",", ".");
        String total = Float.valueOf(priceOutward) + Float.valueOf(priceReturn) + "";
        searchOffersPage.clickContinueButton(1);
        upsalePage.continueButton.click();
        ticketAndReservationPage.returnJourneyButton.click();
        ticketAndReservationPage.continueButton.click();
        /////////////your journey section/////////////
        s_assert.assertTrue(passengerDetailsPage.pasDetailsYourJourney.title.getText().equals("Your journey"), "Your journey not found");
        String bodyText = passengerDetailsPage.pasDetailsYourJourney.body.getText();
        s_assert.assertTrue(bodyText.contains("Outward"), "Outbound not found");
        s_assert.assertTrue(bodyText.contains("Return"), "Outbound not found");
        s_assert.assertTrue(bodyText.contains("Milano Centrale"), "Milano Centrale not found");
        s_assert.assertTrue(bodyText.contains("Roma Termini"), "Roma Termini not found");
        s_assert.assertTrue(bodyText.contains(":"), ": not found");
//        s_assert.assertTrue(bodyText.contains(currentDatePlusNDaysNotWeekendGUI(numberOfDaysOutward)),"date and time not found");
//        s_assert.assertTrue(bodyText.contains(currentDatePlusNDaysNotWeekendGUI(numberOfDaysInward)),"date and time not found");
        s_assert.assertTrue(passengerDetailsPage.pasDetailsYourJourney.footer.getText().contains("Total"), "total not found");
        s_assert.assertTrue(passengerDetailsPage.pasDetailsYourJourney.footer.getText().contains(total.replaceAll("\\.", ",")), "wrong price");
        String bodyTextPart2 = passengerDetailsPage.pasDetailsYourJourney.bodyPart2.getText();
        s_assert.assertTrue(passengerDetailsPage.pasDetailsYourJourney.getText().contains("Price"), "Price not found");
        s_assert.assertTrue(bodyTextPart2.contains("Ticket"), "Ticket not found");
        s_assert.assertTrue(bodyTextPart2.contains(". Class"), ". Class not found");
        s_assert.assertTrue(bodyTextPart2.contains(total.replaceAll("\\.", ",")), "total2 not found");
        s_assert.assertTrue(bodyTextPart2.contains("1 Passenger"), "1 Passenger  not found");
        /////////////////////titles////////////////////
        s_assert.assertTrue(passengerDetailsPage.pageTitle.getText().equals("Passenger details"), "page title");
        s_assert.assertTrue(passengerDetailsPage.pleaseEnterPersonalDataTitle.getText().equals("Please enter your personal data"), "personal data");
        /////////////////////////pass details section/////////////////////
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasOneSalutationLabel.getText().equals("Salutation"), "pas1 salutation label");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasOneSalutation.getText().equals("not selected"), "pas1 one first selected option");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasOneBirthDate.getText().contains("Birth date:"), "pas1 birth date");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasOneNameLabel.getText().equals("First name") || passengerDetailsPage.passengersDetails.pasOneNameLabel.getText().equals("Name"), "pas1 name label");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasOneSurnameLabel.getText().equals("Surname"), "pas1 surname label");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasOneEmailLabel.getText().equals("E-mail"), "pas1 email label");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasOnePhoneLabel.getText().equals("Phone"), "pas1 phone label");
        String currentURL = driver.getCurrentUrl();
        passengerDetailsPage.continueButton.click();
        s_assert.assertTrue(driver.getCurrentUrl().equals(currentURL), "title validation");
        passengerDetailsPage.passengersDetails.pasOneSalutation.click();
        passengerDetailsPage.selectOptionFromDropdown("Mr");
        passengerDetailsPage.passengersDetails.pasOneSalutation.click();
        passengerDetailsPage.selectOptionFromDropdown("Ms");
        passengerDetailsPage.continueButton.click();
        s_assert.assertTrue(driver.getCurrentUrl().equals(currentURL), "name validation");
        passengerDetailsPage.passengersDetails.pasOneName.sendKeys("name");
        passengerDetailsPage.continueButton.click();
        s_assert.assertTrue(driver.getCurrentUrl().equals(currentURL), "last name validation");
        passengerDetailsPage.passengersDetails.pasOneSurname.sendKeys("surname");
        passengerDetailsPage.continueButton.click();
        s_assert.assertTrue(driver.getCurrentUrl().equals(currentURL), "email validation");
        passengerDetailsPage.passengersDetails.pasOneEmail.sendKeys(TEST_EMAIL);
        passengerDetailsPage.continueButton.click();
        s_assert.assertTrue(driver.getCurrentUrl().equals(currentURL), "street validation");
        passengerDetailsPage.passengersDetails.pasOneStreetNumber.sendKeys(STREET);
        passengerDetailsPage.continueButton.click();
        s_assert.assertTrue(driver.getCurrentUrl().equals(currentURL), "postcode validation");
        passengerDetailsPage.passengersDetails.pasOnePostcodeNumber.sendKeys(POSTCODE);
        passengerDetailsPage.continueButton.click();
        s_assert.assertTrue(driver.getCurrentUrl().equals(currentURL), "city validation");
        passengerDetailsPage.passengersDetails.pasOneCity.sendKeys(CITY);
        passengerDetailsPage.continueButton.click();
        //s_assert.assertTrue(checkAndBookPage.titleCheckAndBook.getText().equals("Check your booking here"),"seems not booking confirmation page");
        s_assert.assertAll();
    }

}
