package pages.blocks.pasdetails;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;

import java.util.List;

/**
 * Created by osinskyi on 4/25/2017.
 */
@FindBy(xpath = ".//*[@class='_col-lg-9 _col-sm-8']")
public class PassengersDetails extends HtmlElement {

    ///////////////////////pass1///////////////////////////
    @FindBy(xpath = ".//*[@class='payment-item__title']")
    public WebElement passengerNumber;

    @FindBy(xpath = ".//*[@class='payment-item__tooltip-text']")
    public WebElement infoReceiveBooking;

    @FindBy(xpath = "//*[@class='form__label form__label--required']")
    public WebElement pasOneSalutationLabel;

    @FindBy(xpath = ".//*[@class='ui-selectmenu-text']")
    public Select pasOneSalutation;

    @FindBy(xpath = ".//*[@class='form__group form__group--text']")
    public WebElement pasOneBirthDate;

    @FindBy(xpath = "(.//*[@class='form__label form__label--required'])[2]")
    public WebElement pasOneNameLabel;

    @FindBy(xpath = "//*[@id='book_request_passengers_0_name']")
    public WebElement pasOneName;

    @FindBy(xpath = "(.//*[@class='form__label form__label--required'])[3]")
    public WebElement pasOneSurnameLabel;

    @FindBy(xpath = "//*[@id='book_request_passengers_0_surname']")
    public WebElement pasOneSurname;

    @FindBy(xpath = "(.//*[@class='form__label form__label--required'])[4]")
    public WebElement pasOneEmailLabel;

    @FindBy(xpath = ".//*[@id='book_request_contactDetails_email']")
    public WebElement pasOneEmail;

    @FindBy(xpath = "(.//*[@class='form__label form__label--required'])[9]")
    public WebElement pasOnePhoneLabel;

    @FindBy(xpath = ".//*[@id='book_request_contactDetails_phoneNumber']")
    public WebElement pasOnePhone;

    @FindBy(xpath = "(.//*[@class='form__label form__label--required'])[5]")
    public WebElement pasOneStreetNumberLabel;

    @FindBy(xpath = ".//*[@id='book_request_contactDetails_street']")
    public WebElement pasOneStreetNumber;

    @FindBy(xpath = "(.//*[@class='form__label form__label--required'])[6]")
    public WebElement pasOnePostcodeLabel;

    @FindBy(xpath = ".//*[@id='book_request_contactDetails_postcode']")
    public WebElement pasOnePostcodeNumber;

    @FindBy(xpath = "(.//*[@class='form__label form__label--required'])[7]")
    public WebElement pasOneCityLabel;

    @FindBy(xpath = ".//*[@id='book_request_contactDetails_city']")
    public WebElement pasOneCity;

    @FindBy(xpath = "(.//*[@class='form__label form__label--required'])[8]")
    public WebElement pasOneCountryLabel;

    @FindBy(xpath = ".//*[@id='book_request_contactDetails_country-button']")
    public Select pasOneCountry;

    @FindBy(xpath = "(.//*[@class='form__label'])[1]")
    public WebElement pasOneStateLabel;

    @FindBy(xpath = ".//*[@id='book_request_contactDetails_region']")
    public Select pasOneState;

    @FindBy(css = ".form .form__message--error")
    public List<WebElement> errorMessage;

    ///////////////////////pass2///////////////////////////
    @FindBy(xpath = "(//*[@class='ui-selectmenu-text'])[2]")
    public Select pasTwoSalutation;

    @FindBy(xpath = "(//*[@class='form__group form__group--text'])[2]")
    public WebElement pasTwoBirthDate;

    @FindBy(xpath = "//*[@id='book_request_passengers_1_name']")
    public WebElement pasTwoName;

    @FindBy(xpath = "//*[@id='book_request_passengers_1_surname']")
    public WebElement pasTwoSurname;

    ///////////////////////pass3///////////////////////////
    @FindBy(xpath = "(//*[@class='ui-selectmenu-text'])[3]")
    public Select pasThreeSalutation;

    @FindBy(xpath = "(//*[@class='form__group form__group--text'])[3]")
    public WebElement pasThreeBirthDate;

    @FindBy(xpath = "//*[@id='book_request_passengers_2_name']")
    public WebElement pasThreeName;

    @FindBy(xpath = "//*[@id='book_request_passengers_2_surname']")
    public WebElement pasThreeSurname;

    ///////////////////////pass4///////////////////////////
    @FindBy(xpath = "(//*[@class='ui-selectmenu-text'])[4]")
    public Select pasFourSalutation;

    @FindBy(xpath = "(//*[@class='form__group form__group--text'])[4]")
    public WebElement pasFourBirthDate;

    @FindBy(xpath = "//*[@id='book_request_passengers_3_name']")
    public WebElement pasFourName;

    @FindBy(xpath = "//*[@id='book_request_passengers_3_surname']")
    public WebElement pasFourSurname;

    ///////////////////////pass5///////////////////////////
    @FindBy(xpath = "(//*[@class='ui-selectmenu-text'])[5]")
    public Select pasFiveSalutation;

    @FindBy(xpath = "(//*[@class='form__group form__group--text'])[5]")
    public WebElement pasFiveBirthDate;

    @FindBy(xpath = "//*[@id='book_request_passengers_4_name']")
    public WebElement pasFiveName;

    @FindBy(xpath = "//*[@id='book_request_passengers_4_surname']")
    public WebElement pasFiveSurname;

}
