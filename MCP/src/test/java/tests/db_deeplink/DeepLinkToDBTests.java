package tests.db_deeplink;

import org.testng.annotations.Test;
import tests.BaseTest;
import tests.testData.TestDataProvider;

import java.util.ArrayList;

public class DeepLinkToDBTests extends BaseTest {
    @Test(groups = {"dev", "test", "demo"}, dataProvider = "BerlinHbf_HannoverHbf", dataProviderClass = TestDataProvider.class)
    public void deepLinkDetailsAssertionOW(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("0000");
        searchPage.pasCount.click();
        searchPage.selectOptionFromDropdown("3 Passengers");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.pas1SelectDiscount.click();
        searchPage.selectOptionFromDropdown("BahnCard 25, 1st class");
        searchPage.setPas2BirthDate(CHILD_BIRTH_DATE);
        searchPage.setPas3BirthDate(INFANT_BIRTH_DATE);
        searchPage.clickSearchButton(true);
        String db_link = connectionResultPage.getFirstConnection().toOfferSelection.getAttribute("href");
        s_assert.assertTrue(db_link.contains("https://reiseauskunft-tst.bahn.de/bin/query.exe/en?"), "start url");
        s_assert.assertTrue(db_link.contains("K=2&"), "class");
        s_assert.assertTrue(db_link.contains("A.1=30&RT.1=E&E.1=1&"), "pas1 data");
        s_assert.assertTrue(db_link.contains("A.2=7&RT.2=K&E.2=0&"), "pas2 data");
        s_assert.assertTrue(db_link.contains("A.3=1&RT.3=B&E.3=0&"), "pas3 data");
        s_assert.assertTrue(db_link.contains("VH=T$"), "outbound code");
        s_assert.assertTrue(db_link.contains("&SS="), "start  codes");
        s_assert.assertTrue(db_link.contains("&ZS="), "stop codes");
        s_assert.assertTrue(db_link.contains("&M=D&E=U"), "tail");
        System.out.println(db_link);
        s_assert.assertAll();
    }

    @Test(groups = {"dev", "test", "demo"}, dataProvider = "BerlinHbf_HannoverHbf", dataProviderClass = TestDataProvider.class)
    public void deepLinkDetailsAssertionRT(String dep, String arr) {
        gotoUrl(APP_URL);
        searchPage.setFrom(dep);
        searchPage.setTo(arr);
        searchPage.addDaysToOutwardDate(numberOfDaysOutward);
        searchPage.setOutwardTime("0000");
        searchPage.setPas1BirthDate(ADULT_BIRTH_DATE);
        searchPage.activateRoundTrip();
        searchPage.addDaysToInwardDate(numberOfDaysInward);
        searchPage.setInwardTime("0000");
        searchPage.class1.click();
        searchPage.clickSearchButton();
        connectionResultPage.clickToOfferSelectionBtn();
        String db_link = connectionResultPage.getFirstConnection().toOfferSelection.getAttribute("href");
        s_assert.assertTrue(db_link.contains("https://reiseauskunft-tst.bahn.de/bin/query.exe/en?"), "start url");
        s_assert.assertTrue(db_link.contains("K=1&"), "class");
        s_assert.assertTrue(db_link.contains("A.1=30&RT.1=E&E.1=0&"), "pas1 data");
        s_assert.assertTrue(db_link.contains("VH=T$"), "outbound code");
        s_assert.assertTrue(db_link.contains("&VR=T$8000152$"), "inbound code");
        s_assert.assertTrue(db_link.contains("&SS="), "start codes");
        s_assert.assertTrue(db_link.contains("&ZS="), "stop codes");
        s_assert.assertTrue(db_link.contains("&M=D&E=U"), "tail");
        System.out.println(db_link);
        connectionResultPage.getFirstConnection().toOfferSelection.click();
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        s_assert.assertTrue(driver.getCurrentUrl().contains("bahn.de"),"not opened bahn.de");
        s_assert.assertAll();
    }
}
