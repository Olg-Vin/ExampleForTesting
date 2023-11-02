package org.vinio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage {
    public WebDriver driver;
    @FindBy(css = "#userName")
    private WebElement fullName;
    @FindBy(css = "#userEmail")
    private WebElement email;
    @FindBy(css = "#currentAddress")
    private WebElement currentAddress;
    @FindBy(css = "#permanentAddress")
    private WebElement permanentAddress;
    @FindBy(xpath = "//*[contains(@id, 'submit')]")
    private WebElement submitButton;
    @FindBy(xpath = "//*[contains(@id, 'name')]")
    private WebElement nameField;
    @FindBy(xpath = "//*[contains(@id, 'email')]")
    private WebElement emailField;
    @FindBy(css = "p.mb-1:nth-child(3)")
    private WebElement currentAddressField;
    @FindBy(css = "p.mb-1:nth-child(4)")
    private WebElement permanentAddressField;


    public ElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    public void inputFullName(String name){
        fullName.sendKeys(name);
    }
    public void inputEmail(String email){
        this.email.sendKeys(email);
    }
    public void inputCurrentAddress(String address){
        currentAddress.sendKeys(address);
    }
    public void inputPermanentAddress(String address){
        permanentAddress.sendKeys(address);
    }
    public void clickSubmit(){
        submitButton.click();
    }

    public String getNameField() {
        return nameField.getText();
    }

    public String getEmailField() {
        return emailField.getText();
    }

    public String getCurrentAddressField() {
        return currentAddressField.getText();
    }

    public String getPermanentAddressField() {
        return permanentAddressField.getText();
    }


}
