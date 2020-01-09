package tests.search;

import org.testng.annotations.Test;
import tests.BaseTest;

import static data.DBlink.ROME_MILAN_RT;

public class SelectOffersRTAssertions extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void searchRomeMilanDetailsAssertionRT() {

        gotoUrl(APP_URL + dBlinkHelper.setupLink(ROME_MILAN_RT));
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        /////////top info///////
        s_assert.assertTrue(searchOffersPage.topInfoRoundTrip.outwardJourney.getText().equals("Outward journey"), "outward top journey not found");
        s_assert.assertTrue(searchOffersPage.topInfoRoundTrip.destinationOutward.getText().contains("Rome Termini"), "Roma Termini →  not found");
        s_assert.assertTrue(searchOffersPage.topInfoRoundTrip.dateTimeOutward.getText().length() > 0, " inward date not found");
        s_assert.assertTrue(searchOffersPage.topInfoRoundTrip.returnJourney.getText().equals("Return journey"), "inward journey not found");
        s_assert.assertTrue(searchOffersPage.topInfoRoundTrip.destinationReturn.getText().contains("Rome Termini"), "Rome Termini not found");
        s_assert.assertTrue(searchOffersPage.topInfoRoundTrip.dateTimeReturn.getText().length() > 0, "outward date not found");
        /////////pas info///////////
        s_assert.assertTrue(searchOffersPage.searchOptions.collapsedPassengerDataRT.getText().contains("Passenger 1"), "wrong pas info1");
        s_assert.assertTrue(searchOffersPage.searchOptions.collapsedPassengerDataRT.getText().contains("Birth date 01.05.1988"), "wrong pas info2");
        s_assert.assertTrue(searchOffersPage.searchOptions.collapsedPassengerDataRT.getText().contains("2nd class"), "wrong pas info3");
        ///////outward show details//////////
        s_assert.assertTrue(searchOffersPage.showDetails.getText().equals("Show details"), "show details  not found");
        /////check headers/////
        s_assert.assertTrue(searchOffersPage.offerTitle.getText().contains("1. class: More space. More comfort. Our recommendation for you.") || searchOffersPage.offerTitle.getText().contains("2. class"), "offers title outward");
        s_assert.assertTrue(searchOffersPage.journeyHeader.getText().contains("Outward journey:"), "journey header outward");
        //////////////offers details headers/////////////
        s_assert.assertTrue(isElementHasProperText("//*[@class='offers__caption _col-md-3 _col-sm-4']", "Product"), "Product header not found");
        s_assert.assertTrue(isElementHasProperText("//*[@class='offers__caption _col-md-3 _col-sm-2']", "Offer"), "Offer header not found");
        s_assert.assertTrue(isElementHasProperText("//*[@class='offers__caption _col-sm-6']", "Conditions"), "Conditions header not found");
        s_assert.assertTrue(isElementHasProperText("//*[@class='offers__caption offers__item-column offers__item-column--small _hidden-xs']", "Price"), "Price header not found");
        ///////////////offers details///////////////////
        s_assert.assertTrue(isElementPresentAndHaveNotNullTextByXpathString("//*[@class='_col-md-3 _col-sm-4 _col-xs-7 _text-left-xs']", ""), "offer details1  not found");
        s_assert.assertTrue(isElementContainsProperText("//*[@class='offers__price']", "0 EUR"), "0 EUR price  not found");
        s_assert.assertTrue(searchOffersPage.showConditionDetails.get(0).getText().equals("Show condition details"), "Show condition details button");
        /////////////////////////////////   return journey block////////////////////////////////////////////////////////
        searchOffersPage.returnJourneys.get(0).click();
        String upsaleBlock = upsalePage.upsaleBlock.getText();
        s_assert.assertTrue(upsaleBlock.contains("Travel segment "), "upsale_assert1");
        s_assert.assertTrue(upsaleBlock.contains("Non-flex"), "upsale_assert2");
        s_assert.assertTrue(upsaleBlock.contains("Semi-flex"), "upsale_assert3");
        s_assert.assertTrue(upsaleBlock.contains("Flexible"), "upsale_assert4");
        upsalePage.continueButton.click();
        ///////inward show details//////////
        s_assert.assertTrue(searchOffersPage.showDetails.getText().equals("Show details"), "show details  not found");
        /////check headers/////
        s_assert.assertTrue(searchOffersPage.journeyHeader.getText().contains("Return journey:"), "journey header inward");
        s_assert.assertTrue(searchOffersPage.offerTitle.getText().contains("1. class: More space. More comfort. Our recommendation for you.") || searchOffersPage.offerTitle.getText().contains("2. class"), "offers title outward");
        //////////////offers details headers/////////////
        s_assert.assertTrue(isElementHasProperText("//*[@class='offers__caption _col-md-3 _col-sm-4']", "Product"), "Product header not found");
        s_assert.assertTrue(isElementHasProperText("//*[@class='offers__caption _col-md-3 _col-sm-2']", "Offer"), "Offer header not found");
        s_assert.assertTrue(isElementHasProperText("//*[@class='offers__caption _col-sm-6']", "Conditions"), "Conditions header not found");
        s_assert.assertTrue(isElementHasProperText("//*[@class='offers__caption offers__item-column offers__item-column--small _hidden-xs']", "Price"), "Price header not found");
        ///////////////offers details///////////////////
        s_assert.assertTrue(isElementPresentAndHaveNotNullTextByXpathString("//*[@class='_col-md-3 _col-sm-4 _col-xs-7 _text-left-xs']", ""), " offer details2 not found");
        s_assert.assertTrue(isElementContainsProperText("//*[@class='offers__price']", "0 EUR"), "0 EUR price  not found");
        s_assert.assertTrue(searchOffersPage.showConditionDetails.get(0).getText().equals("Show condition details"), "Show condition details inward");
        ///////////////frequent questions section///////////////
        s_assert.assertTrue(searchOffersPage.frequentQuestionsTitle.getText().equals("Frequent questions"), "frequent questions not found");
        s_assert.assertTrue(searchOffersPage.frequentQuestionsItems.get(0).getText().equals("Which carriers can be found on the booking platform?"), "Which carriers can be found on the booking platform?");
        s_assert.assertTrue(searchOffersPage.frequentQuestionsItems.get(1).getText().equals("How can I book my ticket?"), "How can I book my ticket?");
        ////////////////information section//////////////
        s_assert.assertTrue(searchOffersPage.infoSection.infoTitle.getText().equals("Information for your booking"), "Information for your booking not found");
        String infoText = searchOffersPage.infoSection.getText();
        s_assert.assertTrue(infoText.contains("The price shown includes all entered passengers and all discount cards that can be applied to the offer in accordance with the conditions of carriage."), "The price shown includes all entered passengers and all discount cards that can be applied to the offer in accordance with the conditions of carriage. info section not found");
        s_assert.assertTrue(infoText.contains("You can find the terms and conditions that apply to BahnCard discounts at:"),
                "You can find the terms and conditions that apply to BahnCard discounts at: section not found");
        s_assert.assertTrue(infoText.contains("www.bahn.com/bahncard-en"),
                "www.bahn.com/bahncard-en section not found");
        s_assert.assertTrue(infoText.contains("Please note, that for each selected connection different Train Operating Companies are included. Also check the different conditions and ticket control regulations that apply."), "Please note, that for each selected connection different Train Operating Companies are included. Also check the different conditions and ticket control regulations that apply.  info section not found");
        s_assert.assertTrue(infoText.contains("All information is issued without liability."), "All information is issued without liability. not found");
        s_assert.assertAll();
    }
}
