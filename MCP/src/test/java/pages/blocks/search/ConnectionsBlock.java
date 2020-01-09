package pages.blocks.search;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static helpers.CurrencyHelper.toDouble;


@FindBy(xpath = "//div[@class='offers-search__item']")
public class ConnectionsBlock extends HtmlElement {
    SavingFareBlock savingFareBlock;
    FlexPriceBlock flexPriceBlock;

    @FindBy(xpath = ".//div[@class='offers-search__col offers__size--station']")
    public HtmlElement stations;

    @FindBy(xpath = ".//*[@class='offers-search__col offers__size--time offers-search__col--gray']")
    public HtmlElement time;

    @FindBy(xpath = ".//*[@class='offers-search__col offers__size--duration']")
    public HtmlElement duration;

    @FindBy(xpath = ".//*[@class='offers-search__col offers__size--chg']")
    public HtmlElement changes;

    @FindBy(xpath = ".//div[contains(@id, 'product_name')]")
    public HtmlElement product;

    @FindBy(xpath = ".//a[contains(@class,'offers-search__btn btn btn--primary')]")
    public Button toOfferSelection;

    public String getStations() {
        return stations.getText();
    }

    public String getTime() {
        return time.getText();
    }

    public String getDuration() {
        return duration.getText();
    }

    public String getChanges() {
        return changes.getText();
    }

    public String getProduct() {
        return product.getText();
    }

    public Button getToOfferSelection() {
        return this.toOfferSelection;
    }

    public Double getSavingFaresPrice() {
        if (!savingFareBlock.getText().contains("Fares not available")) {
            return toDouble(savingFareBlock.flexPrice.getText());
        }
        return null;
    }

    public Double getFlexPrice() {
        if (!flexPriceBlock.getText().contains("Fares not available")) {
            return toDouble(flexPriceBlock.flexPrice.getText());
        }
        return null;
    }

}
