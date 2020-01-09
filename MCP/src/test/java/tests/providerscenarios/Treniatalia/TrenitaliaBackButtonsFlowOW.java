package tests.providerscenarios.Treniatalia;

import org.testng.annotations.Test;
import tests.BaseTest;
import tests.testData.TestDataProvider;

public class TrenitaliaBackButtonsFlowOW extends BaseTest {
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "RomaTermini_MilanoCentrale", dataProviderClass = TestDataProvider.class)
    public void backButtonsFlowOW(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("0000");
        searchPage.pasCount.click();
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.clickSearchButton();
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.clickContinueButton(1);
        upsalePage.continueButton.click();
        ticketAndReservationPage.continueButton.click();
        passengerDetailsPage.backButton.click();
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsRoundTrip.getText().contains("Outward journey"), "not found outward journey on outward ticket and reservation page");
        ticketAndReservationPage.backButton.click();
        s_assert.assertTrue(upsalePage.upsaleTitle.getText().contains("Please choose preferable comfort or compartment type"), "Upsale title return");
        upsalePage.backButton.click();
        s_assert.assertTrue(connectionResultPage.titleOffers.getText().contains("Outward journey"), "titleoffers");
        s_assert.assertTrue(connectionResultPage.backButton.getText().equals("Change query"), "change query button");
        s_assert.assertAll();
    }
}
