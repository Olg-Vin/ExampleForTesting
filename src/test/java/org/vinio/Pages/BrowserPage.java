package org.vinio.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserPage {
    public WebDriver driver;

    @FindBy(xpath = "//button[text()='New Tab']")
    private WebElement newTabButton;
    @FindBy(xpath = "//button[text()='New Window']")
    private WebElement newWindowButton;

    public BrowserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    public void clickNewTabButton(){
        newTabButton.click();
    }
    public void clickNewWindowButton(){
        newWindowButton.click();
    }
}
