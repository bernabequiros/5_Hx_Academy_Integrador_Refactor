import hexacta.pageObjects.InterviewPlatform.HomeInterviewPlatform;
import hexacta.pageObjects.InterviewPlatform.WelcomeUserPage;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class InterviewPlatformTests extends BaseTest {
    public String url = "http://hxv-evaluaciondev.interview.hexacta.com";
    private HomeInterviewPlatform getHomeInterviewPlatform = new HomeInterviewPlatform();
    private WelcomeUserPage getWelcomeUserPage = new WelcomeUserPage();

    @Before
    public void NavigateToInterviewPlatform() {
        this.navigateTo(url);
    }

    @Test
    public void InterviewPlatform_LoginWithPendingExams_WelcomeTextIsDisplayed() {
        this.getHomeInterviewPlatform.txtUsername().write("testingAcademy4.0");
        this.getHomeInterviewPlatform.txtPassword().write("abc123");
        this.getHomeInterviewPlatform.btnSubmit().click();
        assertTrue("Element is not displayed", this.getWelcomeUserPage.LblWelcome().isDisplayed());
    }

    @Test
    public void InterviewPlatform_LoginSettingBlankFields_LoginAlertTextIsDisplayed() {
        this.getHomeInterviewPlatform.btnSubmit().click();
        assertTrue("Element is not displayed", this.getHomeInterviewPlatform.LblLogin().isDisplayed());
    }

    @Test
    public void InterviewPlatform_LoginWithoutPendingExams_LoginAlertTextIsDisplayed() {
        this.getHomeInterviewPlatform.txtUsername().write("testingAcademyPQ");
        this.getHomeInterviewPlatform.txtPassword().write("abc123");
        this.getHomeInterviewPlatform.btnSubmit().click();
        assertTrue("Element is not displayed", this.getHomeInterviewPlatform.LblLogin().isDisplayed());
    }

    @Test
    public void InterviewPlatform_LoginWithInvalidCredentials_LoginAlertTextIsDisplayed() {
        this.getHomeInterviewPlatform.txtUsername().write("INVALIDCREDENTIAL010101");
        this.getHomeInterviewPlatform.txtPassword().write("INVALIDPASSWORS010101");
        this.getHomeInterviewPlatform.btnSubmit().click();
        assertTrue("Element is not displayed", this.getHomeInterviewPlatform.LblLogin().isDisplayed());
    }

}
