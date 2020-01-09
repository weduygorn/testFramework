package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.blocks.LoadingContainer;

public class TicketShopPage extends BasePage {

    LoadingContainer loadingContainer;

    @FindBy(css = ".shopContent")
    public WebElement shopContent;

    /**
     * Constructor
     *
     * @param driver
     */
    public TicketShopPage(WebDriver driver) {
        super(driver);
    }

    public void clickBrowserBackToCFD() {
        navigateBack();
        waitForElementInvisible(By.cssSelector(loadingContainer.GLOBAL_LOADING_ANIM_CSS), 60);
    }
}
