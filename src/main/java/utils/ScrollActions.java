package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScrollActions {

    private static WebDriver driver = ThreadDriver.getDriver();

    // Scroll to a specific element
    public static void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        new Actions(driver).moveToElement(element).perform();
    }

    // Scroll to a specific element using WebElement
    public static void scrollToElement(WebElement element) {
        new Actions(driver).moveToElement(element).perform();
    }

    // Scroll to the bottom of the page
    public static void scrollToBottom() {
        new Actions(driver).moveToElement(driver.findElement(By.tagName("body")), 0, driver.findElement(By.tagName("body")).getSize().getHeight()).perform();
    }

    // Scroll to the top of the page
    public static void scrollToTop() {
        new Actions(driver).moveToElement(driver.findElement(By.tagName("body")), 0, 0).perform();
    }

    // Dynamic scrolling to find an element
    public static void dynamicScrollToElement(By locator) {
        WebElement element = null;
        int scrollAttempts = 0;
        while (scrollAttempts < 10) {
            try {
                element = driver.findElement(locator);
                if (element.isDisplayed()) {
                    break;
                }
            } catch (NoSuchElementException e) {
                // Ignore exception and scroll further
            }
            // Scroll down by a certain amount (e.g., 300 pixels)
            new Actions(driver)
                    .moveToElement(driver.findElement(By.tagName("body")), 0, 300)
                    .perform();

            scrollAttempts++;
        }

        if (element == null || !element.isDisplayed()) {
            throw new NoSuchElementException("Element not found after scrolling.");
        }
    }
}
