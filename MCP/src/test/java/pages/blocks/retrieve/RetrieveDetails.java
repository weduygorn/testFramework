package pages.blocks.retrieve;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = ".//*[@class='retrieve__details']")
public class RetrieveDetails extends HtmlElement {
    @FindBy(xpath = ".//*[@class='retrieve__captions']/div[1]")
    public WebElement bookingPNRtitle;

    @FindBy(xpath = ".//*[@class='retrieve__captions']/div[2]")
    public WebElement bookingDateTitle;

    @FindBy(xpath = ".//*[@class='retrieve__captions']/div[3]")
    public WebElement personMadeBookingTitle;

    @FindBy(xpath = ".//*[@class='retrieve__captions']/div[4]")
    public WebElement travellersTitle;

    @FindBy(xpath = ".//*[@class='retrieve__captions']/div[5]")
    public WebElement statusTitle;

    @FindBy(xpath = ".//*[@class='retrieve__cells']/div[1]")
    public WebElement bookingPNR;

    @FindBy(xpath = ".//*[@class='retrieve__cells']/div[2]")
    public WebElement bookingDate;

    @FindBy(xpath = ".//*[@class='retrieve__cells']/div[3]")
    public WebElement personMadeBooking;

    @FindBy(xpath = ".//*[@class='retrieve__cells']/div[4]")
    public WebElement travellers;

    @FindBy(css = ".retrieve__col--status.retrieve__col--xs-half .retrieve__col-text")
    public WebElement bookingStatus;

}
