package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.blocks.retrieve.RetrieveDetails;
import pages.blocks.retrieve.RetrieveTicket;
import ru.yandex.qatools.allure.annotations.Step;

public class BookingDetailsPage extends BasePage {
    /**
     * Constructor
     *
     * @param driver
     */
    public BookingDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitLoading() {

    }

    public RetrieveDetails retrieveDetails;
    public RetrieveTicket retrieveTicket;


    @FindBy(xpath = "//*[@class=\"retrieve__title\"]")
    public WebElement titleBookingDetails;

    @FindBy(xpath = "//*[@class=\"retrieve__subtitle\"]")
    public WebElement subtitleBookingDetails;

    @FindBy(xpath = "//*[text()='Back']")
    public WebElement backButton;

    @FindBy(xpath = "//*[text()='Cancel ticket']")
    public WebElement getRefundConditionsButton;

    @FindBy(css = ".retrieve__total-price .price_amount")
    public WebElement totalRefundAmount;

    @Step("BookingDetails: click get refund conditions")
    public void clickGetRefundConditionsButton() {
        waitElementVisible(getRefundConditionsButton, 30);
        getRefundConditionsButton.click();
    }

    public double getTotalRefundAmount() {
        return Double.parseDouble(totalRefundAmount.getText());
    }

}
