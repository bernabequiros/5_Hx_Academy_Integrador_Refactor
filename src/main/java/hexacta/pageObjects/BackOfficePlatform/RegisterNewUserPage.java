package hexacta.pageObjects.BackOfficePlatform;

import hexacta.controls.Button;
import hexacta.controls.Checkbox;
import hexacta.controls.Input;
import hexacta.controls.Label;
import hexacta.pageObjects.BasePageObject;
import org.openqa.selenium.By;

public class RegisterNewUserPage extends BasePageObject {
    private By usernameField = By.id("usr");
    private By passwordField = By.id("pwd");
    private By logicaExamCheckbox = By.cssSelector("input[name='logica']");
    private By inglesExamCheckbox = By.cssSelector("input[name='ingles']");
    private By tecnicoExamCheckbox = By.cssSelector("input[name='tecnico']");
    private By testingExamCheckbox = By.cssSelector("input[name='testing']");
    private By testingTecnicoExamCheckbox = By.cssSelector("input[name='testingTecnico']");
    private By goBackButton = By.cssSelector("button[class='btn btn-outline']");
    private By createUserButton = By.cssSelector("button[ng-click='user.save()']");
    private By alertMessageText = By.cssSelector("p[ng-bind='user.message']");
    private By userCreatedText = By.cssSelector("strong[class='ng-binding']");

    public RegisterNewUserPage() {
        super(By.id("page-container"));
    }

    public Input txtUsername() {
        waitUntil(() -> (new Input(usernameField).isDisplayed() ? true : false));
        return new Input(usernameField);
    }

    public Input txtPassword() {
        waitUntil(() -> (new Input(passwordField).isDisplayed() ? true : false));
        return new Input(passwordField);
    }

    public Checkbox selectLogicalExam() {
        return new Checkbox(logicaExamCheckbox);
    }

    public boolean logicalExamIsChecked() {
        return new Checkbox(logicaExamCheckbox).isChecked();
    }

    public Checkbox selectEnglishExam() {
        return new Checkbox(inglesExamCheckbox);
    }

    public Checkbox selectTechnicalExam() {
        return new Checkbox(tecnicoExamCheckbox);
    }

    public Checkbox selectTestingExam() {
        return new Checkbox(testingExamCheckbox);
    }

    public Checkbox selectTestingTechnicalExam() {
        return new Checkbox(testingTecnicoExamCheckbox);
    }

    public Label getAlertText() {
        waitUntil(() -> (new Label(alertMessageText).isDisplayed() ? true : false));

        try {
            return new Label(alertMessageText);

        } catch (Exception e) {
            return null;
        }
    }

    public Button btnGoBack() {
        return new Button(goBackButton);
    }

    public Label getUserCreatedText() {
        try {
            return new Label(userCreatedText);

        } catch (Exception e) {
            return null;
        }
    }

    public boolean waitUntilBtnSubmitIsEnabled() {
        return waitUntil(() -> new Button(createUserButton).isEnabled() ? true : false);
    }

    public Button btnSubmit() {
        this.waitUntilBtnSubmitIsEnabled();
        return new Button(createUserButton);
    }
}
