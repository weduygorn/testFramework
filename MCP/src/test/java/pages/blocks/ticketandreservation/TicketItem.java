package pages.blocks.ticketandreservation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@FindBy(xpath = "//div[@class='ticket-item']")
public class TicketItem extends HtmlElement {


    public final By ticketTitleBy = By.xpath("//*[@class='ticket-item__title']");
    public final By travelZoneBy = By.xpath(".//*[@class='ticket-item__subtitle']");
    public final By reservationTitleBy = By.xpath(".//*[@class='ticket-item__reserve-title']");
    public final By reservationInfoBy = By.xpath(".//*[@class='ticket-item__reserve-text']");
    public final By reservedTravellersTitleBy = By.xpath(".//*[@class='ticket-item__type-content-title']");
    public final By textWarningBy = By.xpath(".//*[@class='ticket-item__text-warning']");


    ///////////////////////prices///////////////////////////
    @FindBy(xpath = ".//*[@class='price_amount']")
    public List<WebElement> prices;

    ///////////////////////check boxes///////////////////////////
    @FindBy(css = "input[type=checkbox]")
    public List<WebElement> checkBoxes;

    @FindBy(css = ".checkbox__icon")
    public List<WebElement> checkBoxIcon;

    @FindBy(css = ".ticket-item__reserve-text")
    public List<WebElement> reservationText;

    @FindBy(css = ".ticket-item__option--placeZone")
    public WebElement placeZone;

    @FindBy(css = ".ticket-item__option--placeZone .radio")
    public List<WebElement> placeZoneRadio;

    @FindBy(css = ".ticket-item__option--genderCoupeType")
    public WebElement coupeType;

    @FindBy(css = ".ticket-item__option--genderCoupeType .radio")
    public List<WebElement> coupeTypesRadio;

    @FindBy(css = ".ticket-item__option--berthLevel")
    public WebElement berthLevel;

    @FindBy(css = ".ticket-item__option--berthLevel .radio")
    public List<WebElement> berthLevelRadio;

    @FindBy(css = ".ticket-item__option--placePosition")
    public WebElement placePosition;

    @FindBy(css = ".ticket-item__option--placePosition .radio")
    public List<WebElement> placePositionRadio;


}
