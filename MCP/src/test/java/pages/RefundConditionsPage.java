package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.blocks.retrieve.RetrieveDetails;
import pages.blocks.retrieve.RetrieveTicket;
import ru.yandex.qatools.allure.annotations.Step;

public class RefundConditionsPage extends BasePage {
    /**
     * Constructor
     *
     * @param driver
     */
    public RefundConditionsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitLoading() {

    }

    public RetrieveDetails retrieveDetails;
    public RetrieveTicket retrieveTicket;


    @FindBy(xpath = "//*[@class=\"retrieve__title\"]")
    public WebElement titleRefundConditions;

    @FindBy(xpath = "//*[@class=\"retrieve__subtitle\"]")
    public WebElement subtitleRefundConditions;

    @FindBy(xpath = "//*[text()='Back']")
    public WebElement backButton;

    @FindBy(xpath = "//*[text()='Get refund']")
    public WebElement getRefundButton;

    @FindBy(xpath = "(//*[@class=\"form__message form__message--error\"])[2]")
    public WebElement messageInBottom;

    @Step("RefundConditions: click get refund")
    public void clickGetRefundsButton() {
        waitElementVisible(getRefundButton, 20);
        getRefundButton.click();
    }
}
