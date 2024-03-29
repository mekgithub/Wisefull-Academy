package org.wisefull.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SeleniumUtil {
    private final long SHORT_EXPLICIT_WAIT_TIME = 5;

    public static WebDriver driver() {
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public WebElement findElement(By locator) {
        return driver().findElement(locator);
    }

    public void sendKeys(By locator, String text) {
        clear(locator);
        findElement(locator).sendKeys(text);
    }
    public void goTo(String url){driver().get(url);}

    public void clear(By locator) {
        findElement(locator).clear();
    }

    public void click(By locator) {
        findElement(locator).click();
    }

    public String getText(By locator) {
        return findElement(locator).getText();
    }

    public boolean isDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }

    public List<WebElement> findElements(By locator) {
        return driver().findElements(locator);
    }

    public void waitForVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver(), SHORT_EXPLICIT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
