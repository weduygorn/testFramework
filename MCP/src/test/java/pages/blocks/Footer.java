package pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = ".//*[@class='footer']")
public class Footer extends HtmlElement {
    @FindBy(xpath = "//*[@class='footer__info-content']//span[1]")
    public WebElement footerCreditCards;

    @FindBy(xpath = "//*[@class='footer__info-content']//span[2]")
    public WebElement footerPayPal;

    @FindBy(xpath = "(//*[@class='footer__bottom']//a)[1]")
    public WebElement footerBahnDe;

    @FindBy(xpath = "(//*[@class='footer__bottom']//a)[2]")
    public WebElement footerLegalNotice;

    @FindBy(xpath = "(//*[@class='footer__bottom']//a)[3]")
    public WebElement footerGTC;

    @FindBy(xpath = "(//*[@class='footer__bottom']//a)[4]")
    public WebElement footerTermsOfUse;

    @FindBy(xpath = "(//*[@class='footer__bottom']//a)[5]")
    public WebElement footerPrivacy;

}
