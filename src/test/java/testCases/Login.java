package testCases;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.Properties;

import static org.junit.Assert.assertTrue;
import static utils.ReadPropertyFile.readPropertyFile;

public class Login extends BaseTest {
    LoginPage loginPage;
    Properties TestData = readPropertyFile("src/test/resources/TestData/testData.properties");

    @BeforeMethod
    public void setUpPage() {
        loginPage = new LoginPage(driver);
    }

    @Description("Check the UI of the Login Page")
    @Test (priority = 1)
    public void CheckLoginPageUI (){
        loginPage.waitForPageToGetLoaded();
        Assert.assertTrue(driver.findElement(loginPage.whiteHelmetLogo).isDisplayed());
        Assert.assertTrue(driver.findElement(loginPage.signInTitle).isDisplayed());
        Assert.assertTrue(driver.findElement(loginPage.emailLabel).isDisplayed());
        Assert.assertTrue(driver.findElement(loginPage.passwordLabel).isDisplayed());
        Assert.assertTrue(driver.findElement(loginPage.contactUs).isDisplayed());
    }
    @Description("Check empty mail & password warnings")
    @Test (priority = 2)
    public void CheckEmptyMailAndPasswordWarnings(){
        loginPage.clickOnSignIn();
        Assert.assertTrue(driver.findElement(loginPage.emptyEmailAddressWarning).isDisplayed());
        Assert.assertTrue(driver.findElement(loginPage.emptypasswordWarning).isDisplayed());
    }
    @Description("Check Invalid Mail warning")
    @Test (priority = 3)
    public void CheckInvalidMailWarning (){
        loginPage.enterUsername(TestData.getProperty("Invalid_Mail"))
                 .clickOnSignIn();
        Assert.assertTrue(driver.findElement(loginPage.invalidEmailWarning).isDisplayed());
    }
    @Description("Check that password field eye icon change the visibility of the written password")
    @Test (priority = 4)
    public void CheckPasswordEyeIconFunctionality (){
        System.out.println(TestData.getProperty("SA_Password"));
        loginPage.enterPassword(TestData.getProperty("SA_Password"))
                 .clickOnPasswordEyeOnIcon();
        Assert.assertEquals("text",loginPage.getPasswordFieldType());
        loginPage.clickOnPasswordEyeOffIcon();
        Assert.assertEquals("password",loginPage.getPasswordFieldType());
    }


    @Description("Enter Valid Mail & Password")
    @Test
    public void SuccessfuLogin (){
        loginPage.enterUsername(TestData.getProperty("SA_Mail"))
                 .enterPassword(TestData.getProperty("SA_Password"))
                 .clickOnRememberMe()
                 .clickOnSignIn();
    }

}
