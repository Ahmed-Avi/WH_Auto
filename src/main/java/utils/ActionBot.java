package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static utils.ReadPropertyFile.readPropertyFile;

public class ActionBot {

    // Method to type text into a text box
    public static void type(WebDriver driver, By locator, String text) {
        WebElement element = driver.findElement(locator);
        Waits.getFluentWait(driver).until(f -> {
            System.out.println("Typing " + text);
            element.clear();
            element.sendKeys(text);
            return true;
        });
    }

    // Method to click on a button or link
    public static void click(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Waits.getFluentWait(driver).until(f -> {
            System.out.println("Clicking On " + element.getText());
            element.click();
            return true;
        });
    }

    // Method to get text from an element
    public static String readText(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Waits.getFluentWait(driver).until(f -> {
            element.getText();
            return true;
        });
        return element.getText().replace("\n", "");
    }

    // Method to verify if an element is displayed
    public static boolean isElementDisplayed(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Waits.getFluentWait(driver).until(f -> {
            element.isDisplayed();
            return true;
        });
        return true;
    }

    // Method to verify if an element is enabled
    public static boolean isElementEnabled(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Waits.getFluentWait(driver).until(f -> {
            element.isEnabled();
            return true;
        });
        return true;
    }

    // Method to verify if an element is selected
    public static boolean isElementSelected(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Waits.getFluentWait(driver).until(f -> {
            element.isSelected();
            return true;
        });
        return true;
    }

    // Method to return a value of an attribute of a web element
    public static String getAttributeValue(WebDriver driver, By locator, String attributeName) {
        WebElement element = driver.findElement(locator);
        return element.getAttribute(attributeName);
    }

    // Method to hover over a main menu and select a sub-menu
    public static void hoverToSubMenu(WebDriver driver, By mainMenuLocator, By subMenuLocator) {
        WebElement mainMenu = driver.findElement(mainMenuLocator);
        WebElement subMenu = driver.findElement(subMenuLocator);
        Waits.getFluentWait(driver).until(f -> {
            new Actions(driver)
                    .moveToElement(mainMenu)
                    .pause(Duration.ofMillis(100))
                    .moveToElement(subMenu)
                    .click()
                    .perform();
            return true;
        });
    }

    // Method to wait for an element to be visible
    public static void waitForVisibility(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}