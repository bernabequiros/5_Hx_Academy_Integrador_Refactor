package hexacta.pageObjects.BackOfficePlatform;

import hexacta.controls.Button;
import hexacta.pageObjects.BasePageObject;
import org.openqa.selenium.By;

public class HomeBackOffice extends BasePageObject {
    private By createUserButton = By.cssSelector("i[class='fa fa-plus']");

    public HomeBackOffice() {
        super(By.cssSelector("body[class='ng-scope']"));
    }

    public Button btnCreateUser() {
        return new Button(createUserButton);
    }
}
