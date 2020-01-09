package pages;

import helpers.Logging;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BasePage implements Logging {


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

    public WebDriverWait getWait(long time) {
        return new WebDriverWait(driver, time);
    }

    /**
     * Wait for element with default delay
     */
    public void waitForElement(WebElement element) {
        timeout(1);
        WebDriverWait wait = new WebDriverWait(driver, 120); //up timelimit because of ACP!!!
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementEnabled(By element) {
        timeout(1);
        WebDriverWait wait = new WebDriverWait(driver, 120); //up timelimit because of ACP!!!
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void waitElementDisable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
    }

    public void waitForTitleIs(String value, int time) {
        getWait(time).until(ExpectedConditions.titleIs(value));
    }

    public void waitForElementVisible(WebElement element, int time) {
        getWait(time).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementVisible(By locator, int time) {
        getWait(time).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementInvisible(By locator, int time) {
        getWait(time).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementNotPresent(WebElement element, int time) {
        System.out.println("PRESENT " + isElementPresent(element));
        getWait(time).until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForAllElementsNotPresent(By locator, int time) {
        getWait(time).until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(locator)));
    }

    public void waitForTextPresenseInElement(WebElement element, String expText, int time) {
        getWait(time).until(ExpectedConditions.textToBePresentInElementValue(element, expText));
    }

    public void navigateBack() {
        driver.navigate().back();
    }


    /**
     * Wait for element with custom delay
     *
     * @param element
     * @param timeout
     */
    public void waitForElementClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForFileDownload(String folderLocation, String fileName) {
        int attempts = 5;
        File folder = new File(folderLocation);
        File[] files = folder.listFiles();
        boolean found = false;
        while (!found && attempts > 0) {
            assert files != null;
            for (File file : files) {
                if (file.getName().contains(fileName) && !file.getName().endsWith(".crdownload")) {
                    LOG.info("$$$ Filename is: " + file.getName());
                    found = true;
                    break;
                }
            }
            attempts--;
            timeout(1);
            files = folder.listFiles();
            LOG.info("$$$ Waiting for file downloading.." + attempts);
        }
    }

    public void waitForLoad(int time) {
        getWait(time).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForPageToLoad(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        int i=0;

        while(i!=10){
            String state = (String)js.executeScript("return document.readyState;");
            System.out.println(state);

            if(state.equals("complete"))
                break;
            else {
                try {
                    wait(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            i++;
        }
        // check for jquery status
        i=0;
        while(i!=10){

            Long d= (Long) js.executeScript("return jQuery.active;");
            System.out.println(d);
            if(d == 0 )
                break;
            else {
                try {
                    wait(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
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
     * @param xpath
     * @return
     */
    public Boolean isElementPresent(String xpath) {
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        return elements.size() > 0;
    }

    /**
     * w/o exception method for element.isDisplayed
     * @param element webElement
     * @return boolean condition
     */
    @Step
    public boolean isElementPresent(WebElement element) {
        boolean res = false;
        try {
            element.isDisplayed();
            res = true;
        } catch (Exception ignored) {
        }
        return res;
    }

    @Step("Assert element {element} contains {text}")
    public boolean isElementContainsText(WebElement element, String text) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            return element.getText().contains(text);
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Assert element {element} has text {text}")
    public boolean isElementPresentAndHaveText(WebElement element, String text) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            return element.getText().equals(text);
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * w/o exception method for element.isDisplayed
     * @param elements list webElement
     * @return boolean condition
     */
    public boolean isFirstElementPresent(List<WebElement> elements) {
        try {
            return elements.size() > 0 && elements.get(0).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }



    /**
     * Sleep for thread
     *
     * @param seconds sec
     */
    public void timeout(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Sleep for thread
     *
     * @param seconds sec
     */
    public static void staticTimeout(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param driver
     * @param timeOutInSeconds
     * @param by
     */
    public boolean clickOnElementIfExists(WebDriver driver, int timeOutInSeconds, By by) {
        boolean isPresent = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).click();
            isPresent = true;
        } catch (Exception e) {
            System.out.println("Element doesn't exist ;)");
        }
        return isPresent;
    }

    /**
     * @param driver
     * @param timeOutInSeconds
     * @param by
     * @return
     */
    public boolean isElementPresent(WebDriver driver, int timeOutInSeconds, By by) {
        boolean isPresent = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(ExpectedConditions.elementToBeClickable(by));
            isPresent = true;
        } catch (Exception e) {
            System.out.println("Element doesn't exist ;)");
        } finally {
            return isPresent;
        }
    }

    /**
     * allure attach text to report
     */
    @Attachment(value = "{0}", type = "text/html")
    public static String attachText(String name, String text) {
        System.out.println(name);
        return text;
    }

    private static byte[] getSampleFile(String fileName) {
        try {
            File file = new File(fileName);
            return Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * allure attach CSV to report
     */
    @Attachment(value = "{0}", type = "text/csv")
    public static byte[] saveCsvAttachment(String name, String filePath) {
        System.out.println(name);
        return getSampleFile(filePath);
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

    /**
     * Find element in elements list and return resulting element list
     *
     * @param webElementList
     * @return
     */
    public static WebElement findElementInArray(List<WebElement> webElementList, By by, WebDriver driver) {
        WebElement result = null;
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        for (WebElement element : webElementList) {
            List<WebElement> temp = element.findElements(by);
            if (temp.size() > 0) result = element;
        }
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        return result;
    }


    public void clickJS(WebElement someButton) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", someButton);
    }

    public void reloadPage() {
        driver.get(driver.getCurrentUrl());
    }

    public void selectOptionWithText(List<WebElement> options, String textToSelect) {
        try {
            for(WebElement option : options){
                if(option.getText().equals(textToSelect)) {
                    option.click();
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }



}
