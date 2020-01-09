package pages.blocks.search;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OffersClass {

    WebElement className;

    List<Offers> offers = new ArrayList<>();

    public void setClassName(WebElement classname) {
        this.className = classname;
    }

    public void addOffer(Offers offers) {
        this.offers.add(offers);
    }

    public List<Offers> getOffers() {
        return offers;
    }

    public Integer getClassName() {
        int offerInt;
        offerInt = Integer.parseInt(className.getText().replaceAll("\\D+", ""));
        return offerInt;
    }

    public Offers getOffer(Predicate<? super Offers> predicate) {
        Optional<Offers> result = offers.stream().filter(predicate).findAny();
        return result.orElse(null);
    }
}
