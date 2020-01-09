package tests.passengerdetails;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class PassengerDetailsRTTealiumTest extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void passengerDetailsRTTestTealium() {
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
        searchOffersPage.clickContinueButton(1);
        upsalePage.continueButton.click();
        ticketAndReservationPage.returnJourneyButton.click();
        ticketAndReservationPage.continueButton.click();
        s_assert.assertTrue(passengerDetailsPage.pageTitle.getText().equals("Passenger details"), "pass details no found");

        s_assert.assertTrue(digitalData.getString("pageInstanceId").equals("DEV_PARTNER_PassengerDetails_EN"), "pageInstanceId");
        s_assert.assertTrue(digitalData.getString("version").equals("1.0"), "version");
        s_assert.assertTrue(digitalData.getInt("numberCarts") == 1, "numberCarts");

        s_assert.assertTrue(digitalData.getString("page.pageInfo.pageID").equals("PARTNER_PassengerDetails_EN"), "pageID");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.Portal").equals("PARTNER"), "Portal");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.anwendung").equals("IBE"), "anwendung");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.channel").equals("PARTNER_IBE_DEU_EN_MCP"), "channel");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.channelSpecific").equals("MCP"), "channelSpecific");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.pageName").equals("PARTNER_IBE_DEU_EN_MCP_PassengerDetails"), "pageName");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.pageNameSpecific").equals("PassengerDetails"), "pageNameSpecific");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.language").equals("EN"), "language");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.country").equals("DEU"), "country");
        s_assert.assertTrue(digitalData.getString("page.isError").equals("false"), "isError");
        s_assert.assertTrue(digitalData.getString("page.environment").equals("DEV"), "environment");
        //user

        s_assert.assertTrue(digitalData.getString("user.profile.hash").equals(""), "hash");
        s_assert.assertTrue(digitalData.getString("user.profile.nlHash").equals(""), "nlHash");
        s_assert.assertTrue(digitalData.getString("user.profile.bcStatus").equals("kein"), "bcStatus");
        s_assert.assertTrue(digitalData.getString("user.profile.anrede").equals(""), "anrede");
        s_assert.assertTrue(digitalData.getString("user.loginstatus").equals("logout"), "loginstatus");
        s_assert.assertTrue(digitalData.getString("user.kundenstatus").equals("anonym"), "kundenstatus");
        s_assert.assertTrue(digitalData.getString("user.kundentyp").equals("PK"), "kundentyp");
        //suchparameter
        s_assert.assertTrue(digitalData.getString("suchparameter.start.name").equals("Roma Termini"), "name");
        s_assert.assertTrue(digitalData.getString("suchparameter.start.eBhf").equals("8300263"), "eBhf");
        s_assert.assertTrue(digitalData.getString("suchparameter.start.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("suchparameter.start.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.name").equals("Milano Centrale"), "name");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.eBhf").equals("8300046"), "eBhf");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getInt("suchparameter.wagenklasse") > 0, "wagenklasse");
        s_assert.assertTrue(digitalData.getString("suchparameter.rueckfahrt").equals("true"), "rueckfahrt");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisedatumHin").replaceAll("-", "").equals(currentDatePlusNDaysNotWeekend(numberOfDaysOutward)), "reisedatumHin");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisezeitHinVon").contains("06:00"), "reisezeitHinVon");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisedatumRueck").length() > 4, "reisedatumRueck");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisezeitRueckVon").length() > 4, "reisezeitRueckVon");
        s_assert.assertTrue(digitalData.getInt("suchparameter.anzReisende") == 1, "anzReisende");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisender[0].typ").equals("E"), "typ");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisender[0].ermaessigung").equals("ohne"), "ermaessigung");
        s_assert.assertTrue(digitalData.getInt("suchparameter.reisender[0].alter") == 30, "alter");
        s_assert.assertAll();
    }
}


