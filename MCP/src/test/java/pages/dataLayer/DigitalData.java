package pages.dataLayer;

import helpers.GsonUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

import java.util.List;
import java.util.Map;

public class DigitalData extends BasePage {

    /**
     * Constructor
     *
     * @param driver
     */
    public DigitalData(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitLoading() {

    }

    public String getString(String param) {
        return (String) ((JavascriptExecutor) driver).executeScript("return digitalData." + param);
    }

    public int getInt(String param) {
        Object result = ((JavascriptExecutor) driver).executeScript("return digitalData." + param);
        return result instanceof Number ? ((Number) result).intValue() : Integer.parseInt((String) result);
    }

    public long getLong(String param) {
        return (long) ((JavascriptExecutor) driver).executeScript("return digitalData." + param);
    }

    public double getDouble(String param) {
        return (double) ((JavascriptExecutor) driver).executeScript("return digitalData." + param);
    }

    public String getJSON(String param) {
        return GsonUtils.get().toJson((List<String>) ((JavascriptExecutor) driver).executeScript("return digitalData." + param));
    }

    public String getMap(String param) {
        return GsonUtils.get().toJson((Map<String, Object>) ((JavascriptExecutor) driver).executeScript("return digitalData." + param));
    }
}
