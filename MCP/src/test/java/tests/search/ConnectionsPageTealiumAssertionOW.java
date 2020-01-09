package tests.search;


import org.testng.annotations.Test;
import tests.BaseTest;
import tests.testData.TestDataProvider;


public class ConnectionsPageTealiumAssertionOW extends BaseTest {

    @Test(groups = {"dev", "test", "demo"}, dataProvider = "RomaTermini_MilanoCentrale", dataProviderClass = TestDataProvider.class)
    public void connectionTealiumObjOW(String dep, String arr) {
        gotoUrl(APP_URL.replace("/en", "/mcp_dev.php/en"));
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("0000");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.clickSearchButton();
        connectionResultPage.waitForElement(connectionResultPage.connectionHeaders.stationStop);
        s_assert.assertTrue(digitalData.getString("pageInstanceId").equals("DEV_PARTNER_ConnectionResults_EN") || digitalData.getString("pageInstanceId").equals("PROD_PARTNER_ConnectionResults_EN"), "pageInstanceId");
        s_assert.assertTrue(digitalData.getString("version").equals("1.0"), "version");
        s_assert.assertTrue(digitalData.getInt("numberCarts") == 0, "numberCarts");
//        //page
        s_assert.assertTrue(digitalData.getString("page.pageInfo.pageID").equals("PARTNER_ConnectionResults_EN"), "pageID");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.Portal").equals("PARTNER"), "Portal");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.anwendung").equals("IBE"), "anwendung");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.channel").equals("PARTNER_IBE_DEU_EN_MCP"), "channel");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.channelSpecific").equals("MCP"), "channelSpecific");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.pageName").equals("PARTNER_IBE_DEU_EN_MCP_ConnectionResults"), "pageName");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.pageNameSpecific").equals("ConnectionResults"), "pageNameSpecific");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.language").equals("EN"), "language");
        s_assert.assertTrue(digitalData.getString("page.pageInfo.country").equals("DEU"), "country");
        s_assert.assertTrue(digitalData.getString("page.isError").equals("false"), "isError");
        s_assert.assertTrue(digitalData.getString("page.environment").equals("DEV") || digitalData.getString("page.environment").equals("PROD"), "environment");
//        //user
        s_assert.assertTrue(digitalData.getString("user.profile.hash").equals(""), "hash");
        s_assert.assertTrue(digitalData.getString("user.profile.nlHash").equals(""), "nlHash");
        s_assert.assertTrue(digitalData.getString("user.profile.bcStatus").equals("kein"), "bcStatus");
        s_assert.assertTrue(digitalData.getString("user.profile.anrede").equals(""), "anrede");
        s_assert.assertTrue(digitalData.getString("user.loginstatus").equals("logout"), "loginstatus");
        s_assert.assertTrue(digitalData.getString("user.kundenstatus").equals("anonym"), "kundenstatus");
        s_assert.assertTrue(digitalData.getString("user.kundentyp").equals("PK"), "kundentyp");
//        //suchparameter
        s_assert.assertTrue(digitalData.getString("suchparameter.start.name").equals("Rome Termini"), "name");
        s_assert.assertTrue(digitalData.getString("suchparameter.start.eBhf").equals("8300263"), "eBhf");
        s_assert.assertTrue(digitalData.getString("suchparameter.start.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("suchparameter.start.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.name").equals("Milan Main Station"), "name");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.eBhf").equals("8300046"), "eBhf");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("suchparameter.ziel.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getInt("suchparameter.wagenklasse") == 2, "wagenklasse");
        s_assert.assertTrue(digitalData.getString("suchparameter.rueckfahrt").equals("false"), "rueckfahrt");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisedatumHin").contains("-"), "reisedatumHin");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisezeitHinVon").contains(":"), "reisezeitHinVon");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisedatumRueck").equals(""), "reisedatumRueck");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisezeitRueckVon").equals(""), "reisezeitRueckVon");
        s_assert.assertTrue(digitalData.getInt("suchparameter.anzReisende") == 1, "anzReisende");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisender[0].typ").equals("E"), "typ");
        s_assert.assertTrue(digitalData.getString("suchparameter.reisender[0].ermaessigung").equals("ohne"), "ermaessigung");
        s_assert.assertTrue(digitalData.getInt("suchparameter.reisender[0].alter") == 31, "alter");
//        //verbindung
        s_assert.assertTrue(digitalData.getString("verbindung[0].start.name").equals("Rome Termini"), "name");
        s_assert.assertTrue(digitalData.getString("verbindung[0].start.eBhf").equals("8300263"), "eBhf");
        s_assert.assertTrue(digitalData.getString("verbindung[0].start.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("verbindung[0].start.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getString("verbindung[0].ziel.name").equals("Milan Main Station"), "name");
        s_assert.assertTrue(digitalData.getString("verbindung[0].ziel.eBhf").equals("8300046"), "eBhf");
        s_assert.assertTrue(digitalData.getString("verbindung[0].ziel.typ").equals("Haltestelle"), "typ");
        s_assert.assertTrue(digitalData.getString("verbindung[0].ziel.land").equals("ITA"), "land");
        s_assert.assertTrue(digitalData.getString("verbindung[0].abfahrt").contains("-"), "abfahrt");
        s_assert.assertTrue(digitalData.getString("verbindung[0].abfahrt").contains(":"), "abfahrt");
        s_assert.assertTrue(digitalData.getString("verbindung[0].ankunft").contains("-"), "ankunft");
        s_assert.assertTrue(digitalData.getString("verbindung[0].ankunft").contains(":"), "ankunft");
        s_assert.assertTrue(digitalData.getString("verbindung[0].richtung").contains("H"), "richtung");
        s_assert.assertAll();
    }


}
