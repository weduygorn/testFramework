package pages.blocks.search;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = ".//*[@class='offers-search__captions']")
public class ConnectionHeaders extends HtmlElement {
    @FindBy(xpath = "//*[@class='offers__caption offers__size--station']")
    public WebElement stationStop;

    @FindBy(xpath = ".//*[@class='offers__caption offers__caption--sort offers__size--time']")
    public WebElement time;

    @FindBy(xpath = ".//*[@class='offers__caption offers__caption--sort offers__size--duration']")
    public WebElement duration;

    @FindBy(xpath = ".//*[@class='offers__caption offers__caption--sort offers__size--chg']")
    public WebElement changes;

    @FindBy(xpath = ".//*[@class='offers__caption offers__size--products']")
    public WebElement products;

    @FindBy(xpath = ".//*[@class='offers__caption offers__caption--sort offers__size--savings']")
    public WebElement savingFares;

    @FindBy(xpath = ".//*[@class='offers__caption offers__caption--sort offers__size--flexpreis']")
    public WebElement flexpreis;
}
