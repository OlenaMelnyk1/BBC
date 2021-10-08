package manager;

        import org.openqa.selenium.WebDriver;
        import pages.*;
//      import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) { this.driver = driver;}
    public HomePage getHomePage(){ return new HomePage(driver);}
    public NewsPage getNewsPage(){ return new NewsPage(driver);}
    public SearchPage getSearchPage(){ return new SearchPage(driver);}
    public ArticlePage getArticlePage(){ return new ArticlePage(driver);}
    public CoronavirusPage getCoronavirusPage(){ return  new CoronavirusPage(driver);}
    public YourQuestionsAnsweredPage getYourQuestionsAnsweredPage(){return  new YourQuestionsAnsweredPage(driver);}
//    public WishListPage getWishListPage(){return new WishListPage(driver);}
//    public BagPage getBagPage(){ return new BagPage(driver);}
}
