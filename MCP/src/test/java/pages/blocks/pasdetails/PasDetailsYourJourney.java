package pages.blocks.pasdetails;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by osinskyi on 4/25/2017.
 */
@FindBy(xpath = ".//*[@class='sidebar-total']")
public class PasDetailsYourJourney extends HtmlElement {
    ///////////////////////title///////////////////////////
    @FindBy(xpath = ".//*[@class='sidebar-total__title sidebar-total__title--gray sidebar-total__title--tooltip']")
    public WebElement title;

    ///////////////////////body///////////////////////////
    @FindBy(xpath = ".//*[@class='sidebar-total__trips']")
    public WebElement body;

    ///////////////////////body part 2///////////////////////////
    @FindBy(xpath = ".//*[@class='sidebar-total__ticket']")
    public WebElement bodyPart2;

    ///////////////////////footer///////////////////////////
    @FindBy(xpath = ".//*[@class='sidebar-total__title sidebar-total__title--gray']")
    public WebElement footer;
}
