package pages.blocks.ticketandreservation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;


/**
 * Created by osinskyi on 4/11/2017.
 */
@FindBy(xpath = ".//*[@class='ticket-item']")
public class TicketAndReservationAccomodationsOneWay extends HtmlElement {

    ///////////outward journey//////////////
    @FindBy(xpath = "//*[@class='ticket-item__title']")
    public WebElement outwardJourney;

    ///////////////////////travel zone///////////////////////////
    @FindBy(xpath = ".//*[@class='ticket-item__subtitle']")
    public WebElement travelZone;

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
