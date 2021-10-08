package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YourQuestionsAnsweredPage extends BasePage{

    @FindBy(xpath = "//div[@class='long-text-input-container']/textarea")
    private WebElement textField;

    @FindBy(xpath = "//input[@type]")
    private List<WebElement> fieldsText;

    @FindBy(xpath = "//input[@type and@aria-label='Email address']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@class='button']")
    private WebElement buttonSubmit;


    public YourQuestionsAnsweredPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckBox(){ fieldsText.get(4).click();}
    public void clickButtonSubmit(){buttonSubmit.click();}
    public void inputTextInFields(final String text, final String name, final String email, final String contact,final String location) {

        fieldsText.get(0).clear();
        fieldsText.get(0).sendKeys(name);
 //       emailField.clear();
//        emailField.sendKeys(name);
        fieldsText.get(2).clear();
//       fieldsText.get(2).sendKeys(contact);
        System.out.println(5);
        fieldsText.get(3).clear();
 //       fieldsText.get(3).sendKeys(location);
        System.out.println(8);
        textField.clear();
        textField.sendKeys(text);
        System.out.println("text");

    }
}
