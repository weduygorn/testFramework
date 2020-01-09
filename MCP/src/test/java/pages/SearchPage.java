package pages;

import helpers.SearchParams;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SearchPage extends BasePage {

    /**
     * Constructor
     *
     * @param driver
     */
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    ///////////Title//////////////
    @FindBy(xpath = "//*[@class=\"search__title\"]")
    public WebElement searchTitle;

    ///////////from//////////////
    @FindBy(xpath = "//*[@id='fake_mcp_db_custom_search_departureTrafficHub']")
    public WebElement from;

    @FindBy(css = "#ui-id-4")
    public WebElement autocompleterFrom;

    @FindBy(css = ".ui-menu-item .ui-menu-item-wrapper")
    public List<WebElement> optionCityWrapper;

    ///////////replaceHubs//////////////
    @FindBy(xpath = "//*[@id=\"replace_hubs\"]")
    public WebElement replaceHubs;

    ///////////to//////////////
    @FindBy(xpath = "//*[@id='fake_mcp_db_custom_search_arrivalTrafficHub']")
    public WebElement to;

    @FindBy(css = "#ui-id-5")
    public WebElement autocompleterTo;

    @FindBy(xpath = "//input[@id='mcp_db_custom_search_outboundDateTime_date']")
    public WebElement outwardDate;

    @FindBy(xpath = "//input[@id='mcp_db_custom_search_inboundDateTime_date']")
    public WebElement inwardDate;


    ///////////outward date up//////////////
    @FindBy(xpath = "(//*[@class=\"input__arrow input__arrow--next\"])[1]")
    public WebElement outwardDateUp;

    ///////////inward date up//////////////
    @FindBy(xpath = "(//*[@class=\"input__arrow input__arrow--next\"])[3]")
    public WebElement inwardDateUp;

    ///////////outward time//////////////
    @FindBy(xpath = "//*[@id='mcp_db_custom_search_outboundDateTime_time']")
    public WebElement outwardTime;

    ///////////inward time//////////////
    @FindBy(xpath = "//*[@id='mcp_db_custom_search_inboundDateTime_time']")
    public WebElement inwardTime;

    ///////////passenger count//////////////
    @FindBy(xpath = "//*[contains(@id, 'passengers_count-button')]")
    public WebElement pasCount;

    ///////////passenger 1 birth date//////////////
    @FindBy(xpath = "//*[contains(@id, 'search_passengers_0_dob')]")
    public WebElement pas1BirthDate;

    ///////////passenger 2 birth date//////////////
    @FindBy(xpath = "//*[@data-change-text='#passengerBirth2']")
    public WebElement pas2BirthDate;

    ///////////passenger 3 birth date//////////////
    @FindBy(xpath = "//*[@data-change-text='#passengerBirth3']")
    public WebElement pas3BirthDate;

    ///////////passenger 4 birth date//////////////
    @FindBy(xpath = "//*[@data-change-text='#passengerBirth4']")
    public WebElement pas4BirthDate;

    ///////////passenger 5 birth date//////////////
    @FindBy(xpath = "//*[@data-change-text='#passengerBirth5']")
    public WebElement pas5BirthDate;

    ///////////passenger 1 select discount//////////////
    @FindBy(xpath = "(//*[@class=\"ui-selectmenu-text\"])[2]")
    public WebElement pas1SelectDiscount;

    ///////////passenger 2 select discount//////////////
    @FindBy(xpath = "(//*[@class=\"ui-selectmenu-text\"])[3]")
    public WebElement pas2SelectDiscount;

    ///////////passenger 3 select discount//////////////
    @FindBy(xpath = "(//*[@class=\"ui-selectmenu-text\"])[4]")
    public WebElement pas3SelectDiscount;

    ///////////passenger 4 select discount//////////////
    @FindBy(xpath = "(//*[@class=\"ui-selectmenu-text\"])[5]")
    public WebElement pas4SelectDiscount;

    ///////////passenger 5 select discount//////////////
    @FindBy(xpath = "(//*[@class=\"ui-selectmenu-text\"])[6]")
    public WebElement pas5SelectDiscount;

    //1 class//
    @FindBy(xpath = "//*[@for='mcp_db_custom_search_class_0']")
    public WebElement class1;

    //2 class//
    @FindBy(xpath = "//*[@for='mcp_db_custom_search_class_1']")
    public WebElement class2;

    //search//
    @FindBy(xpath = "*//button[@type='submit']")
    public WebElement searchBtn;

    //search//
    @FindBy(xpath = "//*[@id=\"inboundRow\"]")
    public WebElement roudTrip;

    //search//
    @FindBy(xpath = "//*[@id='radiobutton_mcp_db_custom_search_outboundFilterTimeType_0']")
    public WebElement depRadio;

    //search//
    @FindBy(xpath = "//*[@id='radiobutton_mcp_db_custom_search_outboundFilterTimeType_1']")
    public WebElement arrRadio;

    //errrors
    @FindBy(xpath = "//*[@class=\"form__message form__message--error\"]")
    public List<WebElement> errors;

    //infant text message
    @FindBy(xpath = "//*[@class=\"offers__passengers-text\"]")
    public WebElement infantText;

    final String emptyResultsLocator = "*//div[@id='emptyResults']";
    @FindBy(xpath = emptyResultsLocator)
    public WebElement emptyResults;

    @FindBy(xpath = ".//span[@id='empty-card-select-id-button']/span[@class='ui-selectmenu-icon ui-icon ui-icon-triangle-1-s']")
    public WebElement discountCardsDropDownButton;

    @Override
    public void waitLoading() {
        try {
            waitUntilElementNotVisible(defaultSpinner, 180);
            if (isElementPresent(By.xpath(emptyResultsLocator)) && !emptyResults.getAttribute("style").equals("display: none;")) {
                Assert.fail("Connections not found");
            }
        } catch (TimeoutException e) {
            Assert.fail("Search finished without result or not finished in 120 seconds", e);
        }
    }

    @Step("Set From field: {0}")
    public void setFrom(String city) {
        from.sendKeys(city);
        waitElementVisible(autocompleterFrom);
        selectOptionWithText(optionCityWrapper, city);
    }

    @Step("Set To field: {0}")
    public void setTo(String city) {
        to.sendKeys(city);
        waitElementVisible(autocompleterTo);
        selectOptionWithText(optionCityWrapper, city);
    }

    @Step("Activate round trip")
    public void activateRoundTrip() {
        roudTrip.click();
    }

    @Step("Add days to outward date: {0}")
    public void addDaysToOutwardDate(int days) {
        for (int i = 0; i < days; i++) {
            outwardDateUp.click();
        }
    }

    @Step("Set outward date: {0}")
    public void setOutwardDate(String date) {
        outwardDate.click();
        outwardDate.clear();
        outwardDate.sendKeys(date);
        outwardDate.sendKeys(Keys.ENTER);
    }

    @Step("Set invard date: {0}")
    private void setInwardDate(String date) {
        inwardDate.click();
        inwardDate.clear();
        inwardDate.sendKeys(date);
        inwardDate.sendKeys(Keys.ENTER);
    }


    public void addDaysToInwardDate(int days) {
        for (int i = 0; i < days + 1; i++) {
            inwardDateUp.click();
        }
    }

    @Step("Set outward time: {0}")
    public void setOutwardTime(String time) {
        outwardTime.click();
        outwardTime.sendKeys(Keys.END);
        int timeSize = outwardTime.getAttribute("value").length();
        for (int i = 0; i < timeSize; i++) {
            outwardTime.sendKeys(Keys.BACK_SPACE);
        }
        outwardTime.sendKeys(time);
    }

    @Step("Set inward time: {0}")
    public void setInwardTime(String time) {
        inwardTime.click();
        inwardTime.sendKeys(Keys.END);
        int timeSize = inwardTime.getAttribute("value").length();
        for (int i = 0; i < timeSize; i++) {
            inwardTime.sendKeys(Keys.BACK_SPACE);
        }
        inwardTime.sendKeys(time);
    }

    @Step("Set passenger counter: {0}")
    public void setPassengersCounter(String passengersCounter) {
        pasCount.click();
        selectOptionFromDropdown(passengersCounter);
    }

    @Step("Set passenger counter: {0}")
    public void setPassengersCounter(Integer passengersCounter) {
        pasCount.click();
        selectOptionFromDropdown(passengersCounter);
    }

    @Step("Set first passenger birth date: {0}")
    public void setPas1BirthDate(String birthDate) {
        pas1BirthDate.click();
        for (char a : birthDate.toCharArray()) {
            pas1BirthDate.sendKeys(a + "");
        }
        pas1BirthDate.click();
    }

    @Step("Set second passenger birth date: {0}")
    public void setPas2BirthDate(String birthDate) {
        pas2BirthDate.click();
        for (char a : birthDate.toCharArray()) {
            pas2BirthDate.sendKeys(a + "");
        }
        pas2BirthDate.click();
    }

    @Step("Set third passenger birth date: {0}")
    public void setPas3BirthDate(String birthDate) {
        pas3BirthDate.click();
        for (char a : birthDate.toCharArray()) {
            pas3BirthDate.sendKeys(a + "");
        }
        pas3BirthDate.click();
    }

    @Step("Set fourth passenger birth date: {0}")
    public void setPas4BirthDate(String birthDate) {
        pas4BirthDate.click();
        for (char a : birthDate.toCharArray()) {
            pas4BirthDate.sendKeys(a + "");
        }
        pas4BirthDate.click();
    }

    @Step("Set fourth passenger birth date: {0}")
    public void setPas5BirthDate(String birthDate) {
        pas5BirthDate.click();
        for (char a : birthDate.toCharArray()) {
            pas5BirthDate.sendKeys(a + "");
        }
        pas5BirthDate.click();
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

    public void selectOptionFromDropdown(Integer passengersCounter) {
        pasCount.click();
        // Get all of the options
        List<WebElement> options = driver.findElements(By.xpath("//*[@class='ui-menu ui-corner-bottom ui-widget ui-widget-content']/li"));
        // Loop through the options and select the one that matches
        for (WebElement opt : options) {
            Integer counter = Integer.parseInt(opt.getText().replaceAll("\\D+", ""));
            if (counter.equals(passengersCounter)) {
                opt.click();
                break;
            }
        }
    }

    @Step("Click search button")
    public void clickSearchButton() {
        searchBtn.click();
    }

    @Step("Click search button with infant submit")
    public void clickSearchButton(boolean infant) {
        clickSearchButton();
        if (infant) {
            clickSearchButton();
        }
    }

    /**
     * @return boolean for departure option selected in slider
     */
    private boolean getDepOptionSelected() {
        return depRadio.isSelected();
    }

    /**
     * @return boolean for arrival option selected in slider
     */
    private boolean getArrOptionSelected() {
        return arrRadio.isSelected();
    }

    @Step("Set search mode")
    private void setSearchMode(String searchMode) {
        if (searchMode.equals("Dep") && !getDepOptionSelected()) {
            depRadio.click();
        } else if (searchMode.equals("Arr") && !getArrOptionSelected()) {
            arrRadio.click();
        }
    }

    @Step("Set passengers")
    private void setPassengersData(SearchParams searchParams) {
        selectOptionFromDropdown(searchParams.getPassengers().length);
        for (int i = 0; i < searchParams.getPassengers().length; i++) {
            switch (i) {
                case 0:
                    setPas1BirthDate(searchParams.getPassengers()[i].getBirthDate());
                    break;
                case 1:
                    setPas2BirthDate(searchParams.getPassengers()[i].getBirthDate());
                    break;
                case 2:
                    setPas3BirthDate(searchParams.getPassengers()[i].getBirthDate());
                    break;
                case 3:
                    setPas4BirthDate(searchParams.getPassengers()[i].getBirthDate());
                    break;
                case 4:
                    setPas5BirthDate(searchParams.getPassengers()[i].getBirthDate());
                    break;
            }
        }
    }

    @Step("Search: Perform search with params")
    public void makeSearch(SearchParams searchParams) {
        if (searchParams.getStationFrom() != null) setFrom(searchParams.getStationFrom());
        if (searchParams.getStationTo() != null) setTo(searchParams.getStationTo());
        if (searchParams.getOutwardDate() != null) setOutwardDate(searchParams.getOutwardDate());
        if (searchParams.getOutwardTime() != null) setOutwardTime(searchParams.getOutwardTime());
        if (searchParams.isRoundTrip()) {
            activateRoundTrip();
            setInwardDate(searchParams.getInwardDate());
            setInwardTime(searchParams.getInwardTime());
        }
        if (searchParams.getSearchMode() != null) {
            setSearchMode(searchParams.getSearchMode());
        }
        setPassengersData(searchParams);
        clickSearchButton();
        waitLoading();
    }

    @Step("Search: Perform search with params")
    public void choseDiscountCardByVisibleText(String cardTitle) {
        discountCardsDropDownButton.click();
        driver.findElement(By.xpath(".//div[text()='" + cardTitle + "']")).click();
    }


}
