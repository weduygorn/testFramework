package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.sideBars.OfferDetailsToolTip;
import pages.sideBars.YourJourneySideBar;
import pages.sideBars.YourTravelDataToolTip;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by osinskyi on 6/27/2017.
 */
public class UpsalePage extends BasePage {

    YourJourneySideBar yourJourneySideBar;
    YourTravelDataToolTip yourTravelDataToolTip;
    OfferDetailsToolTip offerDetailsToolTip;

    List<String> compartmentsArray;
    private boolean compartmentPresense;

    /**
     * Constructor
     *
     * @param driver
     */
    public UpsalePage(WebDriver driver) {
        super(driver);
    }

    ////////Back button///////
    @FindBy(xpath = "//*[@class='btn btn--default']")
    public WebElement backButton;

    ////////Book button///////
    @FindBy(xpath = "//*[text()='Continue']")
    public WebElement continueButton;

    ////////upsale block ///////
    @FindBy(xpath = "(//*[@class='compartments__item_list'])")
    public WebElement upsaleBlock;

    @FindBy(xpath = "(//*[@class='passenger_form_error'])")
    public WebElement infantWarning;

    @FindBy(css = ".compartments__item-zones-items")
    public List<WebElement> compartmentsItemsZones;

    @FindBy(css = ".compartments__item-zones-header--link")
    public List<WebElement> compartmentsItemZonesHeader;

    @FindBy(css = "div[data-slider-active]")
    public WebElement dataSliderActive;

    @FindBy(css = "div[data-slider-next][class=compartments__item-next]")
    public WebElement dataSliderNext;

    @FindBy(css = ".compartments__item-caption")
    public List<WebElement> compartmentsList;

    @FindBy(css = ".radio .price_amount")
    public List<WebElement> prices;

    ////////title ///////
    @FindBy(xpath = "(//*[@class='compartments__title'])")
    public WebElement upsaleTitle;

    @Override
    public void waitLoading() {
        waitUntilElementNotVisible(defaultSpinner, 60);
    }

    @Step("Upsale: Click Offer Detail Tool Tip")
    public void clickOfferDetailToolTip() {
        waitElementVisible(yourJourneySideBar);
        yourJourneySideBar.offerDetailsToolTipButton.click();
    }

    @Step("Upsale: Click Your Travel Data Tool Tip Button")
    public void ClickYourTravelDataToolTipButton() {
        yourJourneySideBar.clickYourTravelDataToolTipButton();
    }

    @Step("Upsale: Click continue button")
    public void clickContinueButton() {
        waitForElement(continueButton);
        continueButton.click();
        waitLoading();
    }

    @Step("Upsale: close Offer Details Tool Tip")
    public void closeOfferDetailsToolTip() {
        offerDetailsToolTip.closeButton.click();

    }

    @Step("Upsale: close Offer Details Tool Tip")
    public void closeOfferDetailsToolTip2() {
        waitElementVisible(offerDetailsToolTip);


        offerDetailsToolTip.body.click();
    }

    public double getSumOfTicketPriceFromOfferDetailsToolTip() {
        waitElementVisible(offerDetailsToolTip);
        return offerDetailsToolTip.getSumOfTicketPrice();
    }

    public double getTotalPriceFromOfferDetailsTooltip() {
        waitElementVisible(offerDetailsToolTip);
        return offerDetailsToolTip.getTotalPrice();
    }

    public double getTotalPriceFromYourJourneySidebar() {
        return yourJourneySideBar.getTotalPriceAmount();
    }


    public List<String> getCompartments() {
        compartmentsArray = new ArrayList<>();
        for (WebElement compartments : compartmentsList) {
            compartmentsArray.add(compartments.getText());
        }
        return compartmentsArray;
    }

    public WebElement getCompartmentHeader(String compartmentItemZone) {
        int s = 0;
        for (int i = 0; i < compartmentsItemZonesHeader.size(); i++) {
            if (compartmentsItemZonesHeader.get(i).getText().equals(compartmentItemZone) && compartmentsItemZonesHeader.get(i).isDisplayed()) {
                return compartmentsItemsZones.get(i);
            }
        }
        if (Integer.parseInt(dataSliderActive.getAttribute("data-slider-active")) <= 3) {
            dataSliderNext.click();
        } else {
            Assert.fail("Tried scroll 3 times but Item Zone " + compartmentItemZone + " not found");
        }
        return getCompartmentHeader(compartmentItemZone);

    }

    @Step("Upsale: Select compartment: {0} for {1}")
    public void selectCompartment(String compartmentItemZone, String compartmentType) {
        WebElement compartmentItemHeader = getCompartmentHeader(compartmentItemZone);
        for (int i = 0; i < compartmentsList.size(); i++) {
            if (compartmentsList.get(i).getText().equals(compartmentType)) {
                compartmentItemHeader.findElements(By.cssSelector(".radio")).get(i).click();
                break;
            }
        }
    }

    @Step()
    public boolean getCompartmentAvailability(String compartmentItemZone, String compartmentType) {
        WebElement compartmentItemHeader = getCompartmentHeader(compartmentItemZone);
        for (int i = 0; i < compartmentsList.size(); i++) {
            if (compartmentsList.get(i).getText().equals(compartmentType)) {
                return isElementPresent(compartmentItemHeader.findElements(By.cssSelector(".radio")).get(i));
            }
        }
        return false;
    }


}
