package org.vinio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
    public WebDriver driver;
    @FindBy(css = "#alertButton")
    private WebElement simpleAlertButton;
    public AlertPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    public void clickSimpleAlertButton(){
        simpleAlertButton.click();
    }
}
