package testCases;

import baseTest.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CreateProject;
import pages.LoginPage;

public class CreateProjectTests extends BaseTest {
    CreateProject createProject;

    @BeforeMethod
    public void setUpPage() {
        createProject = new CreateProject(driver);
    }

    @Description("Creating project")
    @Test(priority = 1)
    public void CreateProject (){
        createProject.ClickOnCreateProject();
        createProject.EnterNameField("Automation99");
        createProject.EnterDescription("Descriptionbsaidufhasidufbaisd fiasudyfaisu dyfiuasdfouyas gdfugas");
        createProject.EnterArea("132168.165");
        createProject.EnterProjectManager("pm1@admin.com");
        createProject.EnterTotalCost("254265");
        createProject.EnterCapacity("651651");
        createProject.EnterLocation("saudia");
        createProject.EnterHashtag("Automation");
        createProject.ClickOnSaveAndCreateProject();
        createProject.ClickOnContinueBtn();
    }

}
