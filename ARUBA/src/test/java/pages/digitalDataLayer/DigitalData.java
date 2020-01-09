package pages.digitalDataLayer;

import helpers.GsonUtils;
import helpers.Logging;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.List;
import java.util.Map;

public class DigitalData extends BasePage implements Logging {

    /**
     * Constructor
     *
     * @param driver
     */
    public DigitalData(WebDriver driver) {
        super(driver);
    }

    public String get(String param) {
        return (String) ((JavascriptExecutor) driver).executeScript("return digitalData." + param);
    }

    public String getJSON(String param) {
        return GsonUtils.get().toJson((List<String>)((JavascriptExecutor) driver).executeScript("return digitalData." + param));
    }

    public String getMap(String param) {
        return GsonUtils.get().toJson((Map<String, Object>) ((JavascriptExecutor) driver).executeScript("return digitalData." + param));
    }
}
