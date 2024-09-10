package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ActionBot.*;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public By whiteHelmetLogo = By.xpath("//img[@alt='Logo image' and contains(@class, 'hidden dark:flex')]");
    public By signInTitle = By.xpath("//div[contains(@class,'font-extrabold') and text()=' Sign in ']");
    public By emailLabel = By.xpath("//mat-label[text()='Email address']");
    public By usernameField = By.id("email");
    public By emptyEmailAddressWarning = By.id("mat-error-1");
    public By invalidEmailWarning = By.id("mat-error-2");
    public By passwordLabel = By.xpath("//mat-label[text()='Password']");
    public By passwordField = By.id("password");
    public By emptypasswordWarning = By.id("mat-error-0");
    public By passwordEyeOnIcon = By.xpath("//button[.//mat-icon[@data-mat-icon-name='eye']]");
    public By passwordEyeOffIcon = By.xpath("//button[.//mat-icon[@data-mat-icon-name='eye-off']]");
    public By rememberMeCheckBox = By.id("remeberMeCheckbox");
    public By forgotPassword = By.id("forgotPassword");
    public By signInButton = By.id("signInSubmitButton");
    public By contactUs = By.xpath("//*[text()='Contact Us']");
    public By whatsappIcon = By.id("whatsAppSupportAnchor");
    public By mailIcon = By.id("emailSupportAnchor");
    public By whatsappPage = By.xpath("//span[text()='Continue to Chat']");
    public By contactUsLink = By.linkText("Contact Us");


    public void waitForPageToGetLoaded (){
        waitForVisibility(driver,passwordEyeOnIcon);
        waitForVisibility(driver,whiteHelmetLogo);
        waitForVisibility(driver,whatsappIcon);
    }
    public LoginPage enterUsername(String username) {
        type(driver, usernameField, username);
        return this;
    }
    public LoginPage enterPassword(String password) {
        type(driver, passwordField, password);
        return this;
    }
    public OTPPage clickOnSignIn() {
        click(driver, signInButton);
        return new OTPPage();
    }
    public LoginPage clickOnRememberMe() {
        click(driver, rememberMeCheckBox);
        return this;
    }
    public void clickOnPasswordEyeOnIcon() {
        click(driver, passwordEyeOnIcon);
    }
    public void clickOnPasswordEyeOffIcon() {
        click(driver, passwordEyeOffIcon);
    }
    public String getPasswordFieldType (){
        return getAttributeValue(driver,passwordField,"type");
    }
    public String isRememberMeChecked (){
        return getAttributeValue(driver,rememberMeCheckBox,"aria-checked");
    }
    public ForgetPasswordPage clickOnForgotPassword() {
        click(driver, forgotPassword);
        return new ForgetPasswordPage();
    }
    public LoginPage clickOnWhatsappIcon() {
        click(driver, whatsappIcon);
        return this;
    }
    public LoginPage clickOnMailIcon() {
        click(driver, mailIcon);
        return this;
    }
    public void waitForWhatsappPageToLoad (){
        waitForVisibility(driver,whatsappPage);
    }
    public void waitForMailPageToLoad (){
        waitForVisibility(driver,contactUsLink);
    }
}