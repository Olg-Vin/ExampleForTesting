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
public class ElementsPage extends StartTestClass {
    private final By fullName = By.cssSelector("#userName");
    private final By email = By.cssSelector("#userEmail");
    private final By currentAddress = By.cssSelector("#currentAddress");
    private final By permanentAddress = By.cssSelector("#permanentAddress");
    private final By submitButton = By.xpath("//*[contains(@id, 'submit')]");
    private final By nameField = By.xpath("//*[contains(@id, 'name')]");
    private final By emailField = By.xpath("//*[contains(@id, 'email')]");
    private final By currentAddressField = By.cssSelector("p.mb-1:nth-child(3)");
    private final By permanentAddressField = By.cssSelector("p.mb-1:nth-child(4)");

    public ElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        StartTestClass.driver = (EventFiringWebDriver) driver; }
}
