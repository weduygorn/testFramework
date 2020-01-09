package tests;

import core.browser.LocalBrowserUtils;
import core.browser.TestListener;
import core.properties.PropertyConfig;
import data.Passenger;
import data.Stations;
import helpers.DBlinkHelper;
import helpers.SearchParams;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;
import pages.*;
import pages.dataLayer.DigitalData;
import pages.modalwindows.WelcomePopup;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.concurrent.TimeUnit;

import static data.Passenger.JOHNY;
import static helpers.DateTimeHelper.currentDatePlusNDaysGUI;

/**
 * Created by osinskyi on 3/28/2017.
 */
@Listeners(TestListener.class)
public abstract class BaseTest {
    public static final String CAPTCHA_CODE = "super_secret_code";
    public static final String TEST_EMAIL = "oleksii.osinskyi@amadeus.com";
    public static final String TEST_PHONE = "123";
    public static final String STREET = "street 7";
    public static final String POSTCODE = "12345";
    public static final String CITY = "kiev";
    public String APP_URL, RESELLER_CODE, RESELLER_USER, PASSWORD, GRID_URL;
    public final String TOKEN_KEY = "Z0pDmg*s&4mDkfU4@afH";
    public final String ADULT_BIRTH_DATE = "01051988";
    public final String CHILD_BIRTH_DATE = "01052011";
    public final String INFANT_BIRTH_DATE = "01052017";
    public static final String CARD_NUMBER = "4166 6766 6766 6746";
    public static final String CARD_HOLDER_NAME = "Test";
    public static final String MONTH_EXP = "October";
    public static final String YEAR_EXP = "2020";
    public static final String CARD_VERIFICATION_NUMBER = "737";
    public static final String PAY_PAL_EMAIL = "personal.testaccount@amadeus.com";
    public static final String PAY_PAL_PASSWORD = "amadeuspaypal2014";
    public final String URL_RETRIEVE = "/ordersearch";
    public final int numberOfDaysOutward = 14;
    public final int numberOfDaysInward = 21;
    protected String RomeMilanOWLink = "/request/C=1&PA[1]=30&PC[1]=0&OB=8300263$8300046$YYYYMMDD0600$YYYYMMDD0855$FRO+9600";
    protected String RomeMilanRTLink = "/request/C=2&PA[1]=30&PC[1]=0&PT[1]=E&OB=8300263$8300046$YYYYMMDDOUT0600$YYYYMMDDOUT0855$ES+9600&IB=8300046$8300263$YYYYMMDDIN0615$YYYYMMDDIN0955$ES+9503";
    protected String MunichRoma = "/request/C=2&PT[1]=E&PC[1]=0&OB=8000261$8300217$YYYYMMDDOUT0934$YYYYMMDDOUT1620$EC+85^8300217$8300263$YYYYMMDDOUT1635$YYYYMMDDOUT1828$ES+9641";
    //    protected String MunichRoma="/request/C=2&PT[1]=E&PC[1]=0&OB=8000261$8300217$YYYYMMDDOUT0851$YYYYMMDDOUT1620$EC+85^8300217$8300263$YYYYMMDDOUT1635$YYYYMMDDOUT1828$FR+9641";
    protected String MunichVerona = "/request/C=2&PA[1]=30&PC[1]=0&PT[1]=E&OB=8000261$8300120$YYYYMMDD1334$YYYYMMDD1858$EC+89";
    protected String BaselSbbBernOWLink = "/request/C=2&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&OB=8500010$8507000$YYYYMMDD1131$YYYYMMDD1224$IC+1069";
    protected String GrazKlagenfurtOWLink = "/request/C=2&PT[1]=E&PC[1]=0&OB=8181512$8197056$YYYYMMDD1230$YYYYMMDD1430$Bus+957";
    protected String GrazKlagenfurtRTLink = "/request/C=2&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&OB=8181512$8197056$YYYYMMDDOUT1230$YYYYMMDDOUT1430$Bus+957&IB=8197056$8181512$YYYYMMDDIN1345$YYYYMMDDIN1545$Bus+956";
    protected String BaselSbbBernRTLink = "/request/C=2&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&OB=8500010$8500218$YYYYMMDDOUT1004$YYYYMMDDOUT1028$IR+2319^8500218$8507000$YYYYMMDDOUT1036$YYYYMMDDOUT1121$IR+2364&IB=8507000$8500218$YYYYMMDDIN1238$YYYYMMDDIN1324$IR+2371^8500218$8500010$YYYYMMDDIN1330$YYYYMMDDIN1355$IR+2320";
    protected String ParisNordBruxellesMidiOWLink = "/request/C=2&PT[1]=E&PC[1]=0&OB=8700014$8800004$YYYYMMDD1146$YYYYMMDD1317$THA+9437";
    protected String ParisNordBruxellesMidiRTLink = "/request/C=2&PT[1]=E&PC[1]=0&OB=8700014$8800004$YYYYMMDDOUT1146$YYYYMMDDOUT1317$THA+9437&IB=8800004$8700014$YYYYMMDDIN1237$YYYYMMDDIN1359$THA+9336";
    protected String LondonParisNordOWlink = "/request/C=2&PT[1]=E&PC[1]=0&OB=7004428$8798014$YYYYMMDD1531$YYYYMMDD1847$EST+9036";
    protected String LondonParisNordRTLink = "/request/C=2&PT[1]=E&PC[1]=0&OB=7004428$8798014$YYYYMMDDOUT1631$YYYYMMDDOUT1947$EST+9040&IB=8798014$7004428$YYYYMMDDIN1303$YYYYMMDDIN1439$EST+9031";
    protected String ParisNiceOWLink = "/request/C=2&PT[1]=E&PC[1]=0&OB=8700012$8700171YYYYMMDD1602$YYYYMMDD2208$TGV+6169";
    protected String ParisNiceRTLink = "/request/C=2&PT[1]=E&PC[1]=0&OB=8700012$8700171$YYYYMMDDOUT1602$YYYYMMDDOUT2208$TGV+6169&IB=8700171$8700012$YYYYMMDDIN1000$YYYYMMDDIN1615$TGV+6074";
    protected String WienLinzOW = "/request/C=2&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&OB=8103000$8100013$YYYYMMDD0930$YYYYMMDD1044$RJX+162";
    protected String FeldkirchVillachOW = "/request/C=2&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&OB=8100197$8100147$YYYYMMDDDEP2245$YYYYMMDDARR0605$EN+40465";
    protected String HamburgWienOW = "/request/C=2&PT[1]=E&PC[1]=0&OB=8002549$8103000$YYYYMMDDDEP2029$YYYYMMDDARR0827$NJ+491";
    protected String BernLausanneOWLink = "/request/C=2&PT[1]=E&PC[1]=0&OB=8507000$8501120$YYYYMMDD0934$YYYYMMDD1040$IC+710";
    protected String ZurichLuganoRTLink = "/request/C=2&PT[1]=E&PC[1]=0&PT[1]=E&PC[1]=0&OB=8503000$8505300$YYYYMMDDOUT0732$YYYYMMDDOUT0948$IC+861&IB=8505300$8503000$YYYYMMDDIN0811$YYYYMMDDIN1028$IC+866";
    //    protected String MunichVerona="/request/C=2&PA[1]=30&PC[1]=0&PT[1]=E&OB=8000261$8300120$YYYYMMDD1311$YYYYMMDD1858$EC+89";

    public WebDriver driver;
    public DBlinkHelper dBlinkHelper;
    public SearchPage searchPage;
    public ConnectionResultPage connectionResultPage;
    public TripSearchTempPage tripSearchTempPage;
    public SearchOffersPage searchOffersPage;
    public TicketAndReservationPage ticketAndReservationPage;
    public PassengerDetailsPage passengerDetailsPage;
    public CheckAndBookPage checkAndBookPage;
    public TicketPageDetailsAssertion ticketPage;
    public PaymentPage paymentPage;
    public PayPalPage payPalPage;
    public UpsalePage upsalePage;
    public RetrievePage retrievePage;
    public BookingDetailsPage bookingDetailsPage;
    public FaqPage faqPage;
    public RefundConditionsPage refundConditionsPage;
    public RefundPage refundPage;
    public WelcomePopup welcomePopup;
    protected DigitalData digitalData;

    public SoftAssert s_assert;

    @BeforeMethod(alwaysRun = true)
    public void setUpDriver() {
        initConstants();
        driver = new LocalBrowserUtils().getLocalChromeDriver();
        welcomePopup = new WelcomePopup(driver);
        dBlinkHelper = new DBlinkHelper();
        tripSearchTempPage = new TripSearchTempPage(driver);
        searchOffersPage = new SearchOffersPage(driver);
        ticketAndReservationPage = new TicketAndReservationPage(driver);
        passengerDetailsPage = new PassengerDetailsPage(driver);
        checkAndBookPage = new CheckAndBookPage(driver);
        paymentPage = new PaymentPage(driver);
        payPalPage = new PayPalPage(driver);
        ticketPage = new TicketPageDetailsAssertion(driver);
        upsalePage = new UpsalePage(driver);
        retrievePage = new RetrievePage(driver);
        bookingDetailsPage = new BookingDetailsPage(driver);
        faqPage = new FaqPage(driver);
        refundConditionsPage = new RefundConditionsPage(driver);
        refundPage = new RefundPage(driver);
        searchPage = new SearchPage(driver);
        connectionResultPage = new ConnectionResultPage(driver);
        digitalData = new DigitalData(driver);
        s_assert = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }

    @Step("Go to url {0}")
    public void gotoUrl(String url) {
        driver.get(url);
    }

    @Step("Go to url {0}")
    public void gotoUrl(DBlinkHelper dBlinkHelper) {
        driver.get(dBlinkHelper.toString());
    }

    @Step("Setup search params")
    public SearchParams setupDefaultSearchParams(String stationFrom, String stationTo, String outwardTime) {
        String[] passengerBirthDates = new String[]{JOHNY.getBirthDate()};
        return new SearchParams()
                .withStationFrom(stationFrom)
                .withStationTo(stationTo)
                .withSearchMode("Dep")
                .withDateOutward(currentDatePlusNDaysGUI(14))
                .withOutwardTime(outwardTime)
                .withPassengerBirthDates(passengerBirthDates);
    }

    @Step("Setup search params")
    public SearchParams setupSearchParams(Stations outward, Stations destination, String outwardTime) {
        Passenger[] passenger = new Passenger[]{JOHNY};

        return new SearchParams()
                .withStationFrom(outward.getName())
                .withStationTo(destination.getName())
                .withSearchMode("Dep")
                .withOutwardTime(outwardTime)
                .withPassengers(passenger);
    }

    @Step("Shopping")
    public void shopping() {

    }

    @Step("Setup search params for deep link: DEP, 1 ADULT")
    public SearchParams setupDefaultSearchParams() {
        String[] passengerBirthDates = new String[]{JOHNY.getBirthDate()};
        return new SearchParams()
                .withPassengerBirthDates(passengerBirthDates);
    }

    @Step("Setup search params: OW, ARR, 1 ADULT")
    public SearchParams setupDefaultSearchParamsWithArrival(String stationFrom, String stationTo, String outwardTime) {
        return setupDefaultSearchParams(stationFrom, stationTo, outwardTime)
                .withSearchMode("Arr");
    }

    @Step("Setup search params: RT, DEP, 1 ADULT")
    public SearchParams setupSearchParamsWithRT(String stationFrom, String stationTo, String outwardTime, String inwardTime) {
        return setupDefaultSearchParams(stationFrom, stationTo, outwardTime)
                .withRoundTrip(true)
                .withDateInward(currentDatePlusNDaysGUI(8))
                .withInwardTime(inwardTime);
    }


    @Step("Setup search params: RT, ARR, 1 ADULT")
    public SearchParams setupSearchParamsWithRTArrival(String stationFrom, String stationTo, String outwardTime, String inwardTime) {
        return setupSearchParamsWithRT(stationFrom, stationTo, outwardTime, inwardTime)
                .withSearchMode("Arr");
    }


    @Step
    public boolean isElementPresentAndHaveNotNullText(WebElement element) {
        boolean res = false;
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            res = element.getText().length() > 0;
            System.out.println(element.getText());
        } catch (Exception e) {
            System.out.println("Element not found or ");
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        return res;
    }


    @Step("Assert element {1} with xpath {0}")
    public boolean isElementPresentAndHaveNotNullTextByXpathString(String xpathString, String msg) {
        boolean res = driver.findElements(By.xpath(xpathString)).size() > 0;
        if (res) res = driver.findElement(By.xpath(xpathString)).getText().length() > 0;
        return res;
    }

    public boolean isElementHasProperText(String xpathString, String msg) {
        String text = driver.findElement(By.xpath(xpathString)).getText();
        return msg.equals(text);
    }

    public boolean isElementContainsProperText(String xpathString, String msg) {
        String text = driver.findElement(By.xpath(xpathString)).getText();
        return text.contains(msg);
    }


    public String getTextByXpath(String xpathString) {
        String text = driver.findElement(By.xpath(xpathString)).getText();
        return text;
    }

    public String secureToken(String url) {
        return "&SECURE_TOKEN=" + org.apache.commons.codec.digest.DigestUtils.sha256Hex(url + TOKEN_KEY);
    }

    @Step
    public void moveMouseToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

    }

    public void initConstants() {
        APP_URL = PropertyConfig.getProperty("site.url");
    }


    /**
     * allure attach screenshot to report
     */
    @Attachment(value = "{1}", type = "image/png")
    public byte[] makeScreenshot(WebDriver driver, String screenShotName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
