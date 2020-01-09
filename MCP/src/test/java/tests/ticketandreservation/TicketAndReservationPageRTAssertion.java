package tests.ticketandreservation;

import helpers.SearchParams;
import org.testng.annotations.Test;
import pages.blocks.search.Offers;
import tests.BaseTest;

import java.util.List;

import static data.DBlink.ROME_MILAN_RT;

public class TicketAndReservationPageRTAssertion extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void ticketAndReservationRTTest() {
        gotoUrl(APP_URL + dBlinkHelper.setupLink(ROME_MILAN_RT));
        welcomePopup.close();
        SearchParams searchParams = setupDefaultSearchParams();
        searchPage.makeSearch(searchParams);

        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        Offers outwardOffer = searchOffersPage.selectFirstAvailableOffer(outwardOffersResults);
        upsalePage.clickContinueButton();
        List<Offers> returnOffersResults = searchOffersPage.getOffersResults();
        Offers returnOffer = searchOffersPage.selectFirstAvailableOffer(returnOffersResults);
        upsalePage.clickContinueButton();

        System.out.println(outwardOffer.price);
        System.out.println(returnOffer.price);

        System.out.println(outwardOffer.price + returnOffer.price);
        System.out.println(ticketAndReservationPage.yourJourneySideBar.getTotalPriceAmount());
//        String priceOutward = getTextByXpath(searchOffersPage.price);
//        priceOutward=priceOutward.replaceAll(" EUR","");
//        searchOffersPage.returnJourneys.get(0).click();
//        upsalePage.waitForElement( upsalePage.continueButton);
//        upsalePage.continueButton.click();
//        String priceReturn= getTextByXpath(searchOffersPage.price);
//        priceReturn=priceReturn.replaceAll(" EUR","");
//        String total=Float.valueOf(priceOutward.replaceAll(",","."))+Float.valueOf(priceReturn.replaceAll(",","."))+"";
//        searchOffersPage.continueButton.get(0).click();
//        upsalePage.continueButton.click();
        s_assert.assertTrue(ticketAndReservationPage.title.getText().equals("Ticket and reservation"), "wrong title");

        s_assert.assertTrue(ticketAndReservationPage.ticketTypeBoldName.getText().contains("Paperless ticket (PNR)"), "wrong ticket type");
        s_assert.assertTrue(ticketAndReservationPage.ticketTypeName.getText().contains("No printing required. Passenger must present the PNR code from ticket booking confirmation together with the personal identification on the train (ID card or passport). Only valid for the passenger stated (and accompanying passengers if applicable), not transferable."), "wrong ticket type description");

        ////////////accomodations block outbound//////////
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsRoundTrip.tab.getText().contains("Outward journey"), "outward tab name");
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsRoundTrip.travelZoneOutward.getText().contains("Travel segment 1:"), "Travel segment: not found outward");
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsRoundTrip.getText().contains("Reservation"), "Reservation not found outward");
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsRoundTrip.getText().contains("Your reservation is included"), "Your reservation is included not found outward");
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsRoundTrip.getText().contains("Reservation for 1 traveler"), "Reservation for 1 traveler now not found outward");
        ////////////accomodations block inbound//////////
        ticketAndReservationPage.returnJourneyButton.click();
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsRoundTrip.tab.getText().contains("Return journey"), "return tab name");
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsRoundTrip.getText().contains("Travel segment 1:"), "Travel segment: not found return");
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsRoundTrip.getText().contains("Reservation"), "Reservation not found return");
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsRoundTrip.getText().contains("Your reservation is included"), "Your reservation is included not found return");
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsRoundTrip.getText().contains("Reservation for 1 traveler"), "Reservation for 1 traveler not found return");
        s_assert.assertFalse(ticketAndReservationPage.ticketAndReservationAccomodationsRoundTrip.getText().contains("We endeavour to reserve your seats automatically so that they are directly next to each other"), "We endeavour to reserve your seats automatically so that they are directly next to each other not found");
        /////////////your journey section/////////////
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationYourJourneyRoundTrip.title.getText().equals("Your journey"), "Your journey not found");
        String bodyText = ticketAndReservationPage.ticketAndReservationYourJourneyRoundTrip.body.getText();
        s_assert.assertTrue(bodyText.contains("Outward"), "Outbound not found");
        s_assert.assertTrue(bodyText.contains("Return"), "Outbound not found");
        s_assert.assertTrue(bodyText.contains("Milan Main Station"), "Milan Main Station not found");
        s_assert.assertTrue(bodyText.contains("Rome Termini"), "Rome Termini not found");
        s_assert.assertTrue(bodyText.contains(":"), ": not found");
        //s_assert.assertTrue(bodyText.contains(currentDatePlusNDaysNotWeekendGUI(numberOfDaysOutward)),"date and time not found1");
        //s_assert.assertTrue(bodyText.contains(currentDatePlusNDaysNotWeekendGUI(numberOfDaysInward)),"date and time not found2");
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationYourJourneyRoundTrip.footer.getText().contains("Total"), "total not found");
//        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationYourJourneyRoundTrip.footer.getText().contains(total.replaceAll("\\.",",")),"wrong price");
        String bodyTextPart2 = ticketAndReservationPage.ticketAndReservationYourJourneyRoundTrip.bodyPart2.getText();
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationYourJourneyRoundTrip.getText().contains("Price"), "Price  not found");
        s_assert.assertTrue(bodyTextPart2.contains("Ticket"), "Ticket  not found");
        s_assert.assertTrue(bodyTextPart2.contains(". Class"), ". Class  not found");
        s_assert.assertTrue(bodyTextPart2.contains("Outward"), ". Outward  not found");
        s_assert.assertTrue(bodyTextPart2.contains("Return"), ". Return  not found");
        s_assert.assertTrue(bodyTextPart2.contains("1 Passenger"), "1 Passenger  not found");
//        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationYourJourneyRoundTrip.getText().contains(total.replaceAll("\\.",",")),"total should be present");
        ticketAndReservationPage.backButton.click();
        s_assert.assertTrue(ticketAndReservationPage.ticketAndReservationAccomodationsRoundTrip.tab.getText().contains("Outward journey"), "outward tab name");
        s_assert.assertAll();
    }
}
