package tests.providerscenarios.Treniatalia;

import org.testng.annotations.Test;
import tests.BaseTest;
import tests.testData.TestDataProvider;

public class TrenitaliaCancelBookingOW extends BaseTest {
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "RomaTermini_MilanoCentrale", dataProviderClass = TestDataProvider.class)
    public void cancelBookingOW(String dep, String arr) {
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
        passengerDetailsPage.fillPas1Data();
        passengerDetailsPage.continueButton.click();
        checkAndBookPage.clickCancelButton();
        checkAndBookPage.performCancelBooking();
        s_assert.assertTrue(connectionResultPage.getFirstConnection().toOfferSelection.isDisplayed());
        s_assert.assertAll();
    }
}
