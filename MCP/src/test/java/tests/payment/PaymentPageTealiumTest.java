package tests.payment;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysWeekend;

public class PaymentPageTealiumTest extends BaseTest {

    @Test(priority = 1)
    public void paymentPageTealium() {
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
        ticketAndReservationPage.continueButton.click();
        passengerDetailsPage.passengersDetails.pasOneSalutation.click();
        passengerDetailsPage.selectOptionFromDropdown("Mr");
        passengerDetailsPage.passengersDetails.pasOneName.sendKeys("name");
        passengerDetailsPage.passengersDetails.pasOneSurname.sendKeys("surname");
        passengerDetailsPage.passengersDetails.pasOneEmail.sendKeys(TEST_EMAIL);
        passengerDetailsPage.passengersDetails.pasOnePhone.sendKeys(TEST_PHONE);
        passengerDetailsPage.passengersDetails.pasOneStreetNumber.sendKeys(STREET);
        passengerDetailsPage.passengersDetails.pasOnePostcodeNumber.sendKeys(POSTCODE);
        passengerDetailsPage.passengersDetails.pasOneCity.sendKeys(CITY);
        passengerDetailsPage.continueButton.click();
        checkAndBookPage.detailedInformation.checkBox.click();
        checkAndBookPage.proceedToPayment.click();
        s_assert.assertTrue(paymentPage.paymentTitle.getText().equals("Payment"));

        s_assert.assertTrue(digitalData.getString("pageInstanceId").equals("DEV_PARTNER_Payment_EN"), "pageInstanceId");
        s_assert.assertTrue(digitalData.getString("version").equals("1.0"), "version");
        s_assert.assertTrue(digitalData.getInt("numberCarts") == 1, "numberCarts");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.pageID").equals("PARTNER_Payment_EN"), "pageID");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.Portal").equals("PARTNER"), "Portal");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.anwendung").equals("IBE"), "anwendung");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.channel").equals("PARTNER_IBE_DEU_EN_MCP"), "channel");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.channelSpecific").equals("MCP"), "channelSpecific");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.pageName").equals("PARTNER_IBE_DEU_EN_MCP_Payment"), "pageName");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.pageNameSpecific").equals("Payment"), "pageNameSpecific");
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
        s_assert.assertTrue(digitalData.getString("suchparameter.start.name").equals("München Hbf"), "name");
        s_assert.assertTrue(digitalData.getString("suchparameter.start.eBhf").equals("8000261"), "eBhf");
        s_assert.assertTrue(digitalData.getString("suchparameter.start.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("suchparameter.start.land").equals("DEU"), "land");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.name").equals("Verona Porta Nuova"), "name");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.eBhf").equals("8300120"), "eBhf");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getInt("suchparameter.wagenklasse") == 2, "wagenklasse");
        s_assert.assertTrue(digitalData.getString("suchparameter.rueckfahrt").equals("false"), "rueckfahrt");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisezeitHinVon").contains("13:34"), "reisezeitHinVon");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisedatumRueck").equals(""), "reisedatumRueck");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisezeitRueckVon").equals(""), "reisezeitRueckVon");
        s_assert.assertTrue(digitalData.getInt("suchparameter.anzReisende") == 1, "anzReisende");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisender[0].typ").equals("E"), "typ");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisender[0].ermaessigung").equals("ohne"), "ermaessigung");
        s_assert.assertTrue(digitalData.getInt("suchparameter.reisender[0].alter") == 30, "alter");
        //cart
        s_assert.assertTrue(digitalData.getString("cart.cartID").length() > 10, "cartId");
        s_assert.assertTrue(digitalData.getInt("cart.price.basePrice") > 0, "basePrice");
        s_assert.assertTrue(digitalData.getInt("cart.price.voucherDiscount") == 0, "voucherDiscount");
        s_assert.assertTrue(digitalData.getString("cart.price.currency").equals("EUR"), "currency");
        s_assert.assertTrue(digitalData.getInt("cart.price.priceWithTax") > 0, "priceWithTax");
        s_assert.assertTrue(digitalData.getInt("cart.price.cartTotal") > 0, "cartTotal");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].quantity") == 1, "quantity");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.productInfo.productId").length() >= 4, "productId");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.productInfo.productName").length() >= 5, "productName");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.productInfo.productDescription").length() >= 5, "productDescription");

        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.price.basePrice") != 0, "basePrice");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.price.voucherDiscount") == 0, "voucherDiscount");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.price.currency").equals("EUR"), "currency");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.price.priceWithTax") != 0, "priceWithTax");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.price.cartTotal") == 0, "cartTotal");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.fahrkarte.klasse") == 2, "klasse");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.fahrkarte.anzPersonen") == 1, "anzPersonen");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.fahrkarte.anzErw") == 1, "anzErw");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.fahrkarte.anzK") == 0, "anzK");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.fahrkarte.anzBc50") == 0, "anzBc50");
        s_assert.assertTrue(digitalData.getInt("cart.item[0].product.fahrkarte.anzBc25") == 0, "anzBc25");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].start.name").equals("München Hbf"), "name");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].start.eBhf").equals("8000261"), "eBhf");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].start.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].start.land").equals("DEU"), "land");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].ziel.name").equals("Verona Porta Nuova"), "name");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].ziel.eBhf").equals("8300120"), "eBhf");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].ziel.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].ziel.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].abfahrt").contains("T13:34"), "abfahrt");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].ankunft").contains("T18:58"), "ankunft");
        s_assert.assertTrue(digitalData.getString("cart.item[0].product.verbindung[0].richtung").contains("H"), "richtung");
        s_assert.assertTrue(digitalData.getString("cart.item[1].product.productInfo.productName").equals("Reservierung"), "productName");
        s_assert.assertTrue(digitalData.getJSON("cart.zahlung.zahlungsart").length() > 0, "zahlungsart");
        s_assert.assertTrue(digitalData.getJSON("cart.coupon").length() > 0, "coupon");
        s_assert.assertAll();
    }

}
