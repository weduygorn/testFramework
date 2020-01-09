package pages;

import data.Passenger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tests.BaseTest;

public class RetrievePage extends BasePage {
    /**
     * Constructor
     *
     * @param driver
     */
    public RetrievePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitLoading() {

    }

    @FindBy(xpath = "//*[@class=\"retrieve__title\"]")
    public WebElement titleRetrievePage;

    @FindBy(xpath = "//*[@class=\"retrieve__subtitle\"]")
    public WebElement pleaseEnterMessage;

    @FindBy(xpath = "(//*[@class=\"form__label\"])[1]")
    public WebElement bookingIDLabel;

    @FindBy(xpath = "(//*[@class=\"form__label\"])[2]")
    public WebElement EmailLabel;

    @FindBy(xpath = "//*[@id=\"mcp_retrieve_supplierReferenceNumber\"]")
    public WebElement bookingID;

    @FindBy(xpath = "//*[@id=\"mcp_retrieve_email\"]")
    public WebElement email;

    @FindBy(xpath = "//*[@id=\"mcp_retrieve_captcha\"]")
    public WebElement captcha;

    @FindBy(xpath = "//*[@class=\"btn btn--primary\"]")
    public WebElement searchButton;

    public void retrieveBookingFillAndSubmit(String bookID) {
        bookingID.sendKeys(bookID);
        email.sendKeys(BaseTest.TEST_EMAIL);
        captcha.sendKeys(BaseTest.CAPTCHA_CODE);
        searchButton.click();
    }

    public void retrieveBookingFillAndSubmit(String bookID, Passenger passenger) {
        bookingID.sendKeys(bookID);
        email.sendKeys(passenger.getEmail());
        captcha.sendKeys(BaseTest.CAPTCHA_CODE);
        searchButton.click();
    }
}
