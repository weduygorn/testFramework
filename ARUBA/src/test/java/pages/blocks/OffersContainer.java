package pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@FindBy(css = ".offers")
public class OffersContainer extends HtmlElement{

    public final String depTimeCSS = ".offer-depart__time";
    public final String arrTimeCSS = ".offer-arrive__time";
    public final String changesCSS = ".offer-depart__change";
    public final String offerDurationCSS = ".offer-arrive__duration";
    public final String durationHoursCSS = ".duration-hour";
    public final String durationMinutesCSS = ".duration-minutes";
    public final String secondClassLabelCSS = ".class-second-label";
    public final String firstClassLabelCSS = ".class-first-label";
    public final String secondClassPriceLabelCSS = ".class-second-price__label";
    public final String firstClassPriceLabelCSS = ".class-first-price__label";
    public final String secondClassPriceBoxXPATH = "//*[@class='class-second-price-box']";
    public final String firstClassPriceBoxXPATH = "//*[@class='class-first-price-box']";
    public final String secondClassPriceXPATH = "//*[@class='class-second-price__price']";
    public final String firstClassPriceXPATH = "//*[@class='class-first-price__price']";
    public final String earlierButtonXPATH = "//button[@class='control-v-prev']";
    public final String laterButtonXPATH = "//button[@class='control-v-next']";
    public final String availableConnectionsListXPATH = "//div[contains(@class, 'offer')][@data-offer-id]";
    public final String offersHeadXPATH = "//div[@class='offers-head']";
    public final String offersHorizontalSlideCSS = ".offers-horizontal-slide";
    public List<WebElement> dateColumnXpath;

    @FindBy(xpath = availableConnectionsListXPATH)
    public List<WebElement> connections;

    @FindBy(xpath = "//div[@data-date]")
    public List<WebElement> dateColumn;

    @FindBy(css = ".offers-control-h-next")
    public WebElement nextDayButton;

    @FindBy(css = ".offers-control-h-prev")
    public WebElement previousDayButton;

    @FindBy(css = "div[data-type=empty_with_text]")
    public WebElement noOfferAvailableCard;

    @FindBy(xpath = earlierButtonXPATH)
    public List<WebElement> earlierButton;

    @FindBy(xpath = laterButtonXPATH)
    public List<WebElement> laterButton;

}
