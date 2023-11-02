package org.vinio;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Set;

import io.qameta.allure.Step;


public class WebTest {
    /**
     * начальные настройки теста
     */
    public static WebDriver driver;
    private static String originalWindowHandle;
    public static MainPage mainPage;
    public static MenuPage menuPage;
    public static ElementsPage elementsPage;
    public static ButtonsPage buttonsPage;
    public static BrowserPage browserPage;
    public static AlertPage alertPage;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.firefox.driver",
                "C:/Users/Vinio/web_driver/geckodriver/geckodriver.exe");
        String firefoxPath = "C:\\Program Files\\Firefox Developer Edition\\firefox.exe";
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary(firefoxPath);

        driver = new FirefoxDriver(options);
        mainPage = new MainPage(driver);
        menuPage = new MenuPage(driver);
        elementsPage = new ElementsPage(driver);
        buttonsPage = new ButtonsPage(driver);
        browserPage = new BrowserPage(driver);
        alertPage = new AlertPage(driver);

        Duration durationTime = Duration.ofSeconds(5);
        driver.manage().timeouts().pageLoadTimeout(durationTime);
        try {
            // Переход на веб-сайт
            driver.get("https://demoqa.com");

        }catch (TimeoutException e) {
//            TODO В случае возникновения ошибки (например, превышение времени ожидания), прервать загрузку
            System.out.println("ERROR");
            System.out.println(e.getMessage());

        }
        originalWindowHandle = driver.getWindowHandle();
    }

    @Test
    public void MainTest() throws InterruptedException {
        clickOnElements();
        clickOnTextBox();
        fullFields();
        clickOnSubmit();
        checkData();
        clickOnButtons();
        clickOnClickMe();
        checkClickMeText();
        clickOnRightClick();
        checkRightClickText();
        clickOnDoubleClick();
        checkDoubleClickText();
        clickOnAlertsFrameWindow();
        clickOnBrowserWindow();
        clickOnNewTab();
        closeOpeningPage();
        clickOnNewWindow();
        closeOpeningWindow();
        clickOnAlerts();
        clickOnAlerts();
    }
    @Step
    private void clickOnElements(){mainPage.clickElements();}
    @Step
    private void clickOnTextBox(){menuPage.clickTextBox();}
    @Step
    private void fullFields(){
        elementsPage.inputFullName("Test Name");
        elementsPage.inputEmail("TestEmail@gmail.com");
        elementsPage.inputCurrentAddress("Moscow, Savyolovskiy");
        elementsPage.inputPermanentAddress("Moscow, Savyolovskiy");
    }
    @Step
    private void clickOnSubmit(){elementsPage.clickSubmit();}
    @Step
    private void checkData(){
        Assertions.assertEquals("Name:Test Name", elementsPage.getNameField());
        Assertions.assertEquals("Email:TestEmail@gmail.com", elementsPage.getEmailField());
        Assertions.assertEquals("Current Address :Moscow, Savyolovskiy", elementsPage.getCurrentAddressField());
        Assertions.assertEquals("Permananet Address :Moscow, Savyolovskiy", elementsPage.getPermanentAddressField());
//        TODO Баг в написании слова
    }
    @Step
    private void clickOnButtons(){menuPage.clickButtons();}
    @Step
    private void clickOnClickMe(){buttonsPage.clickOnClickMeButton();}
    @Step
    private void checkClickMeText(){
        Assertions.assertEquals("You have done a dynamic click", buttonsPage.getClickMeMessage());}
    @Step
    private void clickOnRightClick(){buttonsPage.clickOnRightCluckMeButton();}
    @Step
    private void checkRightClickText(){
        Assertions.assertEquals("You have done a right click", buttonsPage.getRightClickMeText());}
    @Step
    private void clickOnDoubleClick(){buttonsPage.clickDoubleClickMeButton();}
    @Step
    private void checkDoubleClickText(){
        Assertions.assertEquals("You have done a double click", buttonsPage.getDoubleClickMeText());}
    @Step
    private void clickOnAlertsFrameWindow(){menuPage.clickAlertsFrameWindowButton();}
    @Step
    private void clickOnBrowserWindow(){menuPage.clickBrowserWindowButton();}
    @Step
    private void clickOnNewTab(){browserPage.clickNewTabButton();}
    @Step
    private void closeOpeningPage(){closeCurrentPage();}
    @Step
    private void clickOnNewWindow(){browserPage.clickNewWindowButton();}
    @Step
    private void closeOpeningWindow(){closeCurrentPage();}
    @Step
    private void clickOnAlerts(){menuPage.clickAlertsButton();}
    @Step
    private void clickOnSimpleAlert(){alertPage.clickSimpleAlertButton();}

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public void closeCurrentPage() {
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.remove(originalWindowHandle);
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            driver.close();
        }
        driver.switchTo().window(originalWindowHandle);
    }
}
