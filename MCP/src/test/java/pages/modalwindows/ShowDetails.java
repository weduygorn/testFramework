package pages.modalwindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

/**
 * Created by osinskyi on 5/15/2017.
 */
public class ShowDetails extends BasePage {
    /**
     * Constructor
     *
     * @param driver
     */
    public ShowDetails(WebDriver driver) {
        super(driver);
        waitForElement(driver.findElement(By.xpath("(//*[@class='modal-dialog'])[3]")));
    }

    @Override
    public void waitLoading() {

    }

    @FindBy(xpath = "(.//*[@class='close'])[3]")
    public WebElement closeX;

    @FindBy(xpath = "(//*[text()='Close'])[3]")
    public WebElement closeButton;

    @FindBy(xpath = "(//*[@class='modal-header']//h4)[3]")
    public WebElement title;

    @FindBy(xpath = "//h5")
    public WebElement date;

    @FindBy(xpath = "(//*[@class='modal-dialog'])[3]//*[@class='modal-body']")
    public WebElement body;

    @FindBy(xpath = "(//*[@class='modal-dialog'])[3]//a")
    public WebElement showHideStops;
}
