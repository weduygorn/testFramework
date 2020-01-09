package pages;

import data.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.blocks.ticketandreservation.*;
import pages.sideBars.YourJourneySideBar;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by osinskyi on 4/11/2017.
 */
public class TicketAndReservationPage extends BasePage {
    /**
     * Constructor
     *
     * @param driver
     */
    public TicketAndReservationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitLoading() {

    }

    public TicketAndReservationAccomodationsOneWay ticketAndReservationAccomodationsOneWay;
    public TicketAndReservationAccomodationsRoundTrip ticketAndReservationAccomodationsRoundTrip;
    public TicketAndReservationYourJourneyOneWay ticketAndReservationYourJourneyOneWay;
    public TicketAndReservationYourJourneyRoundTrip ticketAndReservationYourJourneyRoundTrip;
    public YourJourneySideBar yourJourneySideBar;
    public Ticket ticket;
    public TicketItem ticketItem;
    ///////////Title//////////////
    @FindBy(xpath = "//*[@class='h2 _top-20']")
    public WebElement title;

    @FindBy(xpath = "//*[@class='ticket-caption__text']/span[@class='_text-bold']")
    public WebElement ticketTypeBoldName;

    ///////////ticket type name//////////////
    @FindBy(xpath = "//*[@class='ticket-caption__text']")
    public WebElement ticketTypeName;

    ////////Back button///////
    @FindBy(xpath = "(//*[text()='Back'])[2]")
    public WebElement backButton;

    ////////Book button///////
    @FindBy(xpath = "//*[text()='Continue']")
    public WebElement continueButton;

    ////////Return journey button///////
    @FindBy(xpath = "//*[text()='Return journey']")
    public WebElement returnJourneyButton;

    public String getTitle() {
        return title.getText();
    }

    public String getTicketTypeBoldName() {
        return ticketTypeBoldName.getText();
    }

    public String getTicketTypeName() {
        return ticketTypeName.getText();
    }


    public String getReservationPriceAmount(int segmentNumber) {
        return ticketAndReservationAccomodationsOneWay.prices.get(segmentNumber).getText();
    }

    public boolean getReservationSelect(int segmentNumber) {
        return ticketAndReservationAccomodationsOneWay.checkBoxes.get(segmentNumber).isSelected();
    }

    public String getReservationText(int segmentNumber) {
        return ticketAndReservationAccomodationsOneWay.reservationText.get(segmentNumber).getText();
    }

    @Step("Ticket&Reservation: Click continue button")
    public void clickContinueButton() {
        continueButton.click();
    }

    @Step("Ticket&Reservation: Click return journey button")
    public void clickReturnJourneyButton() {
        returnJourneyButton.click();
    }

    public void selectCoupeType(String coupeType) {
        selectOptionWithText(ticketAndReservationAccomodationsOneWay.coupeTypesRadio, coupeType);
    }

    public List<String> getCoupeTypeTextArray() {
        List<String> coupeTypesArray = new ArrayList<>();
        for (int i = 0; i < ticketAndReservationAccomodationsOneWay.coupeTypesRadio.size(); i++) {
            coupeTypesArray.add(ticketAndReservationAccomodationsOneWay.coupeTypesRadio.get(i).findElement(By.cssSelector(".radio__text")).getText());
        }
        return coupeTypesArray;
    }

    public List<String> getBerthLevelTextArray() {
        List<String> berthLevelArray = new ArrayList<>();
        for (int i = 0; i < ticketAndReservationAccomodationsOneWay.berthLevelRadio.size(); i++) {
            berthLevelArray.add(ticketAndReservationAccomodationsOneWay.berthLevelRadio.get(i).findElement(By.cssSelector(".radio__text")).getText());
        }
        return berthLevelArray;
    }

    public List<String> getPlaceZonesTextArray() {
        List<String> placeZoneArray = new ArrayList<>();
        for (int i = 0; i < ticketAndReservationAccomodationsOneWay.placeZoneRadio.size(); i++) {
            placeZoneArray.add(ticketAndReservationAccomodationsOneWay.placeZoneRadio.get(i).findElement(By.cssSelector(".radio__text")).getText());
        }
        return placeZoneArray;
    }

    public List<String> getPlacePositionTextArray() {
        List<String> placePositionArray = new ArrayList<>();
        for (int i = 0; i < ticketAndReservationAccomodationsOneWay.placePositionRadio.size(); i++) {
            placePositionArray.add(ticketAndReservationAccomodationsOneWay.placePositionRadio.get(i).findElement(By.cssSelector(".radio__text")).getText());
        }
        return placePositionArray;
    }

    public Ticket getTicket() {
        assert ticketItem != null;
        ticket = new Ticket(getTicketTitle(), getTravelZone(), getReservationTitle(), getReservationInfo(), getReservedTravellersTitle(), getTextWarning());
        return ticket;
    }

    public String getTicketTitle() {
        return driver.findElement(ticketItem.ticketTitleBy).getText();
    }

    public String getTravelZone() {
        return driver.findElement(ticketItem.travelZoneBy).getText();
    }

    public String getReservationTitle() {
        return driver.findElement(ticketItem.reservationTitleBy).getText();
    }

    public String getReservationInfo() {
        return driver.findElement(ticketItem.reservationInfoBy).getText();
    }

    public String getReservedTravellersTitle() {
        return driver.findElement(ticketItem.reservedTravellersTitleBy).getText();
    }

    public String getTextWarning() {
        if (isElementPresent(ticketItem.textWarningBy)) {
            return driver.findElement(ticketItem.textWarningBy).getText();
        }
        return null;
    }
}
