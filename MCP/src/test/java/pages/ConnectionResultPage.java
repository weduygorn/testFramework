package pages;

import data.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.blocks.search.ConnectionHeaders;
import pages.blocks.search.ConnectionsBlock;
import pages.blocks.search.TopInfoOneWay;
import pages.blocks.search.TopInfoRoundTrip;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

public class ConnectionResultPage extends BasePage {

    /**
     * Constructor
     *
     * @param driver
     */
    public ConnectionResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitLoading() {

    }

    public TopInfoOneWay topInfoOneWay;
    public TopInfoRoundTrip topInfoRoundTrip;
    public ConnectionHeaders connectionHeaders;
    public List<ConnectionsBlock> connectionsBlockList;


    @FindBy(xpath = "(//*[@class='total-routes__title'])[2]")
    public WebElement travellersOW;


    @FindBy(xpath = "(//*[@class='total-routes__title'])[3]")
    public WebElement travellersRT;

    @FindBy(xpath = "(//*[@class='total-routes__content'])[2]")
    public WebElement travellersInfoOW;

    @FindBy(xpath = "(//*[@class='total-routes__content'])[3]")
    public WebElement travellersInfoRT;

    @FindBy(xpath = "(//*[@class='btn btn--default'])")
    public WebElement backButton;

    @FindBy(xpath = "(//*[@class='btn btn-primary laterButtonClass'])")
    public WebElement later;

    @FindBy(xpath = "//img[contains(@src, 'laterLoader')]")
    public WebElement laterLoader;

    @FindBy(xpath = "//div[@class='offers-search__item']")
    public List<WebElement> searchResultItem;

    @FindBy(xpath = "(//*[@class='offers-search__title'])")
    public WebElement titleOffers;

    @FindBy(xpath = "(//*[@class='offers-search__item_with_details'])")
    public List<WebElement> allConnections;

    @Step("Click to offer selection button")
    public void clickToOfferSelectionBtn() {
        waitForElement(connectionsBlockList.get(0).toOfferSelection);
        clickJS(connectionsBlockList.get(0).toOfferSelection);
    }

    @Step("Click later button")
    public void clickLaterButton() {
        waitForElement(later);
        later.click();
        waitElementDisable(laterLoader, 20);
    }

    public List<Connection> getConnectionResults() {
        List<Connection> connectionData = new ArrayList<>();
        connectionsBlockList.forEach(conn -> {
            connectionData.add(new Connection(conn));
        });
        return connectionData;
    }

    public Connection getFirstConnection() {
       return getConnectionResults().get(0);
    }

    public void selectFirstConnection() {
        getFirstConnection().toOfferSelection.click();
    }

    @Step("ConnectionsResult: Train(s) {1}")
    public Connection selectConnectionByTrain(List<Connection> conList, String train) {
        for (int i = 0; i < conList.size(); i++) {
            if (conList.get(i).product.equals(train)) {
                conList.get(i).toOfferSelection.click();
                return conList.get(i);

            }
            if (conList.size() == i + 1) {
                Assert.fail("Train(s) not found");

            }
        }
        return null;
    }

}
