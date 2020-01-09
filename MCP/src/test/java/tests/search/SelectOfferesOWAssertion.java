package tests.search;

import org.testng.annotations.Test;
import tests.BaseTest;

import static data.DBlink.ROME_MILAN_OW;

public class SelectOfferesOWAssertion extends BaseTest {
    @Test(groups = {"dev", "test", "demo"})
    public void searchRomeMilanDetailsAssertion() {

        gotoUrl(APP_URL + dBlinkHelper.setupLink(ROME_MILAN_OW));

        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        s_assert.assertTrue(searchOffersPage.getElementDisplayedWarningMessage().getText().equals("Please type in the correct birth dates of the travellers in the format DD/MM/YYYY - this is necessary to get the fares for the sections abroad"), "please type in not found");
        searchOffersPage.clickRefreshButton();
        /////////top info///////
        s_assert.assertTrue(searchOffersPage.topInfoOneWay.outwardJourney.getText().equals("Outward journey"), "Outward journey not found");
        s_assert.assertTrue(searchOffersPage.topInfoOneWay.destination.getText().contains("Rome Termini"), "Rome Termini → not found");
        s_assert.assertTrue(searchOffersPage.topInfoOneWay.dateTime.getText().length() > 0, "date not found");
        /////////pas info///////////
        s_assert.assertTrue(searchOffersPage.searchOptions.collapsedPassengerData.getText().contains("Passenger 1,"), "wrong pas info 1");
        s_assert.assertTrue(searchOffersPage.searchOptions.collapsedPassengerData.getText().contains("Birth date 01.05.1988"), "wrong pas info 2");
        s_assert.assertTrue(searchOffersPage.searchOptions.collapsedPassengerData.getText().contains("1st class"), "wrong pas info 3");
        /////check show details button/////
        s_assert.assertTrue(searchOffersPage.showDetails.getText().equals("Show details"), "show details button");
        /////check headers/////
        s_assert.assertTrue(searchOffersPage.journeyHeader.getText().contains("Outward journey:"), "journey header outward");
        s_assert.assertTrue(searchOffersPage.offerTitle.getText().contains("1. class: More space. More comfort. Our recommendation for you."), "offers title outward");
        //////////////offers details headers/////////////
        s_assert.assertTrue(isElementHasProperText("//*[@class='offers__caption _col-md-3 _col-sm-4']", "Product"), "Product header not found");
        s_assert.assertTrue(isElementHasProperText("//*[@class='offers__caption _col-md-3 _col-sm-2']", "Offer"), "Offer header not found");
        s_assert.assertTrue(isElementHasProperText("//*[@class='offers__caption _col-sm-6']", "Conditions"), "Conditions header not found");
        s_assert.assertTrue(isElementHasProperText("//*[@class='offers__caption offers__item-column offers__item-column--small _hidden-xs']", "Price"), "Price header not found");
        ///////////////offers details///////////////////
        s_assert.assertTrue(isElementPresentAndHaveNotNullTextByXpathString("//*[@class='_col-md-3 _col-sm-4 _col-xs-7 _text-left-xs']", ""), "offer details  not found");
        s_assert.assertTrue(isElementContainsProperText("//*[@class='offers__price']", "0 EUR"), "0 EUR price  not found");
        s_assert.assertTrue(searchOffersPage.showConditionDetails.get(0).getText().equals("Show condition details"), "Show condition details button conditions");
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
