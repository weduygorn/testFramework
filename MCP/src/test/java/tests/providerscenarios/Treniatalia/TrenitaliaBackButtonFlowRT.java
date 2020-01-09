package tests.providerscenarios.Treniatalia;

import org.testng.annotations.Test;
import tests.BaseTest;
import tests.testData.TestDataProvider;

public class TrenitaliaBackButtonFlowRT extends BaseTest {
    //AMR-3618
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "RomaTermini_MilanoCentrale", dataProviderClass = TestDataProvider.class)
    public void backButtonsFlowRT(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("0000");
        searchPage.pasCount.click();
        searchPage.selectOptionFromDropdown("2 Passengers");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.setPas2BirthDate(CHILD_BIRTH_DATE);
        searchPage.activateRoundTrip();
        searchPage.addDaysToInwardDate(numberOfDaysInward);
        searchPage.setInwardTime("0000");
        searchPage.clickSearchButton();
        connectionResultPage.selectFirstConnection();
        connectionResultPage.selectFirstConnection();
        searchOffersPage.returnJourneys.get(1).click();
        upsalePage.continueButton.click();
        searchOffersPage.clickContinueButton(1);
        upsalePage.continueButton.click();
        ticketAndReservationPage.returnJourneyButton.click();
        ticketAndReservationPage.continueButton.click();
        passengerDetailsPage.backButton.click();
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsRoundTrip.getText().contains("Return journey"), "not found return journey on inward ticket and reservation page");
        ticketAndReservationPage.backButton.click();
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsRoundTrip.getText().contains("Outward journey"), "not found outward journey on outward ticket and reservation page");
        ticketAndReservationPage.backButton.click();
        s_assert.assertTrue(upsalePage.upsaleTitle.getText().contains("Please choose preferable comfort or compartment type"), "Upsale title return");
        upsalePage.backButton.click();
        s_assert.assertTrue(searchOffersPage.journeyHeader.getText().contains("Return journey"), "return journey not found on select return offer page");
        searchOffersPage.back.click();
        s_assert.assertTrue(upsalePage.upsaleTitle.getText().equals("Please choose preferable comfort or compartment type"), "outward upsale page title not found");
        upsalePage.backButton.click();
        s_assert.assertTrue(connectionResultPage.titleOffers.getText().contains("Outward journey"), "titleoffers");
        s_assert.assertTrue(connectionResultPage.backButton.getText().equals("Change query"), "change query button");
        s_assert.assertAll();
    }
}
