package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.blocks.checkyourbooking.DetailedInformation;
import pages.blocks.checkyourbooking.JOurneyOffersOW;
import pages.blocks.checkyourbooking.JourneyOW;
import ru.yandex.qatools.allure.annotations.Step;

public class CheckAndBookPage extends BasePage {
    /**
     * Constructor
     *
     * @param driver
     */
    public CheckAndBookPage(WebDriver driver) {
        super(driver);
    }


    public JourneyOW journeyOW;
    public JOurneyOffersOW jOurneyOffersOW;
    public DetailedInformation detailedInformation;
    ///////////Check your booking title//////////////
    @FindBy(xpath = "//*[@class=\"h2 _top-20\"]")
    public WebElement titleCheckAndBook;

    @FindBy(xpath = "//*[@class=\"confirmation__total-title\"]")
    public WebElement totalAmountToPay;

    @FindBy(xpath = "//*[@class=\"confirmation__total-price\"]")
    public WebElement totalPrice;

    @FindBy(xpath = "//*[@class='btn btn--default']")
    public WebElement cancelBtn;

    @FindBy(xpath = "//*[text()='Proceed to payment']")
    public WebElement proceedToPayment;

    @FindBy(xpath = "//*[text()='Cancel booking']")
    public WebElement cancelBooking;


    @Override
    public void waitLoading() {
        waitUntilElementNotVisible(defaultSpinner, 60);
    }

    @Step("Check&Book: Click cancel booking button")
    public void clickCancelButton() {
        cancelBtn.click();
    }

    @Step("Check&Book: Perform cancel booking")
    public void performCancelBooking() {
        cancelBooking.click();
        waitLoading();
    }

    private boolean getCheckBoxSelected() {
        return detailedInformation.checkBox.isSelected();
    }

    @Step("Check&Book: Agree with terms&conditions")
    public void agreeWithTermsAndConditions() {
        if (!getCheckBoxSelected()) {
            detailedInformation.checkBox.click();
        }
    }

    @Step("Check&Book: Proceed to Payment")
    public void clickProceedToPayment() {

        waitForElement(proceedToPayment);
        proceedToPayment.click();
    }

    public boolean checkBahnBonusInscriptionsList(String inscription) {
        boolean result = false;
        for (int i = 0; i < jOurneyOffersOW.bahnBonusLoyaltypointsInscription.size(); i++) {
            result = jOurneyOffersOW.bahnBonusLoyaltypointsInscription.get(i).getText().contains(inscription);

        }
        return result;

    }


}
