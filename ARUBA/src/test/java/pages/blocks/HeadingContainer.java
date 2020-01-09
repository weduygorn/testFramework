package pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(css = ".heading-container")
public class HeadingContainer extends HtmlElement {

    @FindBy(css = "h1")
    public WebElement heading;

    @FindBy(css = ".subheading__from")
    public WebElement subheadingFrom;

    @FindBy(css = ".subheading__to")
    public WebElement subheadingTo;

    @FindBy(css = ".subheading__date-time")
    public WebElement subheadingDate;

}
