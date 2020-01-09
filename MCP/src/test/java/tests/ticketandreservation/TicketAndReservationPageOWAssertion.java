package tests.ticketandreservation;

import data.Ticket;
import helpers.SearchParams;
import org.testng.annotations.Test;
import pages.blocks.search.Offers;
import tests.BaseTest;

import java.util.List;

import static data.DBlink.ROME_MILAN_OW;
import static data.Passenger.JOHNY;
import static data.Passenger.PAUL;

public class TicketAndReservationPageOWAssertion extends BaseTest {

    String[] passengerBirthDates = new String[]{JOHNY.getBirthDate(), PAUL.getBirthDate()};

    @Test(groups = {"dev", "test", "demo"})
    public void ticketAndReservationOneWayTest() {
        gotoUrl(APP_URL + dBlinkHelper.setupLink(ROME_MILAN_OW));
        welcomePopup.close();
        SearchParams searchParams = setupDefaultSearchParams().withPassengerBirthDates(passengerBirthDates);
        searchPage.makeSearch(searchParams);
        List<Offers> offersResults = searchOffersPage.getOffersResults();
        Offers selectedOffer = searchOffersPage.selectOfferByConditions(offersResults, "Ticket can be exchanged and refunded.", 1);
        upsalePage.clickContinueButton();


        s_assert.assertTrue(ticketAndReservationPage.getTitle().equals("Ticket and reservation"), "wrong title");
        s_assert.assertTrue(ticketAndReservationPage.getTicketTypeBoldName().contains("Paperless ticket (PNR)"), "wrong ticket type");
        s_assert.assertTrue(ticketAndReservationPage.getTicketTypeName().contains("No printing required. Passenger must present the PNR code from ticket booking confirmation together with the personal identification on the train (ID card or passport). Only valid for the passenger stated (and accompanying passengers if applicable), not transferable."), "wrong ticket type description");
        ////////////accomodations block//////////
        Ticket ticket = ticketAndReservationPage.getTicket();
        s_assert.assertTrue(ticket.getTicketTitle().contains("Outward journey"), "outbound tab name");
        s_assert.assertTrue(ticket.getTravelZone().contains("Travel segment 1:"), "Travel segment: not found");
        s_assert.assertTrue(ticket.getReservationTitle().contains("Reservation"), "Reservation not found");
        s_assert.assertTrue(ticket.getReservationInfo().contains("Your reservations is included"), "Your reservations is included not found");
        s_assert.assertTrue(ticket.getReservedTravellersTitle().contains("Reservation for 2 travelers"), "Reservation for 2 travelers not found");
        s_assert.assertTrue(ticket.getTextWarning().contains("We endeavour to reserve your seats automatically so that they are directly next to each other"), "We endeavour to reserve your seats automatically so that they are directly next to each other not found");
//        /////////////your journey section/////////////
        s_assert.assertTrue(ticketAndReservationPage.yourJourneySideBar.getSideBarTitle().equals("Your journey"), "Your journey not found");

        s_assert.assertTrue(ticketAndReservationPage.yourJourneySideBar.getTripInfo().contains("Outward"), "outward not found");
        s_assert.assertTrue(ticketAndReservationPage.yourJourneySideBar.getTripInfo().contains("Milan Main Station"), "Milan Main Station not found");
        s_assert.assertTrue(ticketAndReservationPage.yourJourneySideBar.getTripInfo().contains("Rome Termini"), "Rome Termini not found");
        s_assert.assertTrue(ticketAndReservationPage.yourJourneySideBar.getTripInfo().contains(":"), "dots in time not found");

        s_assert.assertTrue(ticketAndReservationPage.yourJourneySideBar.getDate().contains(ROME_MILAN_OW.getOutwardDate()), "date and time not found");

        s_assert.assertTrue(ticketAndReservationPage.yourJourneySideBar.getTotalPriceTitle().contains("Total"), "total not found");
        s_assert.assertTrue(ticketAndReservationPage.yourJourneySideBar.getTotalPriceAmount().equals(selectedOffer.price), "wrong price");

        s_assert.assertTrue(ticketAndReservationPage.yourJourneySideBar.getPriceToolTip().contains("Price"), "Price  not found");
        s_assert.assertTrue(ticketAndReservationPage.yourJourneySideBar.getTicketContent().contains("Ticket, "), "Ticket, not found");
        s_assert.assertTrue(ticketAndReservationPage.yourJourneySideBar.getTicketContent().contains(". Class"), ". Class  not found");
        s_assert.assertTrue(ticketAndReservationPage.yourJourneySideBar.getTicketContent().contains("2 Passengers"), "2 Passengers  not found");
        s_assert.assertTrue(ticketAndReservationPage.yourJourneySideBar.getPrice().equals(selectedOffer.price), "price should be present");
        ticketAndReservationPage.backButton.click();
        s_assert.assertTrue(upsalePage.upsaleBlock.isDisplayed(), "upsale not found");
        s_assert.assertAll();
    }
}
