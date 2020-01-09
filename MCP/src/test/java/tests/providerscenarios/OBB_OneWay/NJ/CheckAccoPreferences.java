package tests.providerscenarios.OBB_OneWay.NJ;

import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import tests.BaseTest;
import tests.testData.TestDataProvider;

import static pages.BasePage.isElementPresent;

public class CheckAccoPreferences extends BaseTest {

    @Title("OBB.Ticket & Reservation page. Check 2nd. class seat. incl / Komfort-Ticket Nightjet")
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void check2ndClassSeatInclKomfortTicket(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("2000");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.clickSearchButton();
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.clickContinueButton(0);
        upsalePage.selectCompartment("Komfort-Ticket Nightjet", "2nd class: seat incl.");
        upsalePage.continueButton.click();
        s_assert.assertTrue(ticketAndReservationPage.getPlaceZonesTextArray().contains("Any"), "'Any' is not included in place zone");
        s_assert.assertTrue(ticketAndReservationPage.getPlaceZonesTextArray().contains("Compartment"), "'Compartment' is not included in place zone");
        s_assert.assertTrue(ticketAndReservationPage.getPlacePositionTextArray().contains("Any"), "'Any' is not included in place position");
        s_assert.assertTrue(ticketAndReservationPage.getPlacePositionTextArray().contains("Window"), "'Window' is not included in place position");
        s_assert.assertTrue(ticketAndReservationPage.getPlacePositionTextArray().contains("Aisle"), "'Aisle' is not included in place position");
        s_assert.assertTrue(ticketAndReservationPage.getPlacePositionTextArray().contains("Middle"), "'Middle' is not included in place position");
        s_assert.assertAll();
    }

    @Title("OBB.Ticket & Reservation page. Check Berth in a compartment with 6 berths / Komfort-Ticket Nightjet")
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void checkBerthWith6BerthsKomfortTicket(String dep, String arr) {
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
        s_assert.assertTrue(ticketAndReservationPage.getCoupeTypeTextArray().contains("Any"), "'Any' is not included in coupe types");
        s_assert.assertTrue(ticketAndReservationPage.getCoupeTypeTextArray().contains("Female"), "'Female' is not included in coupe types");
        s_assert.assertTrue(ticketAndReservationPage.getCoupeTypeTextArray().contains("Combined"), "'Combined' is not included in coupe types");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Any"), "'Any' is not included in berth level");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Upper"), "'Upper' is not included in berth level");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Middle"), "'Middle' is not included in berth level");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Lower"), "'Lower' is not included in berth level");
        s_assert.assertAll();
    }

    @Title("OBB.Ticket & Reservation page. Check Berth in a compartment with 4 berths / Komfort-Ticket Nightjet")
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void checkBerthWith4BerthsKomfortTicket(String dep, String arr) {
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
                "with 4 berths");
        upsalePage.continueButton.click();
        s_assert.assertTrue(ticketAndReservationPage.getCoupeTypeTextArray().contains("Any"), "'Any' is not included in coupe types");
        s_assert.assertTrue(ticketAndReservationPage.getCoupeTypeTextArray().contains("Female"), "'Female' is not included in coupe types");
        s_assert.assertTrue(ticketAndReservationPage.getCoupeTypeTextArray().contains("Combined"), "'Combined' is not included in coupe types");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Any"), "'Any' is not included in berth level");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Upper"), "'Upper' is not included in berth level");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Lower"), "'Lower' is not included in berth level");
        s_assert.assertAll();
    }

    @Title("OBB.Ticket & Reservation page. Check Bed in a compartment with 3 beds / Komfort-Ticket Nightjet")
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void checkBedWith3BedsKomfortTicket(String dep, String arr) {
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

        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Any"), "'Any' is not included in berth level");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Upper"), "'Upper' is not included in berth level");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Middle"), "'Middle' is not included in berth level");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Lower"), "'Lower' is not included in berth level");
        s_assert.assertAll();
    }

    @Title("OBB.Ticket & Reservation page. Check Bed in a compartment with 2 beds / Komfort-Ticket Nightjet")
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void checkBedWith2BedsKomfortTicket(String dep, String arr) {
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
                "with 2 beds");
        upsalePage.continueButton.click();
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Any"), "'Any' is not included in berth level");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Upper"), "'Upper' is not included in berth level");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Lower"), "'Lower' is not included in berth level");
        s_assert.assertAll();
    }

    @Title("OBB.Ticket & Reservation page. Check Bed in a Deluxe with 3 beds / Komfort-Ticket Nightjet")
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void checkBedDeluxeWith3BedsKomfortTicket(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("2000");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.clickSearchButton();
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.clickContinueButton(0);
        upsalePage.selectCompartment("Komfort-Ticket Nightjet", "Bed in a Deluxe\n" +
                "compartment with 3 beds");
        upsalePage.continueButton.click();
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Any"), "'Any' is not included in berth level");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Upper"), "'Upper' is not included in berth level");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Middle"), "'Middle' is not included in berth level");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Lower"), "'Lower' is not included in berth level");
        s_assert.assertAll();
    }

    @Title("OBB.Ticket & Reservation page. Check Bed in a Deluxe with 2 beds / Komfort-Ticket Nightjet")
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void checkBedDeluxeWith2BedsKomfortTicket(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("2000");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.clickSearchButton();
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.clickContinueButton(0);
        upsalePage.selectCompartment("Komfort-Ticket Nightjet", "Bed in a Deluxe\n" +
                "compartment with 2 beds");
        upsalePage.continueButton.click();
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Any"), "'Any' is not included in berth level");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Upper"), "'Upper' is not included in berth level");
        s_assert.assertTrue(ticketAndReservationPage.getBerthLevelTextArray().contains("Lower"), "'Lower' is not included in berth level");
        s_assert.assertAll();
    }

    @Title("OBB.Ticket & Reservation page. Check Bed in a compartment with 1 bed / Komfort-Ticket Nightjet")
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void checkBedWith1BedKomfortTicket(String dep, String arr) {
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
                "with 1 bed");
        upsalePage.continueButton.click();
        s_assert.assertFalse(isElementPresent(ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.berthLevel), "Berth level present");
        s_assert.assertFalse(isElementPresent(ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.coupeType), "CoupeType present");
        s_assert.assertFalse(isElementPresent(ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.placePosition), "PlacePosition present");
        s_assert.assertAll();
    }

    @Title("OBB.Ticket & Reservation page. Check Bed in a Deluxe with 1 beds / Komfort-Ticket Nightjet")
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "HamburgHbf_Wien", dataProviderClass = TestDataProvider.class)
    public void checkBedDeluxeWith1BedKomfortTicket(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("2000");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.clickSearchButton();
        connectionResultPage.clickToOfferSelectionBtn();
        searchOffersPage.clickContinueButton(0);
        upsalePage.selectCompartment("Komfort-Ticket Nightjet", "Bed in a Deluxe\n" +
                "compartment with 1 bed");
        upsalePage.continueButton.click();
        s_assert.assertFalse(isElementPresent(ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.berthLevel), "Berth level present");
        s_assert.assertFalse(isElementPresent(ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.coupeType), "CoupeType present");
        s_assert.assertFalse(isElementPresent(ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.placePosition), "PlacePosition present");
        s_assert.assertAll();
    }
}
