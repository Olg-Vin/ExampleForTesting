package org.vinio.Pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.vinio.StartTestClass;

@Getter
public class AlertPage extends StartTestClass {
    private final By simpleAlertButton = By.cssSelector("#alertButton");
    private final By fiveSecondAlertButton = By.cssSelector("#timerAlertButton");
    private final By confirmAlertButton = By.cssSelector("#confirmButton");
    private final By promAlertButton = By.cssSelector("#promtButton");
    private final By confirmResult = By.cssSelector("#confirmResult");
    private final By promptResult = By.cssSelector("#promptResult");

    public AlertPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        StartTestClass.driver = (EventFiringWebDriver) driver; }

}
