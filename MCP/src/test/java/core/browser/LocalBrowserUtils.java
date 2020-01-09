package core.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by ivanchik on 14.06.17.
 */
public class LocalBrowserUtils {

    private static String pathToPhantomjsDriver, pathToGeckoDriver, pathToChromedriver;


    public WebDriver getLocalChromeDriver() {
        setDriverPath();
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\res\\download");
        ChromeOptions chromeOptions = new ChromeOptions();
        if (!checkOS().contains("windows")) {
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--window-size=1920x1080");
            chromeOptions.addArguments("--ignore-certificate-errors");
        }
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    private static String checkOS() {
        return System.getProperty("os");
    }

    private static void setDriverPath() {
        if (checkOS().contains("windows")) {
            pathToPhantomjsDriver = "res/drivers/phantomjs.exe";
            pathToChromedriver = "res/drivers/chromedriver.exe";
            pathToGeckoDriver = "res/drivers/geckodriver.exe";
        } else {
            pathToPhantomjsDriver = "";
            pathToChromedriver = "/usr/bin/chromedriver";
            pathToGeckoDriver = "";
        }

        System.setProperty("webdriver.gecko.driver", pathToGeckoDriver);
        System.setProperty("phantomjs.binary.path", pathToPhantomjsDriver);
        System.setProperty("webdriver.chrome.driver", pathToChromedriver);
    }
}
