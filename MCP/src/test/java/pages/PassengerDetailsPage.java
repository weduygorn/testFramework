package pages;

import data.Passenger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.blocks.pasdetails.BahnBonusCardBlock;
import pages.blocks.pasdetails.PasDetailsYourJourney;
import pages.blocks.pasdetails.PassengersDetails;
import ru.yandex.qatools.allure.annotations.Step;
import tests.BaseTest;

import java.util.List;

/**
 * Created by osinskyi on 4/25/2017.
 */
public class PassengerDetailsPage extends BasePage {
    /**
     * Constructor
     *
     * @param driver
     */
    public PassengerDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitLoading() {

    }

    public PassengersDetails passengersDetails;
    public PasDetailsYourJourney pasDetailsYourJourney;
    public BahnBonusCardBlock bahnBonusCardBlock;

    final String errorCodeMessageLocator = "//div[@id='errorMessage']";

    ///////////PageTitle//////////////
    @FindBy(xpath = "//*[@class='h2 _top-20']")
    public WebElement pageTitle;

    ////////////Please enter your personal data/////////////
    @FindBy(xpath = "//*[@class='payment__title']")
    public WebElement pleaseEnterPersonalDataTitle;

    ////////Back button///////
    @FindBy(xpath = "(//*[text()='Back'])[2]")
    public WebElement backButton;

    ////////Book button///////
    @FindBy(id = "book_request_doBooking")
    public WebElement continueButton;


    @Step("PassengerDetails: Click continue button")
    public void clickContinueButton() {
        waitForElement(continueButton);
        continueButton.click();
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

    @Step("PassengerDetails: Fill 1 pax data {0}")
    public void fillPas1Data(Passenger passenger) {
        passengersDetails.pasOneSalutation.click();
        selectOptionFromDropdown(passenger.getSalutation());
        passengersDetails.pasOneName.sendKeys(passenger.getFirstName());
        passengersDetails.pasOneSurname.sendKeys(passenger.getLastName());
        passengersDetails.pasOneEmail.sendKeys(passenger.getEmail());
        passengersDetails.pasOneStreetNumber.sendKeys(passenger.getStreet());
        passengersDetails.pasOnePostcodeNumber.sendKeys(passenger.getPostcode());
        passengersDetails.pasOneCity.sendKeys(passenger.getCity());
        passengersDetails.pasOnePhone.sendKeys(passenger.getPhone());
    }

    @Step("PassengerDetails: Fill 2 pax data")
    public void fillPas2Data(Passenger passenger) {
        passengersDetails.pasTwoSalutation.click();
        selectOptionFromDropdown(passenger.getSalutation());
        passengersDetails.pasTwoName.sendKeys(passenger.getFirstName());
        passengersDetails.pasTwoSurname.sendKeys(passenger.getLastName());
    }

    @Step("PassengerDetails: Fill 3 pax data")
    public void fillPas3Data(Passenger passenger) {
        passengersDetails.pasThreeSalutation.click();
        selectOptionFromDropdown(passenger.getSalutation());
        passengersDetails.pasThreeName.sendKeys(passenger.getFirstName());
        passengersDetails.pasThreeSurname.sendKeys(passenger.getLastName());
    }

    @Step("PassengerDetails: Fill 4 pax data")
    public void fillPas4Data(Passenger passenger) {
        passengersDetails.pasFourSalutation.click();
        selectOptionFromDropdown(passenger.getSalutation());
        passengersDetails.pasFourName.sendKeys(passenger.getFirstName());
        passengersDetails.pasFourSurname.sendKeys(passenger.getLastName());
    }

    @Step("PassengerDetails: Fill 5 pax data")
    public void fillPas5Data(Passenger passenger) {
        passengersDetails.pasFiveSalutation.click();
        selectOptionFromDropdown(passenger.getSalutation());
        passengersDetails.pasFiveName.sendKeys(passenger.getFirstName());
        passengersDetails.pasFiveSurname.sendKeys(passenger.getLastName());
    }

    @Step("PassengerDetails: Fill 1 pax data")
    public void fillPas1Data() {
        passengersDetails.pasOneSalutation.click();
        selectOptionFromDropdown("Mr");
        passengersDetails.pasOneName.sendKeys("name");
        passengersDetails.pasOneSurname.sendKeys("surname");
        passengersDetails.pasOneEmail.sendKeys(BaseTest.TEST_EMAIL);
        passengersDetails.pasOneStreetNumber.sendKeys(BaseTest.STREET);
        passengersDetails.pasOnePostcodeNumber.sendKeys(BaseTest.POSTCODE);
        passengersDetails.pasOneCity.sendKeys(BaseTest.CITY);
        passengersDetails.pasOnePhone.sendKeys(("123123"));
    }

    @Step("PassengerDetails: Fill 2 pax data")
    public void fillPas2Data() {
        passengersDetails.pasTwoSalutation.click();
        selectOptionFromDropdown("Ms");
        passengersDetails.pasTwoName.sendKeys("nameSec");
        passengersDetails.pasTwoSurname.sendKeys("surnameSec");
    }

    @Step("PassengerDetails: Fill 3 pax data")
    public void fillPas3Data() {
        passengersDetails.pasThreeSalutation.click();
        selectOptionFromDropdown("Ms");
        passengersDetails.pasThreeName.sendKeys("nameThr");
        passengersDetails.pasThreeSurname.sendKeys("surnameThr");
    }

    public String getErrorMessage(int passenger) {
        waitForElement(passengersDetails.errorMessage.get(passenger));
        return passengersDetails.errorMessage.get(passenger).getText();
    }

    public void fillPaxDataAndBook(Passenger passenger) {
        fillPas1Data(passenger);
        clickContinueButton();
        checkBookingIsFinished();
    }

    public void fillPaxDataAndBook(Passenger[] passengers) {
        for (int i = 0; i < passengers.length; i++) {
            switch (i) {
                case 0:
                    fillPas1Data(passengers[i]);
                    break;
                case 1:
                    fillPas2Data(passengers[i]);
                    break;
                case 2:
                    fillPas3Data(passengers[i]);
                    break;
                case 3:
                    fillPas4Data(passengers[i]);
                    break;
                case 4:
                    fillPas5Data(passengers[i]);
                    break;
            }
        }
        clickContinueButton();
        checkBookingIsFinished();
    }

    private void checkBookingIsFinished() {
        if (isElementPresent(By.xpath(errorCodeMessageLocator))) {
            Assert.fail("Booking error");
        }
    }


    @Step("collect Bahn Bonuses")
    public void collectBahnBonuses(String cardNumber) {
        if (bahnBonusCardBlock.cardNumberInput.isDisplayed()) {
            bahnBonusCardBlock.cardNumberInput.clear();
        } else {
            bahnBonusCardBlock.collectBonusCheckBox.click();
        }
        waitElementVisible(bahnBonusCardBlock.cardNumberInput);
        bahnBonusCardBlock.cardNumberInput.sendKeys(cardNumber);
    }

    public String getBahnBonusToolTipLink() {
        return bahnBonusCardBlock.bahnBonusToolTipLink.getAttribute("href");

    }

    public boolean isBahnBonusToolTipOpensInNewWindow() {
        return (bahnBonusCardBlock.bahnBonusToolTipLink.getAttribute("onclick").contains("window.open"));
    }

    public String getBahnBonusErrorsText() {
        return bahnBonusCardBlock.formWithCardErrors.getText();
    }

    public String getBahnBonusTittle() {
        return bahnBonusCardBlock.bahnBonusTitle.getText();
    }

    public void clickBahnBonusCardNumberTittle() {
        bahnBonusCardBlock.cardNumberTittle.click();

    }

}
