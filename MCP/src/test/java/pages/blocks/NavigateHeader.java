package pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@FindBy(xpath = ".//*[@class='navigate__menu']")
public class NavigateHeader extends HtmlElement {
    @FindBy(xpath = "(//li[@class='navigate__menu-item'][1]/a)")
    public WebElement offersItem;

    @FindBy(xpath = "(//li[@class='navigate__menu-item'][2]/a)")
    public WebElement bookingInformation;

    @FindBy(xpath = "(//li[@class='navigate__menu-item'][3]/a)")
    public WebElement trainFleet;
}
