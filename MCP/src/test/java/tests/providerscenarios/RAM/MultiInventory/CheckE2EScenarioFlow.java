package tests.providerscenarios.RAM.MultiInventory;

import org.testng.annotations.Test;
import pages.blocks.search.Offers;
import ru.yandex.qatools.allure.annotations.Description;
import tests.BaseTest;

import java.util.List;

import static data.DBlink.VIENNA_SIENA_OW;
import static data.Passenger.JOHNY;

public class CheckE2EScenarioFlow extends BaseTest {

    String bookingId;

    @Test(groups = {"test", "demo"})
    @Description("")
    public void OBB_RAM_065_E2E_OW_1A_0C_MultiSeg_Vienna_Siena() {
        gotoUrl(APP_URL + dBlinkHelper.setupLink(VIENNA_SIENA_OW));
        welcomePopup.close();
        searchOffersPage.setPasOneBirthDate(ADULT_BIRTH_DATE);
        searchOffersPage.clickRefreshButton();
        List<Offers> offersResults = searchOffersPage.getOffersResults();
        searchOffersPage.selectFirstAvailableOffer(offersResults);
        upsalePage.clickContinueButton();
        ticketAndReservationPage.clickContinueButton();
        passengerDetailsPage.fillPaxDataAndBook(JOHNY);
        checkAndBookPage.agreeWithTermsAndConditions();
        checkAndBookPage.clickProceedToPayment();
        // TODO: Uncomment after ticketing will be working for multiinventory
//        paymentPage.selectPaymentType("CreditCard");
//        paymentPage.fillPayDataAndBuyByCreditCard();
//        bookingId = ticketPage.getBookingId();
//        gotoUrl(APP_URL + URL_RETRIEVE);
//        retrievePage.retrieveBookingFillAndSubmit(bookingId, JOHNY);
//        bookingDetailsPage.clickGetRefundConditionsButton();
//        refundConditionsPage.clickGetRefundsButton();
//        s_assert.assertTrue(refundPage.getBookingStatus().equals("Cancelled"), "Status wrong");
//        s_assert.assertTrue(refundPage.getBookingSubtitle().contains("Your booking " + bookingId + " has been successfully refunded"), "Subtitle wrong");
        s_assert.assertAll();
    }


}
