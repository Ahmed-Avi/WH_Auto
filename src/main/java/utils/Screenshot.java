package utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class Screenshot {

    static int SuccessCodeForTestNG =1;
    static int FailureCodeForTestNG =2;

    public static void captureSuccess(WebDriver driver, ITestResult result) throws IOException {
        if (result.getStatus()==SuccessCodeForTestNG) {

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("src/test/resources/Screenshots/SuccessfulTests/"+ result.getName() +".png");
            org.openqa.selenium.io.FileHandler.copy(source, destination);

            var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(result.getName(),new ByteArrayInputStream(screenshot));
        }
    }

    public static void captureFailure(WebDriver driver, ITestResult result) throws IOException {
        if (result.getStatus() == FailureCodeForTestNG) {

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("src/test/resources/Screenshots/FailedTests/"+ result.getName() +".png");
            org.openqa.selenium.io.FileHandler.copy(source, destination);

            var screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(result.getName(),new ByteArrayInputStream(screenshot));
        }
    }


    public static void takeElementScreenshot(WebDriver driver, By locator , String targetPath ,
                                             String fileName) throws IOException {
        File source = driver.findElement(locator).getScreenshotAs(OutputType.FILE);
        File destination =
                new File (targetPath+fileName+".png");

        FileHandler.copy(source,destination);

    }
}

