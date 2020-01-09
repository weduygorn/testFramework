package tests;

import core.browser.LocalBrowserUtils;
import core.browser.TestListener;
import helpers.FileUtils;
import links.JumpInLink;
import links.JumpOutLink;
import data.Connection;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.CFDPage;
import pages.SbbHomePage;
import pages.TicketShopPage;
import pages.adm.AdminLoginPage;
import pages.adm.SpecialEventPage;
import pages.digitalDataLayer.DigitalData;

import java.lang.reflect.Method;

@Listeners(TestListener.class)
public class BaseTest {

    public WebDriver driver;
    protected SbbHomePage sbbHomePage;
    protected JumpInLink jumpInLink;
    protected JumpOutLink jumpOutLink;
    protected CFDPage cfdPage;
    protected TicketShopPage ticketShopPage;
    protected DigitalData digitalData;
    protected Connection connection;
    protected AdminLoginPage adminLoginPage;
    protected SpecialEventPage specialEventPage;
    protected SoftAssert softAssert;

    @BeforeSuite()
    public void folderOpts() {
        FileUtils.createFolder((System.getProperty("user.dir") + "\\res\\download"));
        FileUtils.cleanFolder((System.getProperty("user.dir") + "\\res\\download"));
    }

    @BeforeClass(alwaysRun = true)
    public void setupDriver() {
        driver = LocalBrowserUtils.getLocalChromeDriver();
    }

    @BeforeMethod(alwaysRun = true)
    public void initPO(Method test) {
        sbbHomePage = new SbbHomePage(driver);
        jumpInLink = new JumpInLink(driver);
        cfdPage = new CFDPage(driver);
        jumpOutLink = new JumpOutLink(driver);
        ticketShopPage = new TicketShopPage(driver);
        digitalData = new DigitalData(driver);
        adminLoginPage = new AdminLoginPage(driver);
        specialEventPage = new SpecialEventPage(driver);
        softAssert = new SoftAssert();
        System.out.println("===Test name: " + test.getName() + "===");
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }


}
