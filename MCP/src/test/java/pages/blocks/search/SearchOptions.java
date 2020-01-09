package pages.blocks.search;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;

import java.util.List;

/**
 * Created by osinskyi on 4/6/2017.
 */
@FindBy(xpath = ".//*[@id='mcp-search-form']")
public class SearchOptions extends HtmlElement {
    ////Titles/////
    @FindBy(xpath = "(//*[@class='form__label'])[1]")
    public WebElement titleTravellers;
    @FindBy(xpath = "(//*[@class='form__label '])")
    public WebElement titleBirthDate;
    @FindBy(xpath = "(//*[@class='form__label _hidden-xs'])")
    public WebElement titleDiscountCards;
    @FindBy(id = "mcp_db_search_passengers_count-button")
    public Select passengerCount;
    //discount cards buttons///
    @FindBy(id = "empty-card-select-id-button")
    public WebElement discountCardsPasOne;
    @FindBy(id = "ui-id-11-button")
    public WebElement discountCardsPasTwo;
    @FindBy(id = "ui-id-24-button")
    public WebElement discountCardsPasThree;
    @FindBy(id = "ui-id-25-button")
    public WebElement discountCardsPasFour;
    @FindBy(id = "ui-id-26-button")
    public WebElement discountCardsPasFive;
    ///////////////////////bahnCardOptions///////////////////////////
    /////Birth dates//////
    @FindBy(id = "mcp_db_search_passengers_0_dob")
    public WebElement passengerOneBirthDate;
    @FindBy(xpath = "//*[@data-change-text='#passengerBirth2']")
    public WebElement passengerTwoBirthDate;
    @FindBy(xpath = "//*[@data-change-text='#passengerBirth3']")
    public WebElement passengerThreeBirthDate;
    @FindBy(xpath = "//*[@data-change-text='#passengerBirth4']")
    public WebElement passengerFourBirthDate;
    @FindBy(xpath = "//*[@data-change-text='#passengerBirth5']")
    public WebElement passengerFiveBirthDate;
    /////////////1 class////////////
    @FindBy(id = "mcp_search_class_0")
    public WebElement firstClass;
    /////////////2 class////////////
    @FindBy(id = "mcp_search_class_1")
    public WebElement secondClass;
    //////////Refresh////////////
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement refreshButton;
    ////Change other data/////
    @FindBy(xpath = "//*[contains(text(),'Change data')]")
    public WebElement changeAllData;
    /////message about type in age/////
    @FindBy(css = ".form__message--error .offers__passengers-text")
    public List<WebElement> pleaseTypeAge;
    //collapsed passenger data
    @FindBy(xpath = "(//*[@class='total-routes__content'])[2]")
    public WebElement collapsedPassengerData;
    //collapsed passenger data RT
    @FindBy(xpath = "(//*[@class='total-routes__content'])[3]")
    public WebElement collapsedPassengerDataRT;
}
