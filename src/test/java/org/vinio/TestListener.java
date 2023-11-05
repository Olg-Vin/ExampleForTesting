package org.vinio;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogType;


public class TestListener implements TestWatcher {
    @Override
    public void testSuccessful(ExtensionContext context) {
        Allure.getLifecycle().addAttachment(
                "скрин успешного прохождения теста", "image/png", "png",
                ((TakesScreenshot) StartTestClass.driver).getScreenshotAs(OutputType.BYTES)
        );

        Allure.addAttachment("Логи после успешного прохождения теста: ",
                String.valueOf(StartTestClass.driver.manage()
                .logs().get(LogType.BROWSER).getAll()));
        WebDriverManager.firefoxdriver().quit();
//        StartTestClass.driver.quit();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.getLifecycle().addAttachment(
                "скрин падения теста", "image/png", "png",
                ((TakesScreenshot) StartTestClass.driver).getScreenshotAs(OutputType.BYTES)
        );

        Allure.addAttachment("Логи после падения теста: ",
                String.valueOf(StartTestClass.driver.manage()
                .logs().get(LogType.BROWSER).getAll()));
        WebDriverManager.firefoxdriver().quit();
//        StartTestClass.driver.quit();
    }
}
