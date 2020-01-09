package tests.passengerdetails;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class PassengerDetailsOW5PaxDetailsAssertion extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void pasDetailsOneWayTest5PasDetailsAssertion() {
        String mcpUrl = RomeMilanOWLink;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(0));
        searchOffersPage.searchOptions.changeAllData.click();
        searchOffersPage.searchOptions.passengerCount.click();
        searchOffersPage.selectOptionFromDropdown("5 Passengers");
        searchOffersPage.setPasTwoBirthDate(CHILD_BIRTH_DATE);
        searchOffersPage.setPasThreeBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.setPasFourBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.setPasFiveBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(0));
        String price = getTextByXpath(searchOffersPage.price);
        searchOffersPage.continueButton.get(0).click();
        upsalePage.continueButton.click();
        ticketAndReservationPage.continueButton.click();
        /////////////////////titles////////////////////
        s_assert.assertTrue(passengerDetailsPage.pageTitle.getText().equals("Passenger details"), "pass details no found");
        s_assert.assertTrue(passengerDetailsPage.pleaseEnterPersonalDataTitle.getText().equals("Please enter your personal data"), "title not found");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.passengerNumber.getText().equals("Passenger 1"), "passenger 1 not found");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.infoReceiveBooking.getText().equals("This passenger will receive the booking confirmation and the online ticket(s)."), "assert info");
        /////////////////////////pass details section/////////////////////
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasOneSalutationLabel.getText().equals("Salutation"), "pas1 salutation label");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasOneSalutation.getText().equals("not selected"), "pas1 one first selected option");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasOneBirthDate.getText().contains("Birth date:"), "pas1 birth date");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasOneNameLabel.getText().equals("First name") || passengerDetailsPage.passengersDetails.pasOneNameLabel.getText().equals("Name"), "pas1 name label");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasOneSurnameLabel.getText().equals("Surname"), "pas1 surname label");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasOneEmailLabel.getText().equals("E-mail"), "pas1 email label");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasOnePhoneLabel.getText().equals("Phone"), "pas1 phone label");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasTwoSalutation.getText().equals("not selected"), "pas2 first selected option");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasTwoBirthDate.getText().contains("Birth date:"), "pas2 birth date");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasThreeSalutation.getText().equals("not selected"), "pas3 first selected option");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasThreeBirthDate.getText().contains("Birth date:"), "pas3 birth date");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasFourSalutation.getText().equals("not selected"), "pas4 first selected option");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasFourBirthDate.getText().contains("Birth date:"), "pas4 birth date");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasFiveSalutation.getText().equals("not selected"), "pas5 first selected option");
        s_assert.assertTrue(passengerDetailsPage.passengersDetails.pasFiveBirthDate.getText().contains("Birth date:"), "pas5 birth date");
        /////////////your journey section/////////////
        s_assert.assertTrue(passengerDetailsPage.pasDetailsYourJourney.title.getText().equals("Your journey"), "Your journey not found");
        String bodyText = passengerDetailsPage.pasDetailsYourJourney.body.getText();
        s_assert.assertTrue(bodyText.contains("Outward"), "Outbound not found");
        s_assert.assertTrue(bodyText.contains("Milano Centrale"), "Milano Centrale not found");
        s_assert.assertTrue(bodyText.contains("Roma Termini"), "Roma Termini not found");
        s_assert.assertTrue(bodyText.contains(":"), ": not found");
        //s_assert.assertTrue(bodyText.contains(currentDatePlusNDaysNotWeekendGUI(numberOfDaysOutward)),"date and time not found");
        s_assert.assertTrue(passengerDetailsPage.pasDetailsYourJourney.footer.getText().contains("Total"), "total not found");
        s_assert.assertTrue(passengerDetailsPage.pasDetailsYourJourney.footer.getText().contains(price), "wrong price");
        String bodyTextPart2 = passengerDetailsPage.pasDetailsYourJourney.bodyPart2.getText();
        s_assert.assertTrue(passengerDetailsPage.pasDetailsYourJourney.getText().contains("Price"), "Price not found");
        s_assert.assertTrue(bodyTextPart2.contains("Ticket, "), "Ticket,  not found");
        s_assert.assertTrue(bodyTextPart2.contains(". Class"), ". Class not found");
        s_assert.assertTrue(bodyTextPart2.contains(price.replaceAll(" EUR", "")), "price not found");
        s_assert.assertTrue(bodyTextPart2.contains("5 Passengers"), "5 Passengers not found");
        s_assert.assertAll();
    }
}
