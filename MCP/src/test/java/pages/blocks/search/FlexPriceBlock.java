package pages.blocks.search;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = ".//*[@class='offers-search__col offers__size--flexpreis offers-search__col--gray']")
public class FlexPriceBlock extends HtmlElement {

    @FindBy(xpath = ".//span[@class='price_amount']")
    public WebElement flexPrice;

}
