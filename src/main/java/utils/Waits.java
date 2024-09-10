package utils;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

import static utils.ReadPropertyFile.*;

public class Waits {

    static Properties Configurations = readPropertyFile("config/capabilities/configurations.properties");
    public static void getImplicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(Integer.parseInt(Configurations.getProperty("implicitWaitTimeout"))
                ));
    }

    public static Wait<WebDriver> getExplicitWait(WebDriver driver) {
        return new WebDriverWait(driver,
                Duration.ofSeconds(Integer.parseInt(Configurations.getProperty("ExplicitWaitTimeout"))
                ));
    }

    public static Wait<WebDriver> getFluentWait(WebDriver driver) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(
                        Integer.parseInt(Configurations.getProperty("FluentWaitTimeout")
                        )))
                .pollingEvery(Duration.ofMillis(
                        Integer.parseInt(Configurations.getProperty("FluentWaitPolling")
                        )))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(AssertionError.class)
                .ignoring(StaleElementReferenceException.class);
    }
}
