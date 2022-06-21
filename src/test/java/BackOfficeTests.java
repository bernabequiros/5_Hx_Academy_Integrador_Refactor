
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import hexacta.pageObjects.BackOfficePlatform.HomeBackOffice;
import hexacta.pageObjects.BackOfficePlatform.RegisterNewUserPage;

public class BackOfficeTests extends BaseTest {
    private String url = "http://hxv-evaluaciondev.backoffice.hexacta.com";
    private HomeBackOffice getHomeBackOffice  = new HomeBackOffice();       
    private RegisterNewUserPage getRegisterNewUserPage = new RegisterNewUserPage();

    @Before
    public void NavigateToBackOffice() {
        this.navigateTo(url);
    }

    @Test
    public void BackOffice_CreateUserWithoutTechnicalExamsAssociated_UserIsCreated(){
        this.getHomeBackOffice.btnCreateUser();
        this.getRegisterNewUserPage.txtUsername().write("testingAcademy5.0.0");
        this.getRegisterNewUserPage.txtPassword().write("abc123");
        this.getRegisterNewUserPage.selectLogicalExam().check();
        this.getRegisterNewUserPage.selectEnglishExam().check();
        this.getRegisterNewUserPage.btnSubmit().click();
        assertTrue("Element is not displayed", this.getRegisterNewUserPage.getUserCreatedText().isDisplayed());
    }

    @Test
    public void BackOffice_CreateUserWithTechnicalExamsAssociated_UserIsCreated(){
        this.getHomeBackOffice.btnCreateUser().click();
        this.getRegisterNewUserPage.txtUsername().write("testingAcademy5.0.1");
        this.getRegisterNewUserPage.txtPassword().write("abc123");
        this.getRegisterNewUserPage.selectTechnicalExam().check();
        this.getRegisterNewUserPage.btnSubmit().click();
        assertTrue("Element is not displayed", this.getRegisterNewUserPage.getUserCreatedText().isDisplayed());
    }

    @Test
    public void BackOffice_CreateUserWithTestingTechnicalExamsAssociated_UserCreatedTextIsDisplayed(){
        this.getHomeBackOffice.btnCreateUser().click();
        this.getRegisterNewUserPage.txtUsername().write("testingAcademy5.0.2");
        this.getRegisterNewUserPage.txtPassword().write("abc123");
        this.getRegisterNewUserPage.selectTestingTechnicalExam().check();
        this.getRegisterNewUserPage.btnSubmit().click();
        assertTrue("Element is not displayed", this.getRegisterNewUserPage.getUserCreatedText().isDisplayed());
    }

    @Test
    public void BackOffice_CreateUserWithTestingExamsAssociated_UserCreatedTextIsDisplayed(){
        this.getHomeBackOffice.btnCreateUser().click();
        this.getRegisterNewUserPage.txtUsername().write("testingAcademy5.0.3");
        this.getRegisterNewUserPage.txtPassword().write("abc123");
        this.getRegisterNewUserPage.selectTestingExam().check();
        this.getRegisterNewUserPage.btnSubmit().click();
        assertTrue("Element is not displayed", this.getRegisterNewUserPage.getUserCreatedText().isDisplayed());
    }

    @Test
    public void BackOffice_UnableToCreateANewUserWithoutAnyExamAssociated_UserIsNotCreated() {
        this.getHomeBackOffice.btnCreateUser().click();
        this.getRegisterNewUserPage.txtUsername().write("testingAcademy5.0.X");
        this.getRegisterNewUserPage.txtPassword().write("abc123");
        this.getRegisterNewUserPage.btnSubmit().click();
        assertTrue("Element is not displayed", this.getRegisterNewUserPage.getAlertText().isDisplayed());
    }

    @Test
    public void BackOffice_CreateButtonIsDisabled() {
        this.getHomeBackOffice.btnCreateUser().click();
        assertFalse("Submit button is enabled.", this.getRegisterNewUserPage.btnSubmit().isEnabled());
    }
}
