package testCases;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.Properties;

import static org.junit.Assert.assertTrue;
import static utils.ReadPropertyFile.readPropertyFile;

public class Login extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(Login.class);
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
    @Description("Check input fields warning for being empty or with wrong format")
    @Test (priority = 2)
    public void CheckWarningsOfMailAndPassword(){
        loginPage.clickOnSignIn();
        Assert.assertTrue(driver.findElement(loginPage.emptyEmailAddressWarning).isDisplayed());
        Assert.assertTrue(driver.findElement(loginPage.emptypasswordWarning).isDisplayed());
        loginPage.enterUsername(TestData.getProperty("Invalid_Mail"))
                 .clickOnSignIn();
        Assert.assertTrue(driver.findElement(loginPage.invalidEmailWarning).isDisplayed());
    }
    @Description("Check the functionality of ")
    @Test (priority = 4)
    public void CheckPasswordEyeAndRememberMeFunc (){
        loginPage.enterPassword(TestData.getProperty("SA_Password"))
                 .clickOnPasswordEyeOnIcon();
        Assert.assertEquals("text",loginPage.getPasswordFieldType());
        loginPage.clickOnPasswordEyeOffIcon();
        Assert.assertEquals("password",loginPage.getPasswordFieldType());
        loginPage.clickOnRememberMe();
        Assert.assertEquals("true",loginPage.isRememberMeChecked());
        loginPage.clickOnRememberMe();
        Assert.assertEquals("false",loginPage.isRememberMeChecked());
    }
    @Description("Check the Contact-Us section")
    @Test (priority = 5)
    public void CheckContactUsSection (){
        loginPage.waitForPageToGetLoaded();
        Assert.assertTrue(driver.findElement(loginPage.contactUs).isDisplayed());
        Assert.assertTrue(driver.findElement(loginPage.whatsappIcon).isDisplayed());
        Assert.assertTrue(driver.findElement(loginPage.mailIcon).isDisplayed());
        loginPage.clickOnWhatsappIcon()
                 .waitForWhatsappPageToLoad();
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("whatsapp.com"));
        driver.close();
        loginPage.clickOnMailIcon()
                 .waitForMailPageToLoad();
        Assert.assertTrue(driver.getPageSource().contains("whitehelmet.sa/#contact"));
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
