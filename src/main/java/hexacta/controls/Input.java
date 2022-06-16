package hexacta.controls;

import org.openqa.selenium.By;

public class Input extends BaseControl {
    public Input(By locator) {
        super(locator);
    }

    public void write(String text) {
        this.webElement().sendKeys(text);
    }

    public String getText() {
        try {
            return this.webElement().getText();
        } catch (Exception e) {
            return null;
        }
    }

    public void clear() {
        this.webElement().clear();
    }
}