package tests.ticketandreservation;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class TicketAndReservationOWTealiumTest extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void ticketAndReservationOneWayTealiumTest() {
        String mcpUrl = RomeMilanOWLink;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.searchOptions.passengerCount.click();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.searchOptions.discountCardsPasOne.click();
        searchOffersPage.selectOptionFromDropdown("BahnCard 25, 1st class");
        searchOffersPage.clickRefreshButton();
        searchOffersPage.waitForElement(searchOffersPage.continueButton.get(0));
        searchOffersPage.continueButton.get(0).click();
        upsalePage.continueButton.click();
        s_assert.assertTrue(ticketAndReservationPage.title.getText().equals("Ticket and reservation"), "wrong title");

        s_assert.assertTrue(digitalData.getString("pageInstanceId").equals("DEV_PARTNER_TicketOptions_EN") || digitalData.getString("pageInstanceId").equals("PROD_PARTNER_TicketOptions_EN"), "pageInstanceId");
        s_assert.assertTrue(digitalData.getString("version").equals("1.0"), "version");
        s_assert.assertTrue(digitalData.getInt("numberCarts") == 1, "numberCarts");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.pageID").equals("PARTNER_TicketOptions_EN"), "pageID");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.Portal").equals("PARTNER"), "Portal");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.anwendung").equals("IBE"), "anwendung");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.channel").equals("PARTNER_IBE_DEU_EN_MCP"), "channel");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.channelSpecific").equals("MCP"), "channelSpecific");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.pageName").equals("PARTNER_IBE_DEU_EN_MCP_TicketOptions"), "pageName");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.pageNameSpecific").equals("TicketOptions"), "pageNameSpecific");
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
        s_assert.assertTrue(digitalData.getString("suchparameter.start.name").equals("Rome Termini"), "name");
        s_assert.assertTrue(digitalData.getString("suchparameter.start.eBhf").equals("8300263"), "eBhf");
        s_assert.assertTrue(digitalData.getString("suchparameter.start.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("suchparameter.start.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.name").equals("Milan Main Station"), "name");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.eBhf").equals("8300046"), "eBhf");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getInt("suchparameter.wagenklasse") == 1, "wagenklasse");
        s_assert.assertTrue(digitalData.getString("suchparameter.rueckfahrt").equals("false"), "rueckfahrt");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisedatumHin").replaceAll("-", "").equals(currentDatePlusNDaysNotWeekend(numberOfDaysOutward)), "reisedatumHin");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisezeitHinVon").contains("06:00"), "reisezeitHinVon");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisedatumRueck").equals(""), "reisedatumRueck");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisezeitRueckVon").equals(""), "reisezeitRueckVon");
        s_assert.assertTrue(digitalData.getInt("suchparameter.anzReisende") == 1, "anzReisende");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisender[0].typ").equals("E"), "typ");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisender[0].ermaessigung").equals("BC25 1"), "ermaessigung");
        s_assert.assertTrue(digitalData.getInt("suchparameter.reisender[0].alter") == 31, "alter");
        //cart
        s_assert.assertTrue(digitalData.getString("cart.cartID").length() > 10, "cartId");
        s_assert.assertTrue(digitalData.getInt("cart.price.basePrice") > 0, "basePrice");
        s_assert.assertTrue(digitalData.getInt("cart.price.voucherDiscount") == 0, "voucherDiscount");
        s_assert.assertTrue(digitalData.getString("cart.price.currency").equals("EUR"), "currency");
        s_assert.assertTrue(digitalData.getInt("cart.price.priceWithTax") > 0, "priceWithTax");
        s_assert.assertTrue(digitalData.getInt("cart.price.cartTotal") > 0, "cartTotal");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].quantity") == 1, "quantity");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.productInfo.productId").length() >= 4, "productId");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.productInfo.productName").length() > 2, "productName");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.productInfo.productDescription").length() > 5, "productDescription");
//
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.price.basePrice") != 0, "basePrice");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.price.voucherDiscount") == 0, "voucherDiscount");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.price.currency").equals("EUR"), "currency");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.price.priceWithTax") != 0, "priceWithTax");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.price.cartTotal") == 0, "cartTotal");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.fahrkarte.klasse") == 1, "klasse");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.fahrkarte.anzPersonen") == 1, "anzPersonen");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.fahrkarte.anzErw") == 1, "anzErw");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.fahrkarte.anzK") == 0, "anzK");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.fahrkarte.anzBc50") == 0, "anzBc50");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.fahrkarte.anzBc25") == 1, "anzBc25");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].start.name").equals("Rome Termini"), "name");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].start.eBhf").equals("8300263"), "eBhf");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].start.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].start.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].ziel.name").equals("Milan Main Station"), "name");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].ziel.eBhf").equals("8300046"), "eBhf");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].ziel.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].ziel.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].abfahrt").replaceAll("-", "").contains(currentDatePlusNDaysNotWeekend(numberOfDaysOutward)), "abfahrt");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].abfahrt").contains("T06:00"), "abfahrt");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].ankunft").replaceAll("-", "").contains(currentDatePlusNDaysNotWeekend(numberOfDaysOutward)), "ankunft");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].ankunft").contains("T08:55"), "ankunft");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].richtung").contains("H"), "richtung");
        s_assert.assertTrue(digitalData.getString("cart.item[1].product.productInfo.productName").equals("Reservierung"), "productName");
        s_assert.assertTrue(digitalData.getJSON("cart.zahlung.zahlungsart").length() > 0, "zahlungsart");
        s_assert.assertTrue(digitalData.getJSON("cart.coupon").length() > 0, "coupon");
        s_assert.assertAll();
    }

}
