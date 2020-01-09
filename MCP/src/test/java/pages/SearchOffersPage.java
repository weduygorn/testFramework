package pages;

import data.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.blocks.BreadcrumbsHeader;
import pages.blocks.Footer;
import pages.blocks.NavigateHeader;
import pages.blocks.TopHeader;
import pages.blocks.search.*;
import pages.modalwindows.ConditionDetails;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static helpers.OffersHelper.getOffersList;


/**
 * Created by osinskyi on 3/28/2017.
 */
public class SearchOffersPage extends BasePage {
    /**
     * Constructor
     *
     * @param driver
     */
    public SearchOffersPage(WebDriver driver) {
        super(driver);
        conditionDetails = new ConditionDetails(driver);
    }

    public SearchOptions searchOptions;
    public TopInfoOneWay topInfoOneWay;
    public TopInfoRoundTrip topInfoRoundTrip;
    public Offers offers;
    public ConnectionsBlock connectionsBlock;
    public ConditionDetails conditionDetails;
    public InfoSection infoSection;
    public TopHeader topHeader;
    public NavigateHeader navigateHeader;
    public BreadcrumbsHeader breadcrumbsHeader;
    public Footer footer;
    ///////////Change//////////////
    @FindBy(id = "change-passengers")
    public WebElement changeButton;

    //////////ShowOutwardsDetails////////////
    @FindBy(xpath = "//a[@data-toggle='#offer-detail']")
    public WebElement showDetails;

    //////////travel information offer header////////////
    @FindBy(xpath = "//*[@class=\"h3 _top-10\"]")
    public WebElement travelInformation;

    //////////journey header////////////
    @FindBy(xpath = "//*[@class=\"offers__title\"]")
    public WebElement journeyHeader;

    //////////offers title////////////
    @FindBy(xpath = "//*[@class=\"offers__title offers__title--gray-dark\"]")
    public WebElement offerTitle;

    /////////////OutwardOWSelect////////////////
    @FindBy(xpath = "//a[contains(.,'Continue')]")
    public List<WebElement> continueButton;

    /////////////OutwardRTSelect////////////////
    @FindBy(xpath = "//a[contains(.,'Return journey')]")
    public List<WebElement> returnJourneys;

    /////////////outward conditions show details/////////////
    @FindBy(xpath = "//*[text()='Show condition details']")
    public List<WebElement> showConditionDetails;

    /////////////frequent section title///////////////
    @FindBy(xpath = "//*[@class=\"faqs__title\"]")
    public WebElement frequentQuestionsTitle;

    /////////////frequent section items///////////////
    @FindBy(xpath = "//*[@class='faqs toggle-block toggle-block--sm']//a")
    public List<WebElement> frequentQuestionsItems;

    /////////////frequent section items///////////////
    @FindBy(xpath = "//*[@class='offer-details toggle-block toggle-block--show']")
    public WebElement hidedInfo;

    ///////////alert///////////
    @FindBy(xpath = "//*[@class=\"form__message form__message--error\"]")
    public WebElement alert;

    ///////////alert///////////
    @FindBy(xpath = "//*[@class=\"form__message form__message--error\"]/div")
    public WebElement dangerAlert;

    ///////////back///////////
    @FindBy(xpath = "//*[@class='btn btn--default']")
    public WebElement back;

    @FindBy(xpath = "//section[@class='offers']/div")
    public List<WebElement> offersListNode;

    @FindBy(xpath = ".//div[@class='offers__item']")
    public List<WebElement> offersItem;


    public String price = "//*[@class='price_amount']";

    public String price2 = "(//*[@class='price_amount'])[2]";

    /////////////prices///////////////
    @FindBy(xpath = "//*[@class='price_amount']")
    public List<WebElement> prices;

    public String outwardXpath = "//*[@class=\"content\"]";

    @Override
    public void waitLoading() {
        waitUntilElementNotVisible(defaultSpinner, 60);
    }

    @Step
    public void clickRefreshButton() {
        searchOptions.refreshButton.click();
        waitLoading();
    }

    @Step
    public void clickShowDetails() {
        showDetails.click();
    }

    @Step
    public void clickChangeAllData() {
        searchOptions.changeAllData.click();
    }

    public void setPasOneBirthDate(String birthDate) {
        searchOptions.passengerOneBirthDate.click();
        for (char a : birthDate.toCharArray()) {
            searchOptions.passengerOneBirthDate.sendKeys(a + "");
        }
        searchOptions.passengerOneBirthDate.click();

    }

    public void setPasTwoBirthDate(String birthDate) {
        searchOptions.passengerTwoBirthDate.click();
        for (char a : birthDate.toCharArray()) {
            searchOptions.passengerTwoBirthDate.sendKeys(a + "");
        }
        searchOptions.passengerTwoBirthDate.click();
    }

    public void setPasThreeBirthDate(String birthDate) {
        searchOptions.passengerThreeBirthDate.click();
        for (char a : birthDate.toCharArray()) {
            searchOptions.passengerThreeBirthDate.sendKeys(a + "");
        }
        searchOptions.passengerThreeBirthDate.click();
    }

    public void setPasFourBirthDate(String birthDate) {
        searchOptions.passengerFourBirthDate.click();
        for (char a : birthDate.toCharArray()) {
            searchOptions.passengerFourBirthDate.sendKeys(a + "");
        }
        searchOptions.passengerFourBirthDate.click();
    }

    public void setPasFiveBirthDate(String birthDate) {
        searchOptions.passengerFiveBirthDate.click();
        for (char a : birthDate.toCharArray()) {
            searchOptions.passengerFiveBirthDate.sendKeys(a + "");
        }
        searchOptions.passengerFiveBirthDate.click();
    }

    public void selectOptionFromDropdown(String option) {
        // Get all of the options
        List<WebElement> options = driver.findElements(By.xpath("//*[@class='ui-menu ui-corner-bottom ui-widget ui-widget-content']/li"));
        // Loop through the options and select the one that matches
        for (WebElement opt : options) {
            if (opt.getText().equals(option)) {
                opt.click();
                break;
            }
        }
    }

    public WebElement getElementDisplayedWarningMessage() {
        for (int i = 0; searchOptions.pleaseTypeAge.size() > i; i++) {
            if (searchOptions.pleaseTypeAge.get(i).isDisplayed()) {
                return searchOptions.pleaseTypeAge.get(i);
            }
        }
        return null;
    }


    @Step("Click continue button")
    public void clickContinueButton(int index) {
        waitElementVisible(continueButton.get(index));
        continueButton.get(index).click();
    }


    public List<Offers> getOffersResults() {
        return getOffersList(offersListNode);
    }


    public Offers selectSavingFareOffer(List<Offers> offers, Connection connection) {
        for (Offers offer : offers) {
            if (offer.getPrice().equals(connection.getSavingFares())) {
                offer.continueButton.click();
                return offer;
            }
        }
        return null;
    }


    @Step
    public ConditionDetails clickShowConditionDetails(List<Offers> offersItem, int offer) {
        for (int i = 0; i < offersItem.size(); i++) {
            if (i == offer) {
                offersItem.get(i).showConditionsDetails.click();
                waitForElement(conditionDetails.popUp);
                return new ConditionDetails(driver);
            }
        }
        return null;
    }

    @Step
    public Offers selectFlexPriceOffer(List<Offers> offersItem, Connection connections) {
        for (int i = 0; i < offersItem.size(); i++) {
            if (offersItem.get(i).price.equals(connections.flexpreis)) {
                offersItem.get(i).continueButton.click();
                return offersItem.get(i);
            }
        }
        return null;
    }

    @Step
    public Offers selectOfferByConditions(List<Offers> offersItem, String conditions, Integer offerClass) {
        for (int i = 0; i < offersItem.size(); i++) {
            if (offersItem.get(i).getConditions().contains(conditions) && offersItem.get(i).offerClass.equals(offerClass)) {
                offersItem.get(i).continueButton.click();
                return offersItem.get(i);
            }
        }
        return null;
    }

    @Step("Search offer: select offer:  {1} for {2} class")
    public Offers selectOffer(List<Offers> offersItem, String offer, Integer offerClass) {
        for (int i = 0; i < offersItem.size(); i++) {
            if (offersItem.get(i).getOffer().contains(offer) && offersItem.get(i).offerClass.equals(offerClass)) {
                offersItem.get(i).continueButton.click();
                return offersItem.get(i);
            }
        }
        return null;
    }

    @Step
    public Offers selectOfferByClass(List<Offers> offersItem, Integer offerClass) {
        for (int i = 0; i < offersItem.size(); i++) {
            if (offersItem.get(i).offerClass.equals(offerClass)) {
                offersItem.get(i).continueButton.click();
                return offersItem.get(i);
            }
        }
        return null;
    }

    @Step
    public Offers selectFirstAvailableOffer(List<Offers> offersItem) {
        offersItem.get(0).continueButton.click();
        return offersItem.get(0);
    }

}
