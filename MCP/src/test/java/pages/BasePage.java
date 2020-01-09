package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by osinskyi on 3/28/2017.
 */
public abstract class BasePage {


    @FindBy(css = "#correlation-id-block")
    public static WebElement corrId;

    public By defaultSpinner = By.cssSelector(".spinner");

    /**
     * Define WebDriver
     */
    public WebDriver driver;

    /**
     * Constructor
     *
     * @param driver
     */
    public BasePage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
    }

    public abstract void waitLoading();

    public static void attachCorrId() {
        if (isElementPresent(BasePage.corrId)) {
            attachText("CorrId", BasePage.corrId.getAttribute("textContent"));
        } else {
            System.out.println("CorrId not present");
        }
    }

    /**
     * allure attach text to report
     */
    @Attachment(value = "{0}", type = "text/html")
    public static String attachText(String name, String text) {
        return text;
    }

    /**
     * Wait for element with default delay
     */
    public void waitForElement(WebElement element) {
        timeout(2);
        WebDriverWait wait = new WebDriverWait(driver, 100); //up timelimit because of ACP!!!
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementEnabled(By locator) {
        timeout(1);
        WebDriverWait wait = new WebDriverWait(driver, 100); //up timelimit because of ACP!!!
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitElementDisable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until((ExpectedConditions.invisibilityOf(element)));
    }

    public void waitUntilElementVisible(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilElementNotVisible(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitElementNotPresense(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(locator)));
    }


    public void waitElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementVisible(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForTextPresent(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    /**
     * Wait for element with custom delay
     *
     * @param element
     * @param timeout
     */
    public void waitForElement(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForTextPresense(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public void selectOptionWithText(List<WebElement> options, String textToSelect) {
        try {
            for (WebElement option : options) {
                if (option.getText().equals(textToSelect)) {
                    option.click();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }


    /**
     * Get driver
     *
     * @return
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Get current URL of the page
     *
     * @return
     */
    public String pageUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Check if some element presents on the page
     *
     * @param by
     * @return
     */
    public Boolean isElementPresent(By by) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        List<WebElement> elements = driver.findElements(by);
        return elements.size() > 0;
    }

    /**
     * w/o exception method for element.isDisplayed
     *
     * @param element webElement
     * @return boolean condition
     */
    @Step
    public static boolean isElementPresent(WebElement element) {
        boolean res = false;
        try {
            element.isDisplayed();
            res = true;
        } catch (Exception ignored) {
        }
        return res;
    }


    public static boolean isElementPresent(List<WebElement> element) {
        try {
            return element.size() > 0;
        } catch (Exception ignored) {
        }
        return false;
    }


    public boolean isElementVisible(By by) {
        try {
            if (driver.findElement(by).isDisplayed()) {
                System.out.println("DISP");
                return true;
            }
        } catch (Exception e) {
            System.out.println("NOT DISP");
            return false;
        }

        return false;
    }


    /**
     * Sleep for thread
     *
     * @param i sec
     */
    public void timeout(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Sleep for thread
     *
     * @param i sec
     */
    public static void staticTimeout(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Chek element exists and clik on it
     *
     * @param driver
     * @param by
     */
    public static void clickOnElementIfExists(WebDriver driver, By by) {
        if (driver.findElements(by).size() != 0) {
            driver.findElement(by).click();
        }

    }

    /**
     * Click on el by JavaScript
     *
     * @param driver
     * @param id
     */
    public static void JSclickOnElementById(WebDriver driver, String id) {

        ((JavascriptExecutor) driver)
                .executeScript("document.getElementById('" + id + "').click();");
    }

    public void clickJS(WebElement someButton) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", someButton);
    }


    /**
     * Find element in elements list and return resulting element list
     *
     * @param webElementList
     * @return
     */
    public static List<WebElement> findElementsInArray(List<WebElement> webElementList, By by, WebDriver driver) {
        List<WebElement> resultList = new ArrayList<>();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        for (WebElement element : webElementList) {
            List<WebElement> temp = element.findElements(by);
            if (temp.size() > 0) resultList.add(element);
        }
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        return resultList;
    }

    public void waitForSpinnerDisable() {
        WebDriverWait wait = new WebDriverWait(driver, 90);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                int elementCount = driver.findElements(By.cssSelector(".spinner")).size();
                System.out.println(elementCount);
                if (elementCount == 0)
                    return true;
                else
                    return false;
            }
        });
    }

}
