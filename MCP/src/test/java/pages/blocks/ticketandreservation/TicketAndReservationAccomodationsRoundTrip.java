package pages.blocks.ticketandreservation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by osinskyi on 4/11/2017.
 */
@FindBy(xpath = ".//*[@class='ticket-item']")
public class TicketAndReservationAccomodationsRoundTrip extends HtmlElement {

    ///////////////////////outbound/inward tab///////////////////////////
    @FindBy(xpath = ".//*[@class='ticket-item__title']")
    public WebElement tab;

    ///////////////////////travel zone outward/inward///////////////////////////
    @FindBy(xpath = ".//*[@class='ticket-item__subtitle']")
    public WebElement travelZoneOutward;

    @FindBy(xpath = "(.//*[@class='ticket-item__subtitle'])[2]")
    public WebElement travelZoneInward;
}
