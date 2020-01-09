package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.blocks.retrieve.RetrieveDetails;
import pages.blocks.retrieve.RetrieveTicket;

import java.util.ArrayList;
import java.util.List;


public class RefundPage extends BasePage {

    public RefundPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitLoading() {

    }

    public RetrieveDetails retrieveDetails;
    public RetrieveTicket retrieveTicket;
    ArrayList<String> subtitleArray;


    @FindBy(xpath = "//*[@class=\"retrieve__title\"]")
    public WebElement titleRefund;

    @FindBy(xpath = "//*[@class=\"retrieve__subtitle\"]")
    public List<WebElement> subtitlesRefund;

    @FindBy(xpath = ".//*[@class='retrieve__total-price']/span[@class='price_amount']")
    public WebElement totalRefundAmount;

    @FindBy(xpath = "(//*[@class=\"retrieve__total-title\"])")
    public WebElement totalRefundedAmount;

    @FindBy(xpath = ".//*[@class='retrieve__col retrieve__col--pnr retrieve__col--xs-half']/*[@class='retrieve__col-text']")
    public WebElement bookingID;


    public ArrayList<String> getBookingSubtitle() {
        subtitleArray = new ArrayList<>();
        for (WebElement webElement : subtitlesRefund) {
            subtitleArray.add(webElement.getText());
        }
        return subtitleArray;
    }

    public String getBookingStatus() {

        return retrieveDetails.bookingStatus.getText();
    }

    public String getTotalRefundAmount() {
        return totalRefundAmount.getText();
    }

    public String getBookingId() {
        return bookingID.getText();
    }
}
