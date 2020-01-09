package core.browser;

import helpers.Logging;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;
import tests.BaseTest;

public class TestListener extends TestListenerAdapter implements Logging {

    @Override
    public void onTestFailure(ITestResult tr) {
        BaseTest baseTest = (BaseTest) tr.getInstance();
        zoomInZoomOut(baseTest.driver, "80%");
        makeScreenshot(baseTest.driver, "Fail listener on - " + baseTest.driver.getTitle());
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        BaseTest baseTest = (BaseTest) tr.getInstance();
        zoomInZoomOut(baseTest.driver, "80%");
        makeScreenshot(baseTest.driver, "Success listener on - " + baseTest.driver.getTitle());
    }

    /**
     * allure attach screenshot to report
     */
    @Attachment(value = "{1}", type = "image/png")
    private byte[] makeScreenshot(WebDriver driver, String screenShotName) {
       return  ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void zoomInZoomOut(WebDriver driver, String value){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='" + value +"'");
    }

}