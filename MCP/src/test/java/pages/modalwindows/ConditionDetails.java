package pages.modalwindows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import ru.yandex.qatools.allure.annotations.Step;


public class ConditionDetails extends BasePage {

    @FindBy(xpath = "//*[@class='modal active']")
    public WebElement popUp;

    @FindBy(xpath = ".//*[@class='modal__close']")
    public WebElement closeX;

    @FindBy(xpath = ".//*[@class='modal__footer']")
    public WebElement footer;

    @FindBy(xpath = "//*[@class='modal__content']")
    public WebElement body;

    /**
     * Constructor
     *
     * @param driver
     */
    public ConditionDetails(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitLoading() {

    }

    public String getBody() {
        return body.getText();
    }

    public String getFooter() {
        return footer.getText();
    }

    @Step
    public void clickX() {
        closeX.click();
    }
}
