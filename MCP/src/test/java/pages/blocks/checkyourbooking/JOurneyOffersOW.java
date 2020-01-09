package pages.blocks.checkyourbooking;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;


@FindBy(xpath = ".//*[@class='confirmation__offers']")
public class JOurneyOffersOW extends HtmlElement {
    @FindBy(xpath = ".//*[@class='confirmation__offers-title']")
    public WebElement journeyOffersTitle;

    @FindBy(xpath = ".//*[@class='confirmation__offer-title']")
    public WebElement journeyOfferTitle;

    @FindBy(xpath = ".//*[@class='confirmation__offer-class']")
    public WebElement journeyOfferClass;

    @FindBy(xpath = ".//*[@class='confirmation__offer-ticket']")
    public WebElement journeyOfferTicketType;

    @FindBy(xpath = ".//*[@class='confirmation__offer-column confirmation__offer-column--company']")
    public WebElement journeyOfferCompany;

    @FindBy(css = ".confirmation__offer-column--info")
    public WebElement journeyOfferColumnInfo;

    @FindBy(xpath = ".//*[@class='confirmation__offer-column confirmation__offer-column--info']")
    public WebElement journeyOfferConditions;

    @FindBy(xpath = ".//*[@class='confirmation__offer-price']")
    public WebElement journeyOfferPrice;

    @FindBy(xpath = ".//*[@class='confirmation__offers-total-text']")
    public WebElement journeyOfferTotalPriceText;

    @FindBy(xpath = ".//*[@class='confirmation__offers-total-price']")
    public WebElement journeyOfferTotalPrice;

    @FindBy(xpath = "//*[text()='Read more']")
    public WebElement journeyOfferReadMore;

    @FindBy(xpath = ".//*[@class='confirmation__bonus-points']")
    public List<WebElement> bahnBonusLoyaltypointsInscription;
}
