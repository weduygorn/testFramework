package pages.blocks.search;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;

/**
 * Created by osinskyi on 4/12/2017.
 */
@FindBy(xpath = ".//*[@class='total-routes__item']")
public class TopInfoOneWay extends HtmlElement {

    @FindBy(xpath = ".//*[@class='total-routes__title']")
    public Select outwardJourney;

    @FindBy(xpath = ".//*[@class='total-routes__way']")
    public Select destination;

    @FindBy(xpath = ".//*[@class='total-routes__date']")
    public Select dateTime;


}
