package pages.modalwindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

/**
 * Created by osinskyi on 4/7/2017.
 */
public class InformationSectionModalWindow extends BasePage {

    /**
     * Constructor
     *
     * @param driver
     */
    public InformationSectionModalWindow(WebDriver driver) {
        super(driver);
        waitForElement(driver.findElement(By.xpath(".//*[@class='modal-dialog']")));
    }

    @Override
    public void waitLoading() {

    }

    @FindBy(xpath = ".//*[@class='close']")
    public WebElement closeX;

    @FindBy(xpath = ".//*[text()='Close']")
    public WebElement closeButton;

    @FindBy(xpath = ".//*[@class='modal-header']//h4")
    public WebElement title;

    @FindBy(xpath = ".//*[@class='modal-body']/p")
    public WebElement body;
}
