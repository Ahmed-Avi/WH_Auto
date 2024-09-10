package utils;

import org.openqa.selenium.WebDriver;

public class ThreadDriver {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static void setDriver(WebDriver driver) {
        threadDriver.set(driver);
    }

    public static void removeDriver() {
        WebDriver driver = threadDriver.get();
        if (driver != null) {
            driver.quit();
            threadDriver.remove();
        }
    }
}