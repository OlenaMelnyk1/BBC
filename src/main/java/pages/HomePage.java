package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
@FindBy (xpath = "//div//button[@type='button' and @aria-label='Close']")
private WebElement buttonClosePopUp;

@FindBy (xpath = "//nav [@role='navigation']//a [@href='https://www.bbc.com/news']")
private WebElement buttonNewsMenu;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnButtonCloseMenu(){buttonClosePopUp.click();}
    public void clickOnButtonNewsMenu(){ buttonNewsMenu.click();}

    public void openHomePage(String url) {driver.get(url);}
}
