package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TicketPageDetailsAssertion extends BasePage {
    /**
     * Constructor
     *
     * @param driver
     */
    public TicketPageDetailsAssertion(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitLoading() {

    }

    @FindBy(xpath = "//*[@class=\"final__header-content\"]")
    public WebElement ticketTitle;

    @FindBy(xpath = "//*[@class=\"final__content\"]")
    public WebElement finalContent;

    @FindBy(xpath = "//*[@class=\"final__header-content\"]//p[2]")
    public WebElement bookingID;


    public String getTicketTitle() {
        waitForElement(ticketTitle, 120);
        return ticketTitle.getText();
    }

    public String getBookingId() {
        return bookingID.getText().replaceAll("Booking ID: ", "");
    }


}
