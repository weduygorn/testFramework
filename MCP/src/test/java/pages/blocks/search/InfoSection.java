package pages.blocks.search;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by osinskyi on 4/12/2017.
 */
@FindBy(xpath = ".//*[@class='bottom-info']")
public class InfoSection extends HtmlElement {

    @FindBy(xpath = "//*[@class='bottom-info__title']")
    public WebElement infoTitle;


}
