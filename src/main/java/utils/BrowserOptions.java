package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class BrowserOptions {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    // Method to initialize and return the WebDriver instance based on browser type
    public static WebDriver OpenBrowser() {
        WebDriver driver;
        String browserType = ReadPropertyFile.readPropertyFile("config/capabilities/configurations.properties")
                .getProperty("Browser", "Chrome");
        boolean isHeadless = Boolean.parseBoolean(ReadPropertyFile.readPropertyFile("config/capabilities/configurations.properties")
                .getProperty("Headless", "false"));

        switch (browserType.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) {
                    edgeOptions.addArguments("--headless");
                }
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                throw new IllegalArgumentException("Browser type not supported: " + browserType);
        }

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set the driver instance to ThreadLocal
        driverThreadLocal.set(driver);
        return driver;
    }

    // Method to retrieve the WebDriver instance from ThreadLocal
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    // Method to remove the WebDriver instance from ThreadLocal
    public static void removeDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}
