package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static utils.ActionBot.*;

public class CreateProject {
    private WebDriver driver;

    public CreateProject(WebDriver driver) {
        this.driver = driver;
    }

    public By CreateProjectBtn = By.id("createNewProjectMainBtn");
    public By NameField = By.id("newProjectProjectNameInput");
    public By DescriptionField = By.id("newProjectProjectDescInput");
    public By AreaField = By.id("newProjectProjectAreaInput");
    public By ManagerField = By.id("newProjectProjectManagerInput");
    public By ManagerDropDownList = By.id("newProjectProjectManagerOptions");
    public By DeleteProjectManagerBtn = By.cssSelector("button#newProjectProjectManagerBtn");
    public By TotalCostField = By.id("newProjectProjectCostInput");
    public By CapacityField = By.id("newProjectCapacityInput");
    public By LocationField = By.id("newProjectProjectLocationInput");
    public By HashtagField = By.cssSelector("input[placeholder='Enter # to filter through tags or enter a tag and add']");
    public By SaveAndCreateProjectBtn = By.id("newProjectProjectLogoBtnSubmit");
    public By MissingDataPopUpContinue = By.id("continue");

    //Methods to interact in the page
    public void ClickOnCreateProject(){
        click(driver,CreateProjectBtn);
    }
    public void EnterNameField (String NameValue){
        type(driver,NameField,NameValue);
    }
    public void EnterDescription (String DescriptionValue){
        type(driver,DescriptionField,DescriptionValue);
    }
    public void EnterArea (String AreaValue){
        type(driver,AreaField,AreaValue);
    }
    public void EnterProjectManager (String ProjectManager){
        type(driver,ManagerField,ProjectManager);
        click(driver,ManagerDropDownList);
        waitForVisibility(driver,DeleteProjectManagerBtn);
    }
    public void EnterTotalCost (String TotalCost) {
        type(driver, TotalCostField, TotalCost);
    }
    public void EnterCapacity (String Capacity){
        type(driver,CapacityField,Capacity);
    }
    public void EnterLocation (String Location){
        type(driver,LocationField,Location);
        driver.findElement(LocationField).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(LocationField).sendKeys(Keys.ENTER);
    }
    public void EnterHashtag (String Hashtag){
        type(driver,HashtagField,Hashtag);
        driver.findElement(HashtagField).sendKeys(Keys.ENTER);
    }
    public void ClickOnSaveAndCreateProject (){
        click(driver,SaveAndCreateProjectBtn);
    }
    public void ClickOnContinueBtn (){
        click(driver,MissingDataPopUpContinue);
    }








}
