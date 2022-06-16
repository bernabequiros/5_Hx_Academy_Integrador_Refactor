package hexacta.controls;

import org.openqa.selenium.By;

public class Label extends BaseControl {
    public Label(By locator) {
        super(locator);
    }

    public String getText() {
        try {
            return this.webElement().getText();
        } catch (Exception e) {
            return null;
        }
    }
}
