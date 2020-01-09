package pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

public class LoadingContainer extends HtmlElement {

    public final String GLOBAL_LOADING_ANIM_CSS = ".loader-global .loading_animation_transformed_container";
    public final String OFFER_LOADING_ANIM_CSS = ".swiper-slide .offer--loader";
    public final String DATE_LOADING_ANIM_CSS = ".loader-slide-wrap--active";

    @FindBy(css = DATE_LOADING_ANIM_CSS)
    public WebElement dateLoader;

    @FindBy(css = OFFER_LOADING_ANIM_CSS)
    public List<WebElement> offerLoader;

}
