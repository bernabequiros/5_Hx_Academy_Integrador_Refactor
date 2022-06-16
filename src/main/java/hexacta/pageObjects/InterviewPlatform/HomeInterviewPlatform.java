package hexacta.pageObjects.InterviewPlatform;
import hexacta.controls.Button;
import hexacta.controls.Input;
import hexacta.controls.Label;
import hexacta.pageObjects.BasePageObject;
import org.openqa.selenium.By;

public class HomeInterviewPlatform extends BasePageObject {

    private By userField = By.id("log-usuario");
    private By passwordField = By.id("log-pwd");
    private By loginMessage = By.cssSelector("div.alert.alert-danger.ng-binding");
    private By submitButton = By.cssSelector("button.btn.btn-default.boton-ingreso");

    public HomeInterviewPlatform() {
        super(By.cssSelector("div.caja-index']"));
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public Input setUsername() {
        return new Input(userField);
    }

    public Input setPassword() {
        return new Input(passwordField);
    }

    public Button btnSubmit() {
        return new Button(submitButton);
    }

    public Label getLoginText() {
        waitUntil(() -> new Label(loginMessage).isDisplayed()? true : false);
        try {
            return new Label(loginMessage);
            
        } catch (Exception e) {
            return null; 
            }
        }
}

