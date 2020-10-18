package ru.comp;

import java.util.concurrent.TimeUnit;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Base automation class for TestNG-based test classes
 */
public class AutomationBaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final int OPTIMIZED_TIMEOUT = 5;

    @BeforeClass
    public void initTestSuite() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {

        driver.quit();
    }

    protected final WebDriver getDriver() {
        final WebDriver finalDriver = driver;
        return finalDriver;
    }

    protected void WaitForElementToAppear(WebElement element) {
        wait = new WebDriverWait(driver, OPTIMIZED_TIMEOUT);
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            System.out.println("TimeoutException, increase timeout!!!");
        }
    }
}