package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FaqPage extends BasePage {
    /**
     * Constructor
     *
     * @param driver
     */
    public FaqPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitLoading() {

    }

    ///////////faq booking title//////////////
    @FindBy(xpath = "//*[@class=\"_col-sm-8\"]")
    public WebElement titleFaq;

    ///////////faq booking title//////////////
    @FindBy(xpath = "//*[@class=\"faqs-page__form\"]")
    public WebElement searchField;

    ///////////faq items titles//////////////
    @FindBy(xpath = "//*[@class=\"faqs-page__topic-title\"]")
    public List<WebElement> topicsTitles;

    ///////////faq items questions//////////////
    @FindBy(xpath = "//*[@class=\"faqs-page__item-question\"]")
    public List<WebElement> topicsQuestions;

    ///////////faq items answers//////////////
    @FindBy(xpath = "//*[@class=\"faqs-page__item-answer\"]")
    public List<WebElement> topicsAnswers;

    ///////////faq close///////
    @FindBy(xpath = "//*[@class=\"btn btn--default\"]")
    public WebElement close;
}
