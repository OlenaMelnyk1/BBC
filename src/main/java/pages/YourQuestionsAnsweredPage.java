package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import static java.lang.String.format;

public class YourQuestionsAnsweredPage extends BasePage{

    private String fieldsByName="//input[contains(@aria-label, '%s')]";
    @FindBy(xpath = "//button[@class='button']")
    private WebElement buttonSubmit;



    @FindBy(xpath = "//input [@type='checkbox']")
    private WebElement checkbox;

    @FindBy(xpath = "//div [contains(text(),'be blank')]")
    private WebElement errorMessage;

    public YourQuestionsAnsweredPage(WebDriver driver) {
        super(driver);
    }

    public void inputFieldByName(String fieldName,String value){
        WebElement field=driver.findElement(By.xpath(format(fieldsByName,fieldName)));
        fillForm(field,value);
    }
    public void clickCheckBox(){ checkbox.click();}
    public void clickButtonSubmit(){buttonSubmit.click();}


    public WebElement getErrorMessage(){return errorMessage;}
    public void openYourQuestionsAnsweredPage(String url) {driver.get(url);}
    public boolean isVisibilityErrorMessage(){ return errorMessage.isDisplayed();}
}

