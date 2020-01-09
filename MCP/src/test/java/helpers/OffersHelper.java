package helpers;

import org.openqa.selenium.WebElement;
import pages.blocks.search.Offers;
import pages.blocks.search.OffersClass;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OffersHelper {

    public static List<Offers> getOffersList(List<WebElement> offersListNodes) {
        List<Offers> offersList = new ArrayList<>();
        for (OffersClass offersResult : getOfferCLassList(offersListNodes)) {
            offersList.addAll(offersResult.getOffers());
        }
        return offersList;
    }

    public static List<OffersClass> getOfferCLassList(List<WebElement> offersListNodes) {
        LinkedList<WebElement> offersListNode = new LinkedList<>(offersListNodes);

        List<OffersClass> offersClassList = new ArrayList<>();
        OffersClass offersClass = null;

        for (WebElement node : offersListNode) {
            if (node.getAttribute("class").equals("offers__class")) {
                if (offersClass != null) {
                    offersClassList.add(offersClass);
                }
                offersClass = new OffersClass();
                offersClass.setClassName(node);
            }
            if (node.getAttribute("class").equals("offers__item")) {
                assert offersClass != null;
                offersClass.addOffer(new Offers(node, offersClass));
            }
        }

        if (offersClass != null) {
            offersClassList.add(offersClass);
        }

        return offersClassList;
    }
}
