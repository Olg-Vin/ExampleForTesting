package org.vinio;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
    public WebDriver driver;
    @FindBy(xpath = "//*[contains(@id, 'item-0')]")
    private WebElement textBox;
    @FindBy(xpath = "//*[contains(@id, 'item-4')]")
    private WebElement buttons;
    @FindBy(xpath = "//*[contains(@class, 'header-text') and text()='Alerts, Frame & Windows']")
    private WebElement alertsFrameWindowButton;
    @FindBy(xpath = "//*[text()='Browser Windows']")
    private WebElement browserWindowButton;
    @FindBy(xpath = "//*[text()='Alerts']")
    private WebElement alertsButton;

    public MenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    public void clickTextBox() {
        textBox.click();
    }
    public void clickButtons(){
        buttons.click();
    }
    public void clickAlertsFrameWindowButton(){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", alertsFrameWindowButton);
        alertsFrameWindowButton.click();
    }
    public void clickBrowserWindowButton(){
        browserWindowButton.click();
    }
    public void clickAlertsButton(){
        alertsButton.click();
    }
}
