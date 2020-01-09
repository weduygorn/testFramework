package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static helpers.DateTimeHelper.currentDatePlusNDaysTipSearchNotWeekend;

/**
 * Created by osinskyi on 5/10/2017.
 */
public class TripSearchTempPage extends BasePage {
    /**
     * Constructor
     *
     * @param driver
     */
    public TripSearchTempPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitLoading() {

    }

    @FindBy(id = "fake_mcp_custom_search_departureTrafficHub")
    public WebElement departure;

    @FindBy(xpath = "//*[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']")
    public WebElement dropdownDeparture;

    @FindBy(id = "fake_mcp_custom_search_arrivalTrafficHub")
    public WebElement arrival;

    @FindBy(xpath = "//*[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front'][2]")
    public WebElement dropdownArrival;

    @FindBy(id = "mcp_custom_search_roundtrip")
    public WebElement roundtrip;

    @FindBy(id = "mcp_custom_search_outboundDateTime_date")
    public WebElement dateOut;

    @FindBy(id = "mcp_custom_search_outboundDateTime_time")
    public WebElement timeOut;

    @FindBy(id = "mcp_custom_search_inboundDateTime_date")
    public WebElement dateIn;

    @FindBy(id = "mcp_custom_search_inboundDateTime_time")
    public WebElement timeIn;

    @FindBy(id = "mcp_custom_search_passengers_0_dob")
    public WebElement pas0BirthDate;

    @FindBy(id = "mcp_custom_search_class_0")
    public WebElement class1;

    @FindBy(id = "mcp_custom_search_class_1")
    public WebElement class2;

    @FindBy(xpath = "//*[text()='Search']")
    public WebElement search;

    @FindBy(xpath = "//*[text()[contains(.,'To offer selection')]]")
    public List<WebElement> toOfferSelection;

    @FindBy(xpath = "//*[text()[contains(.,'Return journey')]]")
    public List<WebElement> returnJourney;

    public void setDeparture(String dep) {
        departure.sendKeys(dep);
        waitForElement(dropdownDeparture);
        dropdownDeparture.click();
    }

    public void setArrival(String arr) {
        arrival.sendKeys(arr);
        waitForElement(dropdownArrival);
        dropdownArrival.click();
    }

    public void setOutwardDate(int numberOfDays) {
        dateOut.sendKeys(currentDatePlusNDaysTipSearchNotWeekend(numberOfDays));
        timeout(1);
        dateOut.click();
    }

    public void setInwardDate(int numberOfDays) {
        dateIn.sendKeys(currentDatePlusNDaysTipSearchNotWeekend(numberOfDays));
        timeout(1);
        dateIn.click();
    }

    public void setPas0BirthDate(String birthDate) {
        pas0BirthDate.click();
        for (int i = 0; i < 10; i++) {
            pas0BirthDate.sendKeys(Keys.LEFT);
        }
        pas0BirthDate.sendKeys(birthDate);
    }
}
