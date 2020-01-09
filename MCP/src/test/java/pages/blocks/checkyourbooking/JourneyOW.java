package pages.blocks.checkyourbooking;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@FindBy(xpath = ".//*[@class='confirmation__journeys']")
public class JourneyOW extends HtmlElement {
    @FindBy(xpath = ".//*[@class='confirmation__journey-title']")
    public WebElement journeyTitle;

    @FindBy(xpath = ".//*[@class='confirmation__journey-column confirmation__journey-column--stantion']")
    public WebElement journeyStations;

    @FindBy(xpath = ".//*[@class='confirmation__journey-column confirmation__journey-column--date']")
    public WebElement journeyDate;

    @FindBy(xpath = ".//*[@class='confirmation__journey-column confirmation__journey-column--time']")
    public WebElement journeyTime;

    @FindBy(xpath = ".//*[@class='confirmation__journey-column confirmation__journey-column--type']")
    public WebElement journeyTrain;

    @FindBy(xpath = ".//*[@class='confirmation__journey-column confirmation__journey-column--reserve']")
    public WebElement journeyReserve;


}
