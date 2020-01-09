package pages.adm;

import core.properties.PropertyConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AdminLoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitBtn;

    /**
     * Constructor
     *
     * @param driver
     */
    public AdminLoginPage(WebDriver driver) {
        super(driver);
    }

    public AdminLoginPage open() {
        driver.get(PropertyConfig.getProperty("admin.host") + "/login");
        return new AdminLoginPage(driver);
    }

    public void logIn(String userName, String password) {
        setUserName(userName);
        setPassword(password);
        submitBtn.click();
    }

    private void setUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    private void setPassword(String password) {
        passwordField.sendKeys(password);
    }
}
