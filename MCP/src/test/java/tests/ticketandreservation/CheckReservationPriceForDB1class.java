package tests.ticketandreservation;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysWeekend;

public class CheckReservationPriceForDB1class extends BaseTest {
    @Test(groups = {"dev", "test"})
    public void checkLogicForReservationPrice2Class1Adult() {
        String mcpUrl = MunichVerona;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(0));
        searchOffersPage.continueButton.get(0).click();
        upsalePage.continueButton.click();
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.prices.get(0).getText().contains("4,50"), "assert1");
        s_assert.assertAll();
    }

    @Test(groups = {"dev", "test"})
    public void checkLogicForReservationPrice1Class1Adult() {
        String mcpUrl = MunichVerona;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(0));
        searchOffersPage.continueButton.get(2).click();
        upsalePage.continueButton.click();
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.prices.get(0).getText().contains("0,00"), "assert2");
        s_assert.assertAll();
    }

    @Test(groups = {"dev", "test"})
    public void checkLogicForReservationPrice2Class1Adult1Child() {
        String mcpUrl = MunichVerona;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.searchOptions.passengerCount.click();
        searchOffersPage.selectOptionFromDropdown("2 Passengers");
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.setPasTwoBirthDate(CHILD_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(0));
        searchOffersPage.continueButton.get(0).click();
        upsalePage.continueButton.click();
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.prices.get(0).getText().contains("9,00"), "assert3");
        s_assert.assertAll();
    }

    @Test(groups = {"dev", "test"})
    public void checkLogicForReservationPrice1Class1Adult1Child() {
        String mcpUrl = MunichVerona;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.searchOptions.passengerCount.click();
        searchOffersPage.selectOptionFromDropdown("2 Passengers");
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.setPasTwoBirthDate(CHILD_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(0));
        searchOffersPage.continueButton.get(2).click();
        upsalePage.continueButton.click();
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.prices.get(0).getText().contains("5,90"), "assert4");
        s_assert.assertAll();
    }

    @Test(groups = {"dev", "test"})
    public void checkLogicForReservationPrice1Class2Adult3Child() {
        String mcpUrl = MunichVerona;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.searchOptions.passengerCount.click();
        searchOffersPage.selectOptionFromDropdown("5 Passengers");
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.setPasThreeBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.setPasTwoBirthDate(CHILD_BIRTH_DATE);
        searchOffersPage.setPasFourBirthDate(CHILD_BIRTH_DATE);
        searchOffersPage.setPasFiveBirthDate(CHILD_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(0));
        searchOffersPage.continueButton.get(2).click();
        upsalePage.continueButton.click();
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.prices.get(0).getText().contains("17,70"), "assert4");
        s_assert.assertAll();
    }

    @Test(groups = {"demo"})
    public void checkLogicForReservationPrice1Class1AdultDemo() {
        String mcpUrl = MunichVerona;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(0));
        searchOffersPage.continueButton.get(1).click();
        upsalePage.continueButton.click();
        s_assert.assertEquals(ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.prices.get(0).getText(), "4,50", "Price was not as expected!");
        s_assert.assertAll();
    }

    @Test(groups = {"demo"})
    public void checkLogicForReservationPrice1Class1Adult1ChildDemo() {
        String mcpUrl = MunichVerona;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.searchOptions.passengerCount.click();
        searchOffersPage.selectOptionFromDropdown("2 Passengers");
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.setPasTwoBirthDate(CHILD_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(0));
        searchOffersPage.continueButton.get(1).click();
        upsalePage.continueButton.click();
        s_assert.assertEquals(ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.prices.get(0).getText(), "9,00", "Price was not as expected!");
        s_assert.assertAll();
    }

    @Test(groups = {"demo"})
    public void checkLogicForReservationPrice1Class2Adult3ChildDemo() {
        String mcpUrl = MunichVerona;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.searchOptions.passengerCount.click();
        searchOffersPage.selectOptionFromDropdown("5 Passengers");
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.setPasThreeBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.setPasTwoBirthDate(CHILD_BIRTH_DATE);
        searchOffersPage.setPasFourBirthDate(CHILD_BIRTH_DATE);
        searchOffersPage.setPasFiveBirthDate(CHILD_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(0));
        searchOffersPage.continueButton.get(1).click();
        upsalePage.continueButton.click();
        s_assert.assertEquals(ticketAndReservationPage.ticketAndReservationAccomodationsOneWay.prices.get(0).getText(), "9,00", "Price was not as expected!");
        s_assert.assertAll();
    }
}
