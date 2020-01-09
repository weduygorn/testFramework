package tests.providerscenarios.RAM.MonoInventory;

import data.Connection;
import data.Passenger;
import data.Stations;
import helpers.SearchParams;
import org.testng.annotations.Test;
import pages.blocks.search.Offers;
import ru.yandex.qatools.allure.annotations.Description;
import tests.BaseTest;

import java.util.List;

import static data.Passenger.*;
import static helpers.DateTimeHelper.currentDatePlusNDaysGUI;
import static helpers.DateTimeHelper.currentDatePlusNDaysWeekendGUI;

public class CheckE2EScenarioFlow extends BaseTest {

    String bookingId;

    @Test(groups = {"test", "demo"})
    @Description("001_RAM_E2E_OneWay_MonoPax_MonoSeg_Individual")
    public void RAM_001_OW_RomaTermini_VeniceSantaLucia_1A_0C_Base() {
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.ROME, Stations.VENICE_SL, "09:00")
                .withDateOutward(currentDatePlusNDaysGUI(21));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "FR (Frecciarossa)");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Base", 2);
        upsalePage.selectCompartment("Base", "Standard: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(JOHNY);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }



    @Test(groups = {"test", "demo"})
    @Description("001_RAM_E2E_OneWay_MonoPax_MonoSeg_Individual")
    public void RAM_003_OW_ZürichHb_MilanMainStation_1A_0C_ADULT_STANDARD_1st() {

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.ZURICH_HB, Stations.MILAN, "1500")
                .withDateOutward(currentDatePlusNDaysGUI(28));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "EC");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Adult/standard", 2);
        upsalePage.selectCompartment("Adult/standard", "1st class: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(JOHNY);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "demo"})
    @Description("002_RAM_E2E_OneWay_MultiPax_MonoSeg_Individual")
    public void RAM_005_OW_BolognaCentrale_FirenzeSMN_2A_Economy() {
        Passenger[] passengers = new Passenger[]{JOHNY, JOAN};

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.BOLOGNA, Stations.FIRENZE, "1100")
                .withDateOutward(currentDatePlusNDaysGUI(28)).withPassengers(passengers);
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "FR (Frecciarossa)");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectFirstAvailableOffer(outwardOffersResults);
        upsalePage.selectCompartment("Economy", "Standard: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(passengers);
        passengerDetailsPage.clickContinueButton();
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        s_assert.assertEquals(refundPage.getTotalRefundAmount(), "0,00", "Refund amount wrong");
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Processed"), "Status wrong");
        System.out.println(refundPage.getBookingSubtitle());
        s_assert.assertAll();
    }


    @Test(groups = {"test", "demo"})
    @Description("002_RAM_E2E_OneWay_MultiPax_MonoSeg_Individual")
    public void RAM_007_OW_NiceVille_MilanMainStation_2A_1C_Smart_2nd() {
        Passenger[] passengers = new Passenger[]{JOHNY, JOAN, SAM};
        // TODO: In case 2A_3C - Provider error: The offer is not purchasable for this number of traveler
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.NICE_VILLE, Stations.MILAN, "1400")
                .withDateOutward(currentDatePlusNDaysGUI(21)).withPassengers(passengers);
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "EC");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Smart", 2);
        upsalePage.selectCompartment("Smart", "2nd class: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(passengers);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        s_assert.assertEquals(refundPage.getTotalRefundAmount(), "0,00", "Refund amount wrong");
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Processed"), "Status wrong");
        System.out.println(refundPage.getBookingSubtitle());
        s_assert.assertAll();
    }


    @Test(groups = {"test", "demo"})
    @Description("003_RAM_E2E_OneWay_MultiPax_MonoSeg_Group")
    public void RAM_008_OW_VeronaPortaNuova_MilanMainStation_1A_2C_BimbiGratis() {
        Passenger[] passengers = new Passenger[]{JOHNY, SAM, BOB};

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.VERONA_PN, Stations.MILAN, "1500")
                .withDateOutward(currentDatePlusNDaysGUI(21)).withPassengers(passengers);
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "FR (Frecciarossa)");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Bimbi Gratis", 2);
        upsalePage.selectCompartment("Bimbi Gratis", "Premium: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(passengers);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "demo"})
    @Description("004_RAM_E2E_OneWay_MonoPax_MultiSeg_HighSpeed")
    public void RAM_011_OW_RomaTermini_ReggioDiCalabria_1A_0C_Economy() {

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.ROME, Stations.REGGIO_DC, "1000")
                .withDateOutward(currentDatePlusNDaysGUI(21));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "FR (Frecciarossa), FB (Frecciabianca)");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectFirstAvailableOffer(outwardOffersResults);
        upsalePage.selectCompartment("Economy", "Standard: seat incl.\n" +
                "2nd class: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(JOHNY);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        s_assert.assertEquals(refundPage.getTotalRefundAmount(), "0,00", "Refund amount wrong");
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Processed"), "Status wrong");
        System.out.println(refundPage.getBookingSubtitle());
        s_assert.assertAll();
    }

    @Test(groups = {"test", "demo"})
    @Description("004_RAM_E2E_OneWay_MonoPax_MultiSeg_HighSpeed")
    public void RAM_014_OW_VeronaPortaNuova_ZürichHb_1A_Base_AdultStandard() {

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.VERONA_PN, Stations.ZURICH_HB, "1000")
                .withDateOutward(currentDatePlusNDaysGUI(21));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "FR (Frecciarossa), EC");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectFirstAvailableOffer(outwardOffersResults);
        upsalePage.selectCompartment("Base, Adult/standard", "Standard: seat incl.\n" +
                "2nd class: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.clickContinueButton();
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "demo"})
    @Description("005_RAM_E2E_OneWay_MonoPax_MultiSeg_HighSpeed&Regional")
    public void RAM_015_OW_RomaTermini_ReggioDiCalabria_1A_0C_Base_Ordinaria() {
        String[] passengerBirthDates = new String[]{JOHNY.getBirthDate()};

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.ROME, Stations.REGGIO_DC, "1200")
                .withDateOutward(currentDatePlusNDaysWeekendGUI(21)).withPassengerBirthDates(passengerBirthDates);
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "FA (Frecciargento), IC (Intercity), RE");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Base Ordinaria", 2);
        upsalePage.selectCompartment("Base, Ordinaria", "2nd class: seat incl.\n" +
                "2nd class");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.clickContinueButton();
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "demo"})
    @Description("006_RAM_E2E_OneWay_MultiPax_MultiSeg_HighSpeed")
    public void RAM_025_OW_VeronaPortaNuova_ZürichHb_5A_Base_AdultStandard() {
        Passenger[] passengers = new Passenger[]{JOHNY, JOAN, RON, FRED, ADAM};

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.VERONA_PN, Stations.ZURICH_HB, "0800")
                .withDateOutward(currentDatePlusNDaysGUI(21)).withPassengers(passengers);
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "FR (Frecciarossa), EC");
        searchOffersPage.selectOffer(searchOffersPage.getOffersResults(), "Base Adult/standard", 2);
        upsalePage.selectCompartment("Base, Adult/standard", "Standard: seat incl.\n" +
                "2nd class: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(passengers);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "demo"})
    @Description("007_RAM_E2E_OneWay_MultiPax_MultiSeg_HighSpeed&Regional")
    public void RAM_032_OW_LaSpeziaCentrale_Ravenna_1A_3C_Ordinaria_Base() {
        Passenger[] passengers = new Passenger[]{JOHNY, SAM, BOB, ALEX};

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.LASPEZIA_CENTRALE, Stations.RAVENNA, "1600")
                .withDateOutward(currentDatePlusNDaysGUI(21)).withPassengers(passengers);
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "RE, RV, FR (Frecciarossa)");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Ordinaria Base", 2);
        upsalePage.selectCompartment("Ordinaria, Base", "2nd class\n" +
                "Standard: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(passengers);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "demo"})
    @Description("008_RAM_E2E_RoundTrip_MonoPax_MonoSeg_Individual")
    public void RAM_033_RT_RomaTermini_VeniceSantaLucia_1A_0C_Base_Economy_2nd() {

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.ROME, Stations.VENICE_SL, "0600")
                .withDateOutward(currentDatePlusNDaysGUI(28)).withRoundTrip(true).withDateInward(currentDatePlusNDaysGUI(35))
                .withInwardTime("1200");
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "FR (Frecciarossa)");
        List<Connection> inwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(inwardConnections, "FR (Frecciarossa)");
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.selectCompartment("Base", "Standard: seat incl.");
        upsalePage.clickContinueButton();
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.selectCompartment("Economy", "Business silence\n" +
                "area: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickReturnJourneyButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(JOHNY);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "demo"})
    @Description("008_RAM_E2E_RoundTrip_MonoPax_MonoSeg_Individual")
    public void RAM_036_RT_NiceVille_MilanMainStation_1A_Flexi() {

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.NICE_VILLE, Stations.MILAN, "1400")
                .withDateOutward(currentDatePlusNDaysGUI(28)).withRoundTrip(true).withDateInward(currentDatePlusNDaysGUI(35))
                .withInwardTime("1200");
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "EC");
        List<Connection> inwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(inwardConnections, "EC");
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.selectCompartment("Flexi", "2nd class: seat incl.");
        upsalePage.clickContinueButton();
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.selectCompartment("Flexi", "1st class: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickReturnJourneyButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(JOHNY);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "demo"})
    @Description("009_RAM_E2E_RoundTrip_MultiPax_MonoSeg_Individual")
    public void RAM_038_RT_ZürichHb_MilanMainStation_1A_2C_ADULT_STANDART_1st() {
        Passenger[] passengers = new Passenger[]{JOHNY, ALEX, BOB};

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.ZURICH_HB, Stations.MILAN, "1500")
                .withDateOutward(currentDatePlusNDaysGUI(28)).withRoundTrip(true).withDateInward(currentDatePlusNDaysGUI(35))
                .withInwardTime("1200").withPassengers(passengers);
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "EC");
        List<Connection> inwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(inwardConnections, "EC");
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.selectCompartment("Child, Adult/standard", "1st class: seat incl.");
        upsalePage.clickContinueButton();
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.selectCompartment("Child, Adult/standard", "1st class: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickReturnJourneyButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(passengers);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "demo"})
    @Description("009_RAM_E2E_RoundTrip_MultiPax_MonoSeg_Individual")
    public void RAM_039_RT_NiceVille_MilanMainStation_2A_3C_Smart_1st() {
        Passenger[] passengers = new Passenger[]{JOHNY, JOAN, SAM, BOB, ALEX};

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.NICE_VILLE, Stations.MILAN, "1400")
                .withDateOutward(currentDatePlusNDaysGUI(28)).withRoundTrip(true).withDateInward(currentDatePlusNDaysGUI(35))
                .withInwardTime("1200").withPassengers(passengers);
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "EC");
        List<Connection> inwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(inwardConnections, "EC");
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.selectCompartment("Smart", "1st class: seat incl.");
        upsalePage.clickContinueButton();
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.selectCompartment("Flexi", "1st class: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickReturnJourneyButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(passengers);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }


    @Test(groups = {"test", "demo"})
    @Description("010_RAM_E2E_RoundTrip_MultiPax_MonoSeg_Group")
    public void RAM_040_RT_VeronaPortaNuova_MilanMainStation_1A_2C_BimbiGratis_2nd() {
        Passenger[] passengers = new Passenger[]{JOHNY, ALEX, BOB};

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.VERONA_PN, Stations.MILAN, "1800")
                .withDateOutward(currentDatePlusNDaysGUI(28)).withRoundTrip(true).withDateInward(currentDatePlusNDaysGUI(35))
                .withInwardTime("1200").withPassengers(passengers);
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "FR (Frecciarossa)");
        List<Connection> inwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(inwardConnections, "FR (Frecciarossa)");
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.selectCompartment("Bimbi Gratis", "Business silence\n" +
                "area: seat incl.");
        upsalePage.clickContinueButton();
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.selectCompartment("Bimbi Gratis", "Business silence\n" +
                "area: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickReturnJourneyButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(passengers);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "demo"})
    @Description("010_RAM_E2E_RoundTrip_MultiPax_MonoSeg_Group")
    public void RAM_042_RT_VeronaPortaNuova_VeniceSantaLucia_2A_Speciale2x1() {
        Passenger[] passengers = new Passenger[]{JOHNY, JOAN};

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.VERONA_PN, Stations.VENICE_SL, "1600")
                .withDateOutward(currentDatePlusNDaysWeekendGUI(28)).withRoundTrip(true).withDateInward(currentDatePlusNDaysGUI(35))
                .withInwardTime("2000").withPassengers(passengers);
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "FR (Frecciarossa)");
        List<Connection> inwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(inwardConnections, "FR (Frecciarossa)");
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.selectCompartment("Speciale 2X1", "Standard: seat incl.");
        upsalePage.clickContinueButton();
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.selectCompartment("Super Economy", "Executive: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickReturnJourneyButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(passengers);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        s_assert.assertEquals(refundPage.getTotalRefundAmount(), "0,00", "Refund amount wrong");
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Processed"), "Status wrong");
        System.out.println(refundPage.getBookingSubtitle());
        s_assert.assertAll();
    }


    @Test(groups = {"test", "demo"})
    @Description("011_RAM_E2E_RoundTrip_MonoPax_MultiSeg_HighSpeed")
    public void RAM_045_RT_VeniceSantaLucia_NiceVille_1A_Economy_Flexy() {

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.VENICE_SL, Stations.NICE_VILLE, "0800")
                .withDateOutward(currentDatePlusNDaysGUI(28)).withRoundTrip(true).withDateInward(currentDatePlusNDaysGUI(35))
                .withInwardTime("0800");
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "FR (Frecciarossa), EC");
        List<Connection> inwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(inwardConnections, "EC, FR (Frecciarossa)");
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.selectCompartment("Economy, Flexi", "Standard: seat incl.\n" +
                "2nd class: seat incl.");
        upsalePage.clickContinueButton();
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.selectCompartment("Flexi, Economy", "Executive: seat incl.\n" +
                "1st class: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickReturnJourneyButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(JOHNY);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        s_assert.assertEquals(refundPage.getTotalRefundAmount(), "0,00", "Refund amount wrong");
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Processed"), "Status wrong");
        System.out.println(refundPage.getBookingSubtitle());
        s_assert.assertAll();
    }

    @Test(groups = {"test", "demo"})
    @Description("012_RAM_E2E_RoundTrip_MonoPax_MultiSeg_HighSpeed&Regional")
    public void RAM_053_RT_LaSpeziaCentrale_Ravenna_1A_Base_Ordinaria() {

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.LASPEZIA_CENTRALE, Stations.RAVENNA, "1600")
                .withDateOutward(currentDatePlusNDaysGUI(28)).withRoundTrip(true).withDateInward(currentDatePlusNDaysGUI(35))
                .withInwardTime("1200");
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "RE, RV, FR (Frecciarossa)");
        List<Connection> inwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(inwardConnections, "BU, RE, RV, IC (Intercity)");
        searchOffersPage.selectOffer(searchOffersPage.getOffersResults(), "Ordinaria Base", 2);
        upsalePage.selectCompartment("Ordinaria, Base", "2nd class\n" +
                "Standard: seat incl.");
        upsalePage.clickContinueButton();
        searchOffersPage.selectOffer(searchOffersPage.getOffersResults(), "Ordinaria Base", 2);
        upsalePage.selectCompartment("Ordinaria, Base", "2nd class\n" +
                "1st class: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickReturnJourneyButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(JOHNY);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }


    @Test(groups = {"test", "demo"})
    @Description("013_RAM_E2E_RoundTrip_MultiPax_MultiSeg_HighSpeed")
    public void RAM_057_RT_VeronaPortaNuova_ZurichHB_5A_Base_AdultStandard() {
        Passenger[] passengers = new Passenger[]{JOHNY, JOAN, RON, FRED, ADAM};

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.VERONA_PN, Stations.ZURICH_HB, "0800")
                .withDateOutward(currentDatePlusNDaysGUI(28)).withRoundTrip(true).withDateInward(currentDatePlusNDaysGUI(35))
                .withInwardTime("1100").withPassengers(passengers);
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "FR (Frecciarossa), EC");
        List<Connection> inwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(inwardConnections, "EC, FR (Frecciarossa)");
        searchOffersPage.selectOffer(searchOffersPage.getOffersResults(), "Base Adult/standard", 2);
        upsalePage.selectCompartment("Base, Adult/standard", "Standard: seat incl.\n" +
                "2nd class: seat incl.");
        upsalePage.clickContinueButton();
        searchOffersPage.selectOffer(searchOffersPage.getOffersResults(), "Adult/standard Base", 2);
        upsalePage.selectCompartment("Adult/standard, Base", "1st class: seat incl.\n" +
                "Executive: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickReturnJourneyButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(passengers);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }


    @Test(groups = {"test", "demo"})
    @Description("014_RAM_E2E_RoundTrip_MultiPax_MultiSeg_HighSpeed&Regional")
    public void RAM_064_RT_LaSpeziaCentrale_Ravenna_1A_3С_Base_Ordinaria() {
        Passenger[] passengers = new Passenger[]{JOHNY, SAM, BOB, ALEX};

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.LASPEZIA_CENTRALE, Stations.RAVENNA, "1600")
                .withDateOutward(currentDatePlusNDaysGUI(28)).withRoundTrip(true).withDateInward(currentDatePlusNDaysGUI(35))
                .withInwardTime("1800").withPassengers(passengers);
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "RE, RV, FR (Frecciarossa)");
        List<Connection> inwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(inwardConnections, "RE, FR (Frecciarossa), IC (Intercity)");
        searchOffersPage.selectOffer(searchOffersPage.getOffersResults(), "Ordinaria Base", 2);
        upsalePage.selectCompartment("Ordinaria, Base", "2nd class\n" +
                "Standard: seat incl.");
        upsalePage.clickContinueButton();
        searchOffersPage.selectOffer(searchOffersPage.getOffersResults(), "Ordinaria Base", 2);
        upsalePage.selectCompartment("Ordinaria, Base", "2nd class\n" +
                "Executive: seat incl.\n" +
                "1st class: seat incl.");
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickReturnJourneyButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(passengers);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        paymentPage.selectPaymentType("CreditCard");
        paymentPage.fillPayDataAndBuyByCreditCard();
        bookingId = ticketPage.getBookingId();
        gotoUrl(APP_URL + URL_RETRIEVE);
        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
        bookingDetailsPage.clickGetRefundConditionsButton();
        refundConditionsPage.clickGetRefundsButton();
        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }


}
