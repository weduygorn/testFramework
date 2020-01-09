package pages.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = ".//*[@class='header']")
public class TopHeader extends HtmlElement {

    @FindBy(xpath = "//a[@class='header__logo']")
    public WebElement headerLogo;

    @FindBy(xpath = "(//*[@class='header__nav']//a)[1]")
    public WebElement home;

    @FindBy(xpath = "(//*[@class='header__nav']//a)[2]")
    public WebElement contact;

    @FindBy(xpath = "//*[@class='dropdown']")
    public WebElement dropdownMenuLanguage;

    @FindBy(xpath = "//*[@class='dropdown__menu-item']")
    public WebElement languageInMenu;

    @FindBy(xpath = "(//*[@class='header__font']/a)[1]")
    public WebElement headerFont_small;

    @FindBy(xpath = "(//*[@class='header__font']/a)[2]")
    public WebElement headerFont_medium;

    @FindBy(xpath = "(//*[@class='header__font']/a)[3]")
    public WebElement headerFont_large;

    @FindBy(xpath = "//*[@class='input input--search']")
    public WebElement searchField;

    @FindBy(xpath = "//*[@class='icon-bahn-search']")
    public WebElement searchIcon;

}
