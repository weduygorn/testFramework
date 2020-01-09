package pages.sideBars;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@FindBy(xpath = ".//*[@id='detail-journey']//div[@class='modal__content modal__content--empty']")
public class YourTravelDataToolTip extends HtmlElement {
    @FindBy(xpath = "(.//div[@class='_col-sm-6 _col-xs-7 offers__item-detail-stantion']//*[@class='_bold'])[1]")
    WebElement originStation;

    @FindBy(xpath = "(.//div[@class='_col-sm-6 _col-xs-7 offers__item-detail-stantion']//*[@class='_bold'])[2]")
    WebElement destinationStation;

    @FindBy(xpath = ".//*[@class='offers__item-detail-route _row']//*[@class='_col-sm-4']")
    List<WebElement> listOfProducts;

    @FindBy(xpath = ".//*[@class='offers-modal__caption']")
    WebElement outwardJourneyStringWithDate;

    @FindBy(xpath = ".//*[@class='modal__title _padding-md']")
    WebElement title;

    @FindBy(xpath = ".//*[@id='detail-journey']//.//*[@class='modal__close']")
    WebElement closeIcon;


    public String getOriginStation() {
        return originStation.getText();
    }

    public String getDestinationStation() {
        return destinationStation.getText();
    }

    public List<WebElement> getListOfProducts() {
        return listOfProducts;
    }

    public String getOutwardJourneyStringWithDate() {
        return outwardJourneyStringWithDate.getText();
    }

    public String getTitle() {
        return title.getText();
    }

    public void clickCloseButton() {
        closeIcon.click();
    }

}
