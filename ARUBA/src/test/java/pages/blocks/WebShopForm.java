package pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(id = "shopForm_verbindung-content")
public class WebShopForm extends HtmlElement {

    @FindBy(id = "buttonCFD")
    public WebElement cfdButton;
}
