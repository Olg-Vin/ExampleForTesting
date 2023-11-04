package org.vinio.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {
    public WebDriver driver;
    @FindBy(css = "#alertButton")
    private WebElement simpleAlertButton;
    @FindBy(css = "#timerAlertButton")
    private WebElement fiveSecondAlertButton;
    @FindBy(css = "#confirmButton")
    private WebElement confirmAlertButton;
    @FindBy(css = "#promtButton")
    private WebElement promAlertButton;
    @FindBy(css = "#confirmResult")
    private WebElement confirmResult;
    @FindBy(css = "#promptResult")
    private WebElement promptResult;

    public AlertPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    public void clickSimpleAlertButton(){
        simpleAlertButton.click();
    }
    public void clickFiveSecondAlertButton(){fiveSecondAlertButton.click();}
    public void clickConfirmAlertButton(){confirmAlertButton.click();}
    public void clickPromAlertButton(){promAlertButton.click();}
    public String getConfirmResult(){return confirmResult.getText();}
    public String getPromptResult(){return promptResult.getText();}
}
