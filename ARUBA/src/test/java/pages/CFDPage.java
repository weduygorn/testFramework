package pages;

import helpers.AllureAssert;
import helpers.Logging;
import data.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.blocks.HeadingContainer;
import pages.blocks.LoadingContainer;
import pages.blocks.OffersContainer;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.ArrayList;
import java.util.List;

public class CFDPage extends BasePage implements Logging {

    public HeadingContainer headingContainer;
    public LoadingContainer loadingContainer;
    public OffersContainer offersContainer;
    Connection connection;
    public String LANGUAGE = null;

    @FindBy(css = ".heading h1")
    public WebElement heading;

    @FindBy(name = "purchase")
    private WebElement purchaseButton;

    @FindBy(css = ".button-back")
    public WebElement backButton;

    @FindBy(id = "correlationId")
    private HtmlElement corrId;

    @FindBy(css = "#select_offer_needed .error-on-request__message")
    private WebElement errorMessageOfferSelection;

    @FindBy(css = ".error-on-request__message")
    public WebElement errorOnRequestMessage;

    @FindBy(css = "#main_error_with_button .error-on-request__message")
    public WebElement mainError;

    @FindBy(css = ".mod_header")
    public WebElement modHeader;

    @FindBy(css = "#main_error_with_button .error-reset")
    public WebElement retryEnquiryBtn;

    @FindBy(css = "span[lang]")
    public WebElement selectedLanguage;

    @FindBy(css = ".mod_langnav_item_text")
    public List<WebElement> languageTypes;

    /**
     * Constructor
     *
     * @param driver
     */
    public CFDPage(WebDriver driver) {
        super(driver);
    }


    private WebElement getDayColumn(int column) {
        return offersContainer.dateColumn.get(column);
    }

    public String getDepTime(int i) {
        return offersContainer.connections.get(i).findElement(By.cssSelector(offersContainer.depTimeCSS)).getAttribute("textContent");
    }

    public String getArrTime(int i) {
        return offersContainer.connections.get(i).findElement(By.cssSelector(offersContainer.arrTimeCSS)).getAttribute("textContent");
    }

    public String getChanges(int i) {
        return offersContainer.connections.get(i).findElement(By.cssSelector(offersContainer.changesCSS)).getAttribute("textContent");
    }

    public String getDurationText(int i) {
        return offersContainer.connections.get(i).findElement(By.cssSelector(offersContainer.offerDurationCSS)).getAttribute("textContent");
    }

    public String getDurationHours(int i) {
        return offersContainer.connections.get(i).findElement(By.cssSelector(offersContainer.durationHoursCSS)).getAttribute("textContent");
    }

    public String getDurationMinutes(int i) {
        return offersContainer.connections.get(i).findElement(By.cssSelector(offersContainer.durationMinutesCSS)).getAttribute("textContent");
    }

    public String getSecondClassTextLabel(int i) {
        return offersContainer.connections.get(i).findElement(By.cssSelector(offersContainer.secondClassLabelCSS)).getAttribute("textContent");
    }

    public String getFirstClassTextLabel(int i) {
        return offersContainer.connections.get(i).findElement(By.cssSelector(offersContainer.firstClassLabelCSS)).getAttribute("textContent");
    }

    public String getSecondClassPrice(int i) {
        if (isElementPresent(offersContainer.connections.get(i).findElement(By.xpath(offersContainer.secondClassPriceXPATH)))) {
            return offersContainer.connections.get(i).findElement(By.xpath(offersContainer.secondClassPriceXPATH)).getAttribute("textContent");
        } else {
            return "Second class price not available!";
        }
    }

    public String getFirstClassPrice(int i) {
        if (isElementPresent(offersContainer.connections.get(i).findElement(By.xpath(offersContainer.firstClassPriceXPATH)))) {
            return offersContainer.connections.get(i).findElement(By.xpath(offersContainer.firstClassPriceXPATH)).getAttribute("textContent");
        } else {
            return "First class price not available!";
        }
    }

    public String getCorrelationID() {
        return corrId.getAttribute("textContent");
    }

    public String getTextOnRequestErrorMessage() {
        return errorOnRequestMessage.getText();
    }

    public String getTextMainError() {
        return mainError.getText();
    }

    public boolean noOfferAvailableCardDisplay() {
        return offersContainer.noOfferAvailableCard.isDisplayed();
    }

    /**
     Get heading Text
     * @return heading Text.
     */
    public String getHeadingText() {
        return headingContainer.heading.getText();
    }

    /**
     Get subheading way 'From' Text
     * @return From Text.
     */
    public String getSubheadingFromText() {
        return headingContainer.subheadingFrom.getText();
    }

    /**
     Get subheading way 'To' Text
     * @return To Text.
     */
    public String getSubheadingToText() {
        return headingContainer.subheadingTo.getText();
    }

    /**
     Get subheading Date Text
     * @return Date Text.
     */
    public String getSubheadingDateText() {
        return headingContainer.subheadingDate.getText();
    }

    public String getEarlierButtonText() {
        return offersContainer.earlierButton.get(0).getText();
    }

    public String getLaterButtonText() {
        return offersContainer.laterButton.get(0).getText();
    }

    public String getPurchaseButtonText() {
        return purchaseButton.getText();
    }

    public String getBackButtonText() {
        return backButton.getText();
    }

    /**
     Get available connection per day
     * @return int.
     */
    public Integer getConnectionSizeInColumn(int column) {
        offersContainer.dateColumnXpath = driver.findElements(By.xpath("//div[@data-date]["+(column + 1)+"]//div[contains(@class, 'offer')][@data-offer-id]"));
        return offersContainer.dateColumnXpath.size();
    }

    public String getOfferSelectionErrorMessage() {
        return errorMessageOfferSelection.getText();
    }

    public void removeHeader() {
        timeout(1);
        JavascriptExecutor js;
        if (driver instanceof JavascriptExecutor) {
            js = (JavascriptExecutor) driver;
            js.executeScript("return window.$('header').remove();");
        }

    }

    /**
     Select first available connection from list
     * @return Connection with depTime/arrTime/changes/duration/secondClassPrice/firstClassPrice.
     */
    @Step
    public Connection selectFirstAvailableConnection() {
        LOG.info("Available connections size: " + offersContainer.connections.size());
        if (isFirstElementPresent(offersContainer.connections)) {
            for (int i =0;i< offersContainer.connections.size(); i++) {
                if(offersContainer.findElements(By.xpath(offersContainer.secondClassPriceBoxXPATH)).get(i).getAttribute("textContent").contains("CHF") ||
                   offersContainer.findElements(By.xpath(offersContainer.firstClassPriceBoxXPATH)).get(i).getAttribute("textContent").contains("CHF")) {
                    connection = new Connection(
                            getDepTime(i),
                            getArrTime(i),
                            getChanges(i),
                            getDurationHours(i) + " " + getDurationMinutes(i),
                            getSecondClassPrice(i),
                            getFirstClassPrice(i));
                    System.out.println("Connection " + i + " details:");
                    System.out.println(connection.depTime);
                    System.out.println(connection.arrTime);
                    System.out.println(connection.changes);
                    System.out.println(connection.duration);
                    System.out.println(connection.secondClassPrice);
                    System.out.println(connection.firstClassPrice);
                    clickJS(offersContainer.connections.get(i));
                    return connection;
                } else {
                    System.out.println("Connection " + i + " without prices!");
                    if((i + 1) == offersContainer.connections.size()){
                        AllureAssert.fail("All connections without prices!");
                    }
                }
            }
        } else {
            AllureAssert.fail("Available connections not found!");
        }
        return null;
    }

    @Step
    public void earlierButtonDisplayInColumn(int column) {
        getDayColumn(column).findElement(By.xpath(offersContainer.earlierButtonXPATH)).click();
        waitForElementInvisible(By.cssSelector(loadingContainer.OFFER_LOADING_ANIM_CSS), 15);
    }

    @Step
    public void clickEarlierButton(int column) {
        getDayColumn(column).findElement(By.xpath(offersContainer.earlierButtonXPATH)).click();
        waitForElementInvisible(By.cssSelector(loadingContainer.OFFER_LOADING_ANIM_CSS), 15);
    }

    @Step
    public void clickLaterButton(int column) {
        getDayColumn(column).findElement(By.xpath(offersContainer.laterButtonXPATH)).click();
        waitForElementInvisible(By.cssSelector(loadingContainer.OFFER_LOADING_ANIM_CSS), 15);
    }

    @Step
    public void clickNextDateButton() {
        offersContainer.nextDayButton.click();
        waitForElementInvisible(By.cssSelector(loadingContainer.DATE_LOADING_ANIM_CSS), 15);

    }

    @Step
    public void clickPrevDateButton() {
        offersContainer.previousDayButton.click();
        waitForElementInvisible(By.cssSelector(loadingContainer.DATE_LOADING_ANIM_CSS), 15);
    }


    @Step
    public int getColumnsDateSize() {
        return offersContainer.dateColumn.size();
    }

    @Step
    public List<String> columnDatesArray() {
        List<String> dates = new ArrayList<String>();
        for (int i = 0; i<offersContainer.dateColumn.size();i++) {
            if(getDayColumn(i).isDisplayed()) {
               String date = getDayColumn(i).findElements(By.xpath(offersContainer.offersHeadXPATH)).get(i).getText().split("\\s+")[1];
               dates.add(date);
            }
        }
        return dates;
    }

    /**
     *  Click Purchase button to get jump out link and proceed to Ticket Shop page
     */
    @Step
    public void clickPurchaseButton() {
        purchaseButton.click();
    }

    @Step
    public void selectLanguage(String language) {
        for (WebElement lang : languageTypes) {
            if (lang.getText().equals(language)) {
                lang.click();
                break;
            }
        }
        LANGUAGE = language;
        waitForElementInvisible(By.cssSelector(loadingContainer.GLOBAL_LOADING_ANIM_CSS), 30);
    }












}
