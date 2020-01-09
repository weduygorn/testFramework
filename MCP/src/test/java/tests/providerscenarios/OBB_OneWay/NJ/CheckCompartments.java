package tests.providerscenarios.OBB_OneWay.NJ;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import tests.BaseTest;
import tests.testData.TestDataProvider;

public class CheckCompartments extends BaseTest {

    @Title("OBB.Upsale. Check compartments availability for adult")
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void checkCompartmentsAdult(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("2000");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.clickSearchButton();
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.clickContinueButton(0);
        s_assert.assertTrue(upsalePage.getCompartments().contains("2nd class: seat incl."), "2nd class: seat incl. not available");
        s_assert.assertTrue(upsalePage.getCompartments().contains("Berth in a compartment\n" +
                "with 6 berths"), "Berth in a compartment with 6 berths not available");
        s_assert.assertTrue(upsalePage.getCompartments().contains("Berth in a compartment\n" +
                "with 4 berths"), "Berth in a compartment with 4 berths not available");
        s_assert.assertTrue(upsalePage.getCompartments().contains("Bed in a compartment\n" +
                "with 3 beds"), "Bed in a compartment with 3 beds not available");
        s_assert.assertTrue(upsalePage.getCompartments().contains("Bed in a compartment\n" +
                "with 2 beds"), "Bed in a compartment with 2 beds not available");
        s_assert.assertTrue(upsalePage.getCompartments().contains("Bed in a Deluxe\n" +
                "compartment with 3 beds"), "Bed in a Deluxe with 3 beds not available");
        s_assert.assertTrue(upsalePage.getCompartments().contains("Bed in a Deluxe\n" +
                "compartment with 2 beds"), "Bed in a Deluxe with 2 beds not available");
        s_assert.assertTrue(upsalePage.getCompartments().contains("Bed in a compartment\n" +
                "with 1 bed"), "Bed in a compartment with 1 bed not available");
        s_assert.assertTrue(upsalePage.getCompartments().contains("Bed in a Deluxe\n" +
                "compartment with 1 bed"), "Bed in a Deluxe compartment with 1 bed not available");
        s_assert.assertAll();
    }

    @Title("OBB.Upsale. Check compartments availability for adult + child + infant")
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void checkCompartmentsAdultChildInfant(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setPassengersCounter("3 Passengers");
        searchPage.setOutwardTime("2000");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.setPas2BirthDate(CHILD_BIRTH_DATE);
        searchPage.setPas3BirthDate(INFANT_BIRTH_DATE);
        searchPage.clickSearchButton(true);
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.clickContinueButton(0);
        s_assert.assertTrue(upsalePage.getCompartments().contains("2nd class: seat incl."), "2nd class: seat incl. not available");
        s_assert.assertTrue(upsalePage.getCompartments().contains("Berth in a compartment\n" +
                "with 6 berths"), "Berth in a compartment with 6 berths not available");
        s_assert.assertTrue(upsalePage.getCompartments().contains("Berth in a compartment\n" +
                "with 4 berths"), "Berth in a compartment with 4 berths not available");
        s_assert.assertTrue(upsalePage.getCompartments().contains("Bed in a compartment\n" +
                "with 3 beds"), "Bed in a compartment with 3 beds not available");
        s_assert.assertTrue(upsalePage.getCompartments().contains("Bed in a compartment\n" +
                "with 2 beds"), "Bed in a compartment with 2 beds not available");
        s_assert.assertTrue(upsalePage.getCompartments().contains("Bed in a Deluxe\n" +
                "compartment with 3 beds"), "Bed in a Deluxe with 3 beds not available");
        s_assert.assertTrue(upsalePage.getCompartments().contains("Bed in a Deluxe\n" +
                "compartment with 2 beds"), "Bed in a Deluxe with 2 beds not available");
        s_assert.assertFalse(upsalePage.getCompartments().contains("Bed in a compartment\n" +
                "with 1 bed"), "Bed in a compartment with 1 bed available");
        s_assert.assertFalse(upsalePage.getCompartments().contains("Bed in a Deluxe\n" +
                "compartment with 1 bed"), "Bed in a Deluxe compartment with 1 bed available");
        s_assert.assertAll();
    }

    @Title("OBB.Upsale. Check family compartments availability for adult + child + infant")
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void checkFamilyCompartmentsAdultChild(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setPassengersCounter("3 Passengers");
        searchPage.setOutwardTime("2000");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.setPas2BirthDate(CHILD_BIRTH_DATE);
        searchPage.setPas3BirthDate(INFANT_BIRTH_DATE);
        searchPage.clickSearchButton(true);
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.clickContinueButton(0);
        Assert.assertTrue(upsalePage.getCompartmentAvailability("Familienabteil Nightjet", "Berth in a compartment\n" +
                "with 6 berths"), "Family compartment is not available.");
    }

}