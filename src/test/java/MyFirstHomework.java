import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MyFirstHomework {

    private final By ACCEPT_COOKIES_SPAN = By.xpath(".//span[@class = 'list-article__headline']");
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final By ACCEPT_COOKIES_IMG = By.xpath(".//img[@src='/v5/img/icons/comment-v2.svg']");
    private final By ALL_ARTICLES_NAMES = By.xpath(".//span[@itemprop = 'headline name']");
    private final By ALL_COMMENTS_NAMES = By.xpath(".//div[@class = 'menu-items menu-items--top']/div[5]");

    @Test
    public void firstHomework() {
        //WebDriver - browser window
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");

        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();
        browserWindow.findElement(ACCEPT_COOKIES_SPAN).click();
        browserWindow.findElement(ACCEPT_COOKIES_IMG).click();

    }

    @Test
    public void firstHomeWorkTvNet() {
        //WebDriver - browser window
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");

        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();
        System.out.println(browserWindow.findElement(ACCEPT_COOKIES_SPAN).getText());
    }

    @Test
    public void allArticlesNamesPrint() {
        //WebDriver - browser window
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browserWindow = new ChromeDriver();
        browserWindow.manage().window().maximize();
        browserWindow.get("http://tvnet.lv");

        browserWindow.findElement(ACCEPT_COOKIES_BTN).click();
        List<WebElement> articleNamesPrint = browserWindow.findElements(ALL_ARTICLES_NAMES);



    }

}





