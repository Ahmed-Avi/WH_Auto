package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ActionBot.click;
import static utils.ActionBot.type;

public class OTPPage {
    private WebDriver driver;

    public OTPPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
    public By OTPField = By.id("otp");
    public By VerifyBtn = By.id("verifyOtpButton");

    public void EnterOTP(){
        type(driver,OTPField,"1234");
        click(driver,VerifyBtn);
    }
}
