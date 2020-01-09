package core.browser;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import tests.BaseTest;

import static pages.BasePage.attachCorrId;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult tr) {
        BaseTest baseTest = (BaseTest) tr.getInstance();
        baseTest.makeScreenshot(baseTest.driver, "Success listener on - " + baseTest.driver.getTitle());
        attachCorrId();
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        BaseTest baseTest = (BaseTest) tr.getInstance();
        baseTest.makeScreenshot(baseTest.driver, "Fail listener on - " + baseTest.driver.getTitle());
        attachCorrId();
    }


}