package org.vinio;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.vinio.Pages.*;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class StartTestClass {
    public static EventFiringWebDriver driver; // нужен, чтобы использовать последовательность шагов
    public static FirefoxOptions options;
    public String url = "https://demoqa.com";
    public static WebDriverWait wait; // явное ожидание
    public static Actions actions;

    public static String originalWindowHandle;
    public static MainPage mainPage;
    public static MenuPage menuPage;
    public static ElementsPage elementsPage;
    public static ButtonsPage buttonsPage;
    public static BrowserPage browserPage;
    public static AlertPage alertPage;

    public static void setOriginalWindowHandle() {
        originalWindowHandle = driver.getWindowHandle();
    }

    public static void setUp() {
        WebDriverManager.firefoxdriver().setup();
        options = new FirefoxOptions();
        driver = new EventFiringWebDriver(new FirefoxDriver(options));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public void waitElement(By element){
        wait.until(visibilityOfElementLocated(element));
    }
    public void clickElement(By element){
        waitElement(element);
        WebElement webElement = driver.findElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        webElement.click();
    }
    public String getText(By element){
        waitElement(element);
        WebElement webElement = driver.findElement(element);
        return webElement.getText();
    }
    public void rightClick(By element){
        waitElement(element);
        WebElement webElement = driver.findElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        actions.contextClick(webElement).perform();
    }
    public void doubleClick(By element){
        waitElement(element);
        WebElement webElement = driver.findElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        actions.doubleClick(webElement).perform();
    }
    public void inputText(By element, String text){
        waitElement(element);
        WebElement webElement = driver.findElement(element);
        webElement.sendKeys(text);
    }

    @BeforeAll
    public static void init(){
        setUp();
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
