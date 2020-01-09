package tests.search;

import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.ArrayList;

import static helpers.DateTimeHelper.currentDatePlusNDaysNotWeekend;

public class FAQAssertions extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void frequentQuestionsTest() {
        String mcpUrl = RomeMilanOWLink;
        mcpUrl = mcpUrl.replaceAll("YYYYMMDD", currentDatePlusNDaysNotWeekend(numberOfDaysOutward));
        String tempForSecureToken = mcpUrl;
        mcpUrl = mcpUrl + secureToken(tempForSecureToken.replaceAll("/request/", ""));
        gotoUrl(APP_URL + mcpUrl);
        welcomePopup.close();
        searchOffersPage.frequentQuestionsItems.get(0).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        s_assert.assertTrue(driver.getCurrentUrl().contains("faq"), "url");
        s_assert.assertTrue(faqPage.titleFaq.getText().equals("Frequent questions"), "title");
        s_assert.assertTrue(faqPage.searchField.isDisplayed(), "search");
        s_assert.assertTrue(faqPage.topicsTitles.size() == 7, "titles size");
        s_assert.assertTrue(faqPage.topicsTitles.get(0).getText().equals("1. Searching"), "1. Searching");
        s_assert.assertTrue(faqPage.topicsTitles.get(1).getText().equals("2. Booking"), "2. Booking");
        s_assert.assertTrue(faqPage.topicsTitles.get(2).getText().equals("3. Payment"), "3. Payment");
        s_assert.assertTrue(faqPage.topicsTitles.get(3).getText().equals("4. Ticketing"), "4. Ticketing");
        s_assert.assertTrue(faqPage.topicsTitles.get(4).getText().equals("5. Aftersales"), "5. Aftersales");
        s_assert.assertTrue(faqPage.topicsTitles.get(5).getText().equals("6. General"), "6. General");
        s_assert.assertTrue(faqPage.topicsTitles.get(6).getText().equals("7. Journey"), "7. Journey");
        s_assert.assertTrue(faqPage.topicsQuestions.size() == 51, "size questions");
        s_assert.assertTrue(faqPage.topicsAnswers.size() == 52, "size answers");
        s_assert.assertTrue(faqPage.close.isDisplayed(), "close");
        s_assert.assertAll();
    }
}
