package org.vinio;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ButtonsPage {
    public WebDriver driver;
    @FindBy(xpath = "//button[text()='Click Me']")
    private WebElement clickMeButton;
    @FindBy(xpath = "//button[text()='Right Click Me']")
    private WebElement rightClickMeButton;
    @FindBy(xpath = "//button[text()='Double Click Me']")
    private WebElement doubleClickMeButton;
    @FindBy(css = "#dynamicClickMessage")
    private WebElement clickMeMessage;
    @FindBy(css = "#rightClickMessage")
    private WebElement rightClickMeText;
    @FindBy(css = "#doubleClickMessage")
    private WebElement doubleClickMeText;


    public ButtonsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    public void clickOnClickMeButton(){
        clickMeButton.click();
    }
    public void clickOnRightCluckMeButton(){
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickMeButton).perform();
    }
    public void clickDoubleClickMeButton(){
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickMeButton).perform();
    }

    public String getClickMeMessage() {
        return clickMeMessage.getText();
    }

    public String getRightClickMeText() {
        return rightClickMeText.getText();
    }

    public String getDoubleClickMeText() {
        return doubleClickMeText.getText();
    }

}
