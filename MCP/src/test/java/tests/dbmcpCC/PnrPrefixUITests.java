package tests.dbmcpCC;

import data.Connection;
import data.Stations;
import helpers.SearchParams;
import org.testng.annotations.Test;
import pages.blocks.search.Offers;
import tests.BaseTest;

import java.util.List;

import static data.Passenger.JOHNY;
import static helpers.BookingIdHelper.getBookingIdwithoutPrefix;
import static helpers.DateTimeHelper.currentDatePlusNDaysGUI;


public class PnrPrefixUITests extends BaseTest {

    String bookingId;
    String bookingIdPrefix = "MCP-";

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_PNR_Prefix_NVS_MonoSeg_OW_1A() {
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.ZURICH_HB, "1100")
                .withDateOutward(currentDatePlusNDaysGUI(7));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "EC");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Flexpreis", 2);
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.clickContinueButton();
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = paymentPage.getFailedPaymentBookingId(); //returns null if not failed
        if (bookingId == null) {
            bookingId = ticketPage.getBookingId();
        }
        s_assert.assertTrue(bookingId.contains(bookingIdPrefix),
                "BookingId is without prefix on the payment (" + bookingId + ")");

        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        s_assert.assertTrue(refundPage.getBookingId().equals(bookingId),
                "BookingId is wrong on the refund page; "
                        + "payed BookingID: " + bookingId + "; displayed bookingId: " + refundPage.getBookingId());

        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(getBookingIdwithoutPrefix(bookingId, bookingIdPrefix), JOHNY);
        s_assert.assertTrue(refundPage.getBookingId().equals(bookingId),
                "BookingId is wrong on the refund page; "
                        + "payed BookingID: " + bookingId + "; displayed bookingId: " + refundPage.getBookingId());

        if (refundPage.getBookingStatus().equals("Processed")) {
            bookingDetailsPage.clickGetRefundConditionsButton();
            refundConditionsPage.clickGetRefundsButton();
            s_assert.assertTrue(refundPage.getBookingId().equals(bookingId),
                    "BookingId is wrong on the refund page; "
                            + "payed BookingID: " + bookingId + "; displayed bookingId: " + refundPage.getBookingId());
        }

        s_assert.assertAll();

    }


    @Test(groups = {"test", "dev2", "dev"})
    public void UI_PNR_Prefix_NVS_SBB_PAO_OW_1A() {
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.WIEN_CENTRAL, Stations.MARSEILLE, "11:17")
                .withDateOutward(currentDatePlusNDaysGUI(14));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "RJX, IC, LYRIA");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Standard-Ticket", 2);
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.clickContinueButton();
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = paymentPage.getFailedPaymentBookingId(); //returns null if not failed
        if (bookingId == null) {
            bookingId = ticketPage.getBookingId();
        }
        s_assert.assertTrue(bookingId.contains(bookingIdPrefix),
                "BookingId is without prefix on the payment (" + bookingId + ")");

        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        s_assert.assertTrue(refundPage.getBookingId().equals(bookingId),
                "BookingId is wrong on the refund page; "
                        + "payed BookingID: " + bookingId + "; displayed bookingId: " + refundPage.getBookingId());

        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(getBookingIdwithoutPrefix(bookingId, bookingIdPrefix), JOHNY);
        s_assert.assertTrue(refundPage.getBookingId().equals(bookingId),
                "BookingId is wrong on the refund page; "
                        + "payed BookingID: " + bookingId + "; displayed bookingId: " + refundPage.getBookingId());

        if (refundPage.getBookingStatus().equals("Processed")) {
            bookingDetailsPage.clickGetRefundConditionsButton();
            refundConditionsPage.clickGetRefundsButton();
            s_assert.assertTrue(refundPage.getBookingId().equals(bookingId),
                    "BookingId is wrong on the refund page; "
                            + "payed BookingID: " + bookingId + "; displayed bookingId: " + refundPage.getBookingId());
        }
        s_assert.assertAll();
    }

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_PNR_Prefix_NVS_TRE_RT_1A() {
        String[] passengerBirthDates = new String[]{JOHNY.getBirthDate()};
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.VENICE_SL, "10:00")
                .withDateOutward(currentDatePlusNDaysGUI(14)).withRoundTrip(true).withDateInward(currentDatePlusNDaysGUI(15))
                .withInwardTime("14:00").withPassengerBirthDates(passengerBirthDates);
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "EC, FR (Frecciarossa)");
        List<Connection> inwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(inwardConnections, "EC");
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.clickContinueButton();
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickReturnJourneyButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(JOHNY);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = paymentPage.getFailedPaymentBookingId(); //returns null if not failed
        if (bookingId == null) {
            bookingId = ticketPage.getBookingId();
        }
        s_assert.assertTrue(bookingId.contains(bookingIdPrefix),
                "BookingId is without prefix on the payment (" + bookingId + ")");

        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        s_assert.assertTrue(refundPage.getBookingId().equals(bookingId),
                "BookingId is wrong on the refund page; "
                        + "payed BookingID: " + bookingId + "; displayed bookingId: " + refundPage.getBookingId());

        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(getBookingIdwithoutPrefix(bookingId, bookingIdPrefix), JOHNY);
        s_assert.assertTrue(refundPage.getBookingId().equals(bookingId),
                "BookingId is wrong on the refund page; "
                        + "payed BookingID: " + bookingId + "; displayed bookingId: " + refundPage.getBookingId());

        if (refundPage.getBookingStatus().equals("Processed")) {
            bookingDetailsPage.clickGetRefundConditionsButton();
            refundConditionsPage.clickGetRefundsButton();
            s_assert.assertTrue(refundPage.getBookingId().equals(bookingId),
                    "BookingId is wrong on the refund page; "
                            + "payed BookingID: " + bookingId + "; displayed bookingId: " + refundPage.getBookingId());
        }
        s_assert.assertAll();

    }

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_PNR_Prefix_THALYS_OneWay_MultiPax_OW_1A() {
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.PARIS_NORD, Stations.BRUSSELS_SOUTH, "0800")
                .withDateOutward(currentDatePlusNDaysGUI(7));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "THALYS");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Standard Mini", 2);
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.clickContinueButton();
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = paymentPage.getFailedPaymentBookingId(); //returns null if not failed
        if (bookingId == null) {
            bookingId = ticketPage.getBookingId();
        }
        s_assert.assertTrue(bookingId.contains(bookingIdPrefix),
                "BookingId is without prefix on the payment (" + bookingId + ")");

        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        s_assert.assertTrue(refundPage.getBookingId().equals(bookingId),
                "BookingId is wrong on the refund page; "
                        + "payed BookingID: " + bookingId + "; displayed bookingId: " + refundPage.getBookingId());

        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(getBookingIdwithoutPrefix(bookingId, bookingIdPrefix), JOHNY);
        s_assert.assertTrue(refundPage.getBookingId().equals(bookingId),
                "BookingId is wrong on the refund page; "
                        + "payed BookingID: " + bookingId + "; displayed bookingId: " + refundPage.getBookingId());


        s_assert.assertAll();

    }

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_PNR_Prefix_PAO_OneWay_MonoPax_OW_1A() {
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.PARIS_NORD, Stations.ZURICH_HB, "1500")
                .withDateOutward(currentDatePlusNDaysGUI(14));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "LYRIA");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Standard", 2);
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.clickContinueButton();
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = paymentPage.getFailedPaymentBookingId(); //returns null if not failed
        if (bookingId == null) {
            bookingId = ticketPage.getBookingId();
        }
        s_assert.assertTrue(bookingId.contains(bookingIdPrefix),
                "BookingId is without prefix on the payment (" + bookingId + ")");

        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        s_assert.assertTrue(refundPage.getBookingId().equals(bookingId),
                "BookingId is wrong on the refund page; "
                        + "payed BookingID: " + bookingId + "; displayed bookingId: " + refundPage.getBookingId());

        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(getBookingIdwithoutPrefix(bookingId, bookingIdPrefix), JOHNY);
        s_assert.assertTrue(refundPage.getBookingId().equals(bookingId),
                "BookingId is wrong on the refund page; "
                        + "payed BookingID: " + bookingId + "; displayed bookingId: " + refundPage.getBookingId());

        if (refundPage.getBookingStatus().equals("Processed")) {
            bookingDetailsPage.clickGetRefundConditionsButton();
            refundConditionsPage.clickGetRefundsButton();
            s_assert.assertTrue(refundPage.getBookingId().equals(bookingId),
                    "BookingId is wrong on the refund page; "
                            + "payed BookingID: " + bookingId + "; displayed bookingId: " + refundPage.getBookingId());
        }
        s_assert.assertAll();

    }


}
