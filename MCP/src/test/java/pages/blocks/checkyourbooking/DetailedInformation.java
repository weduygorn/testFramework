package pages.blocks.checkyourbooking;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = ".//*[@class='confirmation__details']")
public class DetailedInformation extends HtmlElement {

    @FindBy(xpath = ".//*[@class='confirmation__details-title']")
    public WebElement detailedInformationTitle;

    @FindBy(xpath = ".//*[@class='checkbox__icon']")
    public WebElement checkBox;

}
