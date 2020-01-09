package pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@FindBy(xpath = "//div[@data-init='timetableInputForm']")
public class TimetableForm extends HtmlElement{

    @FindBy(xpath = "//input[@id='shopForm_von_valueComp']")
    public WebElement fromStationInput;

    @FindBy(xpath = "//div[@class='mod_autocomplete is_expanded']")
    public WebElement autocompleteExpanded;

    @FindBy(xpath = "//div[@role='listitem']")
    public List<WebElement> listItem;

    @FindBy(xpath = "//input[@id='shopForm_nach_valueComp']")
    public WebElement toStationInput;

    @FindBy(xpath = "//input[@name='shopForm_datepicker_valueComp']")
    public WebElement dateInput;

    @FindBy(xpath = "//input[@id='shopForm_timepicker_valueComp']")
    public WebElement timeInput;

    @FindBy(xpath = "//input[@id='toggleButtonId_first_option']")
    public WebElement departureSlideOption;

    @FindBy(xpath = "//input[@id='toggleButtonId_second_option']")
    public WebElement arrivalSlideOption;

    @FindBy(css = ".verbindungSuchen")
    public WebElement searchForConnectionBtn;




}
