package pages;

import core.properties.PropertyConfig;
import helpers.Logging;
import links.JumpInLink;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.blocks.LoadingContainer;
import pages.blocks.TimetableForm;
import pages.blocks.WebShopForm;
import ru.yandex.qatools.allure.annotations.Step;

public class SbbHomePage extends BasePage implements Logging {

    TimetableForm timetableForm;
    WebShopForm webShopForm;
    LoadingContainer loadingContainer;

    /**
     *  Clean cache each time after SBB  page loading
     */
    public SbbHomePage(WebDriver driver) {
        super(driver);

    }

    /**
     *  Open SbbHomePage page
     */
    @Step("Open SBB home page")
    public SbbHomePage open() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        driver.get(PropertyConfig.getProperty("sbb.host"));
        waitForElementVisible(timetableForm, 60);
        return new SbbHomePage(driver);
    }

    /**
     *  @param fromValue Set 'From' value
     */
    private void setFrom(String fromValue) {
        timetableForm.fromStationInput.clear();
        timetableForm.fromStationInput.sendKeys(fromValue);
        waitForElementVisible(timetableForm.autocompleteExpanded, 3);
        selectOptionWithText(timetableForm.listItem, fromValue);
        waitForTextPresenseInElement(timetableForm.fromStationInput, fromValue, 5);
    }

    /**
     *  @param toValue Set 'To' value
     */
    private void setTo(String toValue) {
        timetableForm.toStationInput.clear();
        timetableForm.toStationInput.sendKeys(toValue);
        waitForElementVisible(timetableForm.autocompleteExpanded, 3);
        selectOptionWithText(timetableForm.listItem, toValue);
        waitForTextPresenseInElement(timetableForm.toStationInput, toValue, 5);
    }

    /**
     *  @param dateValue Set Date value in yyyy.MM.dd
     */
    private void setDate(String dateValue) {
        timetableForm.dateInput.clear();
        timetableForm.dateInput.sendKeys(dateValue);
        waitForTextPresenseInElement(timetableForm.dateInput, dateValue, 5);
    }

    /**
     *  @param timeValue Set Time in HH:mm
     */
    private void setTime(String timeValue) {
        timetableForm.timeInput.clear();
        timetableForm.timeInput.sendKeys(timeValue);
        waitForTextPresenseInElement(timetableForm.timeInput, timeValue, 5);
    }

    /**
     *  @param searchMode Set Search mode Departure/Arrival
     */
    private void setSearchMode(String searchMode) {
       if(searchMode.equals("Departure") && !getDepSlideOptionSelected()) {
           timetableForm.departureSlideOption.click();
       }
       else if(searchMode.equals("Arrival") && !getArrSlideOptionSelected()){
           timetableForm.arrivalSlideOption.click();
       }
    }

    /**
     *  @return boolean for departure option selected in slider
     */
    private boolean getDepSlideOptionSelected() {
        return timetableForm.departureSlideOption.isSelected();
    }

    /**
     *  @return boolean for arrival option selected in slider
     */
    private boolean getArrSlideOptionSelected() {
        return timetableForm.arrivalSlideOption.isSelected();
    }

    /**
     *  Search connection with params:
     *  @param fromValue fromValue
     *  @param toValue toValue
     *  @param dateValue dateValue
     *  @param timeValue timeValue
     *  @param searchMode searchMode
     */
    @Step("Input data for search connection")
    public void searchConnection(String fromValue, String toValue, String dateValue, String timeValue, String searchMode){
        setFrom(fromValue);
        setTo(toValue);
        setDate(dateValue);
        setTime(timeValue);
        setSearchMode(searchMode);
        waitForElementClickable(timetableForm.searchForConnectionBtn, 5);
        clickJS(timetableForm.searchForConnectionBtn);
    }

    /**
     *  Click Cfd button to get jump in link and proceed to CFD page
     */
    @Step("Click Search supersaver tickets button")
    public void clickCfdButton(){
        waitForElement(webShopForm.cfdButton);
        clickJS(webShopForm.cfdButton);
        waitForTitleIs("Saving offers search | SBB", 60);
        if(System.getProperty("environment").equals("dev") || System.getProperty("environment").equals("test")) {

            JumpInLink jumpInLink = new JumpInLink(driver);
            driver.get(jumpInLink.replaceHost());
        }
        attachText("JumpInLink", driver.getCurrentUrl());
        LOG.info("JumpInLink " + driver.getCurrentUrl());
        waitForElementInvisible(By.cssSelector(loadingContainer.GLOBAL_LOADING_ANIM_CSS), 60);
        waitForAllElementsNotPresent(By.cssSelector(loadingContainer.OFFER_LOADING_ANIM_CSS), 120);
    }


}
