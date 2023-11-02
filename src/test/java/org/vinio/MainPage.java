package org.vinio;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * элементы страниц, а также методы непосредственного взаимодействия с ними,
 * выносятся в отдельный класс, используется для навигации.
 * будет содержать локацию элементов.
 * */

public class MainPage {
    @FindBy(xpath = "//*[contains(@class, 'card mt-4 top-card') and descendant::h5[text()='Elements']]")
    private WebElement elements;
    public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    public void clickElements() {
        elements.click();
    }
}
