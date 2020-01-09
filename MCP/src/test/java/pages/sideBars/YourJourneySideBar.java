package pages.sideBars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static helpers.CurrencyHelper.toDouble;

@FindBy(xpath = ".//*[@id='sidebar']")
public class YourJourneySideBar extends HtmlElement {

    @FindBy(css = ".sidebar-total__title--gray.sidebar-total__title--tooltip")
    WebElement sideBarTitle;

    @FindBy(xpath = ".//*[@class='sidebar-total__trips']")
    WebElement tripInfo;

    @FindBy(xpath = ".//*[@class='sidebar-total__ticket']")
    WebElement ticketContent;

    @FindBy(xpath = ".//*[@class='sidebar-total__title sidebar-total__title--tooltip']")
    WebElement priceToolTip;

    @FindBy(xpath = ".//*[@class='_col-xs-4 _text-right']")
    WebElement price;

    @FindBy(xpath = ".//*[@class='sidebar-total__title sidebar-total__title--gray']")
    WebElement totalPriceTitle;

    @FindBy(css = ".price_amount")
    WebElement totalPriceAmount;

    @FindBy(xpath = ".//*[@class='tooltip__icon tooltip__icon--white']")
    WebElement yourTravelDataToolTipButton;

    @FindBy(xpath = ".//*[@class='tooltip__icon']")
    public WebElement offerDetailsToolTipButton;


    public String getSideBarTitle() {
        return sideBarTitle.getText();
    }

    public String getTripInfo() {
        return tripInfo.getText();
    }

    public String getDate() {
        return tripInfo.findElement(By.xpath("_col-xs-6 _text-right")).getText();
    }

    public String getTotalPriceTitle() {
        return totalPriceTitle.getText();
    }

    public Double getPrice() {
        return toDouble(price.getText());
    }

    public String getTicketContent() {
        return ticketContent.getText();
    }

    public String getPriceToolTip() {
        return priceToolTip.getText();
    }

    public Double getTotalPriceAmount() {
        return toDouble(totalPriceAmount.getText());
    }

    public void clickOfferDetailsToolTipButton() {
        offerDetailsToolTipButton.click();
    }

    public void clickYourTravelDataToolTipButton() {
        yourTravelDataToolTipButton.click();
    }


}
