package baseTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.ITestResult;
import utils.BrowserOptions;
import utils.Screenshot;

import java.io.File;
import java.io.IOException;

import static utils.BrowserOptions.OpenBrowser;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUpAndOpenBrowser() {
        driver = BrowserOptions.OpenBrowser();
        driver.get("https://stg.whitehelmet.sa");
    }

    @After
    public void tearDownBrowser() throws IOException {
        // Quit the driver
        if (driver != null) {
            driver.quit();
        }
    }
}
