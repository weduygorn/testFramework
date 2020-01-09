package pages.blocks.payPalSteps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static pages.blocks.payPalSteps.LoginStep.LOGIN_SECTION;

@FindBy(xpath = LOGIN_SECTION)
public class LoginStep extends HtmlElement {

    static final String LOGIN_SECTION = "//section[@id='login']";

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@value='Next']")
    public WebElement nextButton;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;

}
