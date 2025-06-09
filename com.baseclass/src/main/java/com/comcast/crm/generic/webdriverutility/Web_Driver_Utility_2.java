package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Web_Driver_Utility_2 {
	
	// ------------------- WAIT UTILITIES -------------------
    public void waitForPageToLoad(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void waitForElementVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // ------------------- WINDOW HANDLING -------------------
    public void switchToTabOnURL(WebDriver driver, String partialURL) {
        Set<String> set = driver.getWindowHandles();
        for (String windowID : set) {
            driver.switchTo().window(windowID);
            if (driver.getCurrentUrl().contains(partialURL)) {
                break;
            }
        }
    }

    public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
        Set<String> set = driver.getWindowHandles();
        for (String windowID : set) {
            driver.switchTo().window(windowID);
            if (driver.getTitle().contains(partialTitle)) {
                break;
            }
        }
    }

    // ------------------- FRAME HANDLING -------------------
    public void switchToFrame(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }

    public void switchToFrame(WebDriver driver, String nameOrID) {
        driver.switchTo().frame(nameOrID);
    }

    public void switchToFrame(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchBackFromFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    // ------------------- ALERT HANDLING -------------------
    public void switchToAlertAndAccept(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void switchToAlertAndDismiss(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public String getAlertText(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    // ------------------- DROPDOWN -------------------
    public void selectByVisibleText(WebElement element, String text) {
        Select sel = new Select(element);
        sel.selectByVisibleText(text);
    }

    public void selectByIndex(WebElement element, int index) {
        Select sel = new Select(element);
        sel.selectByIndex(index);
    }

    public void selectByValue(WebElement element, String value) {
        Select sel = new Select(element);
        sel.selectByValue(value);
    }

    // ------------------- MOUSE ACTIONS -------------------
    public void mouseHover(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.moveToElement(element).perform();
    }

    public void doubleClick(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.doubleClick(element).perform();
    }

    public void rightClick(WebDriver driver, WebElement element) {
        Actions act = new Actions(driver);
        act.contextClick(element).perform();
    }

    public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        Actions act = new Actions(driver);
        act.dragAndDrop(source, target).perform();
    }

    // ------------------- KEYBOARD ACTIONS -------------------
    public void pressEnter(WebDriver driver) {
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
    }

    // ------------------- SCROLLING -------------------
    public void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollBy(WebDriver driver, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
    }

    public void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    // ------------------- MISC -------------------
    public void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public void minimizeWindow(WebDriver driver) {
        driver.manage().window().minimize();
    }

    public void closeBrowser(WebDriver driver) {
        driver.quit();
    }
}