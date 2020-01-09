package tests.dbmcpCC;

import data.Connection;
import data.Stations;
import helpers.SearchParams;
import org.testng.annotations.Test;
import pages.blocks.search.Offers;
import tests.BaseTest;

import java.util.List;

import static data.Passenger.JOAN;
import static data.Passenger.JOHNY;
import static helpers.DateTimeHelper.currentDatePlusNDaysGUI;


public class BahnBonusPointsUITests extends BaseTest {


    @Test(groups = {"test", "dev2", "dev"})
    public void UI_BahnBonus_NVS_BC_Business_MonoSeg_OW_1A() {
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.ZURICH_HB, "1200")
                .withDateOutward(currentDatePlusNDaysGUI(7));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "EC");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Flexpreis", 2);
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.collectBahnBonuses("417398962335");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusTittle().equals("Collect BahnBonus points"), "Wrong Tittle");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusToolTipLink().equals("https://www.bahn.de/hilfe/view/pk/en/bahnbonustarife.shtml"),
                "Wrong Bahn Bonus tooltip link");
        s_assert.assertTrue(passengerDetailsPage.isBahnBonusToolTipOpensInNewWindow(),
                "Bahn Bonus tooltip link opens not in new window");
        passengerDetailsPage.clickContinueButton();
        s_assert.assertTrue(checkAndBookPage.checkBahnBonusInscriptionsList("You are collecting BahnBonus loyalty points."),
                "Bahn Bonus inscription is wrong");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_BahnBonus_NVS_NotCollectingBonuses_OW_1A() {
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.ZURICH_HB, "1200")
                .withDateOutward(currentDatePlusNDaysGUI(7));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "EC");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Flexpreis", 2);
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        // passengerDetailsPage.collectBahnBonuses("417398962335");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusTittle().equals("Collect BahnBonus points"), "Wrong Tittle");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusToolTipLink().equals("https://www.bahn.de/hilfe/view/pk/en/bahnbonustarife.shtml"),
                "Wrong Bahn Bonus tooltip link");
        s_assert.assertTrue(passengerDetailsPage.isBahnBonusToolTipOpensInNewWindow(),
                "Bahn Bonus tooltip link opens not in new window");
        passengerDetailsPage.clickContinueButton();
        s_assert.assertAll();
    }

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_BahnBonus_LettersInCardNumber() {
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.ZURICH_HB, "1200")
                .withDateOutward(currentDatePlusNDaysGUI(7));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "EC");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Flexpreis", 2);
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.collectBahnBonuses("qwe");
        passengerDetailsPage.clickBahnBonusCardNumberTittle();
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusErrorsText().contains("The information must be 12 characters long."), "Wrong validation message for the Bahn bonus card number");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusErrorsText().contains("The information must only consist of digits."), "Wrong validation message for the Bahn bonus card number");
        passengerDetailsPage.clickContinueButton();
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusErrorsText().contains("The information must be 12 characters long."),
                "Wrong validation message for the Bahn bonus card number");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusErrorsText().contains("The information must only consist of digits."),
                "Wrong validation message for the Bahn bonus card number");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_BahnBonus_ShortCardNumber() {
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.ZURICH_HB, "1200")
                .withDateOutward(currentDatePlusNDaysGUI(7));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "EC");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Flexpreis", 2);
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.collectBahnBonuses("1234");
        passengerDetailsPage.clickBahnBonusCardNumberTittle();
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusErrorsText().contains("The information must be 12 characters long."), "Wrong validation message for the Bahn bonus card number");
        passengerDetailsPage.clickContinueButton();
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusErrorsText().contains("The information must be 12 characters long."),
                "Wrong validation message for the Bahn bonus card number");
        passengerDetailsPage.clickContinueButton();
        s_assert.assertAll();
    }

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_BahnBonus_Out_of_Range_CardNumber() {
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.ZURICH_HB, "1200")
                .withDateOutward(currentDatePlusNDaysGUI(7));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "EC");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Flexpreis", 2);
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.collectBahnBonuses("418258196139");
        passengerDetailsPage.clickBahnBonusCardNumberTittle();
        passengerDetailsPage.clickContinueButton();
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusErrorsText().contains("This card number is invalid."),
                "Wrong validation message for the Bahn bonus card number");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_BahnBonus_InvalidCheckSum_CardNumber() {
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.ZURICH_HB, "1200")
                .withDateOutward(currentDatePlusNDaysGUI(7));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "EC");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Flexpreis", 2);
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.collectBahnBonuses("417257844445");
        passengerDetailsPage.clickBahnBonusCardNumberTittle();
        passengerDetailsPage.clickContinueButton();
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusErrorsText().contains("This card number is invalid."),
                "Wrong validation message for the Bahn bonus card number");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_BahnBonus_EmptyCardNumber_OW_1A() {
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.ZURICH_HB, "1200")
                .withDateOutward(currentDatePlusNDaysGUI(7));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "EC");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Flexpreis", 2);
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.collectBahnBonuses("");
        passengerDetailsPage.clickBahnBonusCardNumberTittle();
        passengerDetailsPage.clickContinueButton();
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusErrorsText().contains("This value should not be blank. Please enter a card number."),
                "Wrong validation message for the Bahn bonus card number");
        s_assert.assertAll();
    }

//    @Test(groups = {"test", "dev2", "dev"})
//    public void UI_BahnBonus_CardUnknownOnProviderSide() {
//
//            gotoUrl(APP_URL);
//            SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.ZURICH_HB, "1200")
//                .withDateOutward(currentDatePlusNDaysGUI(7));
//            searchPage.makeSearch(searchParams);
//            List<Connections> connections = connectionResultPage.getConnectionResults();
//            connectionResultPage.selectConnectionByTrain(connections, "EC");
//            List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
//            searchOffersPage.selectOffer(outwardOffersResults, "Flexpreis", 2);
//            upsalePage.clickContinueButton();
//            ticketAndReservationPage.clickContinueButton();
//            passengerDetailsPage.fillPas1Data(JOHNY);
//            passengerDetailsPage.collectBahnBonuses("417398962335");
//            passengerDetailsPage.clickBahnBonusCardNumberTittle();
//            passengerDetailsPage.clickContinueButton();
//            s_assert.assertTrue(passengerDetailsPage.getBahnBonusErrorsText().contains("This card number is invalid."),
//                "Wrong validation message for the Bahn bonus card number");
//            s_assert.assertAll();
//    }

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_BahnBonusCardNotSelected_OW_1A() {
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.ZURICH_HB, "1200")
                .withDateOutward(currentDatePlusNDaysGUI(7));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "EC");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Flexpreis", 2);
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusTittle().equals("Collect BahnBonus points"), "Wrong Tittle");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusToolTipLink().equals("https://www.bahn.de/hilfe/view/pk/en/bahnbonustarife.shtml"),
                "Wrong Bahn Bonus tooltip link");
        s_assert.assertTrue(passengerDetailsPage.isBahnBonusToolTipOpensInNewWindow(),
                "Bahn Bonus tooltip link opens not in new window");
        passengerDetailsPage.clickContinueButton();
        s_assert.assertTrue(checkAndBookPage.jOurneyOffersOW.bahnBonusLoyaltypointsInscription.isEmpty(),
                "BahnBonus inscription should be absent");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_BahnBonus_NVS_OBB_MultiSegWithBahnBonus_OW_1A() {
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.VENICE_SL, "1500")
                .withDateOutward(currentDatePlusNDaysGUI(21));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "EC, FR (Frecciarossa)");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectOffer(outwardOffersResults, "Flexpreis", 2);
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.collectBahnBonuses("410078067095");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusTittle().equals("Collect BahnBonus points"), "Wrong Tittle");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusToolTipLink().equals("https://www.bahn.de/hilfe/view/pk/en/bahnbonustarife.shtml"),
                "Wrong Bahn Bonus tooltip link");
        s_assert.assertTrue(passengerDetailsPage.isBahnBonusToolTipOpensInNewWindow(),
                "Bahn Bonus tooltip link opens not in new window");
        passengerDetailsPage.clickContinueButton();
        s_assert.assertTrue(checkAndBookPage.checkBahnBonusInscriptionsList("You are collecting BahnBonus loyalty points."),
                "Bahn Bonus inscription is wrong");
        s_assert.assertAll();
    }

    @dTest(groups = {"test", "dev2", "dev"})
    public void UI_BahnBonus_NVS_SBB_PAO_MultiSegWithBahnBonus_OW_1A() {
        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.WIEN_CENTRAL, Stations.MARSEILLE, "11:17")
                .withDateOutward(currentDatePlusNDaysGUI(14));
        searchPage.makeSearch(searchParams);
        List<Connection> connections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(connections, "RJX, EC, TGV, TGV DUPLEX");
        List<Offers> outwardOffersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectFirstAvailableOffer(outwardOffersResults);
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.collectBahnBonuses("410078067095");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusTittle().equals("Collect BahnBonus points"), "Wrong Tittle");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusToolTipLink().equals("https://www.bahn.de/hilfe/view/pk/en/bahnbonustarife.shtml"),
                "Wrong Bahn Bonus tooltip link");
        s_assert.assertTrue(passengerDetailsPage.isBahnBonusToolTipOpensInNewWindow(),
                "Bahn Bonus tooltip link opens not in new window");
        passengerDetailsPage.clickContinueButton();
        s_assert.assertTrue(checkAndBookPage.checkBahnBonusInscriptionsList("You are collecting BahnBonus loyalty points."),
                "Bahn Bonus inscription is wrong");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_BahnBonus_NVS_BCB_MonoSeg_RT_1A() throws InterruptedException {
        String[] passengerBirthDates = new String[]{JOHNY.getBirthDate()};

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.ZURICH_HB, "1100")
                .withDateOutward(currentDatePlusNDaysGUI(7)).withRoundTrip(true).withDateInward(currentDatePlusNDaysGUI(8))
                .withInwardTime("1100").withPassengerBirthDates(passengerBirthDates);
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "EC");
        List<Connection> inwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(inwardConnections, "EC");
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.clickContinueButton();
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickReturnJourneyButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.collectBahnBonuses("418986019348");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusTittle().equals("Collect BahnBonus points"), "Wrong Tittle");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusToolTipLink().equals("https://www.bahn.de/hilfe/view/pk/en/bahnbonustarife.shtml"),
                "Wrong Bahn Bonus tooltip link");
        s_assert.assertTrue(passengerDetailsPage.isBahnBonusToolTipOpensInNewWindow(),
                "Bahn Bonus tooltip link opens not in new window");
        passengerDetailsPage.clickContinueButton();
        s_assert.assertTrue(checkAndBookPage.checkBahnBonusInscriptionsList("You are collecting BahnBonus loyalty points."),
                "Bahn Bonus inscription is wrong");

        s_assert.assertAll();
    }

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_BahnBonus_NVS_BC100_WithBahnCard25_MonoSeg_RT_1A() {
        String[] passengerBirthDates = new String[]{JOHNY.getBirthDate()};

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.ZURICH_HB, "1100")
                .withDateOutward(currentDatePlusNDaysGUI(7)).withRoundTrip(true).withDateInward(currentDatePlusNDaysGUI(8))
                .withInwardTime("1100").withPassengerBirthDates(passengerBirthDates);
        searchPage.choseDiscountCardByVisibleText("BahnCard 25, 1st class");
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "EC");
        List<Connection> inwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(inwardConnections, "EC");
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.clickContinueButton();
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickReturnJourneyButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.collectBahnBonuses("420684468363");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusTittle().equals("Collect BahnBonus points"), "Wrong Tittle");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusToolTipLink().equals("https://www.bahn.de/hilfe/view/pk/en/bahnbonustarife.shtml"),
                "Wrong Bahn Bonus tooltip link");
        s_assert.assertTrue(passengerDetailsPage.isBahnBonusToolTipOpensInNewWindow(),
                "Bahn Bonus tooltip link opens not in new window");
        passengerDetailsPage.clickContinueButton();
        s_assert.assertTrue(checkAndBookPage.checkBahnBonusInscriptionsList("You are collecting BahnBonus loyalty points."),
                "Bahn Bonus inscription is wrong");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_BahnBonus_NVS_BahnBonusCardNotSelected_MonoSeg_RT_1A() {
        String[] passengerBirthDates = new String[]{JOHNY.getBirthDate()};

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.ZURICH_HB, "1100")
                .withDateOutward(currentDatePlusNDaysGUI(7)).withRoundTrip(true).withDateInward(currentDatePlusNDaysGUI(8))
                .withInwardTime("1100").withPassengerBirthDates(passengerBirthDates);
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "EC");
        List<Connection> inwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(inwardConnections, "EC");
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.clickContinueButton();
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickReturnJourneyButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusTittle().equals("Collect BahnBonus points"), "Wrong Tittle");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusToolTipLink().equals("https://www.bahn.de/hilfe/view/pk/en/bahnbonustarife.shtml"),
                "Wrong Bahn Bonus tooltip link");
        s_assert.assertTrue(passengerDetailsPage.isBahnBonusToolTipOpensInNewWindow(),
                "Bahn Bonus tooltip link opens not in new window");
        passengerDetailsPage.clickContinueButton();
        s_assert.assertTrue(checkAndBookPage.jOurneyOffersOW.bahnBonusLoyaltypointsInscription.isEmpty(),
                "BahnBonus inscription should be absent");
        s_assert.assertAll();
    }

    @Test(groups = {"test", "dev2", "dev"})
    public void UI_BahnBonus_NVS_BC_Jahres_Card_MonoSeg_RT_2A() {
        String[] passengerBirthDates = new String[]{JOHNY.getBirthDate(), JOAN.getBirthDate()};

        gotoUrl(APP_URL);
        SearchParams searchParams = setupSearchParams(Stations.MUNICH, Stations.ZURICH_HB, "1100")
                .withDateOutward(currentDatePlusNDaysGUI(7)).withRoundTrip(true).withDateInward(currentDatePlusNDaysGUI(8))
                .withInwardTime("1100").withPassengerBirthDates(passengerBirthDates);
        searchPage.makeSearch(searchParams);
        List<Connection> outwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(outwardConnections, "EC");
        List<Connection> inwardConnections = connectionResultPage.getConnectionResults();
        connectionResultPage.selectConnectionByTrain(inwardConnections, "EC");
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.clickContinueButton();
        searchOffersPage.selectFirstAvailableOffer(searchOffersPage.getOffersResults());
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickReturnJourneyButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPas1Data(JOHNY);
        passengerDetailsPage.collectBahnBonuses("438972803091");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusTittle().equals("Collect BahnBonus points"), "Wrong Tittle");
        s_assert.assertTrue(passengerDetailsPage.getBahnBonusToolTipLink().equals("https://www.bahn.de/hilfe/view/pk/en/bahnbonustarife.shtml"),
                "Wrong Bahn Bonus tooltip link");
        s_assert.assertTrue(passengerDetailsPage.isBahnBonusToolTipOpensInNewWindow(),
                "Bahn Bonus tooltip link opens not in new window");
        passengerDetailsPage.clickContinueButton();
        s_assert.assertTrue(checkAndBookPage.checkBahnBonusInscriptionsList("You are collecting BahnBonus loyalty points."),
                "Bahn Bonus inscription is wrong");
        s_assert.assertAll();
    }


}
