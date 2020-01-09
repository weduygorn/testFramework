package tests.providerscenarios.OBB_OneWay.NJ;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import tests.BaseTest;
import tests.testData.TestDataProvider;

public class CheckReservation extends BaseTest {

    @Title("OBB.Ticket & Reservation page. Check that reservation included.")
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void checkReservationIncludedAdult(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("2000");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.clickSearchButton();
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.clickContinueButton(0);
        upsalePage.selectCompartment("Komfort-Ticket Nightjet", "Berth in a compartment\n" +
                "with 6 berths");
        upsalePage.continueButton.click();
        s_assert.assertTrue(ticketAndReservationPage.getReservationSelect(0), "Reservation is not included");
        s_assert.assertTrue(ticketAndReservationPage.getReservationText(0).contains("Your reservation is included"), "Reservation text not as expected");
        s_assert.assertTrue(ticketAndReservationPage.getReservationPriceAmount(0).contains("0,00"), "Reservation price not as expected");
        s_assert.assertAll();
    }
}
