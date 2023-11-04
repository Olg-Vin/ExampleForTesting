package org.vinio.Pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.vinio.StartTestClass;

@Getter
public class ButtonsPage extends StartTestClass {
    private final By clickMeButton = By.xpath("//button[text()='Click Me']");
    private final By rightClickMeButton = By.xpath("//button[text()='Right Click Me']");
    private final By doubleClickMeButton = By.xpath("//button[text()='Double Click Me']");
    private final By clickMeText = By.cssSelector("#dynamicClickMessage");
    private final By rightClickMeText = By.cssSelector("#rightClickMessage");
    private final By doubleClickMeText = By.cssSelector("#doubleClickMessage");


    public ButtonsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        StartTestClass.driver = (EventFiringWebDriver) driver; }
}
