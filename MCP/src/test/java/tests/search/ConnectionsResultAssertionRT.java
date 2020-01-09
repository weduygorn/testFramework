package tests.search;


import helpers.SearchParams;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.testData.TestDataProvider;


public class ConnectionsResultAssertionRT extends BaseTest {

    @Test(groups = {"dev", "test", "demo"}, dataProvider = "RomaTermini_MilanoCentrale", dataProviderClass = TestDataProvider.class)
    public void connectionDetailsAssertionRT(String dep, String arr) {
        gotoUrl(APP_URL);
        s_assert.assertTrue(searchPage.searchTitle.getText().equals("International booking"), "search title");
        SearchParams searchParams = setupSearchParamsWithRT(dep, arr, "0000", "0000");
        searchPage.makeSearch(searchParams);
        //connection result page
        s_assert.assertTrue(connectionResultPage.topInfoOneWay.outwardJourney.getText().equals("Outward journey"), "outward journey");
        s_assert.assertTrue(connectionResultPage.topInfoOneWay.destination.getText().contains(dep), "Roma Termini");
        s_assert.assertTrue(connectionResultPage.topInfoOneWay.destination.getText().contains(arr), "Milano Centrale");
        s_assert.assertTrue(connectionResultPage.topInfoOneWay.dateTime.getText().length() > 10, "date time");
        s_assert.assertTrue(connectionResultPage.travellersRT.getText().equals("Travellers"), "Travellers");
        s_assert.assertTrue(connectionResultPage.travellersInfoRT.getText().contains("Passenger 1"), "Travellers data1");
        s_assert.assertTrue(connectionResultPage.travellersInfoRT.getText().contains("Birth date"), "Travellers data2");
        s_assert.assertTrue(connectionResultPage.travellersInfoRT.getText().contains("2nd class"), "Travellers data3");
        s_assert.assertTrue(connectionResultPage.connectionHeaders.stationStop.getText().equals("Station/Stop"), "Station/Stop");
        s_assert.assertTrue(connectionResultPage.connectionHeaders.time.getText().equals("Time"), "Time");
        s_assert.assertTrue(connectionResultPage.connectionHeaders.duration.getText().equals("Duration"), "Duration");
        s_assert.assertTrue(connectionResultPage.connectionHeaders.changes.getText().equals("Chg."), "chg");
        s_assert.assertTrue(connectionResultPage.connectionHeaders.products.getText().equals("Product"), "Product");
        s_assert.assertTrue(connectionResultPage.connectionHeaders.savingFares.getText().equals("Saving fares"), "Saving fares");
        s_assert.assertTrue(connectionResultPage.connectionHeaders.flexpreis.getText().equals("Flexpreis"), "Flexpreis");

        s_assert.assertTrue(connectionResultPage.getFirstConnection().getStations().contains(dep), "Roma Termini2");
        s_assert.assertTrue(connectionResultPage.getFirstConnection().getStations().contains(arr), "Milano Centrale2");
        s_assert.assertTrue(connectionResultPage.getFirstConnection().getTime().contains(":"), "time");
        s_assert.assertTrue(connectionResultPage.getFirstConnection().getDuration().contains(":"), "duration");
        s_assert.assertTrue(connectionResultPage.getFirstConnection().getChanges().contains("0"), "changes");
        s_assert.assertTrue(connectionResultPage.getFirstConnection().getProduct().contains("FR"), "product");

        s_assert.assertTrue(connectionResultPage.backButton.getText().equals("Change query"), "Change query");
        s_assert.assertTrue(connectionResultPage.later.getText().equals("Later"), "later");
        s_assert.assertTrue(connectionResultPage.getFirstConnection().toOfferSelection.getText().equals("Return journey"), "later");
        connectionResultPage.clickToOfferSelectionBtn();

        s_assert.assertTrue(connectionResultPage.topInfoRoundTrip.outwardJourney.getText().equals("Outward journey"), "outward journey");
        s_assert.assertTrue(connectionResultPage.topInfoRoundTrip.destinationOutward.getText().contains(dep), "Roma Termini out");
        s_assert.assertTrue(connectionResultPage.topInfoRoundTrip.destinationOutward.getText().contains(arr), "Milano Centrale out");

        s_assert.assertTrue(connectionResultPage.topInfoRoundTrip.returnJourney.getText().equals("Return journey"), "return journey");

        s_assert.assertTrue(connectionResultPage.topInfoRoundTrip.destinationOutward.getText().contains(dep), "Roma Termini inv");
        s_assert.assertTrue(connectionResultPage.topInfoRoundTrip.destinationOutward.getText().contains(arr), "Milano Centrale inv");

        s_assert.assertTrue(connectionResultPage.topInfoRoundTrip.dateTimeOutward.getText().length() > 10, "date time out");
        s_assert.assertTrue(connectionResultPage.topInfoRoundTrip.dateTimeReturnConnectionPage.getText().length() > 10, "date time inv");
        s_assert.assertTrue(connectionResultPage.travellersRT.getText().equals("Travellers"), "Travellers");
        s_assert.assertTrue(connectionResultPage.travellersInfoRT.getText().contains("Passenger 1"), "Travellers data1");
        s_assert.assertTrue(connectionResultPage.travellersInfoRT.getText().contains("Birth date"), "Travellers data2");
        s_assert.assertTrue(connectionResultPage.travellersInfoRT.getText().contains("2nd class"), "Travellers data3");
        s_assert.assertTrue(connectionResultPage.connectionHeaders.stationStop.getText().equals("Station/Stop"), "Station/Stop inv");
        s_assert.assertTrue(connectionResultPage.connectionHeaders.time.getText().equals("Time"), "Time inv");
        s_assert.assertTrue(connectionResultPage.connectionHeaders.duration.getText().equals("Duration"), "Duration inv");
        s_assert.assertTrue(connectionResultPage.connectionHeaders.changes.getText().equals("Chg."), "chg inv");
        s_assert.assertTrue(connectionResultPage.connectionHeaders.products.getText().equals("Product"), "Product inv");
        s_assert.assertTrue(connectionResultPage.connectionHeaders.savingFares.getText().equals("Saving fares"), "Saving fares inv");
        s_assert.assertTrue(connectionResultPage.connectionHeaders.flexpreis.getText().equals("Flexpreis"), "Flexpreis inv");

        s_assert.assertTrue(connectionResultPage.getFirstConnection().getStations().contains(dep), "Roma Termini2");
        s_assert.assertTrue(connectionResultPage.getFirstConnection().getStations().contains(arr), "Milano Centrale2");
        s_assert.assertTrue(connectionResultPage.getFirstConnection().getTime().contains(":"), "time");
        s_assert.assertTrue(connectionResultPage.getFirstConnection().getDuration().contains(":"), "duration");
        s_assert.assertTrue(connectionResultPage.getFirstConnection().getChanges().contains("0"), "changes");
        s_assert.assertTrue(connectionResultPage.getFirstConnection().getProduct().contains("FR"), "product");

        s_assert.assertTrue(connectionResultPage.backButton.getText().equals("Back"), "Back button");
        s_assert.assertTrue(connectionResultPage.later.getText().equals("Later"), "later");
        s_assert.assertEquals(connectionResultPage.getFirstConnection().toOfferSelection.getText(), "To offer selection", "To offer selection");
        connectionResultPage.selectFirstConnection();
        s_assert.assertTrue(searchOffersPage.returnJourneys.get(0).isDisplayed());
        s_assert.assertAll();
    }

}
