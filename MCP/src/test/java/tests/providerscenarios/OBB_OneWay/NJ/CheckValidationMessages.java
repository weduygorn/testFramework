package tests.providerscenarios.OBB_OneWay.NJ;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import tests.BaseTest;
import tests.testData.TestDataProvider;

public class CheckValidationMessages extends BaseTest {

    @Title("OBB.Passenger details. Check salutation error massage for female reservation.")
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void checkSalutationErrorForFemaleReservationAdult(String dep, String arr) {
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
        ticketAndReservationPage.selectCoupeType("Female");
        ticketAndReservationPage.continueButton.click();
        passengerDetailsPage.fillPas1Data();
        passengerDetailsPage.continueButton.click();
        Assert.assertEquals(passengerDetailsPage.getErrorMessage(0), "Salutation should correspond to the selected coupe type", "Error message text was not as expected");
        s_assert.assertAll();
    }

    @Title("OBB.Passenger details. Check salutation warning message.")
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void checkWarningMessageForSalutationSelectAdult(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("2000");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.clickSearchButton();
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.clickContinueButton(0);
        upsalePage.selectCompartment("Komfort-Ticket Nightjet", "Bed in a compartment\n" +
                "with 3 beds");
        upsalePage.continueButton.click();
        ticketAndReservationPage.continueButton.click();
        Assert.assertEquals(passengerDetailsPage.getErrorMessage(0), "Please pay attention to the correct salutation of all passengers. In night trains, multi-bed compartments for single passengers are offered only as ladies' or men's compartments.", "Error message text was not as expected");
        s_assert.assertAll();
    }

}
