package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NewsPage extends BasePage{
    @FindBy(xpath="//div[contains(@class,'gs-u-display-inline-block@m gs-u-mt@xs')]")
    private WebElement titleArticle;

    @FindBy(xpath="//*[contains(@class,'stories__secondary')]")
    private List<WebElement> listOfArticleNames;

    @FindBy (xpath = "//li[contains (@class,'gs-u-float-left nw-c-nav__wide-menuitem-container')]")
    private List<WebElement> navigateCategory;

    @FindBy (xpath = "//input[@type='text']")
    private WebElement searchString;

    @FindBy(xpath ="//button[@class='orb-search__button']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//nav[@class='nw-c-nav__wide']//span[text()='Coronavirus']")
    private WebElement buttonCoronavirus;

    public NewsPage(WebDriver driver) {
        super(driver);
    }
    public String getTitleArticle(){return titleArticle.getText();}
    public List<WebElement> getListOfArticleNames(){return listOfArticleNames;}
    public List<WebElement> getNavigateCategory(){return navigateCategory;}
    public void enterTextToSearchField(final String keyword){
        searchString.clear();
        searchString.sendKeys(keyword);
    }
    public void clickSearchButton(){buttonSearch.click();}
    public void clickButtonCoronavirus(){navigateCategory.get(0).click();}
}
