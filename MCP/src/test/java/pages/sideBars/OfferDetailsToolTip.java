package pages.sideBars;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

import static helpers.CurrencyHelper.toDouble;

@FindBy(xpath = ".//*[@class='modal active']/div[@class='modal__content modal__content--empty']")
public class OfferDetailsToolTip extends HtmlElement {

    @FindBy(xpath = ".//*[@class='modal__title _top-10']")
    public WebElement title;


    @FindBy(xpath = ".//*[@class='detail-offers__ticket-price']/span[@class='price_amount']")
    public List<WebElement> listOfTicketPrice;

    @FindBy(xpath = ".//*[@class='total-sum__price']/span[@class='price_amount']")
    public WebElement totalPrice;

    @FindBy(xpath = ".//*[@class='detail-offers__title']")
    public WebElement outwardJourneyStringWithStations;

    @FindBy(xpath = ".//*[@class='modal__close']")
    public WebElement closeButton;

    @FindBy(xpath = ".//*[@class='_open-modal']")
    public WebElement body;


    public String getTitle() {
        return title.getText();
    }

    public List<WebElement> getListOfTicketPrice() {
        return listOfTicketPrice;
    }

    public double getTotalPrice() {
        return toDouble(totalPrice.getText());
    }

    public String getOutwardJourneyStringWithStations() {
        return outwardJourneyStringWithStations.getText();
    }

    public Double getSumOfTicketPrice() {
        double sumOfTicketPrice = 0;
        for (int i = 0; i < listOfTicketPrice.size(); i++) {
            sumOfTicketPrice += toDouble(listOfTicketPrice.get(i).getText());
        }
        return sumOfTicketPrice;
    }


}
