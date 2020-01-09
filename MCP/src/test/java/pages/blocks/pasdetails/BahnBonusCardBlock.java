package pages.blocks.pasdetails;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@FindBy(id = "bonusCardForm")
public class BahnBonusCardBlock extends HtmlElement {

    @FindBy(xpath = ".//div[@class='checkbox__icon checkbox-bonus-card__icon']")
    public WebElement collectBonusCheckBox;

    @FindBy(xpath = ".//div[@class='payment-item-bonus-card__type-content-title']")
    public WebElement bahnBonusTitle;

    @FindBy(xpath = ".//div[@class='tooltip payment-item-bonus-card__tooltip']/a")
    public WebElement bahnBonusToolTipLink;

    @FindBy(id = "book_request_passengers_0_bonusCards_first_cardNumber")
    public WebElement cardNumberInput;

    @FindBy(xpath = ".//*[contains(@class,'form__group')]")
    public WebElement formWithCardErrors;

    @FindBy(xpath = ".//*[@class='payment-item-bonus-card__title form__label--required']")
    public WebElement cardNumberTittle;


}
