package pages.blocks.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static helpers.CurrencyHelper.toDouble;

public class Offers {

    public Integer offerClass;
    public String product;
    public String offer;
    public String conditions;
    public Double price;

    public List<WebElement> offers;

    public WebElement offersItem;
    By productBy = By.xpath(".//div[contains(@id, 'offer-product')]");
    By offerBy = By.xpath(".//div[contains(@class, 'grey-column _font-size-sm')]");
    By conditionsBy = By.xpath(".//div[contains(@class, 'offers__conditions')]");
    By priceBy = By.xpath(".//span[contains(@class, 'price_amount')]");
    public WebElement continueButton;
    By continueButtonBy = By.xpath(".//a[contains(@class, 'sm btn--primary')]");
    public WebElement showConditionsDetails;
    By showConditionsDetailsBy = By.xpath("//a[contains(@id, 'more_details')]");

    public Offers(WebElement offersItem, OffersClass offersClass) {
        this.offersItem = offersItem;
        assert offersItem != null;
        offerClass = offersClass.getClassName();
        product = getProduct();
        offer = getOffer();
        conditions = getConditions();
        price = getPrice();
        continueButton = offersItem.findElement(continueButtonBy);
        showConditionsDetails = offersItem.findElement(showConditionsDetailsBy);
    }

    public String getProduct() {
        return offersItem.findElement(productBy).getText();
    }

    public String getOffer() {
        return offersItem.findElement(offerBy).getText().replaceAll("\\s+", " ");
    }

    public String getConditions() {
        return offersItem.findElement(conditionsBy).getText();
    }

    public Double getPrice() {
        return toDouble(offersItem.findElement(priceBy).getText());
    }

    @Override
    public String toString() {
        return "Offers{" +
                "offerClass=" + offerClass +
                ", product='" + product + '\'' +
                ", offer='" + offer + '\'' +
                ", conditions='" + conditions + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

}
