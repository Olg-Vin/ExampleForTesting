package org.vinio;

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

import static io.qameta.allure.Allure.step;

@ExtendWith(TestListener.class)
public class WebTest extends StartTestClass {
    @Test
    public void MainTest() {
        mainPage = new MainPage(driver);
        menuPage = new MenuPage(driver);
        elementsPage = new ElementsPage(driver);
        buttonsPage = new ButtonsPage(driver);
        browserPage = new BrowserPage(driver);
        alertPage = new AlertPage(driver);
        step("Открываем главную страницу", () -> openWebSite(url));
        step("Нажать на «Elements»", this::clickOnElements);
        step("Нажать на «Text box»", this::clickOnTextBox);
        step("Заполнить поля: Full Name, Email, Current Address, Permanent Address", this::fullFields);
        step("Нажать на кнопку «Submit»", this::clickOnSubmit);
        step("Проверить, что данные в блоке сохранены корректно", this::checkData);
        step("Нажать на «Buttons»", this::clickOnButtons);
        step("Нажать на кнопку «Click me»", this::clickOnClickMe);
        step("Проверить, что появился текст «You have done a dynamic click»", this::checkClickMeText);
        step("Нажать на кнопку «Right Click me»", this::clickOnRightClick);
        step("Проверить, что появился текст «You have done a right click»", this::checkRightClickText);
        step("Нажать на кнопку «Double Click me»", this::clickOnDoubleClick);
        step("Проверить, что появился текст «You have done a double click»", this::checkDoubleClickText);
        step("Нажать на «Alerts, Frame & Windows»", this::clickOnAlertsFrameWindow);
        step("Нажать на «Browser Windows»", this::clickOnBrowserWindow);
        step("Нажать на кнопку «New Tab»", this::clickOnNewTab);
        step("Закрыть новую вкладку", this::closeOpeningPage);
        step("Нажать на кнопку «New window»", this::clickOnNewWindow);
        step("Закрыть новое окно", this::closeOpeningWindow);
        step("Нажать на «Alerts»", this::clickOnAlerts);
        step("Нажать на кнопку «Click me»  рядом с Click Button to see alert", this::clickOnSimpleAlert);
        step("Закрыть уведомление", this::okAlert);
        step("Нажать на кнопку «Click me»  рядом с On button click, alert will appear after 5 seconds", this::clickOnFiveSecondAlert);
        step("Закрыть уведомление", this::okAlert);
        step("Нажать на кнопку «Click me»  рядом с On button click, confirm box will appear", this::clickOnConfirmAlertButton);
        step("Нажать на кнопку «Да» в уведомление", this::okAlert);
        step("Проверить, что появился текст You selected Ok", this::checkConfirmResult);
        step("Нажать на кнопку «Click me»  рядом с On button click, prompt box will appear", this::clickOnPromAlertButton);
        step("Заполнить поле в уведомление данными: Test name", this::inputProm);
        step("Проверить, что появился текст You entered Test name", this::checkPromptResult);
    }
    public void openWebSite(String url){
        Duration durationTime = Duration.ofSeconds(5);
        driver.manage().timeouts().pageLoadTimeout(durationTime);
        try {
            driver.get(url);
        }catch (TimeoutException e) {
            driver.navigate().forward();
//            TODO В случае возникновения ошибки (например, превышение времени ожидания), прервать загрузку
            System.out.println("ERROR");
            System.out.println(e.getMessage());
        }
        setOriginalWindowHandle();
    }
    private void clickOnElements(){
        clickElement(mainPage.getElements());
    }
    private void clickOnTextBox(){
        clickElement(menuPage.getTextBox());
    }
    private void fullFields(){
        inputText(elementsPage.getFullName(), "Test Name");
        inputText(elementsPage.getEmail(), "TestEmail@gmail.com");
        inputText(elementsPage.getCurrentAddress(), "Moscow, Savyolovskiy");
        inputText(elementsPage.getPermanentAddress(), "Moscow, Savyolovskiy");
    }
    private void clickOnSubmit(){
        clickElement(elementsPage.getSubmitButton());
    }
    private void checkData(){
        Assertions.assertEquals("Name:Test Name", getText(elementsPage.getNameField()));
        Assertions.assertEquals("Email:TestEmail@gmail.com", getText(elementsPage.getEmailField()));
        Assertions.assertEquals("Current Address :Moscow, Savyolovskiy",
                getText(elementsPage.getCurrentAddressField()));
        Assertions.assertEquals("Permananet Address :Moscow, Savyolovskiy",
                getText(elementsPage.getPermanentAddressField()));
//        TODO Баг в написании слова
    }
    private void clickOnButtons(){
        clickElement(menuPage.getButtons());
    }
    private void clickOnClickMe(){
        clickElement(buttonsPage.getClickMeButton());
    }
    private void checkClickMeText(){
        Assertions.assertEquals("You have done a dynamic click",
                getText(buttonsPage.getClickMeText()));}
    private void clickOnRightClick(){
        rightClick(buttonsPage.getRightClickMeButton());
    }
    private void checkRightClickText(){
        Assertions.assertEquals("You have done a right click",
                getText(buttonsPage.getRightClickMeText()));}
    private void clickOnDoubleClick(){
        doubleClick(buttonsPage.getDoubleClickMeButton());
    }
    private void checkDoubleClickText(){
        Assertions.assertEquals("You have done a double click",
                getText(buttonsPage.getDoubleClickMeText()));}
    private void clickOnAlertsFrameWindow(){
        clickElement(menuPage.getAlertsFrameWindowButton());
    }
    private void clickOnBrowserWindow(){
        clickElement(menuPage.getBrowserWindowButton());
    }
    private void clickOnNewTab(){
        clickElement(browserPage.getNewTabButton());
    }
    private void closeOpeningPage(){closeCurrentPage();}
    private void clickOnNewWindow(){
        clickElement(browserPage.getNewWindowButton());
    }
    private void closeOpeningWindow(){closeCurrentPage();}
    private void clickOnAlerts(){
        clickElement(menuPage.getAlertsButton());
    }
    private void clickOnSimpleAlert(){
        clickElement(alertPage.getSimpleAlertButton());
    }
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
    private void clickOnFiveSecondAlert(){
        clickElement(alertPage.getFiveSecondAlertButton());
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
    public void clickOnConfirmAlertButton(){
        clickElement(alertPage.getConfirmAlertButton());
    }
    public void checkConfirmResult(){
        Assertions.assertEquals("You selected Ok",
                getText(alertPage.getConfirmResult()));}
    public void clickOnPromAlertButton(){
        clickElement(alertPage.getPromAlertButton());
    }
    public void inputProm(){
        // Переключение на всплывающее окно
        Alert alert = driver.switchTo().alert();
        // Ввод данных в поле
        alert.sendKeys("Test name");
        // Нажатие на кнопку "Ok" или другую нужную кнопку
        alert.accept();
    }
    public void checkPromptResult(){
        Assertions.assertEquals("You entered Test name", getText(alertPage.getPromptResult()));}
}
