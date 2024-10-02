package baseTest;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.ITestResult;
import pages.LoginPage;
import pages.OTPPage;
import utils.BrowserOptions;
import utils.Screenshot;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import static utils.BrowserOptions.OpenBrowser;
import static utils.ReadPropertyFile.readPropertyFile;

public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeClass
    public void setUpAndOpenBrowser() {
        driver = BrowserOptions.OpenBrowser();
        driver.get("https://stg.whitehelmet.sa");
        //Perform login before each run
        LoginPage loginPage = new LoginPage(driver);
        OTPPage otpPage = new OTPPage(driver);
        Properties TestData = readPropertyFile("src/test/resources/TestData/testData.properties");
        loginPage.enterUsername(TestData.getProperty("SA_Mail"))
                .enterPassword(TestData.getProperty("SA_Password"))
                .clickOnSignIn();
        otpPage.EnterOTP();
    }

    @After
    public void tearDownBrowser() throws IOException {
        // Quit the driver
        if (driver != null) {
            driver.quit();
        }
    }
}
