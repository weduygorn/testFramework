package pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = ".//*[@class='steps']")
public class BreadcrumbsHeader extends HtmlElement {
    @FindBy(xpath = "//div[@class='steps__header']")
    public WebElement internationalBooking;

    @FindBy(xpath = "//div[@class='steps__list steps__list--active-1']/div[1]")
    public WebElement searchStep;

    @FindBy(xpath = "//div[@class='steps__list steps__list--active-1']/div[2]")
    public WebElement selectStep;

    @FindBy(xpath = "//div[@class='steps__list steps__list--active-1']/div[3]")
    public WebElement ticketAndReservStep;

    @FindBy(xpath = "//div[@class='steps__list steps__list--active-1']/div[4]")
    public WebElement checkBookStep;

    @FindBy(xpath = "//div[@class='steps__list steps__list--active-1']/div[5]")
    public WebElement paymentStep;

    @FindBy(xpath = "//div[@class='steps__list steps__list--active-1']/div[6]")
    public WebElement confirmationStep;
}
