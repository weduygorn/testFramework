package pages.blocks.payPalSteps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static pages.blocks.payPalSteps.WayToPayStep.WAY_TO_PAY_SECTION;

@FindBy(xpath = WAY_TO_PAY_SECTION)
public class WayToPayStep extends HtmlElement {

    static final String WAY_TO_PAY_SECTION = "//section[@id='xoSelectFi']";

    @FindBy(css = ".continueButton")
    public WebElement continueButton;
}
