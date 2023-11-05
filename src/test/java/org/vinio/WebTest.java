package org.vinio;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.vinio.Pages.*;

import java.time.Duration;
import java.util.Set;

//@ExtendWith(TestListener.class)
public class WebTest extends StartTestClass {
    @Test
    public void MainTest() {
        mainPage = new MainPage(driver);
        menuPage = new MenuPage(driver);
        elementsPage = new ElementsPage(driver);
        buttonsPage = new ButtonsPage(driver);
        browserPage = new BrowserPage(driver);
        alertPage = new AlertPage(driver);
        openWebSite(url);

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
        clickOnSimpleAlert();
        okAlert();
        clickOnFiveSecondAlert();
        okAlert();
        clickOnConfirmAlertButton();
        okAlert();
        checkConfirmResult();
        clickOnPromAlertButton();
        inputProm();
        checkPromptResult();
    }
    @Step
    public void openWebSite(String url){
        Duration durationTime = Duration.ofSeconds(5);
        driver.manage().timeouts().pageLoadTimeout(durationTime);
        try {
            driver.get(url);
        }catch (TimeoutException e) {
//            TODO В случае возникновения ошибки (например, превышение времени ожидания), прервать загрузку
            System.out.println("ERROR");
            System.out.println(e.getMessage());
        }
        setOriginalWindowHandle();
    }
    @Step
    private void clickOnElements(){
        clickElement(mainPage.getElements());
    }
    @Step
    private void clickOnTextBox(){
        clickElement(menuPage.getTextBox());
    }
    @Step
    private void fullFields(){
        inputText(elementsPage.getFullName(), "Test Name");
        inputText(elementsPage.getEmail(), "TestEmail@gmail.com");
        inputText(elementsPage.getCurrentAddress(), "Moscow, Savyolovskiy");
        inputText(elementsPage.getPermanentAddress(), "Moscow, Savyolovskiy");
    }
    @Step
    private void clickOnSubmit(){
        clickElement(elementsPage.getSubmitButton());
    }
    @Step
    private void checkData(){
        Assertions.assertEquals("Name:Test Name", getText(elementsPage.getNameField()));
        Assertions.assertEquals("Email:TestEmail@gmail.com", getText(elementsPage.getEmailField()));
        Assertions.assertEquals("Current Address :Moscow, Savyolovskiy",
                getText(elementsPage.getCurrentAddressField()));
        Assertions.assertEquals("Permananet Address :Moscow, Savyolovskiy",
                getText(elementsPage.getPermanentAddressField()));
//        TODO Баг в написании слова
    }
    @Step
    private void clickOnButtons(){
        clickElement(menuPage.getButtons());
    }
    @Step
    private void clickOnClickMe(){
        clickElement(buttonsPage.getClickMeButton());
    }
    @Step
    private void checkClickMeText(){
        Assertions.assertEquals("You have done a dynamic click",
                getText(buttonsPage.getClickMeText()));}
    @Step
    private void clickOnRightClick(){
        rightClick(buttonsPage.getRightClickMeButton());
    }
    @Step
    private void checkRightClickText(){
        Assertions.assertEquals("You have done a right click",
                getText(buttonsPage.getRightClickMeText()));}
    @Step
    private void clickOnDoubleClick(){
        doubleClick(buttonsPage.getDoubleClickMeButton());
    }
    @Step
    private void checkDoubleClickText(){
        Assertions.assertEquals("You have done a double click",
                getText(buttonsPage.getDoubleClickMeText()));}
    @Step
    private void clickOnAlertsFrameWindow(){
        clickElement(menuPage.getAlertsFrameWindowButton());
    }
    @Step
    private void clickOnBrowserWindow(){
        clickElement(menuPage.getBrowserWindowButton());
    }
    @Step
    private void clickOnNewTab(){
        clickElement(browserPage.getNewTabButton());
    }
    @Step
    private void closeOpeningPage(){closeCurrentPage();}
    @Step
    private void clickOnNewWindow(){
        clickElement(browserPage.getNewWindowButton());
    }
    @Step
    private void closeOpeningWindow(){closeCurrentPage();}
    @Step
    private void clickOnAlerts(){
        clickElement(menuPage.getAlertsButton());
    }
    @Step
    private void clickOnSimpleAlert(){
        clickElement(alertPage.getSimpleAlertButton());
    }
    @Step
    private void okAlert(){
        Duration durationTime = Duration.ofSeconds(5);
        // Ожидание появления всплывающего окна в течение 5 секунд
        WebDriverWait wait = new WebDriverWait(driver, durationTime);
        wait.until(ExpectedConditions.alertIsPresent());
        // Получение объекта Alert
        Alert alert = driver.switchTo().alert();
        // Нажатие на кнопку "OK"
        alert.accept();
        // Возврат к основному контексту
        driver.switchTo().defaultContent();
    }
    @Step
    private void clickOnFiveSecondAlert(){
        clickElement(alertPage.getFiveSecondAlertButton());
    }
    @Step
    public void closeCurrentPage() {
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.remove(originalWindowHandle);
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            driver.close();
        }
        driver.switchTo().window(originalWindowHandle);
    }
    @Step
    public void clickOnConfirmAlertButton(){
        clickElement(alertPage.getConfirmAlertButton());
    }
    @Step
    public void checkConfirmResult(){
        Assertions.assertEquals("You selected Ok",
                getText(alertPage.getConfirmResult()));}
    @Step
    public void clickOnPromAlertButton(){
        clickElement(alertPage.getPromAlertButton());
    }
    @Step
    public void inputProm(){
        // Переключение на всплывающее окно
        Alert alert = driver.switchTo().alert();
        // Ввод данных в поле
        alert.sendKeys("Test name");
        // Нажатие на кнопку "Ok" или другую нужную кнопку
        alert.accept();
    }
    @Step
    public void checkPromptResult(){
        Assertions.assertEquals("You entered Test name", getText(alertPage.getPromptResult()));}
}
