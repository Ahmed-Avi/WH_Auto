package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.ActionBot.click;
import static utils.ActionBot.type;

public class Project_Info {
    private WebDriver driver;

    public Project_Info(WebDriver driver) {
        this.driver = driver;
    }

    //public By  = By.id("");
    public By editProjectButton = By.id("editProjectButton");
    public By getProjectName = By.id("projectNameValue");
    public By getProjectDescription = By.id("projectDescriptionValue");
    public By getProjectTotalArea = By.id("totalAreaSpaceValue");
    public By getProjectTotalCost = By.id("totalCostValue");
    public By getProjectLocation = By.id("locationAddressValue");
    public By getProjectLogo = By.id("projectLogoImage");
    public By getStackholderLogo1 = By.id("Logo1Image");
    public By getStackholderLogo2 = By.id("Logo2Image");
    public By getStackholderLogo3 = By.id("Logo3Image");
    public By getBlurFaceToggle = By.id("blurFacesToggle");
    public By getCapacityValue = By.id("capacityValue");
    public By getprojectManagerName = By.id("projectManagerInfo");
    public By getProjectManagerEmail = By.id("projectManagerEmail");
    public By getProjectcreatorInfo = By.id("creatorInfo");
    public By getProjectCreatedAtInfo = By.id("createdAtInfo");
    public By getFolderValue = By.id("folderValue");
    public By getNoHashtagsMessage = By.id("noHashtagsMessage"); //No Hashtag Scenario
    public By getHashtagsContainer = By.id("hashtagsContainer"); //there are Hashtags Scenario
    public By getHashtagCapsule = By.id("hashtagCapsule"); //This capsule for each hashtag in case we have two there will be to web elements for it
    public By getProjectStartDateValue = By.id("startDateValue");
    public By getProjectEndDateValue = By.id("endDateValue");
    public By getArchiveProjectButton = By.id("archiveProjectButton");
    public By getDeleteProjectButton = By.id("deleteProjectButton");

    /*
    Remaining:
    3. Success Msgs
    4. Failure Msgs
     */
    public void clickOnEditProjectButton() {
        click(driver, editProjectButton);
//        type(driver, usernameField, username);
    }
}