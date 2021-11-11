package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;


import java.util.List;
import java.util.Map;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {
    WebDriver driver;
    private static final long DEFAULT_TIMEOUT = 60;
    HomePage homePage;
    NewsPage newsPage;
    SearchPage searchPage;
    ArticlePage articlePage;
    CoronavirusPage coronavirusPage;
    YourQuestionsAnsweredPage yourQuestionsAnsweredPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }
    @Given("User opens {string} page")
    public void openHomePage(String url){
        homePage=pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User clicks on button News")
    public void clickOnButtonNews(){
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickOnButtonNewsMenu();
    }
    @And ("User checks page News visibility")
    public void checkNewsPageVisibility(){
        newsPage=pageFactoryManager.getNewsPage();
        newsPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks the name of the headline article {string}")
    public void checkNameArticle(String title){
        assertTrue(newsPage.getTitleArticle().equalsIgnoreCase(title));
    }

    @After
    public void tearDown() { driver.close();}

    @Then("^User checks the names of all articles$")
    public void checkNamesOfAllArticles(DataTable arg) {
        boolean check;
        List<String> rows = arg.asList(String.class);
        for (WebElement title:newsPage.getListOfArticleNames())
        { check=false;
            for (String a:rows) { if (title.getText().equalsIgnoreCase(a)) check=true;}
            assertTrue(check);
        }
    }

    @And("User collects names of all Category of the headline and checks {string}")
    public void collectAllCategoryOfHeadline(final String category) {
        for (WebElement names:newsPage.getNavigateCategory()) {
            if (names.getText().equalsIgnoreCase(category)) assertTrue(true);
        }
    }

    @And("User inputs name of Category into {string} Search field")
    public void inputCategoryIntoSearchField(final String category) {
        newsPage.enterTextToSearchField(category);
        newsPage.clickSearchButton();
    }

    @And("User checks page Search page visibility")
    public void checkPageSearchPageVisibility() {
        searchPage=pageFactoryManager.getSearchPage();
        searchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks {string} of the first article")
    public void checkCategoryOfTheFirstArticle(final String category) {
        System.out.println(category);
        System.out.println(searchPage.getSearchedArticles().get(2).getText());
        assertTrue(searchPage.getSearchedArticles().get(2).getText().contains(category));
    }

    @And("User inputs {string} Search field")
    public void inputSearchPhraseSearchField(final String phrase) {
        newsPage.enterTextToSearchField(phrase);
        newsPage.clickSearchButton();
    }

    @And("User clicks on the first article")
    public void clickOnFirstArticle() {
        searchPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        System.out.println(0);
        searchPage.clickFirstArticle();
        System.out.println(1);
    }

    @And("User checks page Article page visibility")
    public void checkArticlePageVisibility() {
        articlePage = pageFactoryManager.getArticlePage();
        articlePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }


    @And("User clicks on button Coronavirus")
    public void clickOnButtonCoronavirus() {
        newsPage.clickButtonCoronavirus();
    }

    @And("User clicks on button Your Coronavirus Stories")
    public void clickOnButtonYourCoronavirusStories() {
        coronavirusPage = pageFactoryManager.getCoronavirusPage();
        coronavirusPage.clickButtonYourCoronavirusStories();
        coronavirusPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        coronavirusPage.clickButtonYourCoronavirusStories();
    }
//    @And("User inputs data in fields {string} {string} {string} {string} {string}")
//    public void inputDataInFields(final String text, final String name, final String email, final String contact,final String location) {
//        yourQuestionsAnsweredPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
//        yourQuestionsAnsweredPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,yourQuestionsAnsweredPage.getButtonPopUpClose());
//        yourQuestionsAnsweredPage.clickButtonPopUpClose();
//        yourQuestionsAnsweredPage.inputTextInFields(text, name, email, contact, location);
//        yourQuestionsAnsweredPage.clickCheckBox();
//        yourQuestionsAnsweredPage.clickButtonSubmit();
//    }

    @Given("User opens form {string} page")
    public void openFormHttpsWwwBbcComNewsPage(String url) {
        yourQuestionsAnsweredPage=pageFactoryManager.getYourQuestionsAnsweredPage();
        yourQuestionsAnsweredPage.openYourQuestionsAnsweredPage(url);
    }

//    @And("^User fills the form {string} with value: {string}$")
//    public void fillFormWithValue(final String form, final String value) {
//        yourQuestionsAnsweredPage.inputFieldByName(form,value);
//    }

    @And("^User fills the form with value:$")
    public void fillFormWithValue(DataTable fields) {
        List<Map<String, String>> formTable = fields.asMaps();
        yourQuestionsAnsweredPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        yourQuestionsAnsweredPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,yourQuestionsAnsweredPage.getButtonPopUpClose());
        yourQuestionsAnsweredPage.clickButtonPopUpClose();
       // yourQuestionsAnsweredPage.inputFieldByName(formTable.get(0).get("form"),formTable.get(0).get("value"));
        yourQuestionsAnsweredPage.inputFieldByName(formTable.get(1).get("form"),formTable.get(1).get("value"));
        yourQuestionsAnsweredPage.inputFieldByName(formTable.get(2).get("form"),formTable.get(2).get("value"));
        yourQuestionsAnsweredPage.inputFieldByName(formTable.get(3).get("form"),formTable.get(3).get("value"));
        yourQuestionsAnsweredPage.inputFieldByName(formTable.get(4).get("form"),formTable.get(4).get("value"));
        yourQuestionsAnsweredPage.inputFieldByName(formTable.get(5).get("form"),formTable.get(5).get("value"));
        yourQuestionsAnsweredPage.clickCheckBox();
    }

    @And("User clicks Submit button")
    public void clickSubmitButton() {
        yourQuestionsAnsweredPage.clickButtonSubmit();
    }

    @Then("User gets error message")
    public void getErrorMessage(){
        yourQuestionsAnsweredPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        yourQuestionsAnsweredPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,yourQuestionsAnsweredPage.getErrorMessage());
        assertTrue(yourQuestionsAnsweredPage.isVisibilityErrorMessage());
    }
}

