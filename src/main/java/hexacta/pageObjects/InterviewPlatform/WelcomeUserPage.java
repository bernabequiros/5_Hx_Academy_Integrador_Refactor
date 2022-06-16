package hexacta.pageObjects.InterviewPlatform;
import org.openqa.selenium.By;
import hexacta.controls.Label;
import hexacta.controls.Button;
import hexacta.pageObjects.BasePageObject;

public class WelcomeUserPage extends BasePageObject  {

    private By usernameText = By.className("data-user");
    private By welcomeText = By.className("h6-seccion");
    private By logOutButton = By.className("log-out");

    public WelcomeUserPage() {
        super(By.id("page-container"));
    }

    public Label getUsernameText() {
        try {
            return new Label(usernameText);

        } catch (Exception e) {
            return null;
        }
    }

    public Label getWelcomeText() {
        try {
            return new Label(welcomeText);
        } catch (Exception e) {
            return null;
        }
    }

    public Button btnLogout() {
       return new Button(logOutButton);
    }
}
