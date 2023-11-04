package org.vinio.Pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.vinio.StartTestClass;

/**
 * элементы страниц, а также методы непосредственного взаимодействия с ними,
 * выносятся в отдельный класс, используется для навигации.
 * будет содержать локацию элементов.
 * */

@Getter
public class MainPage extends StartTestClass {
    private By elements = By.xpath(
            "//*[contains(@class, 'card mt-4 top-card') and descendant::h5[text()='Elements']]");
    public MainPage(WebDriver driver) {
        this.driver = (EventFiringWebDriver) driver;
        PageFactory.initElements(driver, this);}
}
