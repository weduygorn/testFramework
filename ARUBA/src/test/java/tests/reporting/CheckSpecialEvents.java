package tests.reporting;

import core.SpecialEventsReport;
import helpers.AllureAssert;
import helpers.FileDownloadHelper;
import helpers.Logging;
import org.testng.annotations.Test;
import testData.TestDataProvider;
import tests.BaseTest;

import java.io.File;
import java.util.Collections;

import static helpers.DateTimeHelper.getDate;
import static pages.BasePage.attachText;
import static pages.BasePage.saveCsvAttachment;

public class CheckSpecialEvents extends BaseTest implements Logging {

    private static String corrId;

    @Test(groups = {"dev", "test", "demo", "stage"}, dataProvider = "searchByDeparture", dataProviderClass = TestDataProvider.class)
    public void checkCSVreportForCorrID(String originName, String destinationName, String dateValue, String timeValue, String searchMode) {

        sbbHomePage.open();
        sbbHomePage.searchConnection(originName, destinationName, dateValue, timeValue, searchMode);
        sbbHomePage.clickCfdButton();
        corrId = cfdPage.getCorrelationID();
        System.out.println(corrId);
        attachText("CorrId", cfdPage.getCorrelationID());
        LOG.info("JumpInLinkUrl: " + jumpInLink.getJumpInLinkUrl());
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.headingContainer.subheadingFrom), "Subheading 'From' is not present!");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.headingContainer.subheadingTo), "Subheading 'To' is not present!");
        AllureAssert.assertTrue(cfdPage.isElementPresent(cfdPage.headingContainer.subheadingDate), "Subheading 'Date' is not present!");
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(timeValue));
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(dateValue));
        softAssert.assertTrue(cfdPage.getSubheadingDateText().contains(searchMode));
        connection = cfdPage.selectFirstAvailableConnection();
        cfdPage.clickPurchaseButton();
        byte[] downloadedFileInBytes = FileDownloadHelper.downloadFileAsbyte("https://mrp-admin.contentrail.com/special-event-csv?filter%5Bevent%5D=&filter%5BcorrelationId%5D=&filter%5BdateFrom%5D="+getDate("yyyy-MM-dd", "-Month")+"&filter%5BdateTo%5D="+getDate("yyyy-MM-dd", "+1day"));
        File report = FileDownloadHelper.byteArrayToFile(downloadedFileInBytes, System.getProperty("user.dir") +  "\\res\\download\\SpecialEvents.csv");
        saveCsvAttachment("CSV JumpOutReport", report.getAbsolutePath());
        AllureAssert.assertTrue(SpecialEventsReport.csvToList(report.getAbsolutePath()).contains(corrId), "Corr Id is not included in report.");
        softAssert.assertEquals(Collections.frequency(SpecialEventsReport.csvToList(report.getAbsolutePath()), corrId), 1, "Found duplicate Corr ID.");
        softAssert.assertTrue(SpecialEventsReport.getRowWithCorrID(corrId, report.getAbsolutePath()).contains("8507000"), "Origin station code was not as expected.");
        softAssert.assertTrue(SpecialEventsReport.getRowWithCorrID(corrId, report.getAbsolutePath()).contains("8014309"), "Departure station code was not as expected.");
        softAssert.assertAll();
    }

    @Test(groups = {"prod"})
    public void checkCurrentDateExistsInWeeklyReport() {
        byte[] downloadedFileInBytes = FileDownloadHelper.downloadFileAsbyte("https://mrp-admin.contentrail.com/special-event-csv?filter%5Bevent%5D=&filter%5BcorrelationId%5D=&filter%5BdateFrom%5D="+getDate("yyyy-MM-dd", "-Week")+"&filter%5BdateTo%5D="+getDate("yyyy-MM-dd", "+1day"));
        File report = FileDownloadHelper.byteArrayToFile(downloadedFileInBytes, System.getProperty("user.dir") +  "\\res\\download\\SpecialEvents.csv");
        saveCsvAttachment("CSV JumpOutReport", System.getProperty("user.dir") +  "\\res\\download\\SpecialEvents.csv");
        AllureAssert.assertTrue(SpecialEventsReport.csvToList(report.getAbsolutePath()).get(0).contains(getDate("d/M/yyyy", "")), "Current date is not included in report");
        softAssert.assertAll();
    }

}
