package pages.blocks.search;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 * Created by osinskyi on 4/12/2017.
 */
@FindBy(xpath = ".//*[@class='_col-sm-8']")
public class TopInfoRoundTrip extends HtmlElement {
    @FindBy(xpath = "//*[@class='total-routes__title']")
    public Select outwardJourney;

    @FindBy(xpath = "(//*[@class='total-routes__way'])")
    public Select destinationOutward;

    @FindBy(xpath = "(//*[@class='total-routes__date'])")
    public Select dateTimeOutward;

    @FindBy(xpath = "(//*[@class='total-routes__title'])[2]")
    public Select returnJourney;

    @FindBy(xpath = "(//*[@class='total-routes__way'])[2]")
    public Select destinationReturn;

    @FindBy(xpath = "(//*[@class='total-routes__date'])[2]")
    public Select dateTimeReturn;

    @FindBy(xpath = "(//*[@class='total-routes__content'])[2]")
    public Select dateTimeReturnConnectionPage;

    @FindBy(xpath = "//*[@id='mcp-search-form']/p")
    public Select pleaseNote;
}
