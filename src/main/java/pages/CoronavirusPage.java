package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CoronavirusPage extends BasePage{
    @FindBy(xpath = "//div[@class='gs-u-display-none gs-u-display-block@m']//span[text()='Your Coronavirus Stories']")
    private WebElement buttonYourCoronavirusStories;

    @FindBy (xpath = "//div[@class='long-text-input-container']/textarea")
    private WebElement textField;

    @FindBy(xpath = "//input[@type]")
    private List<WebElement> fields;

    @FindBy(xpath = "//button[@class='button']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//h3[text()='Your questions answered: What questions do you have?']")
    private WebElement buttonYourQuestions;

    public CoronavirusPage(WebDriver driver) {
        super(driver);
    }
    public void clickButtonYourCoronavirusStories(){buttonYourCoronavirusStories.click();}
public void clickButtonYourQuestions(){buttonYourQuestions.click();};
}
