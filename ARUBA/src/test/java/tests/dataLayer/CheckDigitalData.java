package tests.dataLayer;

import core.properties.PropertyConfig;
import helpers.AllureAssert;
import helpers.Logging;
import org.testng.annotations.Test;
import testData.TestDataProvider;
import tests.BaseTest;

import static pages.BasePage.attachText;

public class CheckDigitalData extends BaseTest implements Logging {

    @Test(dataProvider = "searchByDeparture", dataProviderClass = TestDataProvider.class)
    public void checkProductExists(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        attachText("digitalData.product", digitalData.get("product"));
        AllureAssert.assertNotNull(digitalData.get("product"));

    }

    @Test(dataProvider = "searchByDeparture", dataProviderClass = TestDataProvider.class)
    public void checkPageCategories(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        attachText("digitalData.page.category", digitalData.getMap("page.category"));
        softAssert.assertEquals(digitalData.get("page.category.primaryCategory"), "Shop");
        softAssert.assertEquals(digitalData.get("page.category.subCategory1"), "Sparpreissuche");
        softAssert.assertEquals(digitalData.get("page.category.subCategory2"), "");
        softAssert.assertEquals(digitalData.get("page.category.subCategory3"), "");
        softAssert.assertEquals(digitalData.get("page.category.subCategory4"), "");
        softAssert.assertAll();
    }

    @Test(dataProvider = "searchByDeparture", dataProviderClass = TestDataProvider.class)
    public void checkPageInstanceId(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        attachText("digitalData", digitalData.get("pageInstanceId"));
        AllureAssert.assertEquals(digitalData.get("pageInstanceId"), "571882");
    }

    @Test(dataProvider = "searchByDeparture", dataProviderClass = TestDataProvider.class)
    public void checkPageInfo(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        attachText("digitalData.page.pageInfo", digitalData.getMap("page.pageInfo"));
        softAssert.assertEquals(digitalData.get("page.pageInfo.breadCrumbs"), "");
        softAssert.assertEquals(digitalData.get("page.pageInfo.destinationURI"), "/kgp");
        softAssert.assertTrue(digitalData.get("page.pageInfo.destinationURL").contains(PropertyConfig.getProperty("cfd.host")));
        softAssert.assertEquals(digitalData.get("page.pageInfo.language"), "en");
        softAssert.assertTrue(digitalData.get("page.pageInfo.pageID").contains(PropertyConfig.getProperty("cfd.host")));
        softAssert.assertEquals(digitalData.get("page.pageInfo.pageName"), "Saving offers search | SBB");
        softAssert.assertNotNull(digitalData.get("page.pageInfo.referringURL"));
        softAssert.assertEquals(digitalData.get("page.pageInfo.sysEnv"), "desktop");
        softAssert.assertAll();
    }

    @Test(dataProvider = "searchByDeparture", dataProviderClass = TestDataProvider.class)
    public void checkResultsEvent(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        attachText("digitalData.event", digitalData.getJSON("event"));
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"eventName\":\"Results\""), "Event Results in eventName not exists");
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"type\":\"Initial\""), "Event Initial in type not exists");
        softAssert.assertAll();
    }

    @Test(dataProvider = "searchByDeparture", dataProviderClass = TestDataProvider.class)
    public void checkPrevDayButtonEvent(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        cfdPage.clickPrevDateButton();
        attachText("digitalData.event", digitalData.getJSON("event"));
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"eventName\":\"Button\""), "Event Button in eventName not exists");
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"subCategory1\":\"Previous day\""), "Event Previous day in subCategory1 not exists");
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"primaryCategory\":\"Horizontal Slider\""), "Event Horizontal Slider in primaryCategory is not exists");
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"type\":\"Reload\""), "Event Reload in type not exists");
        softAssert.assertAll();
    }

    @Test(dataProvider = "searchByDeparture", dataProviderClass = TestDataProvider.class)
    public void checkNextDayButtonEvent(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        cfdPage.clickNextDateButton();
        attachText("digitalData.event", digitalData.getJSON("event"));
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"eventName\":\"Button\""), "Event Button in eventName not exists");
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"subCategory1\":\"Next day\""), "Event Next day in subCategory1 not exists");
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"primaryCategory\":\"Horizontal Slider\""), "Event Horizontal Slider in primaryCategory is not exists");
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"type\":\"Reload\""), "Event Reload in type not exists");
        softAssert.assertAll();
    }

    @Test(dataProvider = "searchByDeparture", dataProviderClass = TestDataProvider.class)
    public void checkEarlyButtonEvent(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        cfdPage.clickEarlierButton(0);
        attachText("digitalData.event", digitalData.getJSON("event"));
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"eventName\":\"Button\""), "Event Button in eventName not exists");
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"subCategory1\":\"Earlier\""), "Event Earlier in subCategory1 not exists");
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"primaryCategory\":\"Vertical Slider\""), "Event Horizontal Slider in primaryCategory is not exists");
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"type\":\"Reload\""), "Event Reload in type not exists");
        softAssert.assertAll();
    }

    @Test(dataProvider = "searchByDeparture", dataProviderClass = TestDataProvider.class)
    public void checkLaterButtonEvent(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {
        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        cfdPage.clickLaterButton(0);
        attachText("digitalData.event", digitalData.get("event"));
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"eventName\":\"Button\""), "Event Button in eventName not exists");
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"subCategory1\":\"Later\""), "Event Later in subCategory1 not exists");
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"primaryCategory\":\"Vertical Slider\""), "Event Horizontal Slider in primaryCategory is not exists");
        softAssert.assertTrue(digitalData.getJSON("event").contains("\"type\":\"Reload\""), "Event Reload in type not exists");
        softAssert.assertAll();
    }
}