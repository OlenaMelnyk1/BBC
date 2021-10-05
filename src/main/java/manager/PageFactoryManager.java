package manager;

        import org.openqa.selenium.WebDriver;
        import pages.HomePage;
        import pages.NewsPage;
        import pages.SearchPage;
//      import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) { this.driver = driver;}
    public HomePage getHomePage(){ return new HomePage(driver);}
    public NewsPage getNewsPage(){ return new NewsPage(driver);}
    public SearchPage getSearchPage(){ return new SearchPage(driver);}
//    public DressesPage getDressesPage(){ return new DressesPage(driver);}
//    public ProductPage getProductPage(){ return  new ProductPage(driver);}
//    public IdentityPage getIdentityPage(){return  new IdentityPage(driver);}
//    public WishListPage getWishListPage(){return new WishListPage(driver);}
//    public BagPage getBagPage(){ return new BagPage(driver);}
}
