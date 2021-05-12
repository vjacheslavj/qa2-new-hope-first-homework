import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DelfiArticalCommentsTest {
    private final By ACCEPT_COOKIE_BTN = By.xpath(".//button[@mode='primary']");
    private final By HOME_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By HOME_PAGE_COMMENTS = By.xpath(".//a[contains(@class, 'comment-count')]");
    private final By HOME_PAGE_ARTICLE = By.tagName("article");

    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[contains(@class, 'text-size-md-30')]");
    private final By ARTICLE_PAGE_COMMENTS = By.xpath(".//a[contains(@class, 'text-size-md-28')]");

    private WebDriver driver;

    @Test
    public void titleAndCommentsCountCheckk() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://delfi.lv");

        //-----------------------HOME PAGE------------------------

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIE_BTN));

        driver.findElement(ACCEPT_COOKIE_BTN).click();

        List<WebElement> titles = driver.findElements(HOME_PAGE_TITLE);

        //-------------------------------FOR------------------------------------------
        for (int i = 0; i < titles.size(); i = i + 1) {  //i= i + 1 ->  i++
            if (!titles.get(i).getText().isEmpty()) {  //!true = false    !false = true
                System.out.println(i + ": " + titles.get(i).getText());
            }

        }
        //-----------------------------------FOREACH----------------------------------
        for (WebElement we : titles) {
//            if (!we.getText().isEmpty()) {
//                System.out.println(we.getText());
//            }else {
//                System.out.println("--------------------");
//            }
            //условие ? true : false (else)
            System.out.println(we.getText().isEmpty() ? "------" : we.getText());
        }
    }

    @Test
    public void titleAndCommentsCountCheck() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://delfi.lv");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIE_BTN));

        driver.findElement(ACCEPT_COOKIE_BTN).click();

        List<WebElement> articles = driver.findElements(HOME_PAGE_ARTICLE);
        WebElement article = articles.get(4);

        String homePageTitle = article.findElement(HOME_PAGE_TITLE).getText();
        int homePageCommentsCout = 0;
        if (!article.findElements(HOME_PAGE_COMMENTS).isEmpty()) {
            homePageCommentsCout = getCommentsCount(article.findElement(HOME_PAGE_COMMENTS).getText());
        }

        article.findElement(HOME_PAGE_TITLE).click();

        //--------------------------ARTICLE PAGE-----------------------
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();

        int articlePageCommentsCount = 0;
        if (!driver.findElements(ARTICLE_PAGE_COMMENTS).isEmpty()) {
            articlePageCommentsCount = getCommentsCount(driver.findElement(ARTICLE_PAGE_COMMENTS).getText());
        }

        Assertions.assertEquals(homePageTitle, articlePageTitle, "Wrong title!");
        Assertions.assertEquals(homePageCommentsCout, articlePageCommentsCount, "Wrong comments count!");

        //-------------------COMMENTS PAGE------------------------
        //....
    }


    private int getCommentsCount(String commentsCountText) {
        commentsCountText = commentsCountText.substring(1, commentsCountText.length() - 1); // (36) -> (String)
        return Integer.parseInt(commentsCountText); // 36 (String) -> 36 (int)
    }
    @AfterEach
    public void closeBrowser() {
        driver.close();

    }
}

