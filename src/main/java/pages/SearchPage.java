package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage{
    @FindBy(xpath = "//span[@role='text']")
    private List<WebElement> searchedArticles;

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public List<WebElement> getSearchedArticles() { return searchedArticles; }
}
