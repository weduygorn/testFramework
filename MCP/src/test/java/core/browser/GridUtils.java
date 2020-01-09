package core.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 * Created by osinskyi on 3/28/2017.
 */
public class GridUtils {
    private WebDriver driver;

    /**
     * Create remote webdiver with IECapabilities
     *
     * @param hubUrl
     * @return
     */
    public WebDriver getIEDriver(String hubUrl) {
        //connect to grid
        DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
        return driverRegister(capability, hubUrl);
    }

    /**
     * Create remote webdiver with Crome Capabilities
     *
     * @param hubUrl
     * @return
     */
    public WebDriver getChromeDriver(String hubUrl) {
        //connect to grid
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        capability.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        return driverRegister(capability, hubUrl);
    }


    /**
     * Create remote webdiver with Crome Capabilities
     *
     * @param hubUrl
     * @return
     */
    public WebDriver getMobileChromeDriver(String hubUrl) {
        //connect to grid
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "Google Nexus 5");
        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("mobileEmulation", mobileEmulation);
        String[] args = {"--lang=es"};
        chromeOptions.put("args", args);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return driverRegister(capabilities, hubUrl);
    }

    /**
     * Create remote webdiver with Safari Capabilities
     *
     * @param hubUrl
     * @return
     */
    public WebDriver getSafariDriver(String hubUrl) {
        //connect to grid
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setBrowserName("safari");
        return driverRegister(capability, hubUrl);
    }

    /**
     * Create remote webdiver with Firefox Capabilities
     *
     * @param hubUrl
     * @return
     */
    public WebDriver getFirefoxDriver(String hubUrl) {
        //connect to grid
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        return driverRegister(capability, hubUrl);
    }


    /**
     * Register on grid add listener and maximize driver
     *
     * @param capabilities
     * @param hubUrl
     * @return
     */
    private WebDriver driverRegister(DesiredCapabilities capabilities, String hubUrl) {
        try {
            driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //implicity wait
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //add listener
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        EventHandler handler = new EventHandler();
        eventDriver.register(handler);

        return eventDriver;
    }

    /**
     * Get Driver by name
     *
     * @param browserName
     * @return
     */
    public WebDriver getDriverByName(String browserName, String gridUrl) {
        WebDriver driver = null;
        switch (browserName) {
            case "CHROME":
                driver = getChromeDriver(gridUrl);
                break;
            case "FIREFOX":
                driver = getFirefoxDriver(gridUrl);
                break;
            case "IE":
                driver = getIEDriver(gridUrl);
                break;
            case "SAFARI":
                driver = getSafariDriver(gridUrl);
                break;
        }
        return driver;
    }
}
