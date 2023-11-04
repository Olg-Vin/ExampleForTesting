package org.vinio.Pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.vinio.StartTestClass;

@Getter
public class MenuPage extends StartTestClass {
    private final By textBox = By.id("item-0");
    private final By buttons = By.id("item-4");
    private final By alertsFrameWindowButton = By.xpath("//*[contains(@class, 'header-text') and text()='Alerts, Frame & Windows']");
    private final By browserWindowButton = By.xpath("//*[text()='Browser Windows']");
    private final By alertsButton = By.xpath("//*[text()='Alerts']");

    public MenuPage(WebDriver driver) {
        StartTestClass.driver = (EventFiringWebDriver) driver;
        PageFactory.initElements(driver, this);}
}
