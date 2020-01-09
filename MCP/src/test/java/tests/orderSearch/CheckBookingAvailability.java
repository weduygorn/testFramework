package tests.orderSearch;

import core.properties.PropertyConfig;
import org.testng.annotations.Test;
import tests.BaseTest;


public class CheckBookingAvailability extends BaseTest {

    @Test(groups = {"dev", "test", "demo"})
    public void checkOldBookingAvailability() {
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.bookingID.sendKeys(PropertyConfig.getProperty("oldBookingPNR"));
        retrievePage.email.sendKeys("oleksii.osinskyi@amadeus.com");
        retrievePage.captcha.sendKeys(CAPTCHA_CODE);
        retrievePage.searchButton.click();
        s_assert.assertTrue(driver.getCurrentUrl().contains("/result"), "URL is not consist result");
        s_assert.assertTrue(bookingDetailsPage.titleBookingDetails.getText().contains("Booking details"), "Booking details title is not exists");
        s_assert.assertTrue(bookingDetailsPage.retrieveTicket.isDisplayed(), "RetrieveTicket is not exists");
        s_assert.assertTrue(bookingDetailsPage.retrieveDetails.bookingPNR.getText().contains(PropertyConfig.getProperty("oldBookingPNR")), "Booking PNR is not correct!");
        s_assert.assertAll();
    }

}
