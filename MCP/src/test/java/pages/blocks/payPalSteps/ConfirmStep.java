package pages.blocks.payPalSteps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static pages.blocks.payPalSteps.ConfirmStep.REVIEW_SECTION;

@FindBy(xpath = REVIEW_SECTION)
public class ConfirmStep extends HtmlElement {

    static final String REVIEW_SECTION = "//section[@class='review']";

    @FindBy(css = ".continueButton")
    public WebElement continueButton;


}
