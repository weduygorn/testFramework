package pages.blocks.retrieve;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = ".//*[@class='retrieve__ticket']")
public class RetrieveTicket extends HtmlElement {

    @FindBy(xpath = ".//*[@class='retrieve__captions']/div[1]")
    public WebElement receiptTitle;

    @FindBy(xpath = ".//*[@class='retrieve__captions']/div[2]")
    public WebElement dateOfTravelTitle;

    @FindBy(xpath = ".//*[@class='retrieve__captions']/div[3]")
    public WebElement descriptionTitle;

    @FindBy(xpath = ".//*[@class='retrieve__captions']/div[4]")
    public WebElement receiptNumberTitle;

    @FindBy(xpath = ".//*[@class='retrieve__captions']/div[5]")
    public WebElement priceTitle;

    @FindBy(xpath = ".//*[@class='retrieve__cells']")
    public WebElement retrievedTicket;

}
