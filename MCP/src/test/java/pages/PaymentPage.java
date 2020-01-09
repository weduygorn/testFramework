package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.Select;
import tests.BaseTest;

public class PaymentPage extends BasePage {

    /**
     * Constructor
     *
     * @param driver
     */
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@value='creditcard']")
    public WebElement creditCardRadio;

    @FindBy(xpath = "//input[@value='amop0']")
    public WebElement payPalRadio;

    @FindBy(xpath = "//*[@class=\"h2 _top-20 _padding-sm\"]")
    public WebElement paymentTitle;

    @FindBy(xpath = "//*[@id='vendor_']")
    public Select cardType;

    @FindBy(xpath = "//*[@id='pan']")
    public WebElement cardNumber;

    @FindBy(xpath = "//*[@id='creditcard_holdername']")
    public WebElement cardHolderName;

    @FindBy(xpath = "//*[@ng-model='uidata.mops[mopid].expmonth']")
    public Select monthExp;

    @FindBy(xpath = "//*[@ng-model='uidata.mops[mopid].expyear']")
    public Select yearExp;

    @FindBy(xpath = "//*[@id='creditcard_cvv']")
    public WebElement cardVerificationNumber;

    @FindBy(xpath = "//*[@class='forward-button button col-xs-offset-2 col-xs-5 colored-primary-bck colored-defaultcontrast colored-primaryalt-hov']")
    public WebElement buyNow;

    @FindBy(xpath = "//*[@id='userInput1_password']")
    public WebElement passCodde;

    @FindBy(xpath = "//*[@type='button']")
    public WebElement doAuth;

    @FindBy(xpath = "//*[@id='backToMerchant']")
    public WebElement backToMerch;

    @FindBy(xpath = "//*[@value='amop0']")
    public WebElement toPayPal;

    @FindBy(xpath = ".//*[@class='span11 alignRight baslLoginButtonContainer']/a")
    public WebElement connexion;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement email;

    public By formWithFailedBookingID = By.xpath(".//div[@class='form']");

    public By paymentWaitInscription = By.xpath(".//div[@class='payment_confirmation_text']");

    @Override
    public void waitLoading() {
        try {
            waitUntilElementVisible(defaultSpinner, 20);
            waitUntilElementNotVisible(defaultSpinner, 360);
        } catch (TimeoutException e) {
            Assert.fail("Payment timeout, after 360 seconds...", e);
        }
    }

    @Step("Payment: select payment type {0}")
    public void selectPaymentType(String paymentType) {
        driver.switchTo().frame(0);
        switch (paymentType) {
            case "CreditCard":
                creditCardRadio.click();
                break;
            case "PayPal":
                payPalRadio.click();
                buyNow.click();
                driver.switchTo().defaultContent();
                break;
            default:
                throw new AssertionError("unsupported payment type " + paymentType);
        }
    }

    @Step("Payment: set payment data")
    public void fillPayDataAndBuyByCreditCard() {
        cardNumber.sendKeys(BaseTest.CARD_NUMBER);
        cardHolderName.sendKeys(BaseTest.CARD_HOLDER_NAME);
        monthExp.selectByVisibleText(BaseTest.MONTH_EXP);
        yearExp.selectByVisibleText(BaseTest.YEAR_EXP);
        cardVerificationNumber.sendKeys(BaseTest.CARD_VERIFICATION_NUMBER);
        Actions actions = new Actions(driver);
        waitForElement(buyNow);
        actions.moveToElement(buyNow).click().build().perform();
        passCodde.sendKeys("123");
        doAuth.click();
        waitForElement(backToMerch);
        backToMerch.click();
        driver.switchTo().defaultContent();
        waitLoading();
    }

    public String getFailedPaymentId() {
        return StringUtils.substringBetween(driver.findElement(formWithFailedBookingID).getText(),
                "You have paid for booking ID ", ".");

    }

    public String getFailedTicketingId() {
        return StringUtils.substringBetween(driver.findElement(formWithFailedBookingID).getText(),
                "You tried to pay for booking ID ", ".");
    }

    @Step("Payment: get bookingID if payment or ticketing is failed")
    public String getFailedPaymentBookingId() {
        if (isElementVisible(formWithFailedBookingID)) {
            if (getFailedPaymentId() != null) {
                System.out.println("Payment failed");
                return getFailedPaymentId();
            } else {
                System.out.println("Ticketing failed");
                return getFailedTicketingId();
            }
        } else {
            return null;
        }
    }
}
