package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.blocks.payPalSteps.ConfirmStep;
import pages.blocks.payPalSteps.LoginStep;
import pages.blocks.payPalSteps.WayToPayStep;
import ru.yandex.qatools.allure.annotations.Step;

public class PayPalPage extends BasePage {

    LoginStep loginStep;
    WayToPayStep wayToPayStep;
    ConfirmStep confirmStep;

    @FindBy(css = "div[id=preloaderSpinner]")
    public WebElement preLoaderSpinner;

    @FindBy(css = ".spinner")
    public WebElement spinner;


    /**
     * Constructor
     *
     * @param driver
     */
    public PayPalPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitLoading() {

    }

    @Step
    public void loginAndPay(String email, String password) {
        waitForElement(loginStep.emailField);
        loginStep.emailField.sendKeys(email);
        loginStep.nextButton.click(); //TODO sometimes separate steps required.
        waitForElement(loginStep.passwordField);
        loginStep.passwordField.sendKeys(password);
        loginStep.loginButton.click();
        waitForElement(wayToPayStep.continueButton);
        waitElementDisable(preLoaderSpinner, 30);
        wayToPayStep.continueButton.click();
        waitForElement(confirmStep.continueButton);
        waitElementDisable(spinner, 30);
        confirmStep.continueButton.click();
    }


}
