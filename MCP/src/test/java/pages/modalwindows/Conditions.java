package pages.modalwindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

/**
 * Created by osinskyi on 5/16/2017.
 */
public class Conditions extends BasePage {
    /**
     * Constructor
     *
     * @param driver
     */
    public Conditions(WebDriver driver) {
        super(driver);
        waitForElement(driver.findElement(By.xpath("//*[@class='modal active']")));
    }

    @Override
    public void waitLoading() {

    }

    @FindBy(xpath = ".//*[@class='modal__close']")
    public WebElement closeX;

    @FindBy(xpath = ".//*[@class='modal__footer']")
    public WebElement footer;

    @FindBy(xpath = "//*[@class='modal__content']")
    public WebElement body;
}
