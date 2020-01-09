package tests.search;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class SelectOffersPageTealiumAssertionOW extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void tealiumSelectOffersRomeMilanOW() {
        String mcpUrl = RomeMilanOWLink;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.searchOptions.discountCardsPasOne.click();
        searchOffersPage.selectOptionFromDropdown("BahnCard 25, 1st class");
        searchOffersPage.searchOptions.passengerCount.click();
        searchOffersPage.selectOptionFromDropdown("2 Passengers");
        searchOffersPage.setPasTwoBirthDate(CHILD_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(0));
        /////////tealium for OW analyzing///////
        s_assert.assertTrue(digitalData.getString("pageInstanceId").equals("DEV_PARTNER_SelectOffers_EN") || digitalData.getString("pageInstanceId").equals("PROD_PARTNER_SelectOffers_EN"), "pageInstanceId");
        s_assert.assertTrue(digitalData.getString("version").equals("1.0"), "version");
        s_assert.assertTrue(digitalData.getInt("numberCarts") == 0, "numberCarts");
        //page
        s_assert.assertTrue(digitalData.getString("page.pageInfo.pageID").equals("PARTNER_SelectOffers_EN"), "pageID");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.Portal").equals("PARTNER"), "Portal");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.anwendung").equals("IBE"), "anwendung");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.channel").equals("PARTNER_IBE_DEU_EN_MCP"), "channel");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.channelSpecific").equals("MCP"), "channelSpecific");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.pageName").equals("PARTNER_IBE_DEU_EN_MCP_SelectOffers"), "pageName");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.pageNameSpecific").equals("SelectOffers"), "pageNameSpecific");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.language").equals("EN"), "language");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.country").equals("DEU"), "country");
        s_assert.assertTrue(digitalData.getString("page.isError").equals("false"), "isError");
        s_assert.assertTrue(digitalData.getString("page.environment").equals("DEV") || digitalData.getString("page.environment").equals("PROD"), "environment");
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
        s_assert.assertTrue(digitalData.getInt("suchparameter.wagenklasse") == 1, "wagenklasse");
        s_assert.assertTrue(digitalData.getString("suchparameter.rueckfahrt").equals("false"), "rueckfahrt");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisedatumHin").replaceAll("-", "").equals(currentDatePlusNDaysNotWeekend(numberOfDaysOutward)), "reisedatumHin");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisezeitHinVon").equals("06:00"), "reisezeitHinVon");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisedatumRueck").equals(""), "reisedatumRueck");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisezeitRueckVon").equals(""), "reisezeitRueckVon");
        s_assert.assertTrue(digitalData.getInt("suchparameter.anzReisende") == 2, "anzReisende");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisender[0].typ").equals("E"), "typ");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisender[0].ermaessigung").equals("BC25 1"), "ermaessigung");
        s_assert.assertTrue(digitalData.getInt("suchparameter.reisender[0].alter") == 30, "alter");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisender[1].typ").equals("K"), "typ");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisender[1].ermaessigung").equals("ohne"), "ermaessigung");
        s_assert.assertTrue(digitalData.getInt("suchparameter.reisender[1].alter") == 7, "alter");
        //verbindung
        s_assert.assertTrue(digitalData.getString("verbindung[0].start.name").equals("Roma Termini"), "name");
        s_assert.assertTrue(digitalData.getString("verbindung[0].start.eBhf").equals("8300263"), "eBhf");
        s_assert.assertTrue(digitalData.getString("verbindung[0].start.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("verbindung[0].start.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getString("verbindung[0].ziel.name").equals("Milano Centrale"), "name");
        s_assert.assertTrue(digitalData.getString("verbindung[0].ziel.eBhf").equals("8300046"), "eBhf");
        s_assert.assertTrue(digitalData.getString("verbindung[0].ziel.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("verbindung[0].ziel.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getString("verbindung[0].abfahrt").replaceAll("-", "").contains(currentDatePlusNDaysNotWeekend(numberOfDaysOutward)), "verbindung[0].abfahrt");
        s_assert.assertTrue(digitalData.getString("verbindung[0].abfahrt").replaceAll("-", "").contains("T06:00"), "verbindung[0].abfahrt");
        s_assert.assertTrue(digitalData.getString("verbindung[0].ankunft").replaceAll("-", "").contains(currentDatePlusNDaysNotWeekend(numberOfDaysOutward)), "verbindung[0].ankunft");
        s_assert.assertTrue(digitalData.getString("verbindung[0].ankunft").replaceAll("-", "").contains("T08:55"), "verbindung[0].ankunft");
        s_assert.assertTrue(digitalData.getString("verbindung[0].richtung").equals("H"), "richtung1");
        //product
        s_assert.assertTrue(digitalData.getString("product[0].productInfo.productId").contains(""), "productId");
        s_assert.assertTrue(digitalData.getString("product[0].productInfo.productName").contains(""), "productName");
        s_assert.assertTrue(digitalData.getString("product[0].productInfo.productDescription").contains("Einfache Fahrt; 2 Passagiere; 1 Klasse; Roma Termini - Milano Centrale"), "productDescription");
        s_assert.assertTrue(digitalData.getInt("product[0].price.basePrice") != 0, "basePrice");
        s_assert.assertTrue(digitalData.getInt("product[0].price.voucherDiscount") == 0, "voucherDiscount");
        s_assert.assertTrue(digitalData.getString("product[0].price.currency").equals("EUR"), "currency");
        s_assert.assertTrue(digitalData.getInt("product[0].price.priceWithTax") != 0, "priceWithTax");
        s_assert.assertTrue(digitalData.getInt("product[0].price.cartTotal") == 0, "cartTotal");
        s_assert.assertTrue(digitalData.getInt("product[0].fahrkarte.klasse") == 1, "klasse");
        s_assert.assertTrue(digitalData.getInt("product[0].fahrkarte.anzPersonen") == 2, "anzPersonen");
        s_assert.assertTrue(digitalData.getInt("product[0].fahrkarte.anzErw") == 1, "anzErw");
        s_assert.assertTrue(digitalData.getInt("product[0].fahrkarte.anzK") == 1, "anzK");
        s_assert.assertTrue(digitalData.getInt("product[0].fahrkarte.anzBc50") == 0, "anzBc50");
        s_assert.assertTrue(digitalData.getInt("product[0].fahrkarte.anzBc25") == 1, "anzBc25");
        s_assert.assertTrue(digitalData.getString("product[0].verbindung[0].start.name").equals("Roma Termini"), "name");
        s_assert.assertTrue(digitalData.getString("product[0].verbindung[0].start.eBhf").equals("8300263"), "eBhf");
        s_assert.assertTrue(digitalData.getString("product[0].verbindung[0].start.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("product[0].verbindung[0].start.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getString("product[0].verbindung[0].ziel.name").equals("Milano Centrale"), "name");
        s_assert.assertTrue(digitalData.getString("product[0].verbindung[0].ziel.eBhf").equals("8300046"), "eBhf");
        s_assert.assertTrue(digitalData.getString("product[0].verbindung[0].ziel.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("product[0].verbindung[0].ziel.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getString("product[0].verbindung[0].abfahrt").replaceAll("-", "").contains(currentDatePlusNDaysNotWeekend(numberOfDaysOutward)), "abfahrt");
        s_assert.assertTrue(digitalData.getString("product[0].verbindung[0].abfahrt").contains("T06:00"), "abfahrt");
        s_assert.assertTrue(digitalData.getString("product[0].verbindung[0].ankunft").replaceAll("-", "").contains(currentDatePlusNDaysNotWeekend(numberOfDaysOutward)), "ankunft");
        s_assert.assertTrue(digitalData.getString("product[0].verbindung[0].ankunft").contains("T08:55"), "ankunft");
        s_assert.assertTrue(digitalData.getString("product[0].verbindung[0].richtung").contains("H"), "richtung");
        //s_assert.assertTrue(obj.getJSONArray("product").getJSONObject(1).getJSONArray("verbindung").getJSONObject(0).getJSONObject("start").getString("name").equals("Roma Termini"),"name");
        s_assert.assertAll();
    }
}
