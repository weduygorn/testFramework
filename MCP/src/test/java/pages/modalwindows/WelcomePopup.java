package pages.modalwindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;

public class WelcomePopup extends BasePage {
    /**
     * Constructor
     *
     * @param driver
     */
    public WelcomePopup(WebDriver driver) {
        super(driver);

    }

    @Override
    public void waitLoading() {

    }

    @FindBy(xpath = "//*[@class='modal__content']")
    public WebElement popupContent;

    @FindBy(xpath = ".//*[@class='modal__close']")
    public WebElement closeX;

    @FindBy(xpath = ".//*[@class='first_enter_popup_text']")
    public WebElement popupText;

    @FindBy(xpath = ".//*[@class='btn btn--primary continue_booking']")
    public WebElement continueBookingButton;

    @FindBy(xpath = ".//*[@class='checkbox__icon']")
    public WebElement checkBoxDoNotShow;

    @Step
    public void close() {
        waitForElement(popupContent);
        closeX.click();
    }

}
