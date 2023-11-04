package org.vinio.Pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.vinio.StartTestClass;

@Getter
public class BrowserPage extends StartTestClass {

    private final By newTabButton = By.xpath("//button[text()='New Tab']");
    private final By newWindowButton = By.xpath("//button[text()='New Window']");

    public BrowserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        StartTestClass.driver = (EventFiringWebDriver) driver; }
}
