package pages.adm;

import core.properties.PropertyConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.io.File;

import static helpers.FileUtils.getFileNameContains;

public class SpecialEventPage extends BasePage {

    @FindBy(xpath = "//input[@name='filter[dateFrom]']")
    private WebElement startDateField;

    @FindBy(xpath = "//input[@name='filter[dateTo]']")
    private WebElement endDateField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(id = "special-event-csv")
    private WebElement specialEventCSV;

    /**
     * Constructor
     *
     * @param driver
     */
    public SpecialEventPage(WebDriver driver) {
        super(driver);
    }

    public SpecialEventPage open() {
        driver.get(PropertyConfig.getProperty("admin.host") + "/special-event");
        return new SpecialEventPage(driver);
    }

    public void setStartDate(String date) {
        startDateField.sendKeys(date);
    }

    public void setEndDate(String date) {
        endDateField.sendKeys(date);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public void clickDownloadReportBtn() {
        specialEventCSV.click();
    }

    public File getCSVReportFile() {
        String downloadPath = System.getProperty("user.dir") +  "\\res\\download\\";
        timeout(5);
        waitForFileDownload(downloadPath,"specialEvents");
        return new File(downloadPath + getFileNameContains(downloadPath, "specialEvents"));
    }
}
