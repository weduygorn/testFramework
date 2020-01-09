package tests.search;

import org.testng.annotations.Test;
import tests.BaseTest;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class TopHeaderTest extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void topHeaderTest() {
        String mcpUrl = RomeMilanOWLink;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        s_assert.assertTrue(searchOffersPage.topHeader.headerLogo.getAttribute("href").equals("https://www.bahn.de/en/view/index.shtml"), "assert logo link");
        s_assert.assertTrue(searchOffersPage.topHeader.home.getText().equals("Home"), "Home text not found");
        s_assert.assertTrue(searchOffersPage.topHeader.home.getAttribute("href").equals("https://www.bahn.de/en/view/index.shtml"), "assert home link");
        //lang
        s_assert.assertTrue(searchOffersPage.topHeader.dropdownMenuLanguage.getText().equals("English"), "English not found");
        searchOffersPage.topHeader.dropdownMenuLanguage.click();
//        searchOffersPage.topHeader.languageInMenu.click();
//        s_assert.assertTrue(driver.getPageSource().contains("Reiseinformationen"));
//        s_assert.assertTrue(driver.getPageSource().contains("Startseite"));
        s_assert.assertTrue(searchOffersPage.topHeader.headerFont_small.getText().equals("A"), "small A");
        s_assert.assertTrue(searchOffersPage.topHeader.headerFont_medium.getText().equals("A"), "medium A");
        s_assert.assertTrue(searchOffersPage.topHeader.headerFont_large.getText().equals("A"), "large A");
        searchOffersPage.topHeader.searchField.sendKeys("train");
        String currentPage = driver.getCurrentUrl();
        searchOffersPage.topHeader.searchIcon.click();
        s_assert.assertTrue(driver.getCurrentUrl().contains("https://www.bahn.de/q?q=train&l=de"));
        driver.navigate().back();
        s_assert.assertTrue(driver.getCurrentUrl().equals(currentPage), "do not navigate back");
    }
}
